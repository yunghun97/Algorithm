package SamSungSwExpert.D3;

import java.io.*;
public class 농작물수확하기0804 {
    static int count;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\농작물수확하기0804.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int size = Integer.parseInt(br.readLine());
            int[][] map = new int[size][size];
            String temp = "";
            int sum =0;
            
            for(int x=0; x<size; x++){
                temp = br.readLine();
                for(int y=0; y<size; y++){
                map[x][y] = temp.charAt(y)-'0';
                }
            }
            int emptyCount= size/2-1; // 0 1 3 5
            int cnt =1;
            for(int i=0; i<size; i++){
                count = cnt;
                for(int j=0; j<size; j++){
                    if(j<=emptyCount){ 
                        continue;
                    }
                    else if(count>0){count--; sum+=map[i][j];}
                }
                if(i<size/2){
                    emptyCount--;
                    cnt+=2;}
                    else if(i>=size/2){
                        emptyCount++;
                        cnt-=2;
                    }
            }
            System.out.printf("#%d %d\n",t,sum);
        }
    }
}
//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV7GLXqKAWYDFAXB&solveclubId=AXqgPAMaIlADFATi&problemBoxTitle=0804-WS&problemBoxCnt=2&probBoxId=AXsPaj16YLMDFARX+

/*
교수님꺼 출력 범위 구하는 소스
int s = n / 2, e = n / 2;
			int sum = 0;
			for (int x = 0; x < n; x++) {
				// 해당 행의 시작부터 종료 열까지의 데이터의 합을 계산
				for (int k = s; k <= e; k++)
					sum += a[x].charAt(k) - '0';
							
				if (x >= n / 2) {
					s++;
					e--;
				} else {
					s--;
					e++;
				}
			}
*/