import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
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
    }
}

