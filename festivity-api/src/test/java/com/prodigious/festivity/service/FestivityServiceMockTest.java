package com.prodigious.festivity.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.prodigious.festivity.dao.IFestivityDao;
import com.prodigious.festivity.entity.Festivity;
import com.prodigious.festivity.exception.ProdigiousException;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        Unit tests methods for class {@link FestivityServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class FestivityServiceMockTest {

	/** Class to test */
	@TestSubject
	private FestivityServiceImpl service = new FestivityServiceImpl();

	/** Mock needed for testing */
	@Mock
	private IFestivityDao festivityDAOMock;

	/**
	 * Tests searching all the saved festivities
	 */
	@Test
	public void getAllFestities_EmptyList_ShouldSuccess() {

		EasyMock.reset(festivityDAOMock);

		EasyMock.expect(festivityDAOMock.getAllFestivities()).andReturn(
				new ArrayList<Festivity>());

		EasyMock.replay(festivityDAOMock);

		List<Festivity> list = service.getAllFestivities();

		assertNotNull(list);

		EasyMock.verify(festivityDAOMock);
	}

	/**
	 * Tests saving a festivity It ends up updating the festivity
	 * 
	 * @throws ProdigiousException
	 *             when an error occurs
	 */
	@Test
	public void saveFestivity_CompleteInfo_ShouldSuccess()
			throws ProdigiousException {

		EasyMock.reset(festivityDAOMock);

		Festivity festivity = new Festivity();
		festivity.setEndDate("2015-10-27T14:01:09.009Z");
		festivity.setStartDate("2014-10-27T14:01:09.009Z");
		festivity.setId("adsad454323");
		festivity.setName("name");
		festivity.setPlace("place");

		List<Festivity> fest = new ArrayList<>();
		fest.add(festivity);

		EasyMock.expect(festivityDAOMock.getAllFestivities()).andReturn(fest);

		EasyMock.expect(festivityDAOMock.updateFestivity(festivity)).andReturn(
				new Festivity());

		EasyMock.replay(festivityDAOMock);

		Festivity fes = service.saveFestivity(festivity);

		assertNotNull(fes);

		EasyMock.verify(festivityDAOMock);
	}

	/**
	 * Tests saving a festivity
	 * 
	 * @throws ProdigiousException
	 *             when an error occurs
	 */
	@Test
	public void saveFestivity_NotCompleteInfo_ShouldSuccess()
			throws ProdigiousException {

		EasyMock.reset(festivityDAOMock);

		Festivity festivity = new Festivity();
		festivity.setEndDate("2015-10-27T14:01:09.009Z");
		festivity.setStartDate("2014-10-27T14:01:09.009Z");
		festivity.setId("adsad454323");
		festivity.setName("name");
		festivity.setPlace("place");

		List<Festivity> fest = null;

		EasyMock.expect(festivityDAOMock.getAllFestivities()).andReturn(fest);

		EasyMock.expect(festivityDAOMock.saveFestivity(festivity)).andReturn(
				new Festivity());

		EasyMock.replay(festivityDAOMock);

		Festivity fes = service.saveFestivity(festivity);

		assertNotNull(fes);

		EasyMock.verify(festivityDAOMock);
	}

	/**
	 * Tests updating a festivity
	 */
	@Test
	public void updateFestivity_CompleteInfo_ShouldSuccess() {

		EasyMock.reset(festivityDAOMock);

		Festivity festivity = new Festivity();
		festivity.setEndDate("2015-10-27T14:01:09.009Z");
		festivity.setStartDate("2014-10-27T14:01:09.009Z");
		festivity.setId("adsad454323");
		festivity.setName("name");
		festivity.setPlace("place");

		EasyMock.expect(festivityDAOMock.updateFestivity(festivity)).andReturn(
				new Festivity());

		EasyMock.replay(festivityDAOMock);

		Festivity fes = service.updateFestivity(festivity);

		assertNotNull(fes);

		EasyMock.verify(festivityDAOMock);
	}
}
