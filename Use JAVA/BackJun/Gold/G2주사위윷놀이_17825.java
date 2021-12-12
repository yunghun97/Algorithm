package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2주사위윷놀이_17825 {
    static int[] lane1, lane2, lane3, lane4, arr;
    static boolean[] isVisited1, isVisited2, isVisited3, isVisited4;
    static int answer;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        lane1 = new int[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };
        isVisited1 = new boolean[21];

        lane2 = new int[] { 0, 13, 16, 19 }; // 10 -> 25전 가는 줄
        isVisited2 = new boolean[4];

        lane3 = new int[] { 0, 28, 27, 26 }; // 30 -> 25 가는 줄
        isVisited3 = new boolean[4];

        lane4 = new int[] { 0, 22, 24, 25, 30, 35, 40 }; // 20 -> 40 가는 줄
        isVisited4 = new boolean[7];

        answer = 0;
        arr = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new Node(false, 1, 0));
        }

        // 계산 DFS
        for (int i = 0; i < 4; i++) {
            move(0, 0, isVisited1, isVisited2, isVisited3, isVisited4);
        }
        bw.write(""+answer);
        bw.flush();
    }

    private static void move(int cnt, int result, boolean[] visited1, boolean[] visited2, boolean[] visited3,
            boolean[] visited4) {
        if (result + ((10 - cnt) * 40) < answer)
            return; // 백 트래킹
        if (cnt == 10) {
            if (result < answer)
                return;
            else {
                answer = result;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            Node node = list.get(d);
            if (node.isFinished)
                continue; // 이미 이동이 끝난 말이면 다음 말 선택

            int tmpResult = result;
            boolean[] tmpVisit1 = new boolean[21];
            boolean[] tmpVisit2 = new boolean[4];
            boolean[] tmpVisit3 = new boolean[4];
            boolean[] tmpVisit4 = new boolean[7];
            VisitCopy(tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4, visited1, visited2, visited3, visited4);

            if (node.laneNumber == 1) { // 1 번 레인에 있을 때
                int moveCount = node.moveCount + arr[cnt];
                int tmpNodeMoveCount = node.moveCount;
                if (node.moveCount == 5) {
                    if (arr[cnt] >= 4) { // 바로 4번레인으로 이동
                        if(tmpVisit4[3 + arr[cnt] - 4]) continue;
                        tmpVisit1[5] = false;
                        tmpVisit4[3 + arr[cnt] - 4] = true;
                        tmpResult += lane4[3 + arr[cnt] - 4];
                        node.moveCount = 3 + arr[cnt] - 4;
                        node.laneNumber = 4;
                        
                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);
                        
                        node.moveCount = tmpNodeMoveCount;
                        node.laneNumber = 1;
                    } else {    // 2번레인위에 있는 경우
                        if(tmpVisit2[arr[cnt]]) continue;
                        tmpVisit1[5] = false;
                        tmpVisit2[arr[cnt]] = true;
                        tmpResult += lane2[arr[cnt]];
                        node.moveCount = arr[cnt];
                        node.laneNumber = 2;

                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);
                        
                        node.laneNumber = 1;
                        node.moveCount = tmpNodeMoveCount;
                    }
                } else if (node.moveCount == 10) {
                    if(tmpVisit4[arr[cnt]]) continue;
                    tmpVisit1[tmpNodeMoveCount] = false;
                    tmpVisit4[arr[cnt]] = true;
                    tmpResult += lane4[arr[cnt]];
                    node.moveCount = arr[cnt];
                    node.laneNumber = 4;
                    
                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);
                    
                    node.laneNumber = 1;
                    node.moveCount = tmpNodeMoveCount;
                } else if (node.moveCount == 15) {
                    if(arr[cnt]>=4){   // 바로 4번 레인으로 가는 경우
                        if(tmpVisit4[arr[cnt]+3-4]) continue;
                        tmpVisit1[tmpNodeMoveCount] = false;
                        tmpVisit4[arr[cnt]+3-4] = true;
                        tmpResult+= lane4[arr[cnt]+3-4];
                        node.laneNumber = 4;
                        node.moveCount = arr[cnt]+3-4;
                        
                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);

                        node.laneNumber = 1;
                        node.moveCount = tmpNodeMoveCount;
                    }else{  // 3번레인에 있는 경우
                        if(tmpVisit3[arr[cnt]]) continue;
                        tmpVisit3[arr[cnt]] = true;
                        visited1[tmpNodeMoveCount] = false;
                        tmpResult += lane3[arr[cnt]];
                        node.laneNumber = 3;
                        node.moveCount = arr[cnt];

                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);

                        node.laneNumber = 1;
                        node.moveCount = tmpNodeMoveCount;
                    }
                } else {    // 계속 1번레인에 있는 경우
                    if (moveCount >= 21) {
                        node.isFinished = true;
                        tmpVisit1[tmpNodeMoveCount] = false;
                        node.moveCount = moveCount;
                        
                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);
                        
                        node.isFinished = false;
                        node.moveCount = tmpNodeMoveCount;
                    } else if (moveCount == 20) {
                        if (tmpVisit1[20] || tmpVisit4[6])
                            continue;
                        tmpVisit1[20] = true;
                        tmpVisit4[6] = true;
                        tmpVisit1[tmpNodeMoveCount] = false;
                        tmpResult += 40;
                        node.moveCount = moveCount;
                        
                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);
                        
                        node.moveCount = tmpNodeMoveCount;
                    } else {
                        if (tmpVisit1[moveCount])  continue;

                        tmpVisit1[moveCount] = true;
                        tmpVisit1[tmpNodeMoveCount] = false;
                        tmpResult += lane1[moveCount];
                        node.moveCount = moveCount;

                        move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);
                        
                        node.moveCount = tmpNodeMoveCount;
                        
                    }
                }

            }  // 1번 레인에서 시작 할 때
            else if (node.laneNumber == 2) {    // 2번 레인에서 시작
                int moveCount = node.moveCount + arr[cnt];
                int tmpNodeMoveCount = node.moveCount;
                if(moveCount>=8){   // 도착지점
                    node.isFinished = true;
                    tmpVisit2[tmpNodeMoveCount] = false;
                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);

                    node.isFinished = false;                    

                }
                else if(moveCount==7){  // 40점
                    if(tmpVisit4[6]||tmpVisit1[20]) continue;
                    tmpVisit4[6] = true;
                    tmpVisit1[20] = true;
                    tmpVisit2[tmpNodeMoveCount] = false;
                    tmpResult+=40;
                    node.laneNumber = 4;
                    node.moveCount = 6;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);

                    node.laneNumber = 2;
                    node.moveCount = tmpNodeMoveCount;
                }
                else if(moveCount>=4){  // 4번 레인으로 가는 경우
                    if(tmpVisit4[3 + moveCount- 4]) continue;
                    tmpVisit2[tmpNodeMoveCount] = false;                                 
                    tmpVisit4[3 + moveCount- 4] = true;
                    tmpResult += lane4[3+moveCount-4];
                    node.moveCount = 3+moveCount-4;
                    node.laneNumber = 4;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    

                    node.moveCount = tmpNodeMoveCount;
                    node.laneNumber = 2;
                }else{  // 2번레인에 그대로 있는 경우
                    if(tmpVisit2[moveCount]) continue;
                    tmpVisit2[tmpNodeMoveCount] = false;
                    tmpVisit2[moveCount] = true;
                    tmpResult += lane2[moveCount];
                    node.moveCount = moveCount;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    

                    node.moveCount = tmpNodeMoveCount;
                }
            } else if (node.laneNumber == 3) {  // 3번 레인
                int moveCount = node.moveCount + arr[cnt];
                int tmpNodeMoveCount = node.moveCount;
                if(moveCount>=8){   // 도착지점
                    node.isFinished = true;
                    tmpVisit3[tmpNodeMoveCount] = false;
                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);

                    node.isFinished = false;                    

                }
                else if(moveCount==7){  // 40점
                    if(tmpVisit4[6]||tmpVisit1[20]) continue;
                    tmpVisit4[6] = true;
                    tmpVisit1[20] = true;
                    tmpVisit3[tmpNodeMoveCount] = false;
                    tmpResult+=40;
                    node.laneNumber = 4;
                    node.moveCount = 6;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);

                    node.laneNumber = 3;
                    node.moveCount = tmpNodeMoveCount;
                }
                else if(moveCount>=4){  // 4번 레인으로 가는 경우
                    if(tmpVisit4[3 + moveCount- 4]) continue;
                    tmpVisit3[tmpNodeMoveCount] = false;                                 
                    tmpVisit4[3 + moveCount- 4] = true;
                    tmpResult += lane4[3+moveCount-4];
                    node.moveCount = 3+moveCount-4;
                    node.laneNumber = 4;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    

                    node.moveCount = tmpNodeMoveCount;
                    node.laneNumber = 3;
                }else{  // 3번 레인에 그대로 있는 경우
                    if(tmpVisit3[moveCount]) continue;
                    tmpVisit3[tmpNodeMoveCount] = false;
                    tmpVisit3[moveCount] = true;
                    tmpResult += lane3[moveCount];
                    node.moveCount = moveCount;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    

                    node.moveCount = tmpNodeMoveCount;
                }
            } else {    // 4번 레인
                int moveCount = node.moveCount + arr[cnt];
                int tmpNodeMoveCount = node.moveCount;
                if(moveCount>=7){   // 도착 지점
                    node.isFinished = true;
                    tmpVisit4[tmpNodeMoveCount] = false;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    
                    node.isFinished = false;
                    tmpVisit4[tmpNodeMoveCount] = true;

                }else if(moveCount==6){ // 40점 칸
                    if(tmpVisit4[6]||tmpVisit1[20]) continue;
                    tmpVisit1[20] = true;
                    tmpVisit4[6] = true;
                    tmpVisit4[tmpNodeMoveCount] = false;
                    tmpResult +=40;
                    node.moveCount = 6;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    

                    node.moveCount = tmpNodeMoveCount;
                }else{  // 4번 레인에 계속 있는 경우
                    if(tmpVisit4[moveCount]) continue;
                    tmpVisit4[moveCount] = true;
                    tmpVisit4[tmpNodeMoveCount] = false;
                    tmpResult +=lane4[moveCount];
                    node.moveCount = moveCount;

                    move(cnt + 1, tmpResult, tmpVisit1, tmpVisit2, tmpVisit3, tmpVisit4);                    

                    node.moveCount = tmpNodeMoveCount;
                }
            }

        } // item for문 끝
    }

    private static void VisitCopy(boolean[] tmpVisit1, boolean[] tmpVisit2, boolean[] tmpVisit3, boolean[] tmpVisit4,
            boolean[] visited1, boolean[] visited2, boolean[] visited3, boolean[] visited4) {
        for (int i = 0; i < visited1.length; i++) {
            if (visited1[i])
                tmpVisit1[i] = true;
        }
        for (int i = 0; i < visited2.length; i++) {
            if (visited2[i])
                tmpVisit2[i] = true;
        }
        for (int i = 0; i < visited3.length; i++) {
            if (visited3[i])
                tmpVisit3[i] = true;
        }
        for (int i = 0; i < visited4.length; i++) {
            if (visited4[i])
                tmpVisit4[i] = true;
        }

    }

    static class Node {
        boolean isFinished;
        int laneNumber;
        int moveCount;

        public Node(boolean isFinished, int laneNumber, int moveCount) {
            this.isFinished = isFinished;
            this.laneNumber = laneNumber;
            this.moveCount = moveCount;
        }
    }
}
// https://www.acmicpc.net/problem/17825