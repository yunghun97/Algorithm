package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5스타트링크_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int tower = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] dis = new int[tower+1];   // 결과 저장용
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[now] = 0;
        if (goal == now)
            dis[goal] = 0;
        else {
            Queue<Integer> q = new LinkedList<>();
            q.add(now);
            while(!q.isEmpty()){
                int num = q.poll();
                
                if(up!=0){
                    if(num+up<=tower){  // tower 초과 안할 때
                        if(dis[num+up]>dis[num]+1){
                            dis[num+up] = dis[num]+1;
                            q.add(num+up);
                        }
                    }
                }
                if(down!=0){
                    if(num-down>=1){    // 맨 아래보다 클 때
                        if(dis[num-down]>dis[num]+1){
                            dis[num-down] = dis[num]+1;
                            q.add(num-down);
                        }
                    }
                }
            }
        }

        if(dis[goal]!=Integer.MAX_VALUE)   bw.write("" + dis[goal]);
        else bw.write("use the stairs");
        bw.flush();

    }
}
//https://www.acmicpc.net/problem/5014