package SSFAlgorithmLearn.Day6;
import java.util.*;
public class MeetingRoomTest {
    static class Meeting implements Comparable<Meeting>{
        
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) { //음수,양수 그대로, 양수면 교환 -> 기본 오름차순 베이스 이므로
            if(Integer.compare(this.end, o.end)!=0)
            return Integer.compare(this.end, o.end);
            else
            return Integer.compare(this.start, o.start);
        }   
        @Override
        public String toString() {
            return "Meeting [end=" + end + ", start=" + start + "]";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting[] meetings = new Meeting[N];
        for(int i=0; i<N; i++){
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        for(Meeting meeting : getSchedule(meetings)){
            System.out.println(meeting);
        }
    }
    static ArrayList<Meeting> getSchedule(Meeting[] meetings){
        ArrayList<Meeting> list = new ArrayList<>();
        Arrays.sort(meetings); // 종료시간 기준 오름차순 정렬
        list.add(meetings[0]); // 첫회의 추가
        for(int i=1,size= meetings.length; i<size; i++){
            if(list.get(list.size()-1).end<= meetings[i].start){
                list.add(meetings[i]);
            }
        }
        return list;
    }
}
