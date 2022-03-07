import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {
    
    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Activities.csv",
                true))) {
            writer.write(mem + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    // public LinkedList<Activity> readFile(){
        
    //     LinkedList<Activity> m = new LinkedList<Activity>();
    //     String lineRead;
    //     String[] splitLine;
    //     Activity activity;
        
    //     try (BufferedReader reader = new BufferedReader(new FileReader("Activities.csv"))) {
    //         lineRead = reader.readLine();
            
    //         while (lineRead != null) {
    //             splitLine = lineRead.split(",");

                
    //             m.add(activity);
    //             lineRead = reader.readLine();
    //         }
    //     } catch (IOException e) {
    //         System.out.println(e.getMessage());
    //     }
    //     return m;
    // }
    
}
