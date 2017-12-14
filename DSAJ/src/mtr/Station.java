package mtr;


public interface Station {

	String getStationName();
	
	void setNextStation(Station station);
	
	Station nextStation();
	
	void setPreviousStation(Station station);
	
	Station previousStation();
	
	String toString();

	boolean equals(Station station);
	
}
