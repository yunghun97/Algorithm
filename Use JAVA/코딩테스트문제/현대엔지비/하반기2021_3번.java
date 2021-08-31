package 코딩테스트문제.현대엔지비;
import java.io.*;
import java.util.*;

public class 하반기2021_3번 {
    static ArrayList<CarInfo> list;
    static int car;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        car = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        int findCar = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        list.add(new CarInfo(0, 0));
        for(int i=1; i<=car; i++){
            list.add(new CarInfo(i, 0));
        }
        for(int i=0; i<question; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            CarInfo carinfo = list.get(a);
            carinfo.behind[carinfo.getIndex()] = b;
            carinfo.setIndex(carinfo.getIndex()+1);
        }
        int badCar = 0;
        Queue<CarInfo> q = new LinkedList<>();
        q.add(list.get(findCar));
        while(!q.isEmpty()){
            CarInfo carInfo = q.poll();
            for(int i=0; i<car; i++){
                if(carInfo.behind[i]!=0){
                    badCar++;
                    q.add(list.get(carInfo.behind[i]));
                }
            }
        }
        int sameCar = 0;
        int goodCar = 0;
        for(int i=1; i<=car; i++){
            CarInfo carInfo = list.get(i);
            for(int j=0; j<car; j++){
                if(carInfo.behind[j]==0) break;
                if(carInfo.behind[j]==findCar) goodCar++;
            }
        }
        sameCar = car-goodCar-badCar;
        int best = goodCar+1;
        int worst = goodCar+sameCar;
        bw.write(""+best+" "+worst);
        bw.flush();
        bw.close();
        br.close();
    }
    static class CarInfo{
        int num;
        int[] behind = new int[car];
        int index;
        public CarInfo(int num,int index) {
            this.num = num;
            this.index = index;
        }
        public CarInfo(int[] behind,int index) {
            this.behind = behind;
            this.index = index;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        @Override
        public String toString() {
            return "CarInfo [behind=" + Arrays.toString(behind) + ", index=" + index + ", num=" + num + "]";
        }
        
    }
}
/* 
6 6 1
1 4
2 4 
3 4
4 5
3 5 
5 6

답
1
3
*/