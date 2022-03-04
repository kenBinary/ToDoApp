import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ActivityWriter {
    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv",
                true))) {
            writer.write(mem + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
