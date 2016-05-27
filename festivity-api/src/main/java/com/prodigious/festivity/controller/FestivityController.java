package com.prodigious.festivity.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodigious.festivity.constant.RestEndpoint;
import com.prodigious.festivity.converter.DtoToFestivity;
import com.prodigious.festivity.converter.FestivityToDto;
import com.prodigious.festivity.dto.FestivityDto;
import com.prodigious.festivity.entity.Festivity;
import com.prodigious.festivity.exception.PridigiousValidatorException;
import com.prodigious.festivity.exception.ProdigiousException;
import com.prodigious.festivity.service.IFestivityService;
import com.prodigious.festivity.util.FestivityValidationUtil;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Rest controller to manage the {@link Festivity} entity
 */
@RestController
public class FestivityController {

	/** Logger for the class */
	private static final Logger LOGGER = Logger
			.getLogger(FestivityController.class);

	/** Festivity service - it can save or update info */
	@Autowired
	IFestivityService festivityService;

	/** Converter to change data from DTO to entity */
	@Autowired
	DtoToFestivity toEntity;

	/** Converter to change data from entity to DTO */
	@Autowired
	FestivityToDto toDto;

	/**
	 * Rest method to search all the saved festivities
	 * 
	 * @return the list of saved festivities
	 */
	@RequestMapping(value = RestEndpoint.FESTIVITY_ROOT, method = RequestMethod.GET)
	public ResponseEntity<List<FestivityDto>> getAllFestivities() {

		LOGGER.info("Request to search for the festivities");
		List<FestivityDto> dtoList = new ArrayList<>();
		List<Festivity> list = festivityService.getAllFestivities();
		if (list == null || list.isEmpty()) {
			LOGGER.info("No Festivity was found");
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
		for (Festivity fest : list) {
			FestivityDto dto = toDto.convert(fest);
			dtoList.add(dto);
		}
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	/**
	 * Rest method to create a new or edit and existing festivity
	 * 
	 * @param dto
	 *            Festivity information to be saved in the DBMS
	 * @return the saved Festivity
	 */
	@RequestMapping(value = RestEndpoint.FESTIVITY_ADD, method = RequestMethod.POST)
	public ResponseEntity<FestivityDto> createFestivity(
			@RequestBody FestivityDto dto) {

		LOGGER.info("Request to create/update a Festivity was received");
		Festivity saved = null;
		try {
			FestivityValidationUtil.validateFestivity(dto);
			saved = festivityService.saveFestivity(toEntity.convert(dto));
		} catch (PridigiousValidatorException e) {
			LOGGER.error("Some information is empty or null", e);
			return new ResponseEntity<>(new FestivityDto(),
					HttpStatus.BAD_REQUEST);
		} catch (ProdigiousException e) {
			LOGGER.error(
					"There was an error trying to save/update the Festivity", e);
			return new ResponseEntity<>(new FestivityDto(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		FestivityDto savedDto = toDto.convert(saved);
		return new ResponseEntity<>(savedDto, HttpStatus.OK);
	}
}
