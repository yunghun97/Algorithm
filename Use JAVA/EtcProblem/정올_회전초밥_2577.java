package EtcProblem;

import java.io.*;
import java.util.*;

public class 정올_회전초밥_2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int dishCount = Integer.parseInt(st.nextToken());
        int kind = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int free = Integer.parseInt(st.nextToken());
        int max = dishCount+k-1;    // 회전 초밥이므로

        int[] dishes = new int[max];
        int[] arr = new int[kind+1];
        for(int i=0; i<dishCount; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }
        int index = 0;
        for(int i=dishCount; i<max; i++){   // 회전초밥이므로 k-1개수 만큼 더해서 끝에서 처음을 연결한다.
            dishes[i] = dishes[index++];
        }
        int answer = 0;
        int count = 0;
        for(int i=0; i<k; i++){ // 처음 접시 세팅
            arr[dishes[i]]++;
            if(arr[dishes[i]]==1) count++;
        }
        arr[free]++;    // 공짜 음식 추가 -> 이러면 공짜음식이 빠져도 항상 1이 남아있으므로 카운트가 남아있다.
        if(arr[free]==1) count++;   // 공짜 초밥이 처음 먹는거면 count++;
        
        answer = count;
        for(int i=0; i<dishCount-1; i++){
            arr[dishes[i]]--;   // 처음꺼 제외
            if(arr[dishes[i]]==0) count--;  // 0 이면 안 먹었으므로 --;
            arr[dishes[i+k]]++; // 처음위치 + k번째 추가
            if(arr[dishes[i+k]]==1) count++;    // 처음먹은거 count++
            
            answer = Math.max(answer,count); // 최대 값 저장
            if(answer==k+1) break;  // 최대값 나오면 더 탐색 X
        }
        bw.write(""+answer);
        bw.flush();
    }
}
