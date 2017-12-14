package mtr;

import java.util.ArrayList;

public class StationImpl implements Station {
	private String name;
	private Station next;
	private Station previous;
	private ArrayList<Line> lines;
	
	public StationImpl(String name, Station nextStation,Station previousStation ) {
		this.name = name;
		this.next = nextStation;
		this.previous = previousStation;
		this.lines = new ArrayList<>();
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

	@Override
	public void addLines(Line line) {
		lines.add(line);
	}

	@Override
	public ArrayList<Line> getLines() {
		return lines;
	}

}
