package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1Moo게임_5904 {
    
    static char answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;        
        check(Integer.parseInt(br.readLine()));
        bw.write(answer);
        bw.flush();
    }

    private static void check(int n) {
        int size = 3;
        int index = 0;
        if (n == 1) {
            answer = 'm';
        } else if (n <= 3)
            answer = 'o';
        else {
            while (size < n) {
                size = size * 2 + index + 4;
                index++;
            }
            int front_back = (size - index - 3) / 2;
            if (size - front_back + 1 <= n) {
                check(n - size + front_back);
            } else if (n == front_back + 1)
                answer = 'm';
            else
                answer = 'o';
        }
    }

}
// https://www.acmicpc.net/problem/5904