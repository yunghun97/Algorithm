package BackJun.Bronze;
import java.io.*;
import java.util.*;
public class B2시험감독_13458 {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int roomCount = Integer.parseInt(br.readLine());
        int[] roomArr = new int[roomCount];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<roomCount; i++){
            int a = Integer.parseInt(st.nextToken());
            roomArr[i] = a;
        }
        st = new StringTokenizer(br.readLine());
        int allViewer = Integer.parseInt(st.nextToken());
        int subViewer = Integer.parseInt(st.nextToken());
        long answer = 0;
        for(int i=0; i<roomCount; i++){
            int temp = roomArr[i];  // 주 감독관 빼고 1명씩 ++
            temp -=allViewer;
            answer++;
            if(temp>0){
                if(temp/subViewer==0) answer++; // 보조 1명으로 커버되므로 ++
                else{
                answer+=temp/subViewer; // 1명+a일 상황에서 몫만큼 +
                temp = temp - subViewer*(temp/subViewer);   // 몫 * 보조감독관 만큼 -
                if(temp>0) answer++;    // 0 보다 크다는 건 1명 더 필요한 상황
                
                }
            }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();

    }
}
//https://www.acmicpc.net/problem/13458
/*
입력
5
10 9 10 9 10
7 2
출력
13
*/