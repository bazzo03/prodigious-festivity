package com.prodigious.festivity.service;

import java.time.Instant;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodigious.festivity.dao.IFestivityDao;
import com.prodigious.festivity.entity.Festivity;
import com.prodigious.festivity.exception.ProdigiousException;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 * 
 * Implementation of the operations defined in {@link IFestivityService}
 */
@Service
public class FestivityServiceImpl implements IFestivityService {

	/** Logger for the class */
	private static final Logger LOGGER = Logger
			.getLogger(FestivityServiceImpl.class);
	
	/** DAO to operate the {@link Festivity} */
	@Autowired
	private IFestivityDao festivityDAO;
	
	/* (non-Javadoc)
	 * @see com.prodigious.festivity.service.FestivityService#getAllFestivities()
	 */
	@Transactional
	public List<Festivity> getAllFestivities() {
		
		LOGGER.info("Searching for the festivities");
		return festivityDAO.getAllFestivities();
	}

	/* (non-Javadoc)
	 * @see com.prodigious.festivity.service.FestivityService#saveFestivity(com.prodigious.festivity.form.Festivity)
	 */
	@Transactional
	@Override
	public Festivity saveFestivity(Festivity festivity) throws ProdigiousException {
		
		LOGGER.info("Saving the festivity");
		Instant startDate = Instant.parse(festivity.getStartDate());
		Instant endDate = Instant.parse(festivity.getEndDate());
		if (endDate.isBefore(startDate)) {
			LOGGER.error("End Date is greater than End Date");
			throw new ProdigiousException("End Date is greater than End Date");
		}

		List<Festivity> list = getAllFestivities();
		if (list != null && !list.isEmpty()) {
			for (Festivity fest : list) {
				if (fest.getName().equals(festivity.getName())) {
					LOGGER.info("Existing Festivity found");
					fest.setStartDate(festivity.getStartDate());
					fest.setEndDate(festivity.getEndDate());
					fest.setPlace(festivity.getPlace());
					return updateFestivity(fest);
				}
			}
		}
		LOGGER.info("Non existing Festivity found");
		return festivityDAO.saveFestivity(festivity);
	}

	/* (non-Javadoc)
	 * @see com.prodigious.festivity.service.FestivityService#updateFestivity(com.prodigious.festivity.form.Festivity)
	 */
	@Transactional
	@Override
	public Festivity updateFestivity(Festivity festivity) {
		
		LOGGER.info("Updating Festivity");
		return festivityDAO.updateFestivity(festivity);
	}

}
