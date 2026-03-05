import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = br.readLine();
        
        int num = st.length();
        
        int sum = 0;
        
        for (int i = 0; i < num; i++) {
            char alp = st.charAt(i);
            
            if (alp == 'A' || alp == 'B' || alp == 'C') sum += 3;
            else if (alp == 'D' || alp == 'E' || alp == 'F') sum += 4;
            else if (alp == 'G' || alp == 'H' || alp == 'I') sum += 5;
            else if (alp == 'J' || alp == 'K' || alp == 'L') sum += 6;
            else if (alp == 'M' || alp == 'N' || alp == 'O') sum += 7;
            else if (alp == 'P' || alp == 'Q' || alp == 'R' || alp == 'S') sum += 8;
            else if (alp == 'T' || alp == 'U' || alp == 'V') sum += 9;
            else sum += 10;
        }
        
        System.out.println(sum);
        
        br.close();
    }
}