package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G3줄세우기_2252 {
    private static ArrayList<Integer>[] list;
    private static int[] arr;
    private static Queue<Integer> q;
    private static int N, M;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());
            arr[tall]++; // 연결된 개수 구하기
            list[small].add(tall);
        }

        q = new LinkedList<>();
        isVisited = new boolean[N + 1];        
        // 처음 0인값 넣어주기
        for (int i = 1; i <= N; i++) { // 한 번도 연결되지 않음 -> 제일 작은 사람
            if (arr[i] == 0) {
                q.add(i);
                isVisited[i] = true;                
            }
        }        
        while (!q.isEmpty()) { // N만큼 모두 줄을 세우면
            int num = q.poll();
            bw.write(""+num+" ");

        
            for (int i = 0; i < list[num].size(); i++) {
                int next = list[num].get(i);
                arr[next]--;
                if(arr[next]==0&&!isVisited[next]){
                    q.add(next);
                }
            }

        }        
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2252