package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5트리_1068 {
    static int[] parents;
    static int answer,N,delete,count;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        int root = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i]==-1) root = i;    // 젤 처음 -> root 노트 index 기록
        }
        System.out.println(Arrays.toString(parents));
        delete  = Integer.parseInt(br.readLine());  // 삭제할 번호 -> 삭제할 번호

        deleteNode(delete);
        count = 0;
        isVisited = new boolean[N];
        countLeaf(root);

        bw.write(""+count);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void countLeaf(int s) {
        boolean isLeaf = true;
        isVisited[s] = true;
        if(parents[s] != -2) {
            for(int i = 0; i < N; i++) {
                if(parents[i] == s && isVisited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
    private static void deleteNode(int d) {
        parents[d] = -2;    // 삭제한 부모 -2
        for(int i=0; i<N; i++){
            if(parents[i]==d){
                deleteNode(i);
            }
        }
    }
}
//https://www.acmicpc.net/problem/1068