package Programmers.Lv2;

import java.util.*;
public class 파일명정렬 {
    public String[] solution(String[] files) {
        PriorityQueue<File> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1.head.compareTo(o2.head)!=0) return o1.head.compareTo(o2.head);            
            else if(o1.number!=o2.number) return Integer.compare(o1.number, o2.number);     
            else return Integer.compare(o1.idx, o2.idx);          
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < files.length; i++){
            String header = "";
            int number;
            char[] arr = files[i].toCharArray();
            int idx = checkHead(arr);
            
            for(int x = 0; x<idx; x++){
                sb.append(arr[x]);
            }
            header = sb.toString().toUpperCase();
            sb.setLength(0);
            
            int idx2 = checkNumber(idx, arr);
            for(int x = idx; x<idx2; x++){
                sb.append(arr[x]);
            }
            number = Integer.parseInt(sb.toString());
            sb.setLength(0);
            pq.offer(new File(header,number,i));
        }
        String[] answer = new String[pq.size()];
        
        int size = pq.size();
        for(int i =0; i < size; i++){
            File file = pq.poll();
            answer[i] = files[file.idx];
        }
        
        return answer;
    }
    private static class File{        
        String head;
        int number;
        int idx;
        public File(String head, int number, int idx){
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
    }
    private static int checkHead(char[] arr){
        int idx = 0;
        for(char a : arr){
            if(48<=(int) a&& (int) a <=57){ // 0~9사이일 때        
                return idx;
            }else{ // 문자일 때
                idx++;
            }
        }  
        return idx;
    }
    
    private static int checkNumber(int start, char[] arr){
        int idx = start;
        for(int x = start; x<arr.length; x++){
            if(48<=(int) arr[x] && (int) arr[x] <=57){ // 0~9사이일 때        
                idx++;
                if(idx==start+5) return idx; // 최대 5자일 때
            }else{ // 문자일 때
                return idx;
            }
        }  
        return idx;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/17686