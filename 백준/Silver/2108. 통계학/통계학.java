import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[8001];  //  입력되는 정수의 범위: -4000 ~ 4000
        int sum = 0;
        int mode = 0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;  // index = 0 ~ 8000까지 나온 횟수 저장
        }
                
        Arrays.sort(arr);
        
        System.out.println(Math.round(((double)sum / n)));  // 산술평균
        System.out.println(arr[n / 2]);  // 중앙값

        // 가장 많이 나온 횟수 구하기
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            max = Math.max(max, count[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == max) {
                list.add(i - 4000);
            }
        }
        
        Collections.sort(list);
        
        if (list.size() > 1) mode = list.get(1);
        else mode = list.get(0);

        System.out.println(mode);  // 최빈값
        System.out.println(arr[n - 1] - arr[0]);  // 범위
        
        br.close();
    }
}