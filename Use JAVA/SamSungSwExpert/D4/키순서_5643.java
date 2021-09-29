package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;
public class 키순서_5643 {
    static int V,E, answer, result;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> tallerList;    // 해당 번호보다 더 큰 사람 모음
    static ArrayList<ArrayList<Integer>> shorterList;   // 해당 번호보다 더 작은 사람 모음
    // a b -> b가 a보다 크다
    // 탐색 방법 -> 인접 리스트 2개 구현해서 큰 사람 작은 사람 DFS로 탐색
    // 큰사람 DFS 탐색 결과  + 작은사람 DFS 탐색 -> 다 탐색이 되는 경우 순위를 알 수 있음
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            answer = 0;
            V = Integer.parseInt(br.readLine());
            E = Integer.parseInt(br.readLine());
            tallerList = new ArrayList<ArrayList<Integer>>();
            shorterList = new ArrayList<ArrayList<Integer>>();
            for(int i=0; i<=V; i++){
                tallerList.add(new ArrayList<Integer>());
                shorterList.add(new ArrayList<Integer>());
            }
            for(int i=0; i<E; i++){ // 인접리스트 생성
                st = new StringTokenizer(br.readLine());
                int shortMan = Integer.parseInt(st.nextToken());
                int tallMan = Integer.parseInt(st.nextToken());
                tallerList.get(shortMan).add(tallMan);
                shorterList.get(tallMan).add(shortMan);
            }
            for(int i=1; i<=V; i++){    // 1번부터 V정점까지 탐색
                result = 0;
                isVisited = new boolean[V+1];
                tallDfs(i);
                isVisited[i] = false;   // 큰 사람 탐색할 때 시작정점이 방문체크 되었으므로 다시 false로 바꿔준다.
                shortDfs(i);
                if(result-1==V) answer++;   // 모든 정점 탐색 -> answer ++;
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }   // 테케 끝
    }
    private static void shortDfs(int num) { // 작은사람 탐색
        if(isVisited[num]) return;
        isVisited[num] = true;
        for(int i=0; i<shorterList.get(num).size(); i++){
            shortDfs(shorterList.get(num).get(i));
        }
        result++;
    }
    private static void tallDfs(int num) {  // 큰사람 탐색
        if(isVisited[num]) return;
        isVisited[num] = true;
        for(int i=0; i<tallerList.get(num).size(); i++){
            tallDfs(tallerList.get(num).get(i));
        }
        result++;
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo