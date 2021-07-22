package SamSungSwExpert;
import java.util.Scanner;
import java.util.Arrays;
public class sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test =1; test<=t; test++){
            Boolean check = true;
            int answer2 =5;
            int[][] sudoku = new int[9][9];
        	for(int x =0; x<9; x++){
            	for(int y=0; y<9; y++){
                	sudoku[x][y] = sc.nextInt();      // 스도쿠 표 만들기
                }
            }
            int tempR[] = new int[10];
            int tempC[] = new int[10];
            outer : for(int i=0; i<9; i++){             // 각 행과열 비교하기
                for(int j=0; j<9; j++){
                tempR[sudoku[i][j]]++;
                tempC[sudoku[j][i]]++;     
                if(j==8){
                for(int x=1; x<10; x++){                // 비교 한번 끝날때 마다 겹치는 값 확인하기
                    if(tempR[x]>1||tempC[x]>1){
                        check = false;
                        break outer;
                    }
                }}
            }
                Arrays.fill(tempR, 0);                  // 비교한번 끝났으니 0으로 배열을 초기화 시켜준다.
                Arrays.fill(tempC, 0);
            }
            answer2 = new sudoku().square(sudoku);                   // 사각형 부분 계산하기
            if(answer2==0&&check){
                System.out.printf("#%d %d\n",test,1);
                check = true;
            }
            else{
                System.out.printf("#%d %d\n",test,0);
                check = true;
            }
        }
        sc.close();
    }
    private int square(int[][] sudoku){          // 사각형 부분 계산 메소드  
        int[] dx = {-1,-1,-1,0,0,1,1,1};                
        int[] dy = {-1,0,1,-1,1,-1,0,1};            // 방향 8개 생성
        int answer = 0;
        int[] arr = new int[10];
        outer2 : for(int i=1; i<8; i+=3){
            for(int j=1; j<8; j+=3){
                arr[sudoku[i][j]]+=1;              // 자기자신 더하기
                for(int x=0; x<8; x++){             // 방향 8개 계산
                    int nr = i+dx[x];
                    int nc = j+dy[x];
                    arr[sudoku[nr][nc]] ++;
                }
                for(int y=1; y<10; y++){            // 방향 계산 1번 끝날때 마다 중복값 확인
                    if(arr[y]>1){
                        answer = 1;
                        break outer2;
                    }
                }
                Arrays.fill(arr, 0);               // 방향 계산 끝났으니까 초기화
            }
        }
        return answer;
    }
}
