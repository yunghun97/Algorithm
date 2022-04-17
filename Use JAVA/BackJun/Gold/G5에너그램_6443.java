package BackJun.Gold;

import java.io.*;
// 그냥 재귀 돌면 메모리 터진다 -> 알파벳의 개수를 활용해서  풀이
public class G5에너그램_6443 {    
    static int[] check; 
    static char[] arr, answer;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());            
        for(int i=0; i<N; i++){
            arr = br.readLine().toCharArray();                        
            check = new int[26];
            
            for(char input : arr){
                check[input-'a']++;
            }
            answer = new char[arr.length];
            cal(0, arr.length);
        }
        bw.flush();
    }
    private static void cal(int cnt, int len) throws IOException{
        if(cnt==len){ // 해당 원소를 다 반영한 경우
            bw.write(answer);
            bw.newLine();
            return;
        }
        for(int i=0; i<26; i++){
            if(check[i]>=1){ // 원소가 존재할 때
                check[i]--;
                answer[cnt] = ((char)(i+'a'));
                cal(cnt+1,len);
                check[i]++;
            }
        }
    }
}
// https://www.acmicpc.net/problem/6443