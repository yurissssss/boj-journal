import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String station1 = br.readLine();
        String station2 = br.readLine();
        
        if (station1.equals(station2)) {
            System.out.print(0);
        } else {
            System.out.print(1550);
        }
        
        br.close();
    }
}