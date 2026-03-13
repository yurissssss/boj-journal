import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Word {
    int len;
    String word;
    
    Word(int len, String word) {
        this.len = len;
        this.word = word;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Word[] arr = new Word[n];
        
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            
            arr[i] = new Word(st.length(), st);
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a.len == b.len) {
                return a.word.compareTo(b.word);
            }
            return a.len - b.len;
        });
        
        StringBuilder sb = new StringBuilder();
        String prev = "";
        
        for (int i = 0; i < n; i++) {
            if (!arr[i].word.equals(prev)) {
                sb.append(arr[i].word).append('\n');
            }
            
            prev = arr[i].word;
        }
        
        System.out.println(sb);
        
        br.close();
    }
}