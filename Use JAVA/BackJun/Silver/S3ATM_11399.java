package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S3ATM_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum=0;
        for(int i=0; i<size; i++){
            sum+=arr[i];
            for(int j=0; j<i; j++){
                sum+=arr[j];
            }
        }
        bw.write(""+sum);
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/11399
/*
입력
5
3 1 4 3 2
출력
32

*/