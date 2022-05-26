package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4DFS스페셜저지_16964 {
    static int N, index;
    static boolean[] isVisited;
    static boolean end;
    static ArrayList<Integer>[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        answer = new int[N];
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
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        end = true;
        index = 1;
        isVisited = new boolean[N + 1];
        if (answer[0] != 1) {
            bw.write("0");
        } else {
            dfs(1);
            if (end)
                bw.write("1");
            else
                bw.write("0");
        }
        bw.flush();
    }

    private static void dfs(int num) {
        if (!end)
            return;
        if (isVisited[num])
            return;
        isVisited[num] = true;
        Set<Integer> set = new HashSet<>();
        for (int nowNumber : list[num]) {
            if (!isVisited[nowNumber]) { // dfs로 갈 수 있는 숫자
                set.add(nowNumber);
            }
        }
        for(int i=0; i<set.size(); i++){ // size 만큼
            if (set.contains(answer[index])) { // 해당 set에 가능한 수가 있으면
                dfs(answer[index++]); // 해당 수로 DFS 탐색
            } else {
                end = false;
                return;
            }
        }
    }
}
// https://www.acmicpc.net/problem/16964