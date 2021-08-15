package BackJun.Bronze;

import java.io.*;


public class B1단어공부_1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        int[] arr2 = new int[26];
        for(int i=0; i<arr.length; i++){
            if(Character.isUpperCase(arr[i])){
                arr2[arr[i]-65]++;
            }
            else if(Character.isLowerCase(arr[i])){
                arr2[arr[i]-97]++;
            }
            else continue;
        }
        char answer = '?';
        int temp=0;
        for(int i=0; i<26; i++){
            if(arr2[i]>temp){
                temp = arr2[i];
            }
        }
        int check =0;
        for(int i=0; i<26; i++){
            if(arr2[i]==temp){
                check++;
                answer = (char)(i+65);
            }
        }
        if(check>1){
            bw.write("?");
        }
        else{
            bw.write(String.valueOf(answer));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
