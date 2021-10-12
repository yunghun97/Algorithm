package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4스도쿠_2580 {
    static int[][] map;
    static ArrayList<Node> list;
    static ArrayList<PossibleNum> pList;
    static boolean end;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        map = new int[9][9];
        list = new ArrayList<>();
        pList = new ArrayList<>();
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a==0){
                    list.add(new Node(i, j));
                }        
            }
        }
        end = false;
        firstCheck();
        set(0);
        bw.flush();
    }
    private static void set(int cnt) throws IOException{
        if(end) return; // 이미 끝났으면 바로 return
        if(cnt==list.size()){   // 현재 제일 처음으로 도착한 스토쿠이므로 bw에 쓰고 return
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    bw.write(""+map[i][j]+" ");
                }
                bw.newLine();
            }
            end = true;
            return;
        }
        Node node = list.get(cnt);
        PossibleNum possibleNum = pList.get(cnt);
        for(int i=0; i<possibleNum.possibleArr.size(); i++){
            if(end) return; // 이미 끝났으면 바로 return
            map[node.r][node.c] = possibleNum.possibleArr.get(i);
            if(check(node.r, node.c, possibleNum.possibleArr.get(i))){
                set(cnt+1);
                map[node.r][node.c] = 0;
            }else{
                map[node.r][node.c] = 0;
            }
        }
    }
    private static boolean check(int nr, int nc, Integer num) {
        // 열체크
        for(int i=0; i<9; i++){
            if(i==nc) continue;
            if(map[nr][i]==num) return false;
        }
        // 행체크
        for(int j=0; j<9; j++){
            if(j==nr) continue;
            if(map[j][nc]==num) return false;
        }
        // 사각형 체크
        for(int r=nr/3*3; r<nr/3*3+3; r++){
            for(int c=nc/3*3; c<nc/3*3+3; c++){
                if(r==nr&&c==nc) continue;
                if(map[r][c]==num) return false;
            }
        }
        return true;
    }
    private static void firstCheck() {  // 처음 스도쿠에 들어갈 수 있는 숫자만 맨 처음 체크해서 1~9까지 안돌게 
        boolean[] numCheck = new boolean[10];
        for(int i=0; i<list.size(); i++){
            Node node = list.get(i);    

            // 열체크
            for(int r=0; r<9; r++){
                numCheck[map[r][node.c]] = true;
            }
            // 행체크
            for(int c=0; c<9; c++){
                numCheck[map[node.r][c]] = true;
            }
            // 사각형 체크
            for(int r=node.r/3*3; r<node.r/3*3+3; r++){
                for(int c=node.c/3*3; c<node.c/3*3+3; c++){
                    numCheck[map[r][c]] = true;
                }
            }
            ArrayList<Integer> temp = new ArrayList<>();
            for(int x=1; x<=9; x++){
                if(!numCheck[x]){
                    temp.add(x);
                }
            }
            pList.add(new PossibleNum(temp));
            Arrays.fill(numCheck, false);
        }
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class PossibleNum{
        ArrayList<Integer> possibleArr;
        public PossibleNum(ArrayList<Integer> possibleArr){
            this.possibleArr = possibleArr;
        }
    }
}
//https://www.acmicpc.net/problem/2580