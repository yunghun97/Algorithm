package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4가르침_1062 {
    static int N, K;
    static String[] wordArr; // 단어배열
    static int answer; // 정답
    static boolean[] alpah; // 알파벳 방문체크
    public static void main(String[] args) throws IOException{
        // anta tica -> / actin 5개가 기본 베이스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wordArr = new String[N];
        // a = 97
        alpah = new boolean[26];     
        // 기본값 세팅
        for(int i=0; i<N; i++){
            String word = br.readLine();
            word = word.replace("a", ""); // 이미 기본인거는 제거
            word = word.replace("c", "");
            word = word.replace("t", "");
            word = word.replace("i", "");
            word = word.replace("n", "");
            wordArr[i] = word;            
        }
        alpah[(int) 'a'-97] = true;
        alpah[(int) 'c'-97] = true;
        alpah[(int) 't'-97] = true;
        alpah[(int) 'i'-97] = true;
        alpah[(int) 'n'-97] = true;
        answer = 0;
        if(K<5){ // 기본이 5개 이므로 아무것도 읽을 수 없음
            
        }else if(K==26){
            answer = N;
        }else{
            dfs(0,0);
        }        
        bw.write(""+answer);
        bw.flush();
    }
    private static void dfs(int cnt, int start){
        if(cnt==K-5){ // actin 5개가 기본으로 K-5만 선택 가능
            int count = 0;
            for(int n=0; n<N; n++){
                if(wordArr.length==0) count++;
                else{
                    boolean equal = true;                    
                    for(int m=0; m<wordArr[n].length(); m++){                        
                        if(alpah[wordArr[n].charAt(m)-97]) continue;
                        else{ // 속해 있지 않으면 false
                            equal = false;
                            break;
                        }
                    }
                    if(equal) count++;
                }
            }
            answer = Math.max(answer,count);
            return;
        }
        for(int i=start; i<26; i++){
            if(alpah[i]) continue;
            alpah[i] = true;
            dfs(cnt+1, i+1);
            alpah[i] = false;
        }
    }
}
// https://www.acmicpc.net/problem/1062