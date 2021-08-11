package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S2배열돌리기3 {
    static int[][] map;
    static int[][] map2;
    static int[] orderArr;
    static int R,C,order;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S3배열돌리기3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        orderArr = new int[order];
        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<order; i++){
            orderArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<orderArr.length; i++){
            check(orderArr[i]);
        }
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                bw.write(String.valueOf(map[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }//메인문 끝
    private static void check(int i) {
        if(i==1||i==2){
            reversal(i);
        }
        if(i==3||i==4){
            rotate(i);
            map=new int[map2.length][map2[0].length];
            map = map2;
            // 어짜피 다른 메소드에서 map2 새로 생성하기때문에 깊은 복사 필요 없다.
            /*for(int x=0; x<map2.length; x++){       // 배열 다시 복사 
                System.arraycopy(map2[x], 0, map[x], 0, map2[x].length);
            }*/
        }
        if(i==5||i==6){
            partition(i);
        }
    }
    static void reversal(int temp){
        if(temp==1){  // 상하반전
                for(int i=0; i<map.length/2; i++){
                    for(int j=0; j<map[i].length; j++){
                        int num =map[i][j];
                        map[i][j] = map[map.length-1-i][j];
                        map[map.length-1-i][j] = num;
                    }
            }

        }
        else{   // 좌우 반전
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length/2; j++){
                    int num = map[i][j];
                    map[i][j] = map[i][map[0].length-1-j];   
                    map[i][map[0].length-1-j] = num;      
                }
            }
        }
    }
    static void rotate(int temp){
        int n1= map.length;     // ex 6
        int n2= map[0].length;  // ex 8
        if(temp==3){ // 오른쪽 6/8이면 8/6이 됨
            map2 = new int[n2][n1];
            for(int i=0; i<n2; i++){
                for(int j=0; j<n1; j++){
                    map2[i][j] = map[n1-j-1][i];
                }
            }
        }
        else{   // 왼쪽
            map2 = new int[n2][n1];
            for(int i=0; i<n2; i++){
                for(int j=0; j<n1; j++){
                    map2[i][j] = map[j][n2-1-i];
                }
            }
        }
    }
    static void partition(int temp){ // 5,6번 
    int n1 = map.length/2;  // ex 6-> 3
    int n2 = map[0].length/2; // ex 8 -> 4
    int swap =0;
    map2 = new int[n1][n2];
    if(temp==5){
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                map2[i][j]=map[i][j+n2];
                map[i][j+n2] = map[i][j];
            }
        }
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                swap = map[n1+i][n2+j];
                map[n1+i][n2+j] = map2[i][j];
                map2[i][j] = swap;
            }
        }
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                swap= map[n1+i][j];
                map[n1+i][j]=map2[i][j];
                map2[i][j]=swap;
            }
        }
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                map[i][j]=map2[i][j];
            }
        }
    }
    else{
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                map2[i][j]=map[i+n1][j];
                map[i+n1][j] = map[i][j];
            }
        }
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                swap = map[n1+i][n2+j];
                map[n1+i][n2+j] = map2[i][j];
                map2[i][j] = swap;
            }
        }
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                swap = map[i][n2+j];
                map[i][n2+j] =map2[i][j];
                map2[i][j]=swap;
            }
        }
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                map[i][j]=map2[i][j];
            }
        }
    }
    }
}

