package com.prodigious.festivity.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import com.prodigious.festivity.converter.DtoToFestivity;
import com.prodigious.festivity.converter.FestivityToDto;
import com.prodigious.festivity.dto.FestivityDto;
import com.prodigious.festivity.entity.Festivity;
import com.prodigious.festivity.exception.ProdigiousException;
import com.prodigious.festivity.service.IFestivityService;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        Unit tests methods for class {@link FestivityController}
 */
@RunWith(EasyMockRunner.class)
public class FestivityControllerMockTest {

	@TestSubject
	private FestivityController festivityController = new FestivityController();

	/** Mock Festivity service - it can save or update info */
	@Mock
	IFestivityService festivityService;

	/** Mock Converter to change data from DTO to entity */
	@Mock
	DtoToFestivity toEntity;

	/** Mock Converter to change data from entity to DTO */
	@Mock
	FestivityToDto toDto;

	/**
	 * Resets all the mocks
	 */
	private void resetAll() {

		EasyMock.reset(festivityService);
		EasyMock.reset(toEntity);
		EasyMock.reset(toDto);
	}

	/**
	 * Replays all the mocks
	 */
	private void replayAll() {

		EasyMock.replay(festivityService);
		EasyMock.replay(toEntity);
		EasyMock.replay(toDto);
	}

	/**
	 * Verifies all the mocks
	 */
	private void verifyAll() {

		EasyMock.verify(festivityService);
		EasyMock.verify(toEntity);
		EasyMock.verify(toDto);
	}

	/**
	 * Tests finding festivities
	 */
	@Test
	public void getAllFestivities_CompleteInfo_ShouldSuccess() {

		resetAll();

		Festivity fest = new Festivity();
		List<Festivity> list = new ArrayList<>();
		list.add(fest);
		FestivityDto dto = new FestivityDto();

		EasyMock.expect(festivityService.getAllFestivities()).andReturn(list);
		EasyMock.expect(toDto.convert(fest)).andReturn(dto);

		replayAll();

		ResponseEntity<List<FestivityDto>> response = festivityController
				.getAllFestivities();

		assertNotNull(response);

		verifyAll();
	}

	/**
	 * Tests finding festivities
	 */
	@Test
	public void getAllFestivities_NotCompleteInfo_ShouldSuccess() {

		resetAll();

		List<Festivity> list = new ArrayList<>();

		EasyMock.expect(festivityService.getAllFestivities()).andReturn(list);

		replayAll();

		ResponseEntity<List<FestivityDto>> response = festivityController
				.getAllFestivities();

		assertNotNull(response);

		verifyAll();
	}

	/**
	 * Tests creating a festivity
	 * 
	 * @throws ProdigiousException
	 *             thrown when an error occurs
	 */
	@Test
	public void createFestivity_CompleteInfo_ShouldSuccess()
			throws ProdigiousException {

		resetAll();

		FestivityDto dto = new FestivityDto();
		Festivity fest = new Festivity();
		Festivity saved = new Festivity();

		EasyMock.expect(toEntity.convert(dto)).andReturn(fest);
		EasyMock.expect(festivityService.saveFestivity(fest)).andReturn(saved);
		EasyMock.expect(toDto.convert(saved)).andReturn(dto);

		replayAll();

		ResponseEntity<FestivityDto> response = festivityController
				.createFestivity(dto);

		assertNotNull(response);

		verifyAll();
	}

	/**
	 * Tests creating a festivity
	 * 
	 * @throws ProdigiousException
	 *             thrown when an error occurs
	 */
	@Test
	public void createFestivity_CompleteInfo_ShouldCatchException()
			throws ProdigiousException {

		resetAll();

		FestivityDto dto = new FestivityDto();
		Festivity fest = new Festivity();

		EasyMock.expect(toEntity.convert(dto)).andReturn(fest);
		EasyMock.expect(festivityService.saveFestivity(fest)).andThrow(
				new ProdigiousException());

		replayAll();

		ResponseEntity<FestivityDto> response = festivityController
				.createFestivity(dto);

		assertNotNull(response);

		verifyAll();
	}
}
