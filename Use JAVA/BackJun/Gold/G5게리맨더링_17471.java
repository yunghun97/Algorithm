package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5게리맨더링_17471 {
    static int N, AREA1, AREA2, answer,index, maxCombi;
    static ArrayList<ArrayList<Node>> list;
    static ArrayList<Integer> a1,a2;
    static int[] map;
    static boolean[] isVisited1, isVisited2, arr, isChecked1, isChecked2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        isVisited1 = new boolean[N+1];
        isVisited2 = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        int noConnect = 0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==0){
                noConnect++;
            }else{
                while(st.hasMoreTokens()){
                    list.get(i).add(new Node(i, Integer.parseInt(st.nextToken())));
                }
            }
        }
        arr = new boolean[N+1];
        answer = Integer.MAX_VALUE;
        index = 0;
        maxCombi =1;
        for(int i=0; i<N; i++){
            maxCombi *=2;
        }
        if(noConnect>=3){   // 처음부터 외딴 섬 3개면 -1
            bw.write(""+(-1));
        }else{
            combi(1);
            if(answer==Integer.MAX_VALUE) bw.write(""+(-1));    // 선거구가 2개로 나 뉠수 없으면 -1
            else bw.write(""+answer);   // 2개로 나뉠 수 있으면 answer 출력
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void combi(int cnt) { // 부분집합 뽑기 0부터 N-1까지 돌고 0~N-1 에서 1부터 시작하므로 +1 값을 부분집합의 값에 넣는다.
        if(index>=maxCombi/2) return;   // true false false = false true true의 값과 동일하므로 부분집합 경우의수 / 2 만큼 부분집합을 뽑았으면 더 뽑지 않는다.
        if(cnt==N+1){
            // true면 1번 게더링 false면 2번 게더링해서 계산하기
            check();
            index++;
            return;
        }
            arr[cnt] = true;
            combi(cnt+1);
            arr[cnt] = false;
            combi(cnt+1);
    }
    
    private static void check() {   // 부분집합이 잘 뽑혔는지 계산
        a1 = new ArrayList<>(); // 선거구 1
        a2 = new ArrayList<>(); // 선거구 2
        isVisited1 = new boolean[N+1];
        isVisited2 = new boolean[N+2];
        for(int i=1; i<=N; i++){
            if(arr[i]){
                a1.add(i);  // true면 a1 리스에 넣는다
                isVisited1[i] = true;   //방문표시
            }
            else{
                a2.add(i);  // true면 a2리스트에 넣는다
                isVisited2[i] = true;   // 방문표시
            }
        }
        if(a1.size()==N || a2.size()==N) return;    // 부분집합이므로 공집합, 모든거 다 뽑은 경우 선거구가 나뉠 수 없으므로 return

        for(int i=1; i<=N; i++){
            if(isVisited1[i]){
                connectCheck1(i);   // 한 선거구에서 한 점은 모든 한 선거구의 점의 연결되어 있으므로 연결체크 하고 break;
                break;
            }
        }
        for(int i=1; i<=N; i++){    // 선거구의 한 점에서 연결되어 있는 점과 한 선거구의 모든 점이 같지 않으면 선거구가 연결되어 있지 않으므로 return
            if(isChecked1[i]!=isVisited1[i]) return;    
        }

        for(int i=1; i<=N; i++){
            if(isVisited2[i]){
                connectCheck2(i);  // 한 선거구에서 한 점은 모든 한 선거구의 점의 연결되어 있으므로 연결체크 하고 break;
                break;
            }
        }
        for(int i=1; i<=N; i++){    // 선거구의 한 점에서 연결되어 있는 점과 한 선거구의 모든 점이 같지 않으면 선거구가 연결되어 있지 않으므로 return
            if(isChecked2[i]!=isVisited2[i]) return;
        }
        int result1 = 0;
        int result2 = 0;
        for(int i=1; i<=N; i++){    // 선거구 1의 합과 선거구 2의 합 구하기
            if(isVisited1[i]) result1+=map[i];  
            else result2+=map[i];
        }
        answer = Math.min(Math.abs(Math.abs(result1)-Math.abs(result2)), answer);
    }

    private static void connectCheck1(int input) {
        isChecked1 = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(input);
        while(!q.isEmpty()){
            int num = q.poll();
            isChecked1[num] = true;
            for(int i=0; i<list.get(num).size(); i++){
                if(isVisited2[list.get(num).get(i).end]) continue;
                if(isChecked1[list.get(num).get(i).end]) continue;
                q.add(list.get(num).get(i).end);
            }
        }

    }

    private static void connectCheck2(int input) {
        isChecked2 = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(input);
        while(!q.isEmpty()){
            int num = q.poll();
            isChecked2[num] = true;
            for(int i=0; i<list.get(num).size(); i++){
                if(isVisited1[list.get(num).get(i).end]) continue;
                if(isChecked2[list.get(num).get(i).end]) continue;
                q.add(list.get(num).get(i).end);
            }
        }
    }

    static class Node{
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "Node start : "+start + " end : "+ end;
        }
        
    }
}
//https://www.acmicpc.net/problem/17471