package SSAFYAlgorithmLearn.Day1_inOutPut_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
public class StringTokenizer_Test {
    public static void main(String[] args)throws IOException{
    int n = 5;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine(),"q");
    int[] arr = new int[n];
    for(int i =0; i<n; i++){
        arr[i] =Integer.parseInt(st.nextToken());
    }
    System.out.println(Arrays.toString(arr));
    }
}
