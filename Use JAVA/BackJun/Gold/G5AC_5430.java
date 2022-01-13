package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] order = br.readLine().toCharArray();
            int arrLength = Integer.parseInt(br.readLine());                        
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            Deque<Integer> dq = new ArrayDeque<>();            
            for (int i = 0; i < arrLength; i++) {
                dq.add(Integer.parseInt(st.nextToken()));                
            }
            boolean left = true;
            boolean finish = false;
            for (int i = 0; i < order.length; i++) {
                char a = order[i];
                if (a == 'R') { // 뒤집힌 상태인지 아닌지 체크 left = true일 경우 정방향
                    left = !left;
                } else {
                    if (dq.isEmpty()) {
                        bw.write("error\n");
                        finish = true;
                        break;
                    }
                    if (left) { // 왼쪽꺼 지우는 경우
                        dq.removeFirst();
                    } else { // 뒤집힌 상태이므로 맨 뒤의 원소 삭제
                        dq.removeLast();
                    }
                }
            }
            if (!finish) {
                bw.write("[");
                if (!left){   // 뒤집힌 상태이므로 거꾸로 출력
                    int size = dq.size();
                    for (int i = size-1; i>=0; i--) {
                        bw.write(String.valueOf(dq.pollLast()));
                        if (i!=0) {
                            bw.write(",");
                        }
                    }
                }
                else {
                    int size = dq.size();
                    for (int i = 0; i < size; i++) {
                        bw.write(String.valueOf(dq.pollFirst()));
                        if (i < size-1) {
                            bw.write(",");
                        }
                    }
                }
                bw.write("]\n");
            }         
            dq.clear();   
        }   // 테케 끝
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/5430