package BackJun.Bronze;

import java.io.*;
import java.util.*;



public class B1색종이_10163 {
    static int[] answerArr;
    static boolean[][] map;
    static Paper[] paper;
    static BufferedWriter bw;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        map = new boolean[1001][1001];
        paper = new Paper[T];
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int b = 1000-Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            paper[t] = new Paper(a, b, c, d);
        }
        answerArr = new int[T];
        cal();
        for(int i=0; i<T; i++){
            bw.write(""+answerArr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void cal() throws IOException{ 
        for(int i= paper.length-1; i>=0; i--){
            int answer = 0;
            for(int a = paper[i].r; a>paper[i].r-paper[i].depth; a--){
                for(int b= paper[i].c; b<paper[i].c+paper[i].breadth; b++){
                    if(map[a][b]) continue;
                    answer++; map[a][b]=true;
                }
            }
            answerArr[i]  = answer;
        }

    }
    static class Paper{
        int c;
        int r;
        int breadth;
        int depth;
        public Paper(int c, int r, int breadth, int depth) {
            this.r = r;
            this.c = c;
            this.breadth = breadth;
            this.depth = depth;
        }
    }
}
//https://www.acmicpc.net/problem/10163
/*
입력
4
0 2 10 10
7 9 8 4
8 4 10 6
6 0 12 10
결과
62
24
0
120

*/