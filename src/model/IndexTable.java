package model;

import view.SimulationView;

public class IndexTable {
	
	public static int getTotalfirm() {
		return totalfirm;
	}
	public static void setTotalfirm(int totalfirm) {
		IndexTable.totalfirm = totalfirm;
	}
	public static String[] getFirms() {
		return firms;
	}
	public static void setFirms(String[] firms) {
		IndexTable.firms = firms;
	}
	public static String[][] getTable() {
		return table;
	}
	public static void setTable(String[][] table) {
		IndexTable.table = table;
	}
	public static int getOpen() {
		return open;
	}
	public static void setOpen(int open) {
		IndexTable.open = open;
	}
	public static int getLast() {
		return last;
	}
	public static void setLast(int last) {
		IndexTable.last = last;
	}
	public static int getVolume() {
		return volume;
	}
	public static void setVolume(int volume) {
		IndexTable.volume = volume;
	}
	public static int getRic() {
		return ric;
	}
	public static void setRic(int ric) {
		IndexTable.ric = ric;
	}
	public static String getDateInString() {
		return table[0][date];
	}
	public static int getDate() {
		return date;
	}
	public static void setDate(int date) {
		IndexTable.date = date;
	}
	public static int getFirmIndex(String tic){
		int i;
		for(i = 0; i<totalfirm; i++){
			if(firms[i].equals(tic))break;
		}
		return i;
	}	
	public static String getCell(int x, int y){
		return table[x][y];
	}
	public static String getCell(String tic, int y){
		System.out.println("InedxTable "+getFirmIndex(tic)+" "+y);
		return table[getFirmIndex(tic)][y];
	}
	private static String [][] table;
	private static int open;
	private static int last;
	private static int volume;
	private static int ric;
	private static int date;
	private static int totalfirm;		
	private static String firms[];	
	
}
