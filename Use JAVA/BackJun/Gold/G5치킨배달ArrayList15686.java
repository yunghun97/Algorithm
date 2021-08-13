package BackJun.Gold;


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class G5치킨배달ArrayList15686 {
    static int[] abc;
    static int shop,answer,answer2;
    static int result = Integer.MAX_VALUE;
    static ArrayList<int[]> chicks, houses;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5치킨배달15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        chicks= new ArrayList<int[]>();
        houses = new ArrayList<int[]>();
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        answer = 0; answer2 = Integer.MAX_VALUE;
        shop = Integer.parseInt(st.nextToken());
        abc = new int[shop];
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<size; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp==1){
                    houses.add(new int[] {i,j});           // 집 정보 배열(클래스 선언해서 해도 됨)로 저장 
                                
                }
                else if(temp==2){
                    chicks.add(new int[] {i,j});           // 치킨집 정보 배열(클래스 선언해서 해도 됨)로 저장 
                }
            }
        }
        Combination(0,0);
        bw.write(""+answer2);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void Combination(int cnt, int start) {   // 치킨집이 1,7이나 7,1이여도 똑같으므로 조합으로 짠다.
        if(cnt==shop){
            for(int i=0; i<houses.size(); i++){     // ArraysList의 사이즈가 집이 들어간 만큼이 되므로
                result = Integer.MAX_VALUE;
                for(int j=0; j<cnt;j++){    // 모든 치킨에 대해 가까운 부분을 찾기 위해서
                        result = Math.min(Math.abs(houses.get(i)[1]-chicks.get(abc[j])[1])+Math.abs(houses.get(i)[0]-chicks.get(abc[j])[0]),result); // 한 집에서 가장 가까운 치킨집 찾기
                        if(result==1) break;    // 1이면 이미 최소값                
                }
                answer += result;   // 현재 선택한 치킨 집에서 각 집에 대한 거리 ++
            }
            answer2 = Math.min(answer, answer2);    // 최종적으로 가장 가까운거 
            answer =0;  // 조합이 여러개므로 현재 조합이 끝났으므로 다음 조합에서는 0이 되도록 초기화 해준다.
            return;
        }
        for(int x=start; x<chicks.size(); x++){ // 어짜피 ex)0,1,2,3,4,5로 ArrayList에 들어가 있으므로 x로 넣어도 된다.
            abc[cnt] = x;
            Combination(cnt+1, x+1); 
        }

    }
}