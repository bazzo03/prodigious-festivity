package com.prodigious.festivity.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.prodigious.festivity.dto.FestivityDto;
import com.prodigious.festivity.exception.PridigiousValidatorException;
import com.prodigious.festivity.exception.ProdigiousException;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Class to validate the sent data of a {@link FestivityDto}
 */
@Component
public class FestivityValidationUtil {

	/**
	 * Validates if info sent for this web service is correct
	 * 
	 * @param dto
	 *            to validate
	 * @throws ProdigiousException
	 *             thrown when an error occurs
	 */
	public static void validateFestivity(FestivityDto dto)
			throws PridigiousValidatorException {
		
		/** Logger for the class */
		final Logger LOGGER = Logger
				.getLogger(PridigiousValidatorException.class);

		/* Starts the validation of fields */
		if (dto.getStartDate() == null
				|| dto.getStartDate().equals(StringUtils.EMPTY)) {
			LOGGER.error("Start Date is null or empty");
			throw new PridigiousValidatorException("Start Date cannot be null or empty");
		}
		if (dto.getEndDate() == null
				|| dto.getEndDate().equals(StringUtils.EMPTY)) {
			LOGGER.error("End Date is null or empty");
			throw new PridigiousValidatorException("End Date cannot be null or empty");
		}
		if (dto.getPlace() == null || dto.getPlace().equals(StringUtils.EMPTY)) {
			LOGGER.error("Place is null or empty");
			throw new PridigiousValidatorException("Place cannot be null or empty");
		}
		if (dto.getName() == null || dto.getName().equals(StringUtils.EMPTY)) {
			LOGGER.error("Name is null or empty");
			throw new PridigiousValidatorException("Name cannot be null or empty");
		}
	}
}
