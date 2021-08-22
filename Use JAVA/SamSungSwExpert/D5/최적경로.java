package SamSungSwExpert.D5;
import java.io.*;
import java.util.*;
public class 최적경로 {
    static int size,answer,result;
    static ArrayList<Customer> customers;
    static boolean[] isSelected;
    static int[] order;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D5\\최적경로.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            size = Integer.parseInt(br.readLine());
            isSelected = new boolean[size+2]; order = new int[size+2];
            st = new StringTokenizer(br.readLine());
            customers = new ArrayList<>();
            customers.add(new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); // 회사 젤 처음에
            Home home = new Home(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int i=0; i<size; i++){
                customers.add(new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            customers.add(customers.size(), new Customer(home.getR(),home.getC()));
            //System.out.println(customers.toString());
            answer = Integer.MAX_VALUE;
            order[size+1] = size+1;     // 어짜피 0번째는 회사로 초기화 되어있다. 따라서 마지막만 집 index인 List의 사이즈-1==size+1은 넣어준다.
            permutation(1,0);
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        } //테케 끝
        bw.close();
        br.close();        
    }
    private static void permutation(int cnt,int sum) {
        //if(sum>answer) return;
        if(cnt==customers.size()-1){
            //System.out.println(Arrays.toString(order));
            answer = Math.min(answer, sum + Math.abs(customers.get(order[size]).r-customers.get(order[size+1]).r) + Math.abs(customers.get(order[size]).c-customers.get(order[size+1]).c));
            return;
        }
        for(int i=1; i<=size; i++){

            if(isSelected[i]) continue;
            
            isSelected[i] = true;
            order[cnt] = i;
            if(answer>sum+Math.abs(customers.get(order[cnt-1]).r-customers.get(order[cnt]).r)+Math.abs(customers.get(order[cnt-1]).c-customers.get(order[cnt]).c))  // 조건에 만족하면 재귀로 돌리겠다.
            permutation(cnt+1, sum+Math.abs(customers.get(order[cnt-1]).r-customers.get(order[cnt]).r)+Math.abs(customers.get(order[cnt-1]).c-customers.get(order[cnt]).c));  // 여기 하면 됨.
            isSelected[i] = false;
        }
    }
    static class Customer{
        int r;
        int c;
        public Customer(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Customer [r=" + r + ", c=" + c + "]";
        }
        
    }
    static class Home{
        int r;
        int c;
        public Home(int r, int c){
            this.r = r;
            this.c = c;
        }
        int getR(){
            return r;
        }
        int getC(){
            return c;
        }
    }
}