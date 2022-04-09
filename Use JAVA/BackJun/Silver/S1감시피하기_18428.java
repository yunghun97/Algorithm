package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1감시피하기_18428 {
    static int N, studentCount;
    static boolean end;
    static String[][] defaultMap;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1}, arr;
    static ArrayList<Node> teacherList, studentList, blankList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
        blankList = new ArrayList<>();
        studentCount = 0;
        arr = new int[3];
        end = false;
        defaultMap = new String[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                String input = st.nextToken();
                defaultMap[i][j] = input;
                if(input.equals("S")){ // 학생
                    studentCount++;
                    studentList.add(new Node(i,j));
                }else if(input.equals("T")){ // 선생
                    teacherList.add(new Node(i, j));
                }else{
                    blankList.add(new Node(i, j));
                }
            }
        }
        setObstacle(0,0);
        if(end) bw.write("YES");
        else bw.write("NO");
        bw.flush();
    }
    // 조합으로 3개 뽑기
    private static void setObstacle(int cnt, int start) {
        if(end) return; // 이미 볼 수 없는 결과가 나왔을 떄 return
        if(cnt==3){
            if(cal()){ // 볼 수 없으면 true 후 return
                end = true;
                return;
            }else{
                rollbackObstacle(); // 볼 수 있을 때 설치한 장애물 다시 빈칸으로 만들어 주기
                return;
            }
        }

        for(int i=start; i<blankList.size(); i++){
            arr[cnt] = i;
            setObstacle(cnt+1, i+1);
        }

    }    
    private static boolean cal() { // 계산
        locateObstacle(); // 장애물 설정        
        for(int i=0; i<teacherList.size(); i++){
            Node node = teacherList.get(i);
            for(int d=0; d<4 ; d++){
                int nr = node.r;
                int nc = node.c;
                while(true){
                    nr+=dx[d];
                    nc+=dy[d];
                    if(outCheck(nr,nc)) break;
                    if(defaultMap[nr][nc].equals("O")) break;
                    else if(defaultMap[nr][nc].equals("S")){  // 학생을 보았으면 return false;
                        return false;
                    }
                }                
            }
        }
        return true; // 여기까지 오면 학생을 못 본 경우
    }
    // 배열 범위 밖 체크
    private static boolean outCheck(int nr, int nc) {
        if(nr<0||nr>=N||nc<0||nc>=N) return true;
        return false;
    }
    // 장애물 설정
    private static void locateObstacle() {
        for(int i=0; i<3; i++){
            Node node = blankList.get(arr[i]);
            defaultMap[node.r][node.c] = "O";
        }
    }
    // 장애물 해제
    private static void rollbackObstacle() {
        for(int i=0; i<3; i++){
            Node node = blankList.get(arr[i]);
            defaultMap[node.r][node.c] = "X";
        }
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
// https://www.acmicpc.net/problem/18428