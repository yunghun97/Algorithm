package BackJun.Gold;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class G4단어수학_1339 {
    static int[] alphabet;
    static HashMap<Character,Integer> hmap;
    static PriorityQueue<String> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));        
        alphabet = new int[27];        
        int N = Integer.parseInt(br.readLine());
        hmap = new HashMap<>();        
        
        Queue<String> wordList = new LinkedList<>();
        for(int i=0; i<N; i++){
            String a = br.readLine();
            wordList.add(a);
            int len = a.length();
            for(int x=0; x<a.length(); x++){
                char input = a.charAt(x);
                int number = (int) Math.pow(10, len-x-1); // 1의 자리 10번 = 10의 자리 1번이므로 10의 제곱을 통해 정합니다.
                if(hmap.containsKey(input)){
                    hmap.put(input, hmap.get(input)+number);
                }else{
                    hmap.put(input, number);
                }
            }
        }
        int maxNum = 9;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.level, o1.level)); // 제일 큰 알파벳 순
        for(Entry<Character,Integer> entry : hmap.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue())); 
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            alphabet[node.word-'A'] = maxNum--;  // 나온 알파벳 순으로 최대 숫자 할당
        }
        int answer = 0;
        while(!wordList.isEmpty()){
            String word = wordList.poll();
            int len = word.length();
            for(int i=0; i<len; i++){
                answer += alphabet[word.charAt(i)-'A'] * (int) Math.pow(10,len-i-1); // 1의 자리수 = *1 10의자리수 = *10 100의 자리수 *100해서 answer 더 해주기
            }
        }
        bw.write(""+answer);
        bw.flush();
    }
    static class Node{
        char word;
        int level;
        public Node(char word, int level){
            this.word = word;
            this.level = level;
        }
    }
}
// https://www.acmicpc.net/problem/1339