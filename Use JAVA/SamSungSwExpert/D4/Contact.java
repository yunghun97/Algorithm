package SamSungSwExpert.D4;
import java.io.*;
import java.util.*;
public class Contact {
    static boolean[][] map;
    static boolean[] visit;
    static int startNum,answer; 
    static Queue<Integer> q, lastQ;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\contact.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t=1; t<=10; t++){
            q = new LinkedList<Integer>();
            lastQ = new LinkedList<Integer>();
            map = new boolean[101][101];    // 인접 행렬
            visit = new boolean[101];       // 중복 체크
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            startNum = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<repeat/2; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = true;
            }
            cal();
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }// 테케 끝
        bw.close();
        br.close();
    }
    private static void cal() {
        q.add(startNum);
        visit[startNum] = true;
        int temp=0;
        while(!q.isEmpty()){ // 빌 때 까지
            int qsize = q.size(); answer = 0;   // q.size 만큼 돌린다 = level 만큼 돌린다. level이 바뀌면 초기화 된다.
            for(int x=0; x<qsize; x++){
            temp = q.poll();
            for(int i=1; i<101; i++){
                if(map[temp][i]&&!visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
            answer = Math.max(answer,temp); // 최대값 출력 -> level이 증가하면 answer가 초기화 된다.
        }
    }
}
}
//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXqgPAMaIlADFATi&contestProbId=AV15B1cKAKwCFAYD&probBoxId=AXtxRhiq3z8DFARW+&type=PROBLEM&problemBoxTitle=0823-WS&problemBoxCnt=++1+