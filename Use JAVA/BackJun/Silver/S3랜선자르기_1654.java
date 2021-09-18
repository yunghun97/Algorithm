package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S3랜선자르기_1654 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int answer = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];
        
        long max  = 0;
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>max) max = arr[i];
        }
        max++;
        
        long min = 0; 
		long mid = 0; 
 
		while (min < max) { 
			mid = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			if(count < answer) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
			
 
		}

		bw.write(""+(min-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/1654