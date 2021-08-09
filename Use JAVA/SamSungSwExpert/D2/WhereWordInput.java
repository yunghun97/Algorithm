package SamSungSwExpert.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class WhereWordInput {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
        StringTokenizer st;
        int[] dx = {0,1};
        int[] dy = {1,0};
        
    	int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
        	st = new StringTokenizer(br.readLine());
        	int size = Integer.parseInt(st.nextToken());    // 배열 사이즈
            int length = Integer.parseInt(st.nextToken());  // 단어 크기
        	int[][] arr = new int[size][size];  // 배열
            int[] count = new int[size+1];      // 단어 횟수 저장 용
            int countSize=1;
            //st = new StringTokenizer(br.readLine());
            for(int i=0; i<size; i++){
               st = new StringTokenizer(br.readLine());     // 배열 입력이 엔터로 구분 되므로
            	for(int j=0; j<size; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());       // 배열 정보 저장
                }
            }
            for(int r=0; r<size; r++){
            	for(int c=0; c<size; c++){
                    if(arr[r][c]==1){
                        count[countSize]++;
                	for(int x=0; x<2; x++){
                            if(x==0 && c>0 && arr[r][c-dy[x]]==1){          // 자신 왼쪽 전칸이랑 비교해서 전칸이 빈칸이면 이미 계산 했으므로 다음껄로 넘어감
                                continue;
                            }
                            else if(x==1 && r>0 && arr[r-dx[x]][c]==1){     // 자신 위에 칸이랑 비교해서 위에칸이 빈칸이면 이미 계산 했으므로 다음껄로 넘어간다.
                                continue;
                            }
                            int nr = r+dx[x] ;     // 현재행 입력
                            int nc = c+dy[x] ;     // 현재열 입력
                            while(true){    // 비교문 계속 돌림.
                            if(nr>=0 && nr<size && nc>=0&&nc<size && arr[nr][nc]==1){           // 자기 왼쪽꺼랑 위에꺼 1이면 break;
                          				countSize++;
                            }// 구현부 들가야 됨
                            else {
                                if(countSize>1){count[countSize]++; countSize=1;        // 1일때는 한번만 들어가므로 1 이상일때만 저장
                                }			
                                break;}
                            nr += dx[x];    
                            nc += dy[x];
                            }
                            
                        }
                    }	//arr[r][c] ==0 for문 끝나는 부분
                }
            }
            System.out.printf("#%d %d\n",t,count[length]);
        }
    }
}
//1979. 어디에 단어가 들어갈 수 있을까
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq

/*
입력
2
5 3
0 0 1 1 1
1 1 1 1 0
0 0 1 0 0
0 1 1 1 1
1 1 1 0 1
5 3
1 0 0 1 0
1 1 0 1 1
1 0 1 1 1
0 1 1 0 1
0 1 1 1 0


출력
#1 2
#2 6
*/