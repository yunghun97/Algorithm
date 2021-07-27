package EtcProblem;
import java.util.Scanner;
//import java.util.Arrays;
public class Mountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        int count =0;
        int answer=0;
        int me =0;
        int[][] arr = new int[n+2][n+2];       // 테두리 부분 +2
        for(int i=0; i<=n+1; i++){             // 테두리 부분때문에 <=n+1 로 2칸 넓힘
            for(int j=0; j<=n+1; j++){
                if(i==0||j==0||i==n+1||j==n+1){
                    arr[i][j]=0;
                }
                else{arr[i][j] = sc.nextInt();}
            }
        }
        //System.out.println(Arrays.deepToString(arr));  배열 확인용
        for(int r=1; r<=n; r++){
            for(int c=1; c<=n; c++){
                me = arr[r][c];             // 자기 자신 숫자 할당
                for(int d=0; d<4; d++){
                    int nr = r+dx[d];
                    int nc = c+dy[d];
                    if(me>arr[nr][nc]) count++;  //count=4가 되면 봉우리로 판단
                }
                if(count==4){               // answer로 봉우리 숫자 더하기
                    answer++;
                }
                count =0;       // 값 초기화
            }
        }
        System.out.printf("봉우리의 갯수는 %d개 입니다.\n",answer);
        sc.close();
    }
}
