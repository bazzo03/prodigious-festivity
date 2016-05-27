package dto;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Data Transfer Object to represent a {@link Festivity}
 */
public class FestivityDto {

	private String name;
	private String place;
	private String startDate;
	private String endDate;

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
