package SSFAlgorithmLearn.Day1_inOutPut_Array;

public class 하노이재귀 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Hanoi(3,1,2,3);
        System.out.println(sb.toString());
    }

    private static void Hanoi(int N, int start, int temp, int des){
        
            // 자신의 위쪽의 n-1개 원판 들어내기 : 임시기둥으로 옮기기
            // 자신의 원판 옮기기 : 목적기둥
            // 들어냈던 임시기둥의 n-1개 원판 자신위에 쌓기 : 목적 기둥으로 옮기기
        if(N==0)return;
        /*if(N==1){
            sb.append(N+":" +start+ ">"+des+"\n" );
            return;
        }*/
        Hanoi(N-1, start, des, temp);
        sb.append(N+":" +start+ ">"+des+"\n" );
        Hanoi(N-1, temp, start, des);
    }
}
