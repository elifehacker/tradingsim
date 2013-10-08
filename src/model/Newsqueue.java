package model;

import java.util.LinkedList;

public class Newsqueue {

	private static LinkedList<String> news = new LinkedList<String>();

	public static void enque(String n){
		news.add(n);
		if(news.size()==50) deque();
	}
	
	public static void deque(){
		news.removeFirst();
	}
	
	public static String[][] toBoard(){
		int size = news.size();
		String [][] board = new String [size][1];
		for(int i =0 ; i < size ; i++){
			board[size-i-1][0] = news.get(i);
		}
		return board;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
