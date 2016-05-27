package com.prodigious.festivity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.prodigious.festivity.dto.FestivityDto;
import com.prodigious.festivity.entity.Festivity;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Service to convert from DTO to entity
 */
@Service
public class DtoToFestivity implements Converter<FestivityDto, Festivity> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.Converter#convert(java.lang
	 * .Object)
	 */
	@Override
	public Festivity convert(FestivityDto dto) {

		Festivity entity = new Festivity();
		entity.setName(dto.getName());
		entity.setPlace(dto.getPlace());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		return entity;
	}
}
