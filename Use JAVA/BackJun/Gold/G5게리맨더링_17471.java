package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5게리맨더링_17471 {
    static int N,count,answer,max;
    static ArrayList<Integer>[] map;
    static int[] people;
    static boolean[] arr, isVisited1, isVisited2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N+1];
        map = new ArrayList[N+1];   //인접정보 저장용
        map[0] = new ArrayList<>(); 
        people = new int[N+1];  // 인구수
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = new ArrayList<>();
            st.nextToken();
            while(st.hasMoreTokens()){
                map[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        max =  (int)Math.pow(2,N)/2;    // 1,3,5 | 2,4 -> 2,4  | 1,3,5 는 결과가 같으므로 반만 돌게 하기위해
        answer = Integer.MAX_VALUE;
        subset(0);
        if(answer==Integer.MAX_VALUE) bw.write(""+(-1));
        else bw.write(""+answer);
        bw.flush();
    }
    private static void subset(int cnt) {
        if(count>=max) return;  // 이미 반 돌았으면 return
        if(cnt==N){
            count++;
            cal();
            return;
        }
        arr[cnt+1] = true;  // 부분집합
        subset(cnt+1);
        arr[cnt+1] = false;
        subset(cnt+1);
    }
    private static void cal() { // 계산
        boolean[] isVisited1 = new boolean[N+1];
        boolean[] isVisited2 = new boolean[N+1];
        boolean[] isChecked1 = new boolean[N+1];
        boolean[] isChecked2 = new boolean[N+1];
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for(int i=1; i<=N; i++){
            if(arr[i]){ // a에 추가
                a.add(i);
                isVisited1[i] = true;
            }
            else{   // b에 추가
                b.add(i);
                isVisited2[i] = true;
            }
        }
        if(a.size()==N||b.size()==N) return;    // 한쪽이 다 선택된 경우 return
        Queue<Integer> q = new LinkedList<>();
        q.add(a.get(0));
        isChecked1[a.get(0)] = true;   // 시작점 true 표시
        while(!q.isEmpty()){    // bfs탐색
            int num = q.poll();
            for(int i=0; i<map[num].size(); i++){
                if(!isVisited1[map[num].get(i)]) continue;
                if(isChecked1[map[num].get(i)]) continue;
                isChecked1[map[num].get(i)] = true;
                q.add(map[num].get(i));
            }
        }
        for(int i=1; i<=N; i++){    // 선택결과와 bfs 결과가 다르면 연결되어 있지 않으므로 return
            if(isChecked1[i]!=isVisited1[i]) return;
        }

        q.add(b.get(0));
        isChecked2[b.get(0)] = true;    // 시작점 true 표시
        while(!q.isEmpty()){    // bfs탐색
            int num = q.poll();
            for(int i=0; i<map[num].size(); i++){
                if(!isVisited2[map[num].get(i)]) continue;
                if(isChecked2[map[num].get(i)]) continue;
                isChecked2[map[num].get(i)] = true;
                q.add(map[num].get(i));
            }
        }
        for(int i=1; i<=N; i++){        // 선택결과와 bfs 결과가 다르면 연결되어 있지 않으므로 return
            if(isChecked2[i]!=isVisited2[i]) return;
        }

        int result1 =0;
        int result2 =0;
        for(int i=1; i<=N; i++){
            if(isVisited1[i]) result1+=people[i];
            else result2+=people[i];
        }
        answer = Math.min(answer, Math.abs(result1-result2));
        return;
    }
}

//https://www.acmicpc.net/problem/17471