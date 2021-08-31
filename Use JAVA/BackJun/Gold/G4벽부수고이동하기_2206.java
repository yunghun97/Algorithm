package BackJun.Gold;
import java.io.*;
import java.util.*;
public class G4벽부수고이동하기_2206 {  // BFS로 해야 함
    static int R,C,answer;
    static int[] dx = {0,0,-1,1}, dy={-1,1,0,0};
    static int[][] isDrill;
    static char[][] map;
    static Queue<Address> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isDrill = new int[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
            Arrays.fill(isDrill[i], Integer.MAX_VALUE); // 방문했는지 확인하기 위한 배열 초기화
        }
        q = new LinkedList<>();
        answer = 0;
        isDrill[0][0]=0;
        q.add(new Address(0, 0, 0 , 1));    // 초기 좌표 할당
        bfs();
        if(answer==0){
            bw.write(""+-1);
        }else{
            bw.write(""+answer);
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void bfs() {
        while(!q.isEmpty()){
            Address address = q.poll();
            if(address.r==R-1&&address.c==C-1){
                answer = address.count;
                return;
            }
            for(int d=0; d<4; d++){
                int nr = address.r+dx[d];
                int nc = address.c+dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;

                if(isDrill[nr][nc]<=address.crush) continue;    // crush가 같거나 크다 -> 같다 = 이미 방문했다는 뜻 & 크다 = 부수고 방문할 필요 없이 도착했다는 뜻으로 새로 초기화 시켜준다.

                if(map[nr][nc]=='0'){ // 벽이 아닐 때  무조건 이동
                    isDrill[nr][nc]=address.crush;
                    q.add(new Address(nr, nc, address.crush, address.count+1));
                }else{
                    if(address.crush==0){   // 0일때 만 벽을 부술 수 있으므로 
                    isDrill[nr][nc]=address.crush+1;
                    q.add(new Address(nr, nc, address.crush+1, address.count+1));
                    }
                }   
            
            }
        }
        
    }
    static class Address{
        int r;
        int c;
        int crush;
        int count;
        public Address(int r, int c, int crush, int count) {
            this.r = r;
            this.c = c;
            this.crush = crush;
            this.count = count;
        }
    }
}
//https://www.acmicpc.net/problem/2206
