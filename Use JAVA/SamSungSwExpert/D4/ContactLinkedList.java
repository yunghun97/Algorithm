package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;
public class ContactLinkedList  {
    static int N,start,answer;
    static LinkedList<LinkedList<Node>> list;   // 인접 리스트
    static boolean[] isSelected;    // 중복 체크
    static Queue<Integer> q;    
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\contact.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t=1; t<=10; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            isSelected = new boolean[101];  
            list = new LinkedList<LinkedList<Node>>();
            st = new StringTokenizer(br.readLine());
            q = new LinkedList<>();
            answer = 0;
            for(int i=0; i<=100; i++){
                list.add(new LinkedList<Node>());   // 원소가 총 100개 이므로 0~100까지
            }
            for(int i=0; i<N/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(new Node(from, to)); // 원소 from에 출발점 from과 도착지 to를 집어넣는다. -> 0번지 부터~
            }
            cal();
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    private static void cal() {
        q.add(start);
        isSelected[start] = true; // 시작지점
        while(!q.isEmpty()){    // q 반복문
            int size = q.size(); answer= 0; // q.size 만큼 반복해줘서 더 이상 추가 안되면 마지막으로 q.size() 만큼 돌아간 것이 마지막 연락 주소이다.
            for(int i=0; i<size; i++){  // q.size만큼
                int temp = q.poll();    // q원소 
                if(list.get(temp).size()>=1){   // 인접리스트의 출발점의 원소가 1개 이상일 때
                    for(int j=0; j<list.get(temp).size(); j++){ // 원소의 개수만큼 돈다.
                        int to = list.get(temp).get(j).link; //도착지 to 구하기
                        if(!isSelected[to]){    // 도착지 to가 false이면 -> 처음일 때
                            isSelected[to] = true;  //true로 변경
                            q.add(to);  // q에 값 추가
                        }
                    }    
                }
                answer = Math.max(temp, answer);    // 최대 값 찾기
            }
        }
    }
    static class Node{
        int index;
        int link;
        public Node(int index, int link){
            this.index = index;
            this.link = link;
        }
        @Override
        public String toString() {
            return "Node [index=" + index + ", link=" + link + "]";
        }
        
    }
}
