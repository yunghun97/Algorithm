package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5강의실_1374 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> inputPq = new PriorityQueue<>((o1,o2)->{
            if(o1.start==o2.start) return Integer.compare(o1.end, o2.end);
            else return Integer.compare(o1.start, o2.start);
        });
        PriorityQueue<Lecture> nowPq = new PriorityQueue<>((o1,o2)->{
            if(o1.end==o2.end) return Integer.compare(o1.start, o2.start);
            else return Integer.compare(o1.end, o2.end);
        });

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            inputPq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int count = 0;
        while(!inputPq.isEmpty()){
            Lecture lecture = inputPq.poll();
            if(nowPq.isEmpty()){                
                nowPq.add(lecture);
            }else{
                if(nowPq.peek().end>lecture.start){
                    nowPq.add(lecture);
                }else{
                    nowPq.poll();
                    nowPq.add(lecture);
                }
            }
            count = Math.max(count, nowPq.size());
        }

        bw.write(""+count);
        bw.flush();
    }
    static class Lecture{
        int start;
        int end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
// https://www.acmicpc.net/problem/1374