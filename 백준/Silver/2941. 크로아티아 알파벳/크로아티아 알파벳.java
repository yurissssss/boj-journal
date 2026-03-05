import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = br.readLine();
        
        String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        for (String s : cro) {
            st = st.replace(s, "*");
        }
        
        System.out.println(st.length());
        
        br.close();
    }
}