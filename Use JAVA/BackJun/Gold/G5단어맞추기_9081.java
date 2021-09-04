package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5단어맞추기_9081 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String input = br.readLine();
            char[] arr = input.toCharArray();
            int index1 =-1; int index2=-1;
            for(int i=arr.length-1; i>0; i--){
                if(arr[i-1]<arr[i]){    // 뒤에서 부터 탐색하여, 내림차순을 만족하지 않는 인덱스를 찾는다.
                    index1=i-1; break;
                }
            }
            if(index1==-1){ // 다 내림차순 = 가장 큰 값으로 값이 없다는 뜻
                bw.write(input+"\n");   
            }else{
                for(int j=arr.length-1; j>=0; j--){ // 내림차순을 만족하지 않는 지점과 맨 뒤에서(가장 작은 큰 값을 만들기 위해) 탐색하면서 큰 값과 값을 바꾸어준다.
                    if(arr[index1]<arr[j]){
                        index2=j; break;
                    }
                }
                char temp = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = temp;
                Arrays.sort(arr,index1+1,arr.length);   // swap이 일어난 좌표 바로 뒤 좌표를 오름차순 정렬해준다(가장 작은 값을 만들기 위해서)
                for(int i=0; i<arr.length; i++){
                    bw.write(arr[i]);
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/9081
/*
입력
4
HELLO
DRINK
SHUTTLE
ZOO
출력
HELOL
DRKIN
SLEHTTU
ZOO
*/