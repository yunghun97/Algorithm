package SamSungSwExpert.D5;

import java.io.*;
import java.util.*;
public class 범준이의제주도여행계획_1798 {
    static int N, M, airportIndex, answer;
    static int[][] dis;
    static ArrayList<Integer> resultQ;
    static ArrayList<Place> list;
    // 9시간을 넘게 소요하면 안된다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dis = new int[N][N];
            list = new ArrayList<>();
            answer = Integer.MIN_VALUE;
            resultQ = new ArrayList<>();
            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=i+1; j<N; j++){
                    int a = Integer.parseInt(st.nextToken());
                    dis[i][j] = a;
                    dis[j][i] = a;
                }
            }
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                char kind = st.nextToken().charAt(0);
                if(kind=='A'||kind=='H'){
                    if(kind=='A') airportIndex = i;
                    list.add(new Place(kind));
                }else{
                    list.add(new Place(kind,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
                }
            }
            ArrayList<Integer> q = new ArrayList<>();
            boolean[] isVisited = new boolean[N];            
            dfs(1,airportIndex,0, 0,q,isVisited);

            if(answer>0){
                bw.write("#"+t+" "+answer+" ");
                for(int i=0; i<resultQ.size(); i++){
                    bw.write(String.valueOf(resultQ.get(i)+1)+" ");
                }
            }else{
                bw.write("#"+t+" 0");
            }
            bw.newLine();            
            bw.flush();
        }// 테케 끝
    }

    private static void dfs(int day, int nowPlace, int time, int happy, ArrayList<Integer> q, boolean[] isVisited) {
        if (day == M && nowPlace==airportIndex && q.size()!=0) { // 마지막 날이면서 공항일 때            
            if (happy > answer) {
                answer = happy;
                resultQ = q;
                return;
            }
            return;
        
        }
        if(day==M && time+dis[nowPlace][airportIndex]>540) return;  // 마지막날 공항에 도착하지 못하는 경우 return
        for(int i=0; i<N; i++){
            if(day!=M&&i==airportIndex) continue;
            if(i==nowPlace) continue;                
            
            if(time+list.get(i).time+dis[nowPlace][i]<=540){        
                if(list.get(i).kind=='P'){  // 관광명소
                    if(isVisited[i]) continue;

                    boolean[] tmpVisited = new boolean[N];
                    visitCopy(isVisited,tmpVisited);
                    ArrayList<Integer> tmpQ = new ArrayList<>();
                    listCopy(q,tmpQ);

                    tmpVisited[i] = true;
                    tmpQ.add(i);
                    dfs(day, i, time+list.get(i).time+dis[nowPlace][i], happy+list.get(i).happy, tmpQ, tmpVisited);
                }else if(list.get(i).kind=='H'&&day+1<=M){  // 호텔 
                    ArrayList<Integer> tmpQ = new ArrayList<>();
                    listCopy(q,tmpQ);
                    tmpQ.add(i);
                    dfs(day + 1, i, 0, happy, tmpQ, isVisited);                    
                }else if(list.get(i).kind=='A'){ // 공항일 경우
                    ArrayList<Integer> tmpQ = new ArrayList<>();
                    listCopy(q,tmpQ);
                    tmpQ.add(i);
                    dfs(day, i, 0 , happy, tmpQ, isVisited);
                }
            }    
        }
    }
        
    private static void listCopy(ArrayList<Integer> q, ArrayList<Integer> tmpQ) {
        for(int i=0; i<q.size(); i++){
            tmpQ.add(q.get(i));
        }
    }

    private static void visitCopy(boolean[] isVisited, boolean[] tmpVisited) {
        for(int i=0; i<N; i++){
            if(isVisited[i]) tmpVisited[i] = true;
        }
    }

    static class Place{
        char kind;
        int time;
        int happy;

        public Place(char kind){
            this.kind = kind;
        }
        public Place(char kind, int time, int happy) {
            this.kind = kind;
            this.time = time;
            this.happy = happy;
        }
        
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=5&contestProbId=AV4x9oyaCR8DFAUx&categoryId=AV4x9oyaCR8DFAUx&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=ALL&select-1=5&pageSize=10&pageIndex=1&&&&&&&&&&