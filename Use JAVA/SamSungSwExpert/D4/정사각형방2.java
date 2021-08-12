package SamSungSwExpert.D4;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
public class 정사각형방2 {
    static int[][] map;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\정사각형방.txt"));      // 1자 배열로 만든 다음 카운트 하는 거
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                StringTokenizer st;

                int T= Integer.parseInt(br.readLine());
                for(int t=1; t<=T; t++){
                int count =1;
                int max = Integer.MIN_VALUE;
                int roomNum =0;
                int size = Integer.parseInt(br.readLine());                
                map = new int[size][size];
                int[] answerMap = new int[size*size+1];

                for(int i=0; i<size; i++){
                    st =new StringTokenizer(br.readLine());
                    for(int j=0; j<size; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                int nr,nc; 
                for(int r=0; r<size; r++){
                    for(int c=0; c<size; c++){
                        for(int d=0; d<4; d++){
                            nr = r+dx[d];
                            nc = c+dy[d];
                            if(nr>=0&&nr<size&&nc>=0&&nc<size){
                                if(map[nr][nc]-map[r][c]==1){
                                    answerMap[map[r][c]]=1;
                                }
                            }
                        }
                    }
                } 

                
                for(int q=size*size; q>0; q--){ //뒤에서 세면 0이 나오면  q+1 값이 번호가 바로 출발점이 된다.
                    if(answerMap[q]==1){
                        count++;
                    }
                    else{
                        if(max<=count){
                            max = count;
                            if(max==count)roomNum = q;
                        }
                        count=1;
                    }
                }
                bw.write("#"+t+" "+roomNum+" "+max+"\r\n");
                bw.flush();
            }// 테케 끝
            bw.close();
            br.close();
        }
    }
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=%EC%A0%95%EC%82%AC%EA%B0%81%ED%98%95&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
//1차원 배열로 늘어트린다음 뒤에서 부터 새면 더 편하게 풀 수 있다.
