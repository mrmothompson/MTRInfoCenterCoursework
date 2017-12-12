package mtr;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LineImpl implements Line{

	private String lineName;
	private Station[] stationTermini;
	private Set<Station> stations;

	public LineImpl(String lineName) {
		this.lineName=lineName;
		stations= new LinkedHashSet<Station>();
		stationTermini=new Station[2];

	}

	public void add(Station station) {
		stations.add(station);
		setTermini();
	}

	@Override
	public String getLineName() {
		return lineName;
	}

	@Override
	public void setTermini() {
		Object[] temp = stations.toArray();
		Station start=(Station)temp[0];
		Station end=(Station)temp[temp.length-1];
		stationTermini[0]=start;
		stationTermini[1]=end;	

	}

	@Override
	public String getTermini() {

		String s ="The termini of '"+getLineName()+"' are: ";

		return s+ stationTermini[0]+" and "+stationTermini[1];
	}

	@Override
	public Set<Station> getAllStations() {
		return stations;
	}

	@Override
	public Set<Line> getConnectedLines(Collection<Line> line) {


		return null;
	}


	public Set<String> getIntercection(Line line){
		Set<String>intersection=new HashSet<>();
		Set<String>set= new HashSet<>();

		for (Station s:line.getAllStations())
		{
			intersection.add(s.toString());
		}

		for (Station s:this.getAllStations())
		{
			set.add(s.toString());
		}

		intersection.retainAll(set);
		return intersection;
	}

	public String toString() {
		String result = "";
		for(Station item : stations) {
			
				result += item + "<-->";
		
		}
		return result;

	}


}

