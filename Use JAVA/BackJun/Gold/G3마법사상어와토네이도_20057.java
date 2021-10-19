package BackJun.Gold;
import java.io.*;
import java.util.*;
// 이동 규칙 1,1 2,2 3,3 4,4 N-1이 오면 N-1 3번이동
public class G3마법사상어와토네이도_20057{
    // 왼쪽 -> 아래 -> 오른쪽 -> 위로
    static ArrayList<int[]> list;
    static int N, out;
    static int[][] map;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        list = new ArrayList<>();
        // 행 규칙 열
        // 퍼센트순 왼쪽
        list.add(new int[]{0,-1,1,-2,2,0,-1,1,-1,1,0});
        list.add(new int[]{-1,0,0,-1,-1,-3,-1,-1,-2,-2,-2});
        //아래
        list.add(new int[]{1,0,0,1,1,3,1,1,2,2,2});
        list.add(new int[]{0,-1,1,-2,2,0,-1,1,-1,1,0});
        // 오른쪽
        list.add(new int[]{0,-1,1,-2,2,0,-1,1,-1,1,0});
        list.add(new int[]{1,0,0,1,1,3,1,1,2,2,2});
        //위로
        list.add(new int[]{-1,0,0,-1,-1,-3,-1,-1,-2,-2,-2});
        list.add(new int[]{0,-1,1,-2,2,0,-1,1,-1,1,0});

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        out = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 행 좌표, 열좌표, 방향, 해당 방향 이동횟수, 이동 제한 횟수, 2번 됬는지 체크용
        cal(N/2, N/2, 0, 0, 1, 0);
        bw.write(""+out);
        bw.flush();
    }
    private static void cal(int r, int c, int dir, int moveCount, int limit, int twoCheck) {
        if(moveCount==limit){
            moveCount = 0;
            twoCheck++;
            dir = (dir+1)%4;
        }
        if(twoCheck==2){
            limit++;
            twoCheck =0;
        }
        if(r==0&&c==0) return;
        int direction = dir*2;
        int sand = map[r+list.get(direction)[0]][c+list.get(direction+1)[0]];
        map[r+list.get(direction)[0]][c+list.get(direction+1)[0]] = 0;
        
        int temp =0;
    for(int d=1; d<=10; d++){
            int nr = r+list.get(direction)[d];
            int nc = c+list.get(direction+1)[d];
        if(nr<0||nr>=N||nc<0||nc>=N){   // 격자 밖으로 나갔을 때
                if(d==1||d==2){
                    temp+=sand/100;
                    out+=sand/100;
                }else if(d==3||d==4){
                    temp+=sand/50;
                    out+=sand/50;
                }else if(d==5){
                    temp+=sand/20;
                    out+=sand/20;
                }else if(d==6||d==7){
                    temp+=sand*7/100;
                    out+=sand*7/100;
                }else if(d==8||d==9){
                    temp+=sand/10;
                    out+=sand/10;
                }else{
                    out+=sand-temp;
                }
        }
        else{
            if(d==1||d==2){
                map[nr][nc] += sand/100;
                temp+=sand/100;
            }else if(d==3||d==4){
                map[nr][nc] += sand/50;
                temp+=sand/50;
            }else if(d==5){
                map[nr][nc] +=sand/20;
                temp+=sand/20;
            }else if(d==6||d==7){
                map[nr][nc] += sand*0.07;
                temp+=sand*7/100;
            }else if(d==8||d==9){
                map[nr][nc] += sand/10;
                temp+=sand/10;
            }else{
                map[nr][nc] += sand-temp;
            }
        }
    }
        cal(r+list.get(direction)[0],c+list.get(direction+1)[0],dir,moveCount+1,limit,twoCheck);
    }
}
// https://www.acmicpc.net/problem/20057