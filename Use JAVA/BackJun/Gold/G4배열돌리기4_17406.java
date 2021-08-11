package BackJun.Gold;

import java.io.*;
import java.util.StringTokenizer;
public class G4배열돌리기4_17406 {
    static int[][] map,orderArr,map2;
    static int[] dx,dy,answer;
    static boolean[] isSelected;
    static int order,a,b;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G4배열돌리기4_17406.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        dx = new int[]{1,0,-1,0};
        dy = new int[]{0,1,0,-1}; 
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        isSelected = new boolean[order];
        orderArr = new int[order][3];
        map = new int[a][b];
        map2 = new int[a][b];
        answer = new int[order];

        for(int i=0; i<a; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<b; j++){
                map2[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = map2[i][j];
            }
        }
        for(int x=0; x<order; x++){
        st = new StringTokenizer(br.readLine());
        orderArr[x][0] = Integer.parseInt(st.nextToken());
        orderArr[x][1] = Integer.parseInt(st.nextToken());
        orderArr[x][2] = Integer.parseInt(st.nextToken());
    }
        permutation(0); // 순열 구해서 그거 만큼 다 돌려보고 최소값 출력한다!!!!
        bw.write(""+result);
        bw.close();
        br.close();
    }
    static void permutation(int cnt){   // 순열 계산
        if(cnt==order){
            set();
            return;   
        }
        for(int i=0; i<order; i++){
        if(isSelected[i]) continue;
            answer[cnt]=i;
            isSelected[i] =true;
            permutation(cnt+1);
            isSelected[i] = false;
        }

    }
    static void set(){          // 순열에 한번씩 대입해서 다 돌리기
        for(int x=0; x<order; x++){
            int R = orderArr[answer[x]][0];
            int C = orderArr[answer[x]][1];
            int S = orderArr[answer[x]][2];
        cal(R-S-1, C-S-1,  R+S-1, C+S-1);
        }
        
        int temp =0;
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                temp += map[i][j];          // 최소값 구하면서 배열 초기화
                map[i][j] = map2[i][j];
            }
            result = Math.min(result, temp);
            temp =0;
        }
        

    }
    static void cal(int topRow, int topColumn,int bottomRow, int bottomcolumn){
        int row = bottomRow - topRow;
        int column = bottomcolumn - topColumn;
        int size = Math.min(row, column)/2;
        for(int i=0; i<size; i++){
            int r= topRow+i;     // ex 1
            int c= topColumn+i;  // ex 5
                           //column ex 4
            int temp = map[topRow+i][topColumn+i];
            for(int d=0; d<4; d++){     // 방향
                while(true){    // 조건 맞을 때 까지 돌림.
                    int nr = r+dx[d];
                    int nc = c+dy[d];   // 작은 값인 top 부분보다 작으면 안되고 큰 부분인 Bottom보다는 작아야한다.
                    if(nr<topRow+i||nr>bottomRow-i||nc<topColumn+i||nc>bottomcolumn-i) break;
                    else{
                    map[r][c] = map[nr][nc];
                    r = nr;
                    c = nc;}
                }
            }
            map[topRow+i][topColumn+1+i] = temp;
        }
    }
}
