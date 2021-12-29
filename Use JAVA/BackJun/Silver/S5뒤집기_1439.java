package BackJun.Silver;

import java.io.*;

public class S5뒤집기_1439 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split("");
		int one = 0;
		int zero = 0;
		if(arr[0].equals("0")) zero++;
		else one++;
		for(int i = 1; i<arr.length; i++) {
			if(!arr[i-1].equals(arr[i])) {
				if(arr[i].equals("0")) zero++;
				else one++;
			}
		}
		bw.write(""+Math.min(zero, one));
        bw.flush();
	}
}
//https://www.acmicpc.net/problem/1439