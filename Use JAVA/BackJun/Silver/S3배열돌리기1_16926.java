package BackJun.Silver;
import java.io.*;
import java.util.StringTokenizer;


public class S3배열돌리기1_16926 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S3배열돌리기1_16926.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int in = Math.min(R, C)/2;  // 좌우 1줄씩 있을때마다 1번씩 돌아아햠 홀수면 어짜피 1개라서 아래 조건에 걸린다.
        int temp=0;
        for(int i=0; i<size; i++)
            for(int j=0; j<in; j++){
                int r =j;
                int c =j;
                temp = map[j][j];   // 하나 남는값 미ㅣㄹ 저장
                for(int d=0; d<4; d++){     // 바향
                    while(true){    // 조건 맞을 때 까지 돌림.
                        int nr = r+dx[d];
                        int nc = c+dy[d];
                        if(nr<j||nr>=R-j||nc<j||nc>=C-j) break;
                        else{
                        map[r][c] = map[nr][nc];
                        r = nr;
                        c = nc;}
                    }
                }
                map[j+1][j] = temp;
            }
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    bw.write(String.valueOf(map[i][j])+" ");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
        }
       
}
