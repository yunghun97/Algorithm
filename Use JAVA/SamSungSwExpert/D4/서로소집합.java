package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;

public class 서로소집합 {
    static int[] arr;
    static int numCount, orderCount;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\서로소집합.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            numCount = Integer.parseInt(st.nextToken());
            orderCount = Integer.parseInt(st.nextToken());
            
            make();
        
            bw.write("#"+t+" ");
            for(int i=0; i<orderCount; i++){
                st = new StringTokenizer(br.readLine());
                int order =Integer.parseInt(st.nextToken());
                if(order==0){ // Union
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }else{ //find 속해있으면 1 아니면 0
                    int a = find(Integer.parseInt(st.nextToken()));
                    int b = find(Integer.parseInt(st.nextToken()));
                    if(a==b) bw.write(""+1);
                    else bw.write(""+0);
                }
            }
            bw.flush();
            bw.newLine();
        }
        bw.close();
        br.close();
    }
    private static void make() {
        arr = new int[numCount+1];
        for(int i=1; i<=numCount; i++){
            arr[i] = i;
        }
    }
    static int find(int a){
        if(a==arr[a]) return a;
        return arr[a] = find(arr[a]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        //System.out.println(Arrays.toString(arr));
        if(aRoot==bRoot) return false;

        arr[bRoot] = arr[aRoot];
        return true;
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr&categoryId=AWBJKA6qr2oDFAWr&categoryType=CODE&problemTitle=%EC%84%9C%EB%A1%9C%EC%86%8C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1