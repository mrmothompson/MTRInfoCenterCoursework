package mtr;

import java.util.Scanner;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return null;
	}

}
