import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Person {
    int index;
    int age;
    String name;
    
    Person(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            arr[i] = new Person(i, age, name);
        }
        
        Arrays.sort(arr, (a, b) -> {
            return (a.age == b.age) ? a.index - b.index : a.age - b.age;
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(arr[i].age).append(" ").append(arr[i].name).append('\n');
        }
        
        System.out.println(sb);
        
        br.close();
    }
}