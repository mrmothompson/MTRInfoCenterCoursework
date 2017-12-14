package mtr;

import java.awt.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class LineImpl implements Line{

	private String lineName;
	private Station[] stationTermini;
	private Set<Station> stations;
	private LinkedList<String>llCopyStations;
	private Set<String>tsCopyStations;

	public LineImpl(String lineName) {
		this.lineName=lineName;
		stations= new LinkedHashSet<Station>();
		stationTermini=new Station[2];
		llCopyStations=new LinkedList<>();
		tsCopyStations= new TreeSet<>();
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


	public LinkedList<String> getIntercection(Line line){

		LinkedList<String>intersection= new LinkedList<>() ;
		Set<String>set= new TreeSet<>();
	
		for(Station s: line.getAllStations()){
			intersection.add(s.toString());
		}
		for(Station s: this.getAllStations()){
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

	public LinkedList<String> getLinkedListStations() {
		return llCopyStations;
	}

	public Set<String> getTreeSetStations() {
		return tsCopyStations;
	}
	
	


}

