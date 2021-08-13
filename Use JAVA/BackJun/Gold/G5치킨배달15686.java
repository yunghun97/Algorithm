package BackJun.Gold;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class G5치킨배달15686 {
    static int[][] house, chicken;
    static int[] abc;
    static int shop,answer,chickenCount,answer2;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5치킨배달15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        answer = 0; answer2 = Integer.MAX_VALUE;
        shop = Integer.parseInt(st.nextToken());
        abc = new int[shop];
        house = new int[size*2][2]; // 최대갯수 배열
        chicken = new int[13][2];   // 최대갯수
        int houseCount=0; chickenCount =0;
        for(int[] arr : house){
            Arrays.fill(arr, -1);
        }
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<size; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp==1){
                    house[houseCount][0] = i;           // 집의 행 저장
                    house[houseCount++][1] = j;         // 집의 열 저장
                }
                else if(temp==2){
                    chicken[chickenCount][0] = i;       // 치킨집 행 저장
                    chicken[chickenCount++][1] = j;     // 치킨집 열 저장
                }
            }
        }
        Combination(0,0);
        bw.write(""+answer2);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void Combination(int cnt, int start) {   // 순서가 상관없으므로 조합으로 계산
        if(cnt==shop){
            for(int i=0; i<house.length; i++){
                if(house[i][0]==-1) break;  // -1 이면 더이상 집이 없으므로 
                result = Integer.MAX_VALUE;
                for(int j=0; j<cnt;j++){
                        result = Math.min(Math.abs(house[i][1]-chicken[abc[j]][1])+Math.abs(house[i][0]-chicken[abc[j]][0]),result); // 최솟값 구하기
                        if(result==1) break;
                }
                answer += result;   // 1번집 최솟값 + 2번집 최솟값 + ~~~
            }
            answer2 = Math.min(answer, answer2);    // 모든 집을 돌았을때에 최솟값을 구한다.
            answer =0;  // 현재 치킨집 조합에서 모든 집 돌았으므로 다음 조합에서 0부터 시작하기 위해 초기화 시켜준다.
            return;
        }
        for(int x=start; x<chickenCount; x++){
            abc[cnt] = x;
            Combination(cnt+1, x+1); 
        }

    }
}