import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Program {
	
	public static void inc(int num,  LinkedList<Integer> list){
		num++;
		list.add(num);
	}
	
	public static void reset(Program p){
		p.resetNum();
	}
	
	private int num;
	
	public Program(int n){
		num = n;
	}
	
	public void resetNum(){
		num = 0;
	}
	
	public int getNum(){
		return num;
	}
	
    public static void main(String[] args) {
        String text = "Hello world";
        try {
          File file = new File("example.txt");
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(text);
          output.close();
        } catch ( IOException e ) {
           e.printStackTrace();
        }
        int n = 5;
        LinkedList<Integer> list = new LinkedList<Integer>();
        Program.inc(n, list);
        System.out.println(n+" "+list.get(0));
        String s1[] = {"a","b"};
        String s2[] = s1;
        s2[0] = "c";
        System.out.println(s1[0]);
        System.out.println("-----------");
        Program p = new Program(9);
        reset(p);
        System.out.println(p.getNum());
        
    }
}

