package com.prodigious.festivity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        Entity to represent each of the Festivities to handle
 */
@Entity
@Table(name = "festivity")
public class Festivity {

	/** Unique identification for this Festivity */
	@Id
	@Column(name = "festivity_id")
	@NotNull
	private String id;

	/** Name for this Festivity */
	@Column(name = "festivity_name")
	@NotNull
	private String name;

	/** Place of the festivity */
	@Column(name = "festivity_place")
	@NotNull
	private String place;

	/** Start date of this Festivity */
	@Column(name = "festivity_start_date")
	@NotNull
	private String startDate;

	/** End date of this Festivity */
	@Column(name = "festivity_end_date")
	@NotNull
	private String endDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the stardDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param stardDate
	 *            the stardDate to set
	 */
	public void setStartDate(String stardDate) {
		this.startDate = stardDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
