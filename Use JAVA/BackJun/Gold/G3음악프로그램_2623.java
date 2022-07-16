package BackJun.Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상 정렬
public class G3음악프로그램_2623 {

    static int N, M;
    static int[] order;
    static boolean[] isVisited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int start = 0;
        order = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 처음 버리기
            start = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                order[next]++;
                list[start].add(next);
                start = next;
            }
        }
        isVisited = new boolean[N + 1];
        Queue<Integer> answer = cal();
        if (answer.size() != N) {
            bw.write("" + 0);
        } else {
            while (!answer.isEmpty()) {
                bw.write("" + answer.poll());
                if (!answer.isEmpty()) bw.newLine();
            }
        }
        bw.flush();
    }

    private static Queue<Integer> cal() {
        Queue<Integer> answer = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (order[i] == 0) {
                q.add(i);
                isVisited[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int people = q.poll();
            answer.add(people);
            for (int i = 0; i < list[people].size(); i++) {
                order[list[people].get(i)]--;
            }
            for (int i = 1; i <= N; i++) {
                if (order[i] <= 0 && !isVisited[i]) {
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
        return answer;
    }
}
//https://www.acmicpc.net/problem/2623