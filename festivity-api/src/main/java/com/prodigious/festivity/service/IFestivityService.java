package com.prodigious.festivity.service;

import java.util.List;

import com.prodigious.festivity.entity.Festivity;
import com.prodigious.festivity.exception.ProdigiousException;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        Service to handle the {@link Festivity} entity operations
 *
 */
public interface IFestivityService {

	/**
	 * Searches all the saved festivities
	 * 
	 * @return the list of saved festivities
	 */
	List<Festivity> getAllFestivities();

	/**
	 * Creates a new {@link Festivity} in the DBMS <br>
	 * If an existing {@link Festivity} with the same name is found, then is
	 * updated
	 * 
	 * @param festivity
	 *            to be created
	 * @return the created {@link Festivity}
	 * @throws ProdigiousException
	 *             thrown when an error occurs
	 */
	Festivity saveFestivity(Festivity festivity) throws ProdigiousException;

	/**
	 * Updates a {@link Festivity}
	 * 
	 * @param festivity
	 *            to be updated
	 * @return the just updated {@link Festivity}
	 */
	Festivity updateFestivity(Festivity festivity);
}
