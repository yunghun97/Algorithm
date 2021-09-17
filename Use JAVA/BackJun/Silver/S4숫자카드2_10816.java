package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S4숫자카드2_10816 {
    static int size;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int findSize = Integer.parseInt(br.readLine());
        int[] findArr = new int[findSize];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<findSize; i++){
            findArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<findSize; i++){
            System.out.println(upperFind(findArr[i])+" ~ ~"+lowerFind(findArr[i]));
            // bw.write(""+(upperFind(findArr[i])-lowerFind(findArr[i]))+" ");
        }
        for(int i=0; i<findArr.length;i++){
            
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int lowerFind(int num) {
        int start = 0;
        int last = size;
        int mid =0;
        while(start<last){
            mid = start + (last-start)/2;
            if(num<=arr[mid]){
                last = mid;
            }else{
                start = mid+1;
            }

        }
        return start;
    }

    private static int upperFind(int num) {
        int start = 0;
        int last = size;
        int mid =0;
        while(start<last){
            mid = start + (last-start)/2;
            if(num>=arr[mid]){
                start = mid+1;
            }else{
                last = mid;
            }

        }
        return start;
    }
}
//https://www.acmicpc.net/problem/21608