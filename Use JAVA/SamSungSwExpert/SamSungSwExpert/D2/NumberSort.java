package SamSungSwExpert.D2;

import java.util.Arrays;
import java.util.Scanner;
public class NumberSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int num = sc.nextInt();
        	sc.nextLine();
        	String input = sc.nextLine();
            String[] arr = new String[num];
            int[] answer = new int[num];
            arr = input.split(" ");
            for(int i=0; i<arr.length; i++){
            	answer[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(answer);
            System.out.printf("#%d ",t);
            for(int a : answer){
            	System.out.printf("%d ",a);
            }
            System.out.println("");
        }
        sc.close();
    }
}
