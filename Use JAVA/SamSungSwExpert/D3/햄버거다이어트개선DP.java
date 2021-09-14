package SamSungSwExpert.D3;
import java.io.*;
import java.util.StringTokenizer;
public class 햄버거다이어트개선DP {           // 배열로 계산안하고 DP로 계산바로 하기
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\햄버거다이어트.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            
            int[] scoreArr = new int[count+1];
            int[] calArr = new int[count+1];
            for(int i=1; i<=count; i++){
                st = new StringTokenizer(br.readLine());
                scoreArr[i] = Integer.parseInt(st.nextToken());
                calArr[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[count+1][limit+1];
            for(int i=1; i<=count; i++){

                for(int j=1; j<=limit; j++){
                    if(calArr[i]<=j){    // 칼로리보다 작거나 같을때 -> 넣을 수 있음
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-calArr[i]]+scoreArr[i]);
                    }else{  // 넣을 수 없음
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            bw.write("#"+t+" "+dp[count][limit]+"\n");
            bw.flush();
            bw.close();
            br.close();
        }   // 테케 끝
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=%ED%96%84%EB%B2%84%EA%B1%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1