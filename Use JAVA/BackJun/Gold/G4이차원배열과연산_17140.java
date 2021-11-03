package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4이차원배열과연산_17140 {

    // R연산 행의 개수 >= 열개수
    // C 연산 열의 개수 > 행 개수
    // 배열 크기 100넘어가면 앞에 100개만 저장

    static int R,C,k, answer;
    static int[][] map;
    static PriorityQueue<Node> pq;
    static PriorityQueue<Integer> tempQ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());
        map = new int[100][100];
        tempQ = new PriorityQueue<>((o1,o2)->Integer.compare(o1, o2));
        pq = new PriorityQueue<>((o1, o2) ->{
            if(o1.repeat==o2.repeat){
                return Integer.compare(o1.num, o2.num);
            }else return Integer.compare(o1.repeat, o2.repeat);
        });
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = -1;
        cal(0,3,3);
        bw.write(""+answer);
        bw.flush();
    }
    // 0 은 R 연산 1은 C 연산
    private static void cal(int time, int r, int c) {// 시간, 최대행, 최대열
        /*for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------");*/
        if(map[R][C]==k){
            answer = time;
            return;
        }
        if(time==100){
            return;
        }
        if(r>=c){   // R 연산
            cal(time+1, r, Rcal(r,c));
        }else{  // C 연산
            cal(time+1, Ccal(r,c), c);
        }

    }
    
    private static int Ccal(int r, int c) { // C 연산
        int max = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (map[j][i] != 0) {
                    tempQ.add(map[j][i]);
                    map[j][i] = 0;
                }
            }
            int num = tempQ.poll();
            int overlap = 1;
            tempQ.add(Integer.MAX_VALUE);
            while (!tempQ.isEmpty()) {
                int temp = tempQ.poll();
                if (temp != num) { // 다르면
                    pq.add(new Node(num, overlap));
                    num = temp;
                    overlap = 1;
                } else {
                    overlap++;
                }
            }
            int index = -1;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                map[++index][i] = node.num;
                map[++index][i] = node.repeat;
                if (index == 99)    break; // 끝까지 돔
            }
            pq.clear();
            max = Math.max(max, ++index);
        }
        return max;
    }
    private static int Rcal(int r, int c) { // R 연산
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) {
                    tempQ.add(map[i][j]);
                    map[i][j] = 0;
                }
            }
            int num = tempQ.poll();
            int overlap = 1;
            tempQ.add(Integer.MAX_VALUE);
            while (!tempQ.isEmpty()) {
                int temp = tempQ.poll();
                if (temp != num) { // 다르면
                    pq.add(new Node(num, overlap));
                    num = temp;
                    overlap = 1;
                } else {
                    overlap++;
                }
            }
            int index = -1;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                map[i][++index] = node.num;
                map[i][++index] = node.repeat;
                if (index == 99) break; // 끝까지 돔
            }
            pq.clear();
            max = Math.max(max, ++index);
        }
        return max;
    }
    static class Node{
        int num;
        int repeat;
        public Node(int num, int repeat) {
            this.num = num;
            this.repeat = repeat;
        }
    }
}
//https://www.acmicpc.net/problem/17140