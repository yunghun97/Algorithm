package SamSungSwExpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 원점으로집합 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = null;
        int T = Integer.parseInt(br.readLine());
         
        for(int t = 1;  t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
             
            for(int n = 0; n < N; n ++) {
                sc = new StringTokenizer(br.readLine());
                arr[n] = (Math.abs(Integer.parseInt(sc.nextToken())) + Math.abs(Integer.parseInt(sc.nextToken())));
            }
             
            int max = 0;
            int ans = 0;
            int isOdd = arr[0] % 2 == 0 ? 0 : 1;
             
            for(int num : arr) {
                if(num % 2 != isOdd) ans = -1;
                max = Math.max(num, max);
            }
 
            int sum = 0;
            if(ans != -1) {
                while(sum < max || Math.abs(max - sum) % 2 == 1) {
                    sum += ++ans;
                }
            }
             
             
             
            System.out.println("#" + t + " " + ans);
        }
    }
 
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzaq5KKk_ADFAVU&categoryId=AWzaq5KKk_ADFAVU&categoryType=CODE&problemTitle=%EC%9B%90%EC%A0%90%EC%9C%BC%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1