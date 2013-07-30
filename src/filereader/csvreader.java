package filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvreader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static String csvFile = "test.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		csvreader obj = new csvreader();
		obj.run();
		
	}
	
	public void run() throws IOException {

	    BufferedReader br = new BufferedReader(new FileReader(csvFile));
	    try {
	        StringBuilder sb = new StringBuilder();
	        line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            
				String[] columns = line.split(cvsSplitBy);
	            
		        System.out.println(columns[0]+" "+columns.length);

	            
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        
	        //System.out.println(everything);
	        
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			br.close();
			
	    }
	}
	

}
