package mtr;

import java.util.ArrayList;

/**  */
public interface Station {


	/** Accessor/Getter for Station name
	 * @return String - name of Station
	 */
	String getStationName();

	/** Mutator/Setter for the next Station
	 */
	void setNextStation(Station station);

	/** Accessor/Getter for the next Station
	 * @return Station - next Station
	 */
	Station nextStation();

	/** Mutator/Setter for the previous Station
	 */
	void setPreviousStation(Station station);


	/** Accessor/Getter for the next Station
	 * @return Station - previous Station
	 */
	Station previousStation();

	
	/**
	 * @return String representation of Station
	 */
	String toString();

	
	/**Checks if two station names are equal
	 * @param station the station you want to compare
	 * @return if it is equal or not
	 */
	boolean equals(Station station);


	/**
	 * @return all the Lines the station is on
	 */
	ArrayList<Line> getLines();

	/**  */
	void addLines(Line line);
	
}
