package SamSungSwExpert.모의역랑테스트;
import java.io.*;
import java.util.*; // 행과열을 바꿔서 
public class 무선충전 {     //0은 이동하지 않는다  //1 상-> 행 -1 2: 우 -> 열 +1 3 : 하 -> 행+1 4: 좌 열-1
    static int[] dx = {0,-1,0,1,0}, dy = {0,0,1,0,-1};  //반전시킨 상태라서 교수님꺼랑 방향이 다름
    static int order, chargeCount, answer;
    static int[] pathA, pathB;
    static Player playerA, playerB;
    static ArrayList<BatteryCharger> bc;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\모의역량테스트\\무선충전.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            answer = 0;
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());       // 총 이동명령 갯 수    
            chargeCount = Integer.parseInt(st.nextToken()); // 충전기 갯수
            playerA = new Player(0, 0); // 초기위치 할당 2번
            playerB = new Player(9, 9);
            pathA = new int[order+1];   // 움직임을 저장할 배열 2개
            pathB = new int[order+1];
  
            st = new StringTokenizer(br.readLine());    // 움직임 명령 저장
            for(int i=1; i<=order; i++) pathA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=order; i++) pathB[i] = Integer.parseInt(st.nextToken());
            
            bc = new ArrayList<>(); // 배터리에 대한 정보의 클래스를 ArrayList로 저장해서 관리해준다.
            for(int i=0; i<chargeCount; i++){
                st = new StringTokenizer(br.readLine());
                bc.add(new BatteryCharger(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); // 초기위치를 0,0 9,9로 잡으면 발전기 위치 -1씩해주고 초기위치 1,1 10,10이면 그대로
            }

            Collections.sort(bc, (o1, o2) -> Integer.compare(o2.power, o1.power)); // 파워 기준으로 내림차순 정렬
            bc.add(0, new BatteryCharger(-1,-1,-1,0)); // 젤 앞에 못찾았을때 파워 0을 더해야하므로 index[0]번째에 파워가 0이 되게 해준다. 앞에 3개는 쓰레기 값 막넣어도 됨.
            //System.out.println(bc.toString());  // 확인용
            solve();

            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    //매번 움직일때 마다 두 사용자의 최대 충전량의 합을 구하여 answer에 더해준다.
    private static void solve() {
        for(int time =0; time<=order; time++){
            
            playerA.move(pathA[time]); // -> 처음은 0이라서 제자리이동하고 계산 됨
            playerB.move(pathB[time]);

            int[] maxA = getCharge(playerA);    // 최대값 배열 저장
            int[] maxB = getCharge(playerB);

            if(maxA[0]!=maxB[0]){  // -> 같은 충전기를 사용하고 있지 않으면 == 충전기의 번호가 같지 않으면 -> 겹치는게 없므로 2개를 더해준다.
                answer += bc.get(maxA[0]).power + bc.get(maxB[0]).power;
            }else{  //> 충전기의 번호가 같으면(현재 공유하고 있는 충전기가 최대값이다) -> 따로 더 할 가능성이 있기때문에 -> 1개를 우선 더하고 -> 뒤에꺼에서 max를 구한다
                // 뒤에가 둘다 0 0 이면 어짜피 /2해서 더한 값이 되므로 상관없고 -> 1개라도 값이있으면 +a이므로 성립 -> 두 개 다 값이 있으면 /2하지않고 +a이므로 성립한다. 
                // ex) {200,0}{200,0} -> 200   {200 10}, {200,0} -> 210   {200,50} {200,70} -> 270
                answer += bc.get(maxA[0]).power + Math.max(bc.get(maxB[1]).power, bc.get(maxA[1]).power); //bc에 0 0 0 0 더한 이유이다. -> 둘 다 못찾았을때에도 0,0이라서 발전기 번호가 같으므로 BC ArrayList[0] 인덱스에 0,0,0,0을 넣어준다. 앞에 0,0,0은 뭘 넣어도 상관없다.
            }
        }
        

    }
    private static int[] getCharge(Player p) {
        int[] maxArr = {0,0};  // -> 최대 순으로 내림차순 정렬했으므로 가장 큰 파워 2개를 가진 충전기의 번호가 저장된다.
        int index = 0;
        int pos = 1; // -> 0부터 시작해도 상관없지만 어짜피 bc[0]에는 쓰레기 값이므로 1부터 시작하게 한다.
        while(index<2 && pos <=chargeCount){    // index가 2이상이 되면 어짜피 최대 파워순으로 내림차순 정렬했으므로 더 탐색할 필요가 없기때문에 종료시켜준다.
            if(check(bc.get(pos), p)){  
                maxArr[index++] = pos;
            }
            pos++;  // 다음 충전기로 이동
        }
        return maxArr;
    }

    private static boolean check(BatteryCharger BC, Player p) {
        return Math.abs(BC.r-p.r) + Math.abs(BC.c-p.c) <= BC.dis;
    }

    static class BatteryCharger{
        int r;
        int c;
        int dis;
        int power;
        BatteryCharger(int c, int r, int dis, int power) {  // 반전시킨 상태이므로 r,c반대로 입력받는다.
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.power = power;
        }
        @Override
        public String toString() {  // 배터리 들어갔나 확인용 없어도 되는 코드
            return "BatteryCharger [c=" + c + ", dis=" + dis + ", power=" + power + ", r=" + r + "]";
        }
        
    
    }
    static class Player{
        int r,c;

        Player(int r, int c) {  // 현재 위치를 저장하는 생성자
            this.r = r;
            this.c = c;
        }
        void move(int dir){ // 움직이는 코드
            r+=dx[dir];
            c+=dy[dir];
        }
    }
}
