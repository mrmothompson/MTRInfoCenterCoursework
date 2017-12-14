package mtr;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
/** + ControllerImpl -implements-> Controller
 *
 */
public class ControllerImpl implements Controller {

	/** - fileReader: FileReader */
	private FileReader f;

	/** - stdIn: Scanner */
	private Scanner stdIn;

	/** + ControllerImpl: Constructor
	 * initializes fileReader: FileReader with parameter
	 * initializes stdIn: Scanner with System.in
	 */
	public ControllerImpl(FileReader f) {
		this.f = f;
		stdIn = new Scanner(System.in);
	}

	@Override
	public String listAllTermini() {
		StringBuilder rtn = new StringBuilder("These are all the Termini for the MTR Lines:\n");
		for(Line l: f.lines)
			rtn.append(l.getTermini()).append("\n");

		return rtn.toString();
	}

	@Override
	public String listStationsInLine(String line) {
		String rtn = null;
		for(Line l : f.lines)
			if(l.getLineName().equals(line))
				rtn=l.getLineName()+":"+l.toString();

		return (rtn!=null)?rtn:"Line '"+line+"' does not exist on our system";
	}

	@Override
	public String listAllDirectlyConnectedLines(String line) {
		Set<Line>connected = new HashSet<>(f.linesCount*2);
		Line query = lineSearch(line);
		int count = 0;
		StringBuilder conSta = new StringBuilder();

		if(query!=null){
			for (Line l : f.lines) {
				LinkedList<String> intersection = l.getIntercection(query);
				if(!intersection.isEmpty()&&!l.getLineName().equals(query.getLineName())&&!l.getLineName().equals
						("Walkable")) {
					connected.add(l);
					conSta.append(l.getLineName()).append("\n");
					count++;
				}
			}
			return "'"+query.getLineName()+"' Is directly connected to "+count+" line(s):\n"+conSta;
		}
		else
			return "Line '"+line+"' does not exist on our system";
	}

	@Override
	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Searches for if a stated station Line exists
	 * @param line: String - name of station's Line you're searching for
	 */
	public Line lineSearch(String line) {
		for(Line l : f.lines)
			if(l.getLineName().equals(line))
				return l;

		return null;
	}
}
