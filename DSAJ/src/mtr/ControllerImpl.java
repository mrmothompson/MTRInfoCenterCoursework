package mtr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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




		Station A = null;
		Station B = null;
		A=stationSearch(stationA);
		B=stationSearch(stationB);

		if(!(A==null) && !(B==null))
		{	
			if(A.equals(B))
			{
				return "You have entered the same station for both entries the path is: "+A.getStationName();
			}
			else{

				ArrayList<Line> aLines = A.getLines();
				ArrayList<Line> bLines = B.getLines();
				ArrayList<Line> connected = new ArrayList<>();

				if(aLines.get(0).toString().equals(bLines.get(0).toString()))
				{
					Queue<String> route = aLines.get(0).getLineFromTwoStations(A, B);
					String s="";
					while(route.size()>0)
					{
						s+=route.remove();
						if(route.size()!=0)
						{
							s+="->";
						}
					}

					return s;
				}
			}

		}




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

	public Station stationSearch(String station)
	{
		for(Station s : f.stations) {		
			if(s.getStationName().equals(station)) {
				return s;
			}
		}
		return null;
	}
}
