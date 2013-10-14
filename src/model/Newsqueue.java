package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Newsqueue {

	private static LinkedList<News> news;
	private static ArrayList<LinkedList<News>> newsll ;
	public static boolean loading = false;
	
	public static void reset(){
		news = new LinkedList<News>();
		newsll= new ArrayList<LinkedList<News>>();
		for(int i= 0; i<IndexTable.getTotalfirm(); i++){
			newsll.add(new LinkedList<News>());
		}
	}
	
	public static void enque(News n){
		news.add(n);
		enquell(n);
		if(news.size()==IndexTable.getTotalfirm()*5) deque();
	}

	public static void enquell(News n){
		String[] firms = IndexTable.getFirms();
		for(int i= 0; i<IndexTable.getTotalfirm(); i++){			
			if(n.getLink().contains(firms[i])){
				newsll.get(i).add(n);
				break;
			}
		}
	}
	
	public static void deque(){
		news.removeFirst();
	}
	
	public static String[][] toBoard(){
		int size = news.size();
		String [][] board = new String [size][3];
		int i =0;
		for(News n: news){
			board[size-i-1][0] = n.getTime();
			board[size-i-1][1] = n.getHeadline();
			board[size-i-1][2] = n.getLink();
			i++;
		}
		return board;
	}

	public static String[][] toBoardLatest(){
		int size = news.size();
		String [][] board = new String [size][3];
		int i =0;
		for(LinkedList<News> l : newsll){
			if(l.getLast()!=null){
				News n = l.getLast();
				board[size-i-1][0] = n.getTime();
				board[size-i-1][1] = n.getHeadline();
				board[size-i-1][2] = n.getLink();
				i++;
			}
		}
		return board;
	}
	
	public static String[][] toBoard(String ric){
		String[] firms = IndexTable.getFirms();

		for(int k= 0; k<IndexTable.getTotalfirm(); k++){
			
			if(ric.equals(firms[k])){
				int size = newsll.get(k).size();
				if(size !=0){
					String [][] board = new String [size][3];
					int i = 0;
					for(News n: newsll.get(k)){
						board[size-i-1][0] = n.getTime();
						board[size-i-1][1] = n.getHeadline();
						board[size-i-1][2] = n.getLink();
						i++;
						
					}					
					return board;	
				}
			}
		}

		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
