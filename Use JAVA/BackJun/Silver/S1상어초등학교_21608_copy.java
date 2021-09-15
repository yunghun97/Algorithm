package BackJun.Silver;
import java.io.*;
import java.util.*;
/*
비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
*/
public class S1상어초등학교_21608_copy { 
    static int[][] map, likeArr;
    static int N,answer;
    static ArrayList<Student> list;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        likeArr = new int[N*N+1][4];
        for(int i=0; i<N*N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<4; j++){
                likeArr[num][j] = Integer.parseInt(st.nextToken());
            }
            cal(num);   // 배열 세팅
        }
        answer =0;
        calScore();     // 점수 계산 
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();        
    }
    private static void calScore() {
        for(int i=0; i<N; i++){
        
            for(int j=0; j<N; j++){
                HashSet<Integer> hs = new HashSet<>(); 
                int num = map[i][j];  
                int matchCount =0;
                for(int x=0; x<4; x++){
                    hs.add(likeArr[num][x]);    //hs에 좋아하는 사람 저장
                }
                for(int d=0; d<4; d++){
                    int nr = i+dx[d];
                    int nc = j+dy[d];
                    if(nr<0||nr>=N||nc<0||nc>=N) continue;
                    if(hs.contains(map[nr][nc])) matchCount++;  // 포함이면 ++
                }
                if(matchCount==0){}
                else if(matchCount==1) answer++;
                else if(matchCount==2) answer+=10;
                else if(matchCount==3) answer+=100;
                else answer+=1000;
            }
        }
    }
    private static void cal(int num) {
        HashSet<Integer> hs = new HashSet<>();
        PriorityQueue<Student> pq = new PriorityQueue<>();  // 들어갈 인원의 우선순위 큐 선언
        for(int i=0; i<4; i++){
            hs.add(likeArr[num][i]);    // 좋아하는 짝궁 저장
        }
        outer : for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int friendCount = 0;    // 인접 친구 수
                int blankCount = 0;     // 인접 공백 수
                if(map[i][j]!=0) continue;
                for(int d=0; d<4; d++){     // 여백 + 친구수 계산
                    int nr = i+dx[d];
                    int nc = j+dy[d];
                    if(nr<0||nr>=N||nc<0||nc>=N) continue;
                    if(hs.contains(map[nr][nc])) friendCount++;
                    if(map[nr][nc]==0) blankCount++;
                }
                pq.add(new Student(i, j, friendCount, blankCount));
                if(friendCount==4) break outer;         // 가장 작은행 -> 열 순이므로 사방향이 4이면 위치가 최소이기 때문에 더 볼 필요 없이 break 시켜준다.
            }
        }
        Student student = pq.poll();    // 0번째가 조건을 만족하는 최소가 오게 된다.
        map[student.r][student.c] = num;    // 현재 map에 해당학생의 번호 넣기
    }
    static class Student implements Comparable<Student>{
        int r;
        int c;
        int friendCount;
        int blankCount;
        public Student(int r, int c, int friendCount, int blankCount) {
            this.r = r;
            this.c = c;
            this.friendCount = friendCount;
            this.blankCount = blankCount;
        }
        @Override
        public int compareTo(Student o) {   // 우선순위 큐에 정렬될 조건 -> 친구수 큰거 -> 공백수 큰거 -> 행 작은거 -> 열 작은거
            if(this.friendCount!=o.friendCount) return Integer.compare(o.friendCount, this.friendCount);
            if(this.blankCount!=o.blankCount) return Integer.compare(o.blankCount,this.blankCount);
            if(this.r!=o.r) return Integer.compare(this.r, o.r);
            return Integer.compare(this.c, o.c);
        }
    }
}
//https://www.acmicpc.net/problem/21608