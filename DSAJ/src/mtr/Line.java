package mtr;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public interface Line {

	/** Accessor/Getter for Train Line
	 * @return String - name of Train Line
	 */
	String getLineName();

	/** Mutator/Setter for Train Station
	 * @param station: Station
	 */
	void add(Station station);

	/** Mutator/Setter for Termini of Train Line
	 * Termini means first and last Station of a Train Line
	 */
	void setTermini();

	/** Accessor/Getter for Termini of Train Line
	 * Termini means first and last Station of a Train Line
	 */
	String getTermini();
	
	/** Accessor/Getter for Set of all Stations
	 * @return Set [Station]
	 */
	Set<Station> getLineStations();
	
	/** Accessor/Getter for Set of all Stations
	 * @return Set [Line]
	 */
	Set<Line> getConnectedLines(Collection<Line> Lines);

	/** Accessor/Getter for list of intersecting Train Lines
	 * @param line: Line
	 * @return LinkedList [String]
	 */
	LinkedList<String> getIntercection(Line line);

	/** toString Method
	 * @return String
	 */
	String toString();

	/** Accessor/Getter for Stations
	 * @return LinkedList [String]
	 */
	LinkedList<String> getLinkedListStations();

	/** Accessor/Getter for Stations
	 * @return Set [String]
	 */
	Set<String> getTreeSetStations();

	/** Accessor/Getter for a shared Train Line of Two Stations
	 * @return Queue [String]
	 */
	Queue<String> getLineFromTwoStations(Station a, Station b);

}