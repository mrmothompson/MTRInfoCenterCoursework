package mtr;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class ControllerImpl implements Controller {

	private FileReader f;
	private Scanner stdIn;
	public ControllerImpl(FileReader f) {
		this.f = f;
		stdIn = new Scanner(System.in);
	}

	@Override
	public String listAllTermini() {
		String s="These are all the Termini for the MTR Lines:\n";
		for(Line l: f.lines)
		{
			s+=l.getTermini()+"\n";
		}

		return s;
	}

	@Override
	public String listStationsInLine(String line) {

		String a=null;
		for(Line l : f.lines) {		
			if(l.getLineName().equals(line)) {
				a= l.getLineName()+ ":"+l.toString();
			}
		}
		if(a!=null)
		{
			return a;
		}
		else{
			return "Line '"+line+"' does not exist on our system";
		}


	}

	@Override
	public String listAllDirectlyConnectedLines(String line) {
		Set<Line>connected = new HashSet<>(f.linesCount*2);
		Line query = lineSearch(line);
		int count=0;
		String conSta="";


		if(query!=null)
		{
			for (Line l : f.lines) {
				LinkedList<String> intersection = l.getIntercection(query);
				if(!intersection.isEmpty()&&!l.getLineName().equals(query.getLineName())&&!l.getLineName().equals("Walkable"))
				{
					connected.add(l);
					conSta+=l.getLineName()+"\n";
					count++;
				}
			}
			return "'"+query.getLineName()+"' Is directly connected to "+count+" line(s):\n"+conSta;
		}
		else
		{
			return "Line '"+line+"' does not exist on our system";
		}
	}

	@Override
	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return null;
	}

	public Line lineSearch(String line)
	{
		for(Line l : f.lines) {		
			if(l.getLineName().equals(line)) {
				return l;
			}
		}
		return null;
	}
}
