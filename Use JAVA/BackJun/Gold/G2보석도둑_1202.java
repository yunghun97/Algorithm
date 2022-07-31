package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2보석도둑_1202 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Jewel[] jewelArr = new Jewel[N];
        int[] bagArr = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelArr[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i < K; i++){
            bagArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelArr, new Comparator<Jewel>() {            
            @Override
            public int compare(Jewel o1, Jewel o2){
                if(o1.weight==o2.weight) return Integer.compare(o2.price, o1.price);
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        Arrays.sort(bagArr); // 가방 무게 오름차순

        // 가격 내림차순 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o2, o1));

        long answer = 0; 
        int j =0;               
        for(int i=0; i < K; i++){                        
            while(j < N && jewelArr[j].weight <= bagArr[i]){
                pq.add(jewelArr[j++].price);
            }

            if(!pq.isEmpty()){ // 가능한 숫자 중 가장 가치가 큰 것 1개 
                answer += pq.poll();       
            }
        }

        bw.write(""+answer);
        bw.flush();
    }

    static class Jewel {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
// https://www.acmicpc.net/problem/1202