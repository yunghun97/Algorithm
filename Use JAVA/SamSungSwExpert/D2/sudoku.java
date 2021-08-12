package SamSungSwExpert.D2;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sudoku {
    static int[][] map;
    static boolean[] check;
    static int[] dx =  {-1,-1,-1,0,0,0,1,1,1};  // 본인좌표까지 9번 탐색
    static int[] dy =  {-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D2\\스도쿠.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T= Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            int answer =1;
            check = new boolean[10];    // 숫자가 겹치는지 확인할 배열
            map = new int[9][9];
            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<9; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());   // 스토쿠 맵 설정
                }
            }
            outer1: for(int i=0; i<9; i++){
                Arrays.fill(check, false);
                for(int j=0; j<9; j++){
                    if(!check[map[i][j]]){      // -> 방향으로 탐색 후 check 배열이 false면 처음 등장하므로 true 넣고 true가 또 나오면 answer=0으로 하고 반복문 바로 끝낸다.
                        check[map[i][j]] = true;
                    }
                    else{
                        answer =0;
                        break outer1;
                    }
                }
                Arrays.fill(check, false);      // 한 번 사용하면 false로 모두 초기화
                for(int j=0; j<9; j++){
                    if(!check[map[j][i]]){     // 아래 방향으로 탐색 후 check 배열이 false면 처음 등장하므로 true 넣고 true가 또 나오면 answer=0으로 하고 반복문 바로 끝낸다.
                        check[map[j][i]] = true;
                    }
                    else{
                        answer=0;
                        break outer1;
                    }
                }
            }
            if(answer!=0){       // answer =0이면 이미 옳지않은 스도쿠이므로 실행하지 않는다.
            outer2 : for(int i=1; i<8; i+=3){   // 좌표는 1,4,7 부분에서 9번 탐색
                for(int j=1; j<8; j+=3){
                    Arrays.fill(check, false);  // 사용했으므로 다시 초기화 시켜준다.
                    for(int d=0; d<9; d++){
                                                // 기본 본인 좌표 할당
                        
                        int nr = i+dx[d];       // 좌표 설정
                        int nc = j+dy[d];
                        if(check[map[nr][nc]]){ // 확인 겹치면 바로 끝낸다.
                            answer =0;
                            break outer2;
                        }
                        else{
                            check[map[nr][nc]]=true;  // 첨 나오면 true로
                        }
                    }
                }
            }
        }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }//테케 끝
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq&categoryId=AV5Psz16AYEDFAUq&categoryType=CODE&problemTitle=%EC%8A%A4%EB%8F%84%EC%BF%A0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
/*
    for(int r=0; r<9; r++){
        for(int c=0; c<9; c++){
            data[r/3*3 + c/3][r%3*3 + c%3]  -> 9칸 구하는 공식
        }
    }

*/
