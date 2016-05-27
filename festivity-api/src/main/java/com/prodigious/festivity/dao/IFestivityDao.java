package com.prodigious.festivity.dao;

import java.util.List;

import com.prodigious.festivity.entity.Festivity;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        DAO interface to define operations to do for a Festivity
 */
public interface IFestivityDao {

	/**
	 * Searches for all the saved festivities
	 * 
	 * @return the found festivities
	 */
	List<Festivity> getAllFestivities();

	/**
	 * Creates a new tuple in the DBMS
	 * 
	 * @param festivity
	 *            to be saved
	 * @return the just saved {@link Festivity}
	 */
	Festivity saveFestivity(Festivity festivity);

	/**
	 * Updates a tuple in the DBMS
	 * 
	 * @param festivity
	 *            to be updated
	 * @return the just updated {@link Festivity}
	 */
	Festivity updateFestivity(Festivity festivity);
}
