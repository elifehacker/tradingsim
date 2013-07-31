package filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Chartmaker {

	/**
	 * @param args
	 * @throws IOException 
	 */
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Chartmaker obj = new Chartmaker();
		obj.run("test.csv");
		
	}
	
	public void run(String csvFile) throws IOException {

	    BufferedReader br = new BufferedReader(new FileReader("header.txt"));
        StringBuilder sb = new StringBuilder();

	    String output = sb.toString();
	    
	    try {
		    br = new BufferedReader(new FileReader(csvFile));
	        sb = new StringBuilder();
	        line = br.readLine();

	        while (line != null) {
	        	//work on these
	            //sb.append(line);
	            //sb.append("\n");
	            
				String[] columns = line.split(cvsSplitBy);
	            
		        System.out.println(columns[0]+" "+columns.length);

	            
	            line = br.readLine();
	        }
	        //System.out.println(everything);
	        output = output.concat(sb.toString());
	        
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
	    br = new BufferedReader(new FileReader("footer.txt"));
        sb = new StringBuilder();

	    output = output.concat(sb.toString());
	    
		br.close();

	}
	

}
