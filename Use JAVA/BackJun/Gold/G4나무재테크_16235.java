package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4나무재테크_16235{
    static ArrayList<Integer>[][] list; // 나무 상태 저장하는 리스트
    static int[][] map, vitamin;    // map, 영양추가하는 맵
    static int N,M,K;
    static int[] dx ={-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N][N];
        vitamin = new int[N][N];
        map = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                list[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = 5;  // 기본 5  세팅
                vitamin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Collections.sort(list[i][j], Collections.reverseOrder());   // 처음에만 정렬 리스트 맨 뒤에 붙으므로 내림차순 정렬
            }
        }
        for(int i=0; i<K; i++){
            springSummer(); // 봄, 여름작업 동시에 진행
            fallWinter();
        }
        bw.write(""+cal());
        bw.flush();
    }
    private static int cal() {
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result+=list[i][j].size();
            }
        }
        return result;
    }
    private static void springSummer() {        // 봄 여름 연산
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int sum = 0; 
                for(int x=list[i][j].size()-1; x>=0; x--){  // 맨 뒤부터해서 탐색
                    int age = list[i][j].get(x);
                    if(age<=map[i][j]){
                        map[i][j] -= age;
                        list[i][j].set(x, ++age);
                    }else{
                        list[i][j].remove(x);
                        sum += age/2;
                    }
                }
                map[i][j]+=sum;
            }
        }

    }
    private static void fallWinter() {  // 가을 겨울 연산
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] += vitamin[i][j];
                for(int x=0; x<list[i][j].size(); x++){
                    int age = list[i][j].get(x);
                    if(age%5==0){
                        for(int d=0; d<8; d++){
                            int nr = i+dx[d];
                            int nc = j+dy[d];
                            if(nr<0||nr>=N||nc<0||nc>=N) continue;
                            list[nr][nc].add(1);
                        }
                    }
                }
            }
        }

    }
}
//https://www.acmicpc.net/problem/16235