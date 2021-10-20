package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5빗물_14719 {
    static int R, C;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // R = 최대 높이
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left =0;
        int right =0;
        int answer = 0;
        for(int i=1; i<C-1; i++){   // 맨 왼쪽과 끝은 빗물이 쌓일 수 없다.
            left = 0;
            right = 0;
            for(int j=0; j<i; j++){ // 현재 좌표에서 왼쪽꺼 확인
                left = Math.max(left, arr[j]);
                if(left==R) break;  // 최대면 더 탐색 X
            }
            for(int j=i+1; j<C; j++){ // 현재 좌표에서 오른쪽 확인
                right = Math.max(right, arr[j]);
                if(right==R) break; //최대면 더 탐색 X
            }
            // 현재 좌표에서 왼쪽, 오른쪽에 자기보다 큰 부분이 없으면 비가 안내린다.
            if(arr[i]<left&&arr[i]<right){
                answer += Math.min(left, right)-arr[i];
            }
        }
        bw.write(""+answer);
        bw.flush();  
    }
}

// https://www.acmicpc.net/problem/14719

// 시간초과 나는 코드 -> 정답은 나오지만 시작부터 끝 까지 계속 확인하므로 시간이 오래걸린다.
/*
public class Main {
    static int R, C;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // R = 최대 높이
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start =0;
        int end =0;
        int answer = 0;
        while(true){
            start = firstCheck(start);
            if(start==C-1) break;
            end = check(start);
            // System.out.println(start+" @ "+end);
            answer += sum(start, end);
            if(end==C-1) break;
            start = end;            
        } 
        bw.write(""+answer);
        bw.flush();  
    }
    private static int sum(int start, int end) {
        int result =0;
        int temp =0;
        if(arr[start]<arr[end]) temp = start;
        else temp = end;
        for(int i=start+1; i<end; i++){
            result += arr[temp]-arr[i];
        }
        if(result<0) return 0;
        return result;
    }
    private static int check(int start) {
        int index =0;
        int result = 0;
        for(int i=start+1; i<C; i++){
            if(arr[i]==R){
                return i;
            }else if(arr[start]<=arr[i]){
                return i;
            }else{
                if(arr[i]>result){
                    result = arr[i];
                    index =i;
                }
                if(i==C-1){
                    return index;
                }
            }
                
        }   
        return 0;         
    }
    private static int firstCheck(int start) {
        while(true){
            if(start+1==C){
                return start;
            }
            if(arr[start]<=arr[start+1]){
                start++;
                continue;
            }else{
                return start;                
            }
        }
    }    
}



*/
