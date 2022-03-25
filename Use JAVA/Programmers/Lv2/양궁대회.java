package Programmers.Lv2;

public class 양궁대회 {
    static int N, score;
    static int[] arr,input, answer;
    private static int[] solution(int n, int[] info) {
        N = n;
        input = info;
        arr = new int[11];
        answer = new int[11];        
        score = 0;
        
        dfs(0,N,arr,0,0);
        if(score==0) answer = new int[]{-1};
        return answer;
    }
    static void dfs(int cnt, int remain, int[] map, int mySum, int apacheSum){
        if(cnt==10){
            if(mySum-apacheSum>=score){ // 점수차가 같거나 큰 경우
                map[10] = remain;   // 마지막 0점은 남은 화살 모두 쏜다고 가정합니다.
                if(score<mySum-apacheSum){ // 더 큰 경우 무조건 갱신
                    score = mySum-apacheSum;                    
                    answer = map;   
                }else{ // 같으면 뒤에서 부터 비교해서 갱신
                    if(maxCheck(map, answer)){ // map이 낮은거 더 많이 맞춰서 갱신해야 되는경우
                        score = mySum-apacheSum;                    
                        answer = map;  
                    }
                }             
            }
            return;
        }
        int[] tmpMap = new int[11];
        arrayCopy(map,tmpMap);
        
        if(input[cnt]<remain){ // 이길 수 있는 경우
            int tmpSum = mySum+10-cnt;
            tmpMap[cnt] = input[cnt]+1;
            int tmpRemain = remain - input[cnt]-1;
            dfs(cnt+1,tmpRemain,tmpMap, tmpSum, apacheSum);
        }        
        if(input[cnt]!=0){  // 아파치가 과녁을 맞춘거를 반영해야 하는 경우
            int tmpApacheSum = apacheSum + 10-cnt;  // 아파치 점수 추가
            dfs(cnt+1, remain, map, mySum, tmpApacheSum);
        }else{  // 둘 다 0 점인 경우
            dfs(cnt+1, remain, map, mySum, apacheSum);  // 둘 다 0점인 경우
        }        
    }
    static void arrayCopy(int[] map, int[] tmpMap){
        System.arraycopy(map,0,tmpMap,0,10);
    }
    static boolean maxCheck(int[] tmpMap, int[] answerMap){ // 뒤에서 부터 비교
        for(int i = 10; i>=0; i--){
            if(tmpMap[i]>answerMap[i]) return true; // true면 새로운 값으로 바꾸어야 한다.
            else if(tmpMap[i]<answerMap[i]) return false;
        }
        return false;
    }
}
