package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;
public class 활주로건설 {
    static int N, X, answer;
    static int[][] map;
    static boolean[] isinstalled;
    static int[] tempMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            answer = 0;
            map = new int[N][N];
            tempMap = new int[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isinstalled = new boolean[N];
            for(int i=0; i<N; i++){
                if(check(i,0)) answer++;    // 위에서 아래 (행)
                if(check(i,1)) answer++;    // 왼쪽에서 오른쪽(열)
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
    }
    private static boolean check(int num, int dir) {
        Arrays.fill(isinstalled, false);
        for(int i=0; i<N; i++){
            tempMap[i] = (dir==0) ? map[i][num] : map[num][i];
        }
        /*System.out.println("--------");
        for(int i=0; i<N; i++){
            System.out.print(tempMap[i]+" ");
        }*/
        
        for(int i=0; i<N-1; i++){
            if(tempMap[i]==tempMap[i+1]) continue;  //크기 같으면 다음꺼 탐색

            if(Math.abs(tempMap[i]-tempMap[i+1])>1) return false;  //차이가 1보다 크면 false

            if(tempMap[i]>tempMap[i+1]){    // 내려가는 로직
                for(int j=i+2; j<=i+X; j++){    // 경사로 최고값 2이므로 i의 다음칸(작아지는 부분과) 작아지는 다음부분이 다르거나 범위 밖이면 false
                    if(j>=N || tempMap[i+1]!=tempMap[j]) return false;
                    isinstalled[j] = true;
                }
                i+=X-1;
            }
            else{   // 올라가는 로직
                for(int j=i; j>i-X; j--){   // 기존좌표와 경사로 만큼(현재좌표 포함)의 이전좌표가 같으며 이전에 설치되지 않아야함
                    if(j<0 || tempMap[i]!=tempMap[j] || isinstalled[j]) return false;
                    isinstalled[j] = true;
                }
            }

        }
        return true;
    }
}


//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH&categoryId=AWIeW7FakkUDFAVH&categoryType=CODE&problemTitle=%ED%99%9C%EC%A3%BC%EB%A1%9C+%EA%B1%B4%EC%84%A4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1