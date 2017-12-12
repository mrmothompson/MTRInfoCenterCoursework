package mtr;


public interface Station {

	String getStationName();
	
	Station nextStation();
	
	Station previousStation();
	
	String toString();

	boolean equals(Station station);
	
}
