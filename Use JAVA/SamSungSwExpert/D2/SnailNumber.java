package SamSungSwExpert.D2;
import java.util.Scanner;
public class SnailNumber {
    public static void main(String[] args) {
    		int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for(int t=1; t<=T; t++){
				int input = sc.nextInt();
				int[][] arr = new int[input][input];
				int count =1;
				
				arr[0][0]=count++;	// 기본 0을 가지고 
				int nr =0;
				int nc =0;
                if(arr.length>1){   // 배열 크기는 기본 1이상이므로 2이상부터 돌리겠다.
				outer : while(true){        //나오는 숫자 총 갯수가 input*input 이므로 될때까지 게속 돌린다.
					while(true){        // 방향전환 계속하기 위해 true로 계속 돌린다.
					for(int d=0; d<4; d++){
						outer1 : while(true){
						nr = nr + dx[d];        
						nc = nc + dy[d];
						if(count==input*input+1){break outer;}      //count갯수를 만족하면 빠져나온다. n^2 +1이면 나온다.
						else if(nr>=0&&nr<input&&nc>=0&&nc<input&&arr[nr][nc]==0){// 벽이나 아직 숫자 안넣으면 0이므로 0인 칸일때 까지
							arr[nr][nc] = count++;         
						}
						else
						{	nr = nr - dx[d];    // 벽을 만나면 다시 원위치로 간다. 안그러면 벽이나 기존에 변경된 값 좌표에서 시작하게 된다.
							nc = nc - dy[d];
							break outer1;}
					}
				}
			}
			}
        }
			System.out.printf("#%d\n",t);
			for(int x=0; x<input; x++){
				for(int y=0; y<input; y++){
					System.out.printf("%d ",arr[x][y]);
				}
				System.out.println();
			}
		}
		sc.close();
    }
}

/* 입력
2
3
4



출력
#1
1 2 3
8 9 4
7 6 5
#2
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
*/