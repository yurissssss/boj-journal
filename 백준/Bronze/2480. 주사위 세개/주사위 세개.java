import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dice = new int[3];
        
        for (int i = 0; i < 3; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(dice);
        
        br.close();
        
        System.out.println(setMoney(dice));
    }
  
    private static int setMoney(int[] dice) {
        int money = dice[2] * 100;
        
        if ((dice[0] == dice[1]) && (dice[1] == dice[2]))
            money = 10000 + dice[0]*1000;
        else if (dice[0] == dice[1])
            money = 1000 + dice[0]*100;
        else if (dice[1] == dice[2])
            money = 1000 + dice[1]*100;
        
        return money;
    }
}