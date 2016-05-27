package com.prodigious.festivity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.prodigious.festivity.dto.FestivityDto;
import com.prodigious.festivity.entity.Festivity;

/**
 * @author Daniel Bernal Bazzan
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Service to convert from entity to DTO
 */
@Service
public class FestivityToDto implements Converter<Festivity, FestivityDto> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.Converter#convert(java.lang
	 * .Object)
	 */
	@Override
	public FestivityDto convert(Festivity entity) {

		FestivityDto dto = new FestivityDto();
		dto.setName(entity.getName());
		dto.setPlace(entity.getPlace());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		return dto;
	}
}
