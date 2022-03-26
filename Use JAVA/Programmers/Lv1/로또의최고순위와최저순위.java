package Programmers.Lv1;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] t1 = new int[]{44, 1, 0, 0, 31, 25};
        int[] t2 = new int[]{31, 10, 45, 1, 6, 19};
        solution(t1, t2);
    }
    /**
    6개 맞 -> 1등
    ``
    ``
    `
    2개 맞 -> 5등
    1개 이하 -> 6등
    */
    static boolean[] isVisited;
    static int[] result;
    private static int[] solution(int[] lottos, int[] win_nums) {        
        isVisited = new boolean[6];
        int min = findMinRank(lottos, win_nums);
        int max = findMaxRank(lottos, win_nums) + min;
        
        result = new int[]{6,6,5,4,3,2,1}; 
        int[] answer = new int[2];
        
        answer[0] = result[max];
        answer[1] = result[min];
                
        
        return answer;
    }
    // 최소 구하기
    static int findMinRank(int[] arr, int[] answer){
        int result = 0;
        for(int i = 0; i <6; i++){
            for(int j =0; j<6; j++){
                if(arr[i] == answer[j]){ // 기존의 번호와 일치할 때
                    isVisited[j] = true;
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    // 최대 구하기
    static int findMaxRank(int[] arr, int[] answer){
        int result = 0;
        for(int i = 0; i <6; i++){            
            for(int j =0; j<6; j++){
                if(isVisited[j]||arr[i]!=0) continue;   
                // 0이거나 해당 번호를 이미 맞았다고 계산한 경우가 아니면 -> 계산 후 방문 체크
                isVisited[j] = true;
                result++;
                break;
            }
        }
        return result;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/77484