package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;
// 16진수 : 0 1 2 3 4 / 5 6 7 8 9 / A D C D E F /
// 회전수는 N/4-1 번하면 된다.
public class 보물상자비밀번호_5658 {
    static int N, K;
    static char[] arr;
    static HashMap<Integer, Boolean> hmap;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;        

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = br.readLine().toCharArray();

            hmap = new HashMap<>();
            pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2, o1));
            sb = new StringBuilder();

            rotate(0);
            int answer = getNum();
            bw.write("#"+t+" "+answer+"\n");
        }// 테케 끝
        bw.flush();
    }
    private static int getNum() {
        int idx = 1;
        while(!pq.isEmpty()){
            int result = pq.poll();
            if(idx==K){
                return result;
            }else idx++;
        }
        return -1;
    }
    // 회전하기
    private static void rotate(int cnt) {
        for(int i = 0; i<4; i++){
            checkNum(N/4*i, N/4*(i+1));             
        }
        if(cnt+1==N/4){
            return;
        }
        rotateArr();    // 배열 회전하기
        rotate(cnt+1);
    }
    // 배열 회전
    private static void rotateArr() {
        char tmp = arr[arr.length-1];
        for(int i = arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = tmp;
    }
    // start부터 end전까지의 요소들을 뽑아내서 체크
    private static void checkNum(int start, int end) {
        for(int i = start; i <end; i++){
            sb.append(arr[i]);
        }
        int result = Integer.parseInt(sb.toString(),16);    // 16진수 10진수 변환
        sb.setLength(0);
        if(hmap.containsKey(result)) return;    // 이미 있으면 그냥 바로 return
        else{ // 새로운 수이면
            hmap.put(result, true);  // 방문 표시
            pq.add(result); // pq에 넣기
            return;
        }
    }
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo&