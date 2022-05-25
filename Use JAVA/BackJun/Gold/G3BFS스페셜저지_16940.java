package BackJun.Gold;

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class G3BFS스페셜저지_16940 {
    static int N;
    static int[] answer;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        st = new StringTokenizer(br.readLine());
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        if (bfs()) {
            bw.write("1");
        } else
            bw.write("0");
        bw.flush();

    }

    private static boolean bfs() {
        int index = 0;
        if (answer[0] != 1) // 처음이 1이 아니면 바로 false
            return false;
        Queue<Integer> q = new LinkedList<>(); 
        Set<Integer> set = new HashSet<>(); // 현재 노드에서 나올 수 있는 모든 수를 저장
        boolean[] isVisited = new boolean[N + 1];
        q.add(1);
        isVisited[1] = true;
        index++;
        while (!q.isEmpty()) {
            if (index == N)
                return true;
            int nowNumber = q.poll();            
            for (int i = 0; i < list[nowNumber].size(); i++) {
                int nextNumber = list[nowNumber].get(i);
                if(isVisited[nextNumber]) continue;
                set.add(nextNumber); // set에 모두 저장
                isVisited[nextNumber] = true;                                
            }
            if(index==N) return true; // index는 0부터 시작했으므로 index = N 모든 경우를 다 구한 경우 이므로 return
            for(int i=0; i<set.size(); i++){ // 저장된 set 사이즈 만큼
                if(set.contains(answer[index])) q.add(answer[index++]); // 현재 정답이 set에 저장되어있는 경우
                else{ // 없으면 false
                    return false;
                }
            }
            set.clear();            
        }
        return true;
    }
}
// https://www.acmicpc.net/problem/16940