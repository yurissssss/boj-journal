import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = br.readLine();
        
        int answer = 0;
        int num = 0;
        
        while(num < st.length()) {
            char alp = st.charAt(num);
            
            if (alp == 'c') {
                if ((num + 1 < st.length()) && ((st.charAt(num + 1) == '=') || (st.charAt(num + 1) == '-'))) {
                    num += 2;
                } else num++;
            } else if (alp == 'd') {
                if ((num + 2 < st.length()) && (st.charAt(num + 1) == 'z') && (st.charAt(num + 2)) == '=') {
                    num += 3;
                } else if ((num + 1 < st.length()) && st.charAt(num + 1) == '-') num += 2;
                else num++;
            } else if (alp == 'l' || alp == 'n') {
                if ((num + 1 < st.length()) && (st.charAt(num + 1) == 'j')) {
                    num += 2;
                } else num++;
            } else if (alp == 's' || alp == 'z') {
                if ((num + 1 < st.length()) && (st.charAt(num + 1) == '=')) {
                    num += 2;
                } else num++;
            } else num++;
            
            answer++;
        }
        
        System.out.println(answer);
        
        br.close();
    }
}