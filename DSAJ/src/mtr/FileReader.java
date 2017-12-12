package mtr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileReader {

	public String file;
	public int stationsCount;
	public int linesCount;
	public HashSet<Line> lines;



	private void Counter(String file) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(file));
		// read records one by one
		while(in.hasNextLine()){
			String record = in.nextLine();
			String[] station = record.split(",");
			int lines = 0;

			for (int i=1;i<station.length;i++ )
			{			
				lines++;					
			} 
			stationsCount+=lines;
			linesCount++;
		}						
		stationsCount+=1;
	}

	public FileReader(String file) throws IOException {
		// read seminar records from data file
		Scanner in = new Scanner(new File(file));
		Counter(file);
		lines = new HashSet<>(linesCount * 2);
		// read records one by one
		while(in.hasNextLine()){
			String record = in.nextLine();
			String[] station = record.split(",");
			Line line = new LineImpl(station[0]);
			//System.out.println("Created line: " + line.getLineName());
			for (int i=1;i<station.length;i++ )
			{
				//System.out.println("adding "+ station[i]+" to "+line.getLineName());
				Station s = new StationImpl(station[i], null, null);
				line.add(s);						
			} 
			lines.add(line);
		}						
		this.file = file;
	}



	/**
	 * The Main -- for a quick unit testing
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		FileReader f = new FileReader(args[0]);
		System.out.println("this service has " + f.stationsCount +" stations and " + f.linesCount + " lines" );
		for(Line l: f.lines)
		{
			System.out.println(l.getTermini());
		}
//
//		String q="Airport Express";
//		String a=null;
//		for(Line l : f.lines) {		
//			if(l.getLineName().equals(q)) {
//				a= l.getLineName()+ ":"+l.toString();
//			}
//		}
//		if(a!=null)
//		{
//			System.out.println(a);
//		}
//		else{
//			System.out.println("Line '"+q+"' does not exist on our system");
//		}
//
//		Set<Line>connected = new HashSet<>(f.linesCount);
//		Line il = null;
//		Line swl = null;
//		String s="Island Line";
//		String s2="Walkable";
//		for(Line l : f.lines) {		
//			if(l.getLineName().equals(s)) {
//				il=l;
//			}
//			if(l.getLineName().equals(s2)) {
//				swl=l;
//			}
//		}
//		if(il!=null && swl!=null)
//		{
//		
//			for (Line line : f.lines) {
//				Set<String> r = line.getIntercection(il);
//				if(!r.isEmpty()&&!line.getLineName().equals(il.getLineName())&&!line.getLineName().equals("Walkable"))
//				{
//					connected.add(line);
//				}
//			}
//			String conSta="'"+il.getLineName()+"' Is directly connected to:\n";
//			for (Line conn : connected) {
//				conSta+=conn.getLineName()+"\n";
//			}
//			System.out.println(conSta);
//		}


	}
}

