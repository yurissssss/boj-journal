import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String letter = br.readLine();
        
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for (int i = 0; i < letter.length(); i++) {
            findLetter(i, arr, letter);
        }
        
        br.close();
        
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
    
    private static int[] findLetter(int i, int[] arr, String letter) {
        int num = letter.charAt(i) - 'a';
        
        if (arr[num] == -1) arr[num] = i;
        
        return arr;
    }
}