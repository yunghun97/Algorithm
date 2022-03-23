package Programmers.Lv3;

import java.util.*;
public class 다단계칫솔판매 {
    static ArrayList<Integer>[] list;
    static int[] answer;
    static HashMap<String, Integer> hmap;
    /**
    판매에서 발생하는 이익에서 10%를 계산하여 자신의 조직에 참여시킨 추천인에게 분배 후 나머지는 자기가 가진다.
    즉 자신이 조직에 추천하여 가입시킨 판매원에게 발생하는 10%까지 자신의 이익이 됩니다 -> 이 또한 자신의 추천인에게 분배
    
    String[] enroll 판매원의 이름
    String[] referral 조직에 참여시킨 판매원의 이름
    String[] seller  판매량 집계 데이터의 판매원 이름
    int[] amount 판매 집계 데이터의 판매  수량
    */    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        list = new ArrayList[enroll.length];
        hmap = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            list[i] = new ArrayList<>();
        }
        int idx = 0 ;
        // hashmap에 이름별로 index 저장하기
        for(int i = 0; i < enroll.length; i++){
            hmap.put(enroll[i],idx);
            idx++;
            if("-".equals(referral[i])) continue;
            else{
                list[i].add(hmap.get(referral[i])); // 해당 사람에게 Boss 존재 시 추가해주기
            }
        }
        answer = new int[enroll.length];
        for(int i = 0; i < amount.length; i++){
            idx = hmap.get(seller[i]);  // 현재 사람의 index
            
            int money = amount[i] * 100;
            int dividedMoney = money / 10;
            answer[idx] += money - dividedMoney;
            if(list[idx].size()!=0){ // 상관이 있을 경우                                 
                addBoss(list[idx].get(0), dividedMoney); // list[idx].get(0) = boss의 index 번호
            }
        }
        return answer;
    }
    static void addBoss(int idx, int money){
        int tmpMoney = money / 10;
 
        if(tmpMoney == 0) answer[idx] += money; // 10%값이 1미만일 때 자기가 다 먹는다.
        else answer[idx] += money - tmpMoney; // 아니면 90%만 먹기

        if(list[idx].size()==0|| tmpMoney == 0) return; // 보스가 없거나 10%이 0미만이면 자기가 다 먹었으므로 return
        addBoss(list[idx].get(0), tmpMoney); // list[idx].get(0) = boss의 index 번호
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/77486#