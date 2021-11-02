package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4사다리조작_15684 {
    static boolean[][] ladder;
    static int R, C, count, answer;
    static ArrayList<Node> list;
    static boolean end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;        
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        ladder = new boolean[R+1][C+1];

        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            ladder[row][col] = true;
        }
        list = new ArrayList<>();
        end = false;

        for(int i=1; i<=R; i++){
            for(int j=1; j<C; j++){
                if(!ladder[i][j]&&!ladder[i][j-1]){
                    list.add(new Node(i, j));            
                }
            }
        }
        answer = 4;
        for(int i=0; i<=3; i++){    // 0,1,2,3개 놓는거 탐색
            dfs(0,0,i);
            if(end) break;  // 끝나면 뒤 탐색 X
        }
        
        if(answer==4){  // answer=4면 경우의수가 없으므로 -1 출력
            bw.write(String.valueOf(-1));
        }else bw.write(String.valueOf(answer));
        bw.flush();
    }
    private static void dfs(int install, int start, int size) { // 설치한 사다리 개수, 시작번호, 최대 설치가능 개수
        if(end) return; // 이미 끝났으면 return
        if(install==size){  // 설치개수랑 최대가능 설치개수면 탐색
            if(check()){
                answer = install;
                end = true;
            }
            return;
        }
        // 놓을 수 있는 사다리 좌표저장 list를 저번에 넣은 다음 번호부터 확인 -> 넣는 좌표 왼쪽에 이미 설치되어 있으면 설치 X
        for(int i=start; i<list.size(); i++){
            Node node = list.get(i);
            if(ladder[node.r][node.c-1]) continue;
            ladder[node.r][node.c] = true;
            dfs(install+1, i+1,size);
            ladder[node.r][node.c] = false;
        }
    }
    private static boolean check() {
        for(int i=1; i<=C; i++){
            if(move(i)!=i) return false;
        }
        return true;
    }
    private static int move(int num) {
        int c = num;
        int r = 1;
        while(r<=R){
            // 내가 사다리칸이면 오른쪽으로 이동, 사다리칸 아니면 왼쪽탐색 후 사다리칸이면 거기로 이동
            if(ladder[r][c]){
                ++c;
                ++r;
            }else{
                if(ladder[r][c-1])
                --c;
                ++r;
            }
            if(r==R+1){
                return c;
            }
        }
        
        return -1;
    }

    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

//https://www.acmicpc.net/problem/15684