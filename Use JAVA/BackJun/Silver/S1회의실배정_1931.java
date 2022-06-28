package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1회의실배정_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Room> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.end==o2.end){
                return Integer.compare(o1.start, o2.start);                
            }else return Integer.compare(o1.end, o2.end);
        });
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());            
            pq.add(new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int now = 0;
        int answer = 0;
        now = pq.poll().end;
        answer++;
        while(!pq.isEmpty()){
            Room room = pq.poll();
            if(room.start>=now){
                now = room.end;
                answer++;
            }
        }
        bw.write(""+answer);
        bw.flush();
    }
    static class Room{
        int start;
        int end;
        public Room(int start, int end){
            this.start = start;
            this.end = end;
        }
    }   
}
// https://www.acmicpc.net/problem/1931