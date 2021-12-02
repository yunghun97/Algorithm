package Softeer2021모의알고리즘코딩대회;

import java.util.*;
import java.io.*;

// 매출액 순 정렬
// 1이 최대매출 N이 최저매출
// 최대매출 차 번호순으로 정렬
public class test2
{   
    static int N;
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Car> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1.score, o2.score));
        for(int i=0; i<N; i++){
            pq.add(new Car(i+1,Integer.parseInt(st.nextToken())));
        }

        while(!pq.isEmpty()){
            Car car = pq.poll();
            bw.write(""+car.num+" ");
        }
        bw.flush();
    }
    static class Car{
        int num;
        int score;
        public Car(int num, int score){
            this.num = num;
            this.score = score;
        }
    }
}