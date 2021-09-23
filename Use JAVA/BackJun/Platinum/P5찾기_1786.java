package BackJun.Platinum;

import java.io.*;
import java.util.*;

public class P5찾기_1786 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;

		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){

	        while(j > 0 && pattern[i] != pattern[j]) {
	        	j = pi[j-1];  
	        }
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	    }
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) { 
				if(j == pLength-1) { 
					list.add(i-pLength+1); 
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		bw.write(""+list.size()+"\n");
		for(int i=0; i<list.size(); i++){
            bw.write(""+(list.get(i)+1)+" ");
        }
        bw.flush();
	}
}
//https://www.acmicpc.net/problem/1786
