package BackJun.Gold;
import java.io.*;
import java.util.*;
 
class G3경사로_14890 {
    static int n,L,count;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[n][n];
 
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
 
        // 풀이 시작
        for (int i=0; i<n; i++) {
            if (canGo(i, 0, 0))     // 0 이면 위에서 아래로
                count++;
            
            if (canGo(0, i, 1))     // 1이면 왼쪽에서 오른쪽으로
                count++;
        }
 
        System.out.println(count);
    }
 
    // 한 줄이 경사로인지 확인 d = 0 이면 행검사, d = 1 이면 열검사
    static boolean canGo(int x, int y, int d) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];     // 경사로가 이미 놓여있는지 체크
 
        // 알아보기 쉽게 height 배열에 옮기기
        for (int i=0; i<n; i++) {
            height[i] = (d == 0) ? map[x][y+i] : map[x+i][y];
        }
 
        for (int i=0; i<n-1; i++) {
            // 높이가 같으면 패스
            if (height[i] == height[i+1]) { // 같으면 바로 다음 꺼 탐색
                continue;
            }
            
            else if (Math.abs(height[i] - height[i+1]) > 1) {   // 다음칸이 크기가 1보다 클 때
                return false;
            }
 
            // 내려가야되는 경우
            if (height[i] - 1 == height[i+1]) {
                for (int j=i+1; j<=i+L; j++) {  //내려가므로 내 다음칸부터 L-1칸까지 경사로로 설정한다.
                    // j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
                    if (j >= n || height[i+1] != height[j] || visited[j] == true) {     //1,~L칸까지 비교해서 높이가 다르면 -> 높이 차이가 2를 초과한다는 뜻.
                        return false;
                    } 
                    visited[j] = true;
                }
            }
            // 올라가야되는 경우
            else if (height[i] + 1 == height[i+1]) {    // 올라가는 지점 찾기 -> 지점 부터 -L-1칸 을 경사로로 설정한다.
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }            
        }
 
        return true;
    }
}
