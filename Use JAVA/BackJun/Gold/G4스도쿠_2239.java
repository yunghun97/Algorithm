package BackJun.Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class G4스도쿠_2239{
    static int[][] map;
    static ArrayList<Node> list;
    static int count;
    static BufferedWriter bw;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new int[9][9];
        check = new boolean[10];
        list = new ArrayList<>();
        for(int i=0; i<9; i++){
            String input = br.readLine();
            for(int j=0; j<9; j++){
                int a = input.charAt(j)-'0';
                map[i][j] = a;
                if(a==0){
                    list.add(new Node(i,j));
                }
            }
        }
        count = 0;
        input(0);
    }
    private static void input(int num) throws IOException{
        if(num==list.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    bw.write(""+map[i][j]);
                }
                bw.newLine();
            }
            bw.flush();
            count++;
            return;
        }
        Node node = list.get(num);

        for(int i=1; i<=9; i++){
            if(count==1) return;
            map[node.r][node.c] = i;
            // System.out.println("num :"+num+" r c "+node.r+" "+node.c+" i : "+i);
            if(check(node)){
                input(num+1);
                map[node.r][node.c] = 0;
            }else{
                map[node.r][node.c] = 0;
            }
        }
    }
    private static boolean check(Node node) {
        Arrays.fill(check, false); 
        int r = node.r;
        int c = node.c;
        for(int i=0; i<9; i++){
            if(map[r][i]!=0){
                if(check[map[r][i]]) return false;
                check[map[r][i]] = true;
            }
        }
        Arrays.fill(check, false); 
        for(int i=0; i<9; i++){
            if(map[i][c]!=0){
                if(check[map[i][c]]) return false;
                check[map[i][c]] = true;
            }
        }
        if(r<=2) r = 0;
        else if(r>=3&&r<=5) r = 3;
        else if(r>=6) r = 6;

        if(c<=2) c = 0;
        else if(c>=3&&c<=5) c =3;
        else if(c>=6) c = 6;
        Arrays.fill(check, false);
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(map[i][j]!=0){
                    if(check[map[i][j]]) return false;
                    check[map[i][j]] = true;
                }
            }
        }
        return true;
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
//https://www.acmicpc.net/problem/2239