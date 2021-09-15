package SSFAlgorithmLearn.Day7;
import java.util.Scanner;

// 같은 행에 두지 않는 방식
// N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수

public class NQueenTest{
    static int N,cnt;
    static int col[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("퀸의 갯수를 입력하세요 : ");
        N = sc.nextInt();
        col = new int[N+1];
        cnt =0;

        setQueens(1); // 1행부터 놓기
        System.out.println("경우의 수는 : "+cnt+" 입니다.");
        sc.close();
    }

    private static void setQueens(int rowNum){
        // 유망여부 체크 : rowNum-1 행까지 유망한지 체크한다.
        //if(!isAvailable(rowNum-1)) return;
        
        if(rowNum>N){       // 마지막까지 다 놓고 이제 넣을 행이 없을때 까지 돌린다.
            cnt++;
            return;
        }

        // 1열부터 N열까지 놓아보기 
        // 놓았으면 다음 퀸 놓으러 가기

        for(int i=1; i<=N; i++){
            col[rowNum] = i;
            if(isAvailable(rowNum)){    // 유망한지 확인하고 유망하면 다음꺼 진행
                setQueens(rowNum+1);
            }
            /*col[rowNum] = i; // i열에 놓아보기
            setQueens(rowNum+1);*/
        }
    }
    private static boolean isAvailable(int rowNum){
        for(int k=1; k<rowNum; k++){ // k : 이전 퀸
            if(col[rowNum]==col[k]|| Math.abs(col[rowNum]-col[k]) == (rowNum-k)) return false;   // |이전열-현재열| = 이전열이 되면 현재 대각선에 위치한다고 판단.
        }
        return true;
    }
}