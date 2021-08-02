package SamSungSwExpert.D2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class KillFly {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int flap = Integer.parseInt(st.nextToken());
        int[][] arr = new int[size][size];
        int answer =0; int count =0;
       	for(int i=0; i<size; i++){
        	st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       	// 계산 부분
        for(int r=0; r<size-flap+1; r++){           // 배열 - 파리채크기 + 1 만큼만 확인해도 됨
        	for(int c=0; c<size-flap+1; c++){
                count =0;                   // 칸 이동 마다 count 초기화
                for(int x=0; x<flap; x++){          // 파리채 크기 만큼 2중배열 해서 파리 제거 갯수 구함
                	for(int y=0; y<flap; y++){
                    	count += arr[r+x][c+y];
                    }
                }
                if(count>answer){answer = count;}       // answer보다 크면 answer에 값 저장
            }
        }
				System.out.printf("#%d %d\n",t, answer);
        }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

/*
입력
2
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
6 3
29 21 26 9 5 8
21 19 8 0 21 19
9 24 2 11 4 24
19 29 1 0 21 19
10 29 6 18 4 3
29 11 15 3 3 29

출력
#1 49
#2 159

*/
