package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;

public class 비서로소그래프_13432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int TK = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TK; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
                        
            if (start == end) {
                bw.write("#" + t + " " + "0\n");
            } else {                                            
                PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.len, o2.len));
                pq.add(new Node(start, 0));
                // boolean[] isVisited = new boolean[N+1];
                boolean finish = false;
                int max = getMax(N);
                while (!pq.isEmpty()) {
                    Node node = pq.poll();
                    if(node.len>max) break;
                    // if (isVisited[node.start])
                    //     continue;
                    // isVisited[node.start] = true;
                    if (node.start == end) {
                        finish = true;
                        bw.write("#" + t + " " + node.len + "\n");
                        break;
                    }
                    for (int i = 2; i <= N; i++) {
                        // if(isVisited[i]) continue;
                        if (check(node.start, i)) {
                            pq.add(new Node(i, node.len+1));
                        }
                    }
                }
                if(!finish) bw.write("#" + t + " " + "-1\n");
            }
            bw.flush();
        } // 테케 끝
    }

    private static int getMax(int num) {
        int result = 0;
        int tmp = num;
        for (int i = 2; i <= num; i++) {
            if(tmp%i==0){
                result+=tmp/i;
                tmp/=i;
            }
        }
        return result;
    }

    private static boolean check(int a, int b) {
        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        int start;
        int len;

        public Node(int start, int len) {
            this.start = start;
            this.len = len;
        }
    }
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AX4ENOBK8MkDFARe&categoryId=AX4ENOBK8MkDFARe&categoryType=CODE&&&