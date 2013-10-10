package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import view.SimulationView;

public class DataReader {

	public int getTotalFirm() {
		return totalfirm;
	}

	public float getStartingCash() {
		return startingCash;
	}
	
	public String[][] get_table(){
		return index_table;
	}
	
	public String getDate(){
		return file_content[0][date];
	}
	
	public String[] getFileContent(int i){
		return file_content[i];
	}
	
	public String[] getFileTitle(){
		return 	file_title;
	}
	public String[] getFirms(){
		return firms;
	}
	
	public int getFirmIndex(String tic){
		int i;
		for(i = 0; i<totalfirm; i++){
			if(firms[i].equals(tic))break;
		}
		return i;
	}
	
	private BufferedReader brs[];
	private FileWriter fws[];
	private BufferedWriter bws[];
	private float lasts[];
	private int daycount = 0;
	private BufferedReader newsreader;
	private String nline;
	
	private String file_title[];
	private String news_title[];
	private String index_table[][];
	private String file_content[][];
	
	private double volatility[];

	private String firms[];
	private String path;
	
	private int open;
	private int last;
	private int volume;
	private int ric;
	private int date;
	
	private int ndate;
	private int ntake;
	private int nhead;
	
	private BlackSchole bs;
	
	private String chart_dir = "chartdata";
    private String chart_index = "data.csv";
	
	private boolean simulationend = false;
	private int bufferstage[];
	
	private int hourcounter = 0;	
	
    private int totalfirm = 0;
    private float startingCash;
	
	public DataReader(String folder, float cash){
		
		startingCash = cash;
		
		double current_price[] = null;
		if(!folder.equals("null")){
		    path = "packages/"+folder+"/";

			try {
				BufferedReader br = new BufferedReader(new FileReader(path+folder+".csv"));
		        String line; 
		        String splited[];
		        String lastfirm ="";
		        int stage = 0;
		        File file = null;
		        FileWriter fw = null;
		        BufferedWriter bw;
		        
		        if((line= br.readLine())!= null){
		        	splited = line.split(",");
		        	file_title = new String [splited.length];
	        		System.arraycopy(splited, 0, file_title, 0 , splited.length);
	        		int counter = 0;
	    			for(int k = 0; k < file_title.length; k++){
	    				if(file_title[k].equals("Open")){
	    					open = k;
	    					IndexTable.setOpen(k);
	    					counter++;
	    				}if(file_title[k].equals("Last")){
	    					last = k;
	    					IndexTable.setLast(k);
	    					counter++;
	    				}if(file_title[k].equals("Volume")){
	    					volume = k;
	    					IndexTable.setVolume(k);
	    					counter++;
	    				}if(file_title[k].equals("#RIC")){
	    					ric = k;
	    					IndexTable.setRic(k);
	    					counter++;
	    				}if(file_title[k].equals("Date[L]")){
	    					date = k;
	    					IndexTable.setDate(k);
	    					counter++;
	    				}
	    			}
	    			if(counter != 5){
						JOptionPane.showMessageDialog(null,
							    "Please parse in data file with #RIC, Open, Last, Time[L] and Volume columns");
						simulationend = true;
	    			}
	        		
	        	}
		        LinkedList<String> flist = new LinkedList<String>();
		        LinkedList<Double> plist = new LinkedList<Double>();

		        while((line= br.readLine())!= null){
		        	splited = line.split(",");
		        	if(splited[open].isEmpty()){ // if open column is empty then other columns are also empty
		        		
		        	}else{
		        		
						if(lastfirm.equals("")||!lastfirm.equals(splited[ric])){
							lastfirm = splited[ric];
							totalfirm++;
							stage = 0;
							flist.add(lastfirm);
							plist.add(Double.parseDouble(splited[last]));

						}
						if(stage  == 0){
							file = new File(path+splited[ric]+".csv");
							fw = new FileWriter(file);
							stage = 1;
							
						}else if(stage  == 1){
							fw = new FileWriter(file.getAbsoluteFile(),true);
							stage= 2;
						}
						bw = new BufferedWriter(fw);
						//System.out.println("Making csv from raw TRTH file "+line);
				        bw.write(line+"\n");
				        bw.flush();		        		
		        	}
		        	
		        }
		        
		        firms = new String[totalfirm];
		        lasts = new float[totalfirm];
		        SimulationView.displayingtable = new String[totalfirm+1][SimulationView.get_index_title().length];
		        
		        current_price = new double[totalfirm];
		        for(int i = 0; i < flist.size(); i++){
		        	firms[i] = flist.get(i);
		        	current_price[i] = plist.get(i);
		        	//System.out.println("firm[i] "+firms[i]);
		        }
		        IndexTable.setFirms(firms);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
		
        String[][] preview = new String [totalfirm][3];
		try {
			BufferedReader br = new BufferedReader(new FileReader(path+"preview.csv"));
	        String line;
	        boolean firstline = true;
	        int o_ric = 0, o_last=0, o_date=0;
	        String lastric = "";
	        int counter = 0;
	        while((line = br.readLine()) !=null){
		        String[] splited = line.split(",");		        
		        if(firstline){
		        	firstline = false;
		        	for(int k = 0; k < splited.length; k++){
		        		if(splited[k].equals("Last")){
	    					o_last = k;
	    				}if(splited[k].equals("#RIC")){
	    					o_ric = k;
	    				}if(splited[k].equals("Date[L]")){
	    					o_date = k;
	    				}
		        	}
		        }else{
		        	if(!lastric.equals(splited[o_ric].substring(0, 3))&&!splited[o_last].isEmpty()){
				        lastric = splited[o_ric].substring(0, 3);					        					        	
		        		preview[counter][0] = lastric;
		        		preview[counter][1] = splited[o_last];
		        		preview[counter][2] = convertdate(splited[o_date]);
		        		counter++;
		        	}

		        } 
	        }		       
	        br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        String[][] export = new String [totalfirm][4];
		try {
			BufferedReader br = new BufferedReader(new FileReader(path+"export.csv"));
	        String line;
	        boolean firstline = true;
	        int o_ric = 0, x_price =0, x_date=0, o_type = 0;
	        String lastric = "";
	        int counter = 0;
	        while((line = br.readLine()) !=null){
		        String[] splited = line.split(",");		        
		        if(firstline){
		        	firstline = false;
		        	for(int k = 0; k < splited.length; k++){
		        		if(splited[k].equals("Expiry Date")){
	    					x_date = k;
	    				}if(splited[k].equals("#RIC")){
	    					o_ric = k;
	    				}if(splited[k].equals("Strike Price")){
	    					x_price = k;
	    				}if(splited[k].equals("Options Type")){
	    					o_type = k;
	    				}
		        	}
		        }else{
		        	if(!lastric.equals(splited[o_ric].substring(0, 3))){
				        lastric = splited[o_ric].substring(0, 3);	
				        
				        if(counter==12) System.out.println("DR debug: "+line);
				        
				        export[counter][0] = lastric;
				        export[counter][1] = splited[o_type];
				        export[counter][2] = splited[x_price];
				        export[counter][3] = convertdate(splited[x_date]);
		        		counter++;
		        	}

		        } 
	        }		       
	        br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		volatility = new double[totalfirm];
		bs = new BlackSchole();
		int x = 0;
		for(int i = 0; i < totalfirm; i++){
			//System.out.println("DataReader export[i][0] preview[x][0]"+export[i][0]+" "+preview[x][0]);

			//CallPutFlag,  S,  X,  T,  r,  v1+diff, v2, target
			try{
				if(export[i][0].equals(preview[x][0])){
					String tic = export[i][0];
					double timediff = bs.timetilmaturity(preview[x][2],export[i][3]);
					double bondyield = bs.bondyield(timediff);
					int k;
					for(k = 0; k<totalfirm; k++){
						if(firms[k].equals(tic))break;
					}
					volatility[k] = bs.findImpliedvolatility(export[i][1].charAt(0),current_price[k], 
							Double.parseDouble(export[i][2]),timediff,bondyield,(double)0,(double)5,Double.parseDouble(preview[x][1]));
					x++;
					/*
					System.out.println("Tic v is "+tic);
					System.out.println("Calculated v is "+volatility[i]);
					System.out.println("option type is "+export[i][1].charAt(0));
					System.out.println("current_price is "+current_price[getFirmIndex(tic)]);
					System.out.println("x_price is "+Double.parseDouble(export[i][2]));
					System.out.println("bondyield is "+bondyield);
					System.out.println("Traget price is "+Double.parseDouble(preview[i][1]));
					*/
				
				}else{
					String tic = export[i][0];
					for(int k = 0; k<totalfirm; k++){
						if(firms[k].equals(tic)){
							volatility[k]= -1;
							//System.out.println("DataReader else i k "+i+" "+k);
							break;
						}
					}
				}
			}catch(Exception e){
				//System.out.println("DataReader exception i "+i);
				volatility[i]= -1;
			}
		}
		bs.setFirms(firms);
		bs.setVolatility(volatility);
		
		index_table = new String[totalfirm][SimulationView.get_index_title().length];
		file_content = new String[totalfirm][];
		
		brs = new BufferedReader[totalfirm];
		fws = new FileWriter[totalfirm];
		bws = new BufferedWriter[totalfirm];
		bufferstage = new int[totalfirm];
		for(int k = 0; k < totalfirm; k++){
			bufferstage[k]=0;
		}

		
		try {
			String line = null;
	        String splited[];
	        newsreader = new BufferedReader(new FileReader(path+"news.csv"));
			if((line= newsreader.readLine())!= null){
	        	splited = line.split(",");
	        	news_title = new String [splited.length];
        		System.arraycopy(splited, 0, news_title, 0 , splited.length);
    			for(int k = 0; k < news_title.length; k++){
    				if(news_title[k].equals("MSG_DATE")){
    					ndate = k;
    				}if(news_title[k].equals("TAKE_DATE_TIME")){
    					ntake = k;
    				}if(news_title[k].equals("HEADLINE_ALERT_TEXT")){
    					nhead = k;
    				}
    			}
			}
		}catch(Exception e){
			
		}

	}
	
	public void updateTable(){
		if(!simulationend){
			String line;
			String splited [];
			double current_price[] = new double [totalfirm];
			for(int i = 0; i < totalfirm; i++){
				if(brs[i]==null){
					try {
						//System.out.println("Debug "+firms[i]+" "+totalfirm);

						brs[i] = new BufferedReader(new FileReader(path+firms[i]+".csv"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					line = brs[i].readLine();

					if(line != null){			
						
						//System.out.println("From "+path+" the line read was "+line);
						
						splited = line.split(",", -1);
		        		splited[date] = convertdate(splited[date]);
						file_content[i] = splited;
						
						index_table[i][0]= firms[i];
						index_table[i][1]= splited[last];
						current_price[i] = Double.parseDouble(splited[last]);
						
						//net change
						float temp = 0;
						if(daycount ==0){
							index_table[i][2] = ""+temp;
						}else{
							temp = Float.parseFloat(splited[last])-lasts[i];
							index_table[i][2]= ""+temp;
							temp = temp/Float.parseFloat(splited[last])*100;
						}	
						lasts[i]= Float.parseFloat(splited[last]); 

						//% change
						index_table[i][3]= ""+temp;
						index_table[i][4]= splited[volume];

						//System.out.println(firms[i]+" last, open, volume, change: "+last+" "+open+" "+volume+" "+temp);

						writeTofile(chart_dir,firms[i], i);
						
					}else{
						IndexTable.setEnd(true);
						JOptionPane.showMessageDialog(null,
							    "You have finished this simulation.");
						simulationend = true;
						break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			IndexTable.setTable(file_content);
			SimulationView.setDisplay(index_table);
			bs.updatePrices(current_price);
			bs.updateDate(this.getDate());
			hourcounter++;
			if(hourcounter == 8) hourcounter = 0;
			
			//read in news
	        try {
	        	if(nline==null){
	        		nline= newsreader.readLine();
	        	}
    			//System.out.println("news----" );
	        	if(nline != null) { // check again to see if it is the end of file
		        	do{
		        		try{
			    			splited = nline.split(",", -1);
			    			String d = splited[ndate];
			    			String cd = getDate();
			    			//System.out.println("nline is "+nline );
			    			
			    			if(!splited[ntake].isEmpty()&& compareNewsdate(cd.split("[-/]"), d.split("[-/]"))){
			    				Newsqueue.enque(splited[ndate]+" "+splited[nhead]);	
				        		nline= newsreader.readLine();
		
			    			}else{
			    				break;
			    			}
		        		}catch(Exception e2){		        			
		        		}
		        	}while((nline= newsreader.readLine())!= null);
	        	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		daycount++;

	}

	private boolean compareNewsdate(String[] cdate, String[] news){
		int day = Integer.parseInt(news[2]);
		int month = Integer.parseInt(news[1]);
		int year = Integer.parseInt(news[0]);
		
		int cd = Integer.parseInt(cdate[0]);
		int cm = Integer.parseInt(cdate[1]);
		int cy = Integer.parseInt(cdate[2]);
		
		if(cy>year)return true;
		else if (cy==year && cm>month) return true;
		else if(cy==year && cm==month && cd>=day) return true;
		return false;
	}
	
	public void deleteMe(){

		for(FileWriter fw:fws){
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(BufferedReader br:brs){
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String convertdate(String date){
		StringBuffer sb = new StringBuffer();
		
		String[] splited = date.split("-");
		if(splited != null){

			sb.append(splited[0]+"-");
			String lower = splited[1].toLowerCase();
			if(lower.equals( "jan")){
	            lower = "01";
	            
	        }else if(lower.equals( "feb")){
	            lower = "02";
	            
	        }else if(lower.equals( "mar")){
	            lower = "03";
	            
	        }else if(lower.equals( "apr")){
	            lower = "04";
	            
	        }else if(lower.equals( "may")){
	            lower = "05";
	            
	        }else if(lower.equals( "jun")){
	            lower = "06";
	            
	        }else if(lower.equals( "jul")){
	            lower = "07";
	            
	        }else if(lower.equals( "aug")){
	            lower = "08";
	            
	        }else if(lower.equals( "sep")){
	            lower = "09";
	            
	        }else if(lower.equals( "oct")){
	            lower = "10";
	            
	        }else if(lower.equals( "nov")){
	            lower = "11";
	            
	        }else if(lower.equals( "dec")){
	            lower = "12";
	            
	        }
			sb.append(lower+"-"+splited[2]);
		}
		return sb.toString();
    }

	
	private void writeTofile(String chart_dir, String chart_index, int index) {
		// TODO Auto-generated method stub		
		//System.out.println("writeTofile xxx.csv");
		File file = new File(chart_dir,chart_index+".csv");
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			//System.out.println("File does not exist");

			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		try { //write index to the csv file for amchart
			if(bufferstage[index]  == 0){
				//System.out.println("Flag is false, first time "+file.getName());

				fws[index] = new FileWriter(file);
				bufferstage[index] = 1;
				
			}else if(bufferstage[index]  == 1){
				fws[index] = new FileWriter(file.getAbsoluteFile(),true);
				bufferstage[index] = 2;
			}
			bws[index]= new BufferedWriter(fws[index]);
			String temp = file_content[index][date]+","+file_content[index][last]+"\n";
			//System.out.println(date+" "+temp);
	        bws[index].write(temp);
	        bws[index].flush();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
