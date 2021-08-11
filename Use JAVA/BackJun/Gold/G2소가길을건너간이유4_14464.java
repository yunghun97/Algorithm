package BackJun.Gold;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class G2소가길을건너간이유4_14464 {
    static int ChickenCount, CowCount, answer;
    static int[] chickenArr;
    static boolean pass;
    static PriorityQueue<Cow> pq = new PriorityQueue<>(new Comparator<Cow>(){
        @Override
        // 음수값이 리턴일 경우 기준점이 비교대상의 앞에 위치 -> 비교 대상이 뒤로 간다(원래 뒤에였음) -> 오름 차순
        // 양수값이 리턴일 경우 기준점이 비교대상 뒤에 위치 -> 반대(두 객체의 자리가 바뀐다.) -> 내림 차순
        // 0 일 경우 자리이동이 없다.
        public int compare(Cow o1, Cow o2) {
            if(Integer.compare(o1.startTime, o2.startTime)!=0){
                return o2.startTime-o1.startTime;   // 시작 시간 기준 내림차순
            }
            else{
                return o2.endTime -o1.endTime;      // 종료 시간 기준 내림차순
            }
        }
    });
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G2소가길을건너간이유4_14464.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        ChickenCount = Integer.parseInt(st.nextToken());
        CowCount = Integer.parseInt(st.nextToken());
        chickenArr = new int[ChickenCount];
        for(int i=0; i<ChickenCount; i++){
            chickenArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(chickenArr);    // 오름 차순 정렬
        for(int i=0; i<CowCount; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Cow(a, b));  // 우선순위 큐에 저장 내림차순으로 시작시간이 같으면 종료시간 내림차순
        }
        bw.write(String.valueOf(cal()));
        bw.flush();
        bw.close();
        br.close();
    }
    static int cal(){
        int cnt =0;
        while(!pq.isEmpty()){
            pass = false;
            for(int i=ChickenCount-1; i>=0; i--){
            if(chickenArr[i]>=pq.peek().startTime && chickenArr[i]<=pq.peek().endTime&&chickenArr[i]>=0){   // 1번 닭부터 끝까지 돌아서 소가
                    cnt++;
                    pq.poll();
                    pass =true;
                    chickenArr[i] =-1;
                    break;
                }
            }
            if(!pass) pq.poll();
            pass = false;
        }
    return cnt;
    }
    private static class Cow { //implements Comparable<Cow>{
        int startTime;
        int endTime;
        public Cow(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
        // 음수값이 리턴일 경우 기준점이 비교대상의 앞에 위치 -> 비교 대상이 뒤로 간다 -> 내림 차순
        // 양수값이 리턴일 경우 기준점이 비교대상 뒤에 위치 -> 반대
        // 0 일 경우 자리이동이 없다.
        /*@Override
        public int compareTo(Cow o) {
            if(Integer.compare(this.startTime, o.startTime)!=0){    // 비교해서 똑같이 않으면
                return o.startTime-this.startTime;  // 내림 차순 정렬
            }
            else{
                return o.endTime-this.endTime;
            }
        }*/
        @Override
        public String toString(){       // 큐 들어갔는지 확인용 문제풀이에는 쓸모 없음
            return "[" + this.startTime +" | " + this.endTime +"]";
        }
    }
}
