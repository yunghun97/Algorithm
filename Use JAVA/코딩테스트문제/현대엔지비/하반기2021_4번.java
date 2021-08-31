package 코딩테스트문제.현대엔지비;

import java.util.*;
import java.io.*;


public class 하반기2021_4번
{
    static LinkedList<LinkedList<Node>> list;
    static ArrayList<Node2> find;
    static int N;
    static int[] colors, resultColors,check, temp;
    static boolean[] isVisited,isFinded;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        for(int i=0; i<=N; i++){
            list.add(new LinkedList<>());
        }
        colors = new int[N+1];
        resultColors = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            colors[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to));
            list.get(to).add(new Node(from));
        }

        find = new ArrayList<>();
        isFinded = new boolean[N+1];
        for(int i=1; i<=N; i++){
            check = new int[N+1];
            isVisited = new boolean[N+1];
            for(int j=1; j<=i; j++){
                isVisited[j]=true;
            }
            for(int j=0; j<find.size(); j++){
                Node2 node2 = find.get(j);
                if(i==node2.set){
                    isVisited[node2.remove]=false;
                    isFinded[node2.remove]=true;
                    resultColors[node2.remove]--;
                    resultColors[node2.set]--;
                    find.remove(j);
                    j--;
                }
            }
            check[colors[i]] = 1;
            dfs(i,0);
        }
        for(int i=1; i<=N; i++){
            bw.write(""+resultColors[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int num, int index) {
        for(int x=1; x<=N; x++){
            if(check[x]!=0){
                resultColors[x]++;
            }
        }
        if(list.get(num).size()>=1){
            
            for(int i=0; i<list.get(num).size(); i++){
                int temp = list.get(num).get(i).connect;
                if(!isVisited[temp]){
                if(list.get(num).size()>=3){
                    if(!isFinded[num]){
                    for(int z=0; z<list.get(num).size(); z++){
                        int temp2 = list.get(num).get(z).connect;
                        if(isVisited[temp2]) continue;
                        find.add(new Node2(num,temp2));
                    }
                    }
                    isFinded[num]=true;
                }
                isVisited[temp] =true;
                check[colors[temp]] = 1; 
                dfs(temp,index+1);
                check[colors[temp]] = 0;
                }
            }
        }
    }
    
    static class Node{
        int connect;

        public Node(int connect) {
            this.connect = connect;
        }

        @Override
        public String toString() {
            return "Node [connect=" + connect + "]";
        }
        
    }
    static class Node2{
        int remove;
        int set;
        public Node2(int remove, int set) {
            this.remove = remove;
            this.set = set;
        }
    }
}


/*
정점 개수, 색깔, 그래프 좌표 -> 무향 좌표 -> 처음 나오는 그래프 집합만 가능 -> 색깔이 등장하는 총 개수
5
1 2 3 4 5
1 2
2 3
3 4
3 5

5
8
10
5
5

*/