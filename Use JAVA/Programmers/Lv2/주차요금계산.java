package Programmers.Lv2;

import java.util.*;
public class 주차요금계산 {
    static HashMap<Integer, Integer> hmap;
    static HashMap<Integer, Integer> resultMap;
    static PriorityQueue<Fee> pq;

    private static int[] solution(int[] fees, String[] records) {
        hmap = new HashMap<>();
        resultMap = new HashMap<>();
        StringTokenizer st;
        
        for(int i = 0; i < records.length; i++){
            
            st = new StringTokenizer(records[i], " ");
            String[] arr = st.nextToken().split(":");
            int time = Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
            int carNum = Integer.parseInt(st.nextToken());
            st.nextToken(); // 마지막 IN OUT 값
            
            addRecord(carNum, time);               
        }
        remainCheck();
        
        pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.carNum,o2.carNum));
        addPq(fees);
        int[] answer = new int[resultMap.size()];
        setAnswer(answer);
        return answer;
    }
    /**
     * 주차요금 구해서 resultMap에 결과 저장하기
     * @param carNum 차량 번호
     * @param time 시간 -> 시 * 60 + 분으로 계산한 값
     */
    static void addRecord(int carNum, int time){
        if(hmap.containsKey(carNum)){ // 해당 key가 있을 경우 -> OUT을 의미                
            int result = time-hmap.get(carNum); // 나간 시간 - 들어온 시간 = 주차장을 이용한 시간
            hmap.remove(carNum);
            if(resultMap.containsKey(carNum)){ // 결과 resultMap에 있을 경우 합쳐서 저장
                resultMap.put(carNum, result+resultMap.get(carNum));                    
            }else{ // 처음이므로 그냥 저장
                resultMap.put(carNum, result);
            }
        }else{  // IN일 경우
            hmap.put(carNum, time);
        }
    }
    // hmap에 IN만 되어서 OUT하지 않은 차량들 구하기
    static void remainCheck(){
        int max = 23*60 + 59;
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(resultMap.containsKey(key)){ // resultMap에 존재하는 경우 -> +
                resultMap.put(key, resultMap.get(key)+max-value);
            }else{ // 없는 경우 이므로 max - value해서 넣어주기
                resultMap.put(key, max-value);
            }
        }
    }
    /**
     * pq에 요금계산후 저장하기 -> 차량번호 오름차순
     * @param fees 요금표 0 기본시간 1 기본 요금 2 초과 단위시간 3 단위 요금
     */
    static void addPq(int[] fees){ 
        for(Map.Entry<Integer, Integer> entry : resultMap.entrySet()){
            int carNum = entry.getKey();
            int time = entry.getValue();
            
            int money = 0;
            
            if(time>fees[0]){ // 기본시간 보다 많은 경우 -> 단위 시간 부과
                time-= fees[0];
                money += fees[1];
                money += time/fees[2] * fees[3];
                if(time%fees[2]!=0) money+=fees[3];
            }else{ // 기본시간 보다 같거나 적은 경우 -> 기본 요금만
                money = fees[1];
            }
            pq.add(new Fee(carNum, money));
        }
    }
    /**
     * pq에 있는 원소 1개씩 뽑아서 answer 정답 배열에 저장하기
     * @param answer 정답 배열
     */
    static void setAnswer(int[] answer){
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll().money;
        }
    }
    static class Fee{
        int carNum;
        int money;
        public Fee(int carNum, int money){
            this.carNum = carNum;
            this.money = money;
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/92341