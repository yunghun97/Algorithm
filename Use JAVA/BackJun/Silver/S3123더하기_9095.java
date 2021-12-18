package BackJun.Silver;

import java.io.*;

public class S3123더하기_9095 {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));        
		int[] arr = new int[11];
		
        int N = Integer.parseInt(br.readLine());
		arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

		
	
        for(int i= 4; i <= 10; i++) {   // 숫자가 11보다 작으므로 10까지
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];    // N은 1,2,3 합으로 구하므로 -1 -2 -3 했을 떄 만들 수 있는 경우의 수의 합
        }
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			bw.write(""+arr[num]);
            bw.newLine();
		}
        bw.flush();
	}
}
//https://www.acmicpc.net/problem/9095