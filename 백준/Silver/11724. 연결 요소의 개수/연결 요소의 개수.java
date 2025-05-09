import java.io.BufferedReader;  // 빠른 입력을 위해 사용 ('System.in' 보다 성능 우수)
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;  //공백으로 구분된 입력을 효율적으로 파싱하기 위해 사용

public class Main {
    static ArrayList<Integer>[] A;  //그래프 데이터 저장 인접 리스트
    static boolean[] visited;  //방문 기록 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  //노드 개수
        int m = Integer.parseInt(st.nextToken());  //에지 개수
        A = new ArrayList[n + 1];  //1~n번 노드를 사용하기 위해
        visited = new boolean[n + 1];  //1~n번 노드를 사용하기 위해
        for (int i = 1; i < n + 1; i++) {  //인접 리스트 초기화
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {  //에지 정보 입력
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());  //애지 시작 노드
            int e = Integer.parseInt(st.nextToken());  //에지 끝 노드
            A[s].add(e);  //양방향 그래프 -> 양쪽에 에지 추가
            A[e].add(s);
        }
        int count = 0;  //연결 요소 개수
        for (int i = 1; i < n + 1; i++) {  //연결 요소 탐색
            if (!visited[i]) {  //방문 X 노드 발견 시
                count++;  //새로운 연결 요소 추가
                DFS(i);  //해당 노드로부터 DFS 추가
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {  //깊이 우선 탐색 (DFS)
        if (visited[v]) {  //이미 방문한 노드라면
            return;  //탐색 중단 -> 무한 루프 방지
        }
        visited[v] = true;  //현재 노드 방문 처리 -> 중복 탐색 방지
        for (int i : A[v]) {  //현재 노드와 연결된 모든 인접 노드 탐색
            if (visited[i] == false) {  //방문 X 노드라면
                DFS(i);  //재귀 호출
            }
        }
    }
}
