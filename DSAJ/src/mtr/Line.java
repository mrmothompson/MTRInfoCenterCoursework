package mtr;

import java.util.Collection;
import java.util.Set;

public interface Line {

	String getLineName();
	
	void add(Station station);
	
	String getTermini();
	
	Set<Station> getAllStations();
	
	Set<Line> getConnectedLines(Collection<Line> Lines );
	
	Set<String> getIntercection(Line line);
	
	String toString();


}
