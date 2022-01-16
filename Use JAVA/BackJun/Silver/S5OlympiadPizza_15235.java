package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S5OlympiadPizza_15235 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] want = new int[N];
        int[] now = new int[N];
        int[] answer = new int[N];
        st =  new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            want[i] = Integer.parseInt(st.nextToken());
            q.add(i);
        }
        int time = 0;
        while(!q.isEmpty()){
            time++;
            int num = q.poll();
            now[num]++;
            if(want[num]>now[num]){
                q.add(num);
            }else{
                answer[num] = time;
            }
        }
        for(int i=0; i<N; i++){
            bw.write(String.valueOf(answer[i])+" ");
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/15235