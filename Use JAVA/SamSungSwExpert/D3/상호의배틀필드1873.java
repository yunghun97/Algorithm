package SamSungSwExpert.D3;
import java.util.StringTokenizer;
import java.io.*;

public class 상호의배틀필드1873 {
    static int r, c, moveLimit, locationR, locationC;
    static char[][] map;
    static char[] order;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\상호의배틀필드.txt"));
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()); // 행
            c = Integer.parseInt(st.nextToken()); // 열
            String temp;
            
            map = new char[r][];        // 맵 입력
            for (int i = 0; i < r; i++) {
                temp = br.readLine();
                map[i] = temp.toCharArray();
            }
            
            
            moveLimit = Integer.parseInt(br.readLine());    // 명령 갯수 저장
            order = br.readLine().toCharArray();    // 명령 한글자씩 배열에 저장
            
            find();
            readOrder();
            System.out.printf("#%d ", t);
            for (int x = 0; x < r; x++) {
                for (int y = 0; y < c; y++) {
                    System.out.print(map[x][y]);
                }
                System.out.println();
            }
        } // 테케 끝
    }

    private static void find() { // 현재 위치 찾기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                    locationR = i;  locationC = j;      // 현재위치를 저장해 놓는다.
                    return;
                }
            }
        }
    }

    private static void readOrder() {
        char nowOrder;
        for (int i = 0; i < moveLimit; i++) {
            nowOrder = order[i];
            moveRead(nowOrder);     //명령을 처음부터 읽어서 moveRead에 한 글자씩 전달
        }
        return;
    }

    private static void moveRead(char now) {        // 행동 읽어서 전달하는 부분.
        switch (now) {
            case 'U':
                move(-1,0,'^');     
                break;
            case 'D':
                move(1,0,'v');
                break;
            case 'L':
                move(0,-1,'<');
                break;
            case 'R':
                move(0,1,'>');
                break;
            case 'S':
                if (map[locationR][locationC] == '^') {
                shoot(-1,0);
                } else if (map[locationR][locationC] == 'v') {
                shoot(1,0);
                } else if (map[locationR][locationC] == '<') {
                shoot(0,-1);
                } else if (map[locationR][locationC] == '>') {
                shoot(0,1);
                }
                break;
        }
        return;
    }
    private static void move(int nr, int nc, char tankDirec){   // 탐색해서 .이면 이동 후 tankDirec, 아니면 그냥 tankDirec만 설정
        if (locationR+nr>=0&&locationR+nr<r&&locationC+nc>=0&&locationC+nc<c) {
            if (map[locationR+nr][locationC+nc] == '.') {
                map[locationR][locationC] = '.';
                locationR +=nr; locationC+=nc;
                map[locationR][locationC] = tankDirec;
            } else {
                map[locationR][locationC] = tankDirec;
            }
        } else {
            map[locationR][locationC] = tankDirec;
        }
    }
    private static void shoot(int nr, int nc) {     // 슈팅 부분입니다.
        int tempR = locationR;
        int tempC = locationC;
        while (true) {
            if (tempR+nr>=0&&tempR+nr<r&&tempC+nc>=0&&tempC+nc<c) {
                tempR+=nr; tempC +=nc;
                if (map[tempR][tempC] == '.' || map[tempR][tempC] == '-')   // . * 이면 계속
                    continue;
                else if (map[tempR][tempC] == '*') {    // 벽돌이면 부서서 초기화
                    map[tempR][tempC] = '.';
                    break;}
                else {break;}   // index밖이거나 철문이므로 빠져나온다.
            } 
            else{break;}
        }
        return;
    }
}
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV5LyE7KD2ADFAXc&solveclubId=AXqgPAMaIlADFATi&problemBoxTitle=0804-WS&problemBoxCnt=1&probBoxId=AXsPaj16YLMDFARX+
/*
입력
3
4 6
*.*..*
*.....
..-...
^.*#..
10
SRSSRRUSSR
2 2
<.
..
12
DDSRRSUUSLLS
3 5
>-#**
.-*#*
.-**#
15
SSSDRSSSDRSSSUU


출력
#1 *....*
......
..-...
..>#..
#2 <.
..
#3 ^-#**
.-.#*
.-..#
*/