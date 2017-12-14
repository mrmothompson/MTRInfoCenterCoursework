package mtr;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public interface Line {

	String getLineName();
	
	void add(Station station);
	
	void setTermini();
	
	String getTermini();
	
	Set<Station> getLineStations();
	
	Set<Line> getConnectedLines(Collection<Line> Lines );
	
	LinkedList<String> getIntercection(Line line);
	
	String toString();
	
	LinkedList<String> getLinkedListStations();
	
	Set<String> getTreeSetStations();

	Queue<String> getLineFromTwoStations(Station a, Station b);

}
