package EtcProblem;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class 정올_냉장고_1828 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        Temperature[] temperatures = new Temperature[size];
        for(int i=0; i<size; i++){
            st= new StringTokenizer(br.readLine());
            temperatures[i] = new Temperature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            //list.add(new Temperature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        bw.write(""+cal(temperatures));
        bw.flush();
        bw.close();
        br.close();
    }
    static int cal(Temperature[] tempArr){
        int answer =1;
        Arrays.sort(tempArr);
        ArrayList<Temperature> list = new ArrayList<>();
        list.add(tempArr[0]);
        int maxTemper = list.get(0).maxT;
        for(int i=1; i<tempArr.length; i++){    // 최대 온도 보다 다른 약의 최저 온도가 높을 경우 냉장고가 새로 필요하게 된다.
            if(maxTemper<tempArr[i].minT){
                maxTemper = tempArr[i].maxT;
                answer++;   
            }
        }
        return answer;
    }
    static class Temperature implements Comparable<Temperature>{
        @Override
        public String toString() {
            return "Temperature [maxT=" + maxT + ", minT=" + minT + "]";
        }

        int minT;
        int maxT;
        
        public Temperature(int minT, int maxT) {
            this.minT = minT;
            this.maxT = maxT;
        }

        @Override
        public int compareTo(Temperature o) {       // 최대 온도 기준으로 내림차순 정렬한다.
            return Integer.compare(this.maxT, o.maxT);
        }
    }
}



//http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=30