package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5개똥벌레_3020 {
    static int N, H, min, cnt;
    static int[] bot, top;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        bot = new int[H+1];
        top = new int[H+1];
        min = N;
        cnt = 0;
        for(int i=0; i<N/2; i++){
            bot[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }
        cal();
        bw.write(""+min+" "+cnt);        
        bw.flush();
    }
    private static void cal() {
        int[] bot_sum = new int[H + 1]; // 높이가 h이하인 석순의 갯수
		int[] top_sum = new int[H + 1]; // 높이가 h이하인 종유석의 갯수

		// 누적합 계산
		for (int i = 1; i < H + 1; i++) {
			top_sum[i] = top_sum[i - 1] + top[i];
			bot_sum[i] = bot_sum[i - 1] + bot[i];
		}

		for (int i = 1; i < H + 1; i++) {
			int crush = 0; // 부딪히는 개수

			// 부딪히는 석순의 갯수 = 전체 석순의 갯수 - (h-i)이하인 석순의 갯수
			crush += bot_sum[H] - bot_sum[i - 1];
			// 부딪히는 종유석의 갯수 = 전체 종유석갯수 - (i-1)이하인 종유석의 갯수
			crush += top_sum[H] - top_sum[H - i];
			
			if (min > crush) { // 더 적게 부수고 갈 수 있는 경우
				min = crush;
				cnt = 1;
			} else if (min == crush) { // 같은 경우 개수 늘려주기
				cnt++;
			}
		}
    }
}
// https://www.acmicpc.net/problem/3020