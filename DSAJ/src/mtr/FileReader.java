package mtr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**  */
public class FileReader {

	/**  */
	public String file;

	/**  */
	public int stationsCount;

	/**  */
	public int linesCount;

	/**  */
	public HashSet<Line> lines;

	/**  */
	public ArrayList<Station>stations;


	/**
	 * Used to count the stations and line sizes in order to initialise Hash data structures
	 * @param file - the file to read
	 * @throws FileNotFoundException
	 */
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

	/**
	 * Reads a File and sets up the datastructures for the lines and stations
	 * @param file
	 * @throws IOException
	 */
	public FileReader(String file) throws IOException {
		// read seminar records from data file
		Scanner in = new Scanner(new File(file));
		Counter(file);
		lines = new HashSet<>(linesCount * 2);
		stations = new ArrayList<>(stationsCount*2);
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
				stations.add(s);
				line.getLinkedListStations().add(s.toString());
				line.getTreeSetStations().add(s.toString());
				for(Station st:stations)
				{
					if(st.equals(s))
					{
						st.addLines(line);
					}
				}
			} 
			
			lines.add(line);
		}						
		this.file = file;
		
		
	}

	/**  */
	public ArrayList<Station> getAllStations() {
		return stations;
	}

	/**
	 * The Main -- for a quick unit testing
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		FileReader f = new FileReader(args[0]);
		System.out.println("this service has " + f.stationsCount +" stations and " + f.linesCount + " lines" );
	}
}

