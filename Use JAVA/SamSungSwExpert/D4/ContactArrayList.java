package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class ContactArrayList  {
    static int N,start,answer;
    static ArrayList<Integer>[] list;   // 인접 리스트
    static boolean[] isSelected;    // 중복 체크
    static Queue<Integer> q;    
    public static void main(String[] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t=1; t<=10; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            isSelected = new boolean[101];  
            list = new ArrayList[101];
            q = new LinkedList<>();
            answer = 0;
            for(int i=0; i<=100; i++){
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }
            cal();
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    private static void cal() {
        q.add(start);
        isSelected[start] = true; // 시작지점
        while(!q.isEmpty()){    // q 반복분
            int size = q.size(); 
            answer= 0; // q.size 만큼 반복해줘서 더 이상 추가 안되면 마지막으로 q.size() 만큼 돌아간 것이 마지막 연락 주소이다.
            for(int x=0; x<size; x++){  // q.size만큼
                int temp = q.poll();    // q원소                 
                for(int i=0; i<list[temp].size(); i++){ // list의 개수만큼 돈다.
                    int to = list[temp].get(i);
                    if(!isSelected[to]){    // 도착지 to가 false이면 -> 처음일 때
                        isSelected[to] = true;  //true로 변경
                        q.add(to);  // q에 값 추가
                    }
                }                    
                answer = Math.max(temp, answer);    // 최대 값 찾기
            }
        }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD