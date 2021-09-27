package BackJun.Gold;

import java.io.*;
import java.util.*;

// 배열 범위 0 ~ 100,000
public class G5숨바꼭질2_12851 {
    static int answerCount,answerTime, subin, brother;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        
        answerCount = 0;
        answerTime = 999999;
        arr = new int[100001];
        Arrays.fill(arr, 999999);   // 배열을 MAX 값으로 초기화
        bfs();
        bw.write(""+answerTime+"\n"+answerCount+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(subin, 0));
        arr[subin] = 0;
        while(!q.isEmpty()){
            Node node = q.poll();           
            if(node.time>answerTime) return;    // 현재 소모시간이 정답 시간보다 더 크면 return
            if(node.num==brother){  // 동생 좌표에 도착했을 때
                answerTime = node.time;
                answerCount++;
            }
            for(int i=0; i<3; i++){
                int temp = node.num;
                if(i==0){
                    temp*=2;
                }else if(i==1){
                    temp -=1;
                }else{
                    temp +=1;
                }
                if(temp<0||temp>100000) continue;
                if(arr[temp]>=node.time+1){ // 소모시간이 배열의 해당지점과 작거나 같을 때만 q에 넣기
                    q.add(new Node(temp, node.time+1));
                    arr[temp] = node.time+1;
                }
            }
        }
    }

    static class Node{
        int num;
        int time;
        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
}
//https://www.acmicpc.net/problem/12851