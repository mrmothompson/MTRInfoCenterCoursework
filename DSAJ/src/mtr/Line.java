package mtr;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public interface Line {

	String getLineName();
	
	void add(Station station);
	
	void setTermini();
	
	String getTermini();
	
	Set<Station> getAllStations();
	
	Set<Line> getConnectedLines(Collection<Line> Lines );
	
	LinkedList<String> getIntercection(Line line);
	
	String toString();
	
	LinkedList<String> getLinkedListStations();
	
	Set<String> getTreeSetStations();


}
