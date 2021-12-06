package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

public class 점심식사시간_2383 {
    static ArrayList<Stair> StairList;
    static ArrayList<People> PeopleList;
    static int N, peopleCount, time;
    static boolean[] arr;
    static int[][] dis;
    static Queue<Integer> q1, q2;
    static PriorityQueue<Integer> pq1, pq2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            
            N = Integer.parseInt(br.readLine());
            PeopleList = new ArrayList<>(); // 사람 정보
            StairList = new ArrayList<>();  // 계단 정보   
            q1 = new LinkedList<>();    // 계단내려가는 길이를 q 사이즈로 만들어서 사람, 사람아님을 표시할 예정
            q2 = new LinkedList<>();
            pq1 = new PriorityQueue<>((o1,o2) -> Integer.compare(o1, o2));  // 계단에 도착한 시간을 저장
            pq2 = new PriorityQueue<>((o1,o2) -> Integer.compare(o1, o2));
            peopleCount = 0;     // 총 사람 수     
            time = Integer.MAX_VALUE;   // 걸리는 시간(정답)

        
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a==1){
                        peopleCount++;
                        PeopleList.add(new People(i, j));
                    }else if(a>=2){
                        StairList.add(new Stair(i, j, a));
                    }
                }
            }
            dis = new int[peopleCount][2];  // 거리에 대한 정보 저장
            arr = new boolean[peopleCount]; // true면 1번 계단 false면 2번 계단 선택
            getDis();   // 사람과 계단사이의 거리 구하기
            permutation(0); // 순열

            bw.write("#"+t+" "+time+"\n");
            bw.flush();
        }
    }    

    // 사람과 계단사이의 거리 구하기
    private static void getDis() {
        for(int i=0; i<peopleCount; i++){
            for(int j=0; j<2; j++){
                dis[i][j] = (int)(Math.abs(PeopleList.get(i).r-StairList.get(j).r)+Math.abs(PeopleList.get(i).c-StairList.get(j).c));
            }
        }
    }

    // 순열 뽑기
    private static void permutation(int cnt) {
        if(cnt==peopleCount){
            cal();
            return;
        }
        for(int i=0; i<2; i++){
            if(i==0){                                
                arr[cnt] = true;
            }else{
                arr[cnt] = false;
            }
            permutation(cnt+1);
        }        
    }

    // 거리 계산하기
    private static void cal() {
        for(int i=0; i<peopleCount; i++){
            // 1번 계단
            if(arr[i]){
                pq1.add(dis[i][0]);
            }
            // 2번 계단
            else{
                pq2.add(dis[i][1]);
            }
        }
        int outPeople = 0;  // 총 나가는 사람
        int result = 1; // 걸리는 시간
        while(outPeople<peopleCount){
            // 사람있으면 빼주기
            while(!q1.isEmpty()){
                if(q1.peek()>result) break;
                else{
                    q1.poll();
                    outPeople++;
                }
            }
            while(!q2.isEmpty()){
                if(q2.peek()>result) break;
                else{
                    q2.poll();
                    outPeople++;
                }
            }
            // 사람 추가
            while(!pq1.isEmpty()){
                if(pq1.peek()>result){
                    break;
                }
                if(q1.size()==3) break;   
                pq1.poll();         
                q1.add(result+StairList.get(0).length);                
            }
            
            while(!pq2.isEmpty()){
                if(pq2.peek()>result){
                    break;
                }
                if(q2.size()==3) break;
                pq2.poll();                
                q2.add(result+StairList.get(1).length);  
            }
            if(result>=time){
                q1.clear();
                q2.clear();
                pq1.clear();
                pq2.clear();
                return;
            }
            if(outPeople==peopleCount){                
                pq1.clear();
                pq2.clear();
                time = result+1;
                return;
            }
            result++;  
            
        }                    
    }
    static class Stair{
        int r;
        int c;
        int length;
        public Stair(int r, int c, int length){
            this.r = r;
            this.c = c;
            this.length = length;
        }
    }
    static class People{
        int r;
        int c;
        public People(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl&categoryId=AV5-BEE6AK0DFAVl&categoryType=CODE&problemTitle=2383&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1#none