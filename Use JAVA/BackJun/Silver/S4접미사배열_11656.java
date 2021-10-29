package BackJun.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class S4접미사배열_11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int size = str.length();
        String[] arr = new String[size];

        for (int i = 0; i < size; i++) {
            arr[i] = str.substring(i, size);
        }
        Arrays.sort(arr);
        for (String s : arr){
            System.out.println(s);
        }
        sc.close();
    }
}
// https://www.acmicpc.net/problem/11656