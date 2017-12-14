package mtr;

public class StationImpl implements Station {
	private String name;
	private Station next;
	private Station previous;
	
	public StationImpl(String name, Station nextStation,Station previousStation ) {
		this.name = name;
		this.next = nextStation;
		this.previous = previousStation;
	}
	
	@Override
	public String getStationName() {
		return name;
	}

	@Override
	public void setNextStation(Station station) {
		this.next = station;
	}

	@Override
	public Station nextStation() {
		return next;
	}

	@Override
	public void setPreviousStation(Station station) {
		this.previous = station;
	}

	@Override
	public Station previousStation() {
		return previous;
	}
	
	public String toString()
	{
		return name;
	}
	
	@Override
	public boolean equals(Station station) {
		// TODO Auto-generated method stub
		if(this.name.equals(station.getStationName()))
		{
			return true;
		}
		return false;
	}

}
