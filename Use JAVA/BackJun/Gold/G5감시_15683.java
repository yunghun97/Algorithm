package BackJun.Gold;
import java.io.*;
import java.util.*;

public class G5감시_15683 {
    static int[][] map, mapTemp;
    static ArrayList<CctvLocation> cctvMap;
    static int cctvCount,R,C,blindSpot,answer, blindSpotTemp;
    static boolean[][] isSelected, isSelectedTemp;
    static int[] dirArr;
    static boolean min;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5감시_15683.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mapTemp= new int[R][C]; map = new int[R][C];
        cctvCount = 0; cctvMap = new ArrayList<>(); blindSpot = R*C;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<C; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp!=0){ 
                    blindSpot--;
                    if(temp!=6){
                    cctvMap.add(cctvCount++, new CctvLocation(i,j,temp));
                    }
                }
            mapTemp[i][j]=temp;
            }
        }
        blindSpotTemp = blindSpot;
        answer = Integer.MAX_VALUE;
        dirArr = new int[cctvCount];
        min = false;
        combi(0);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();

    }
    static void combi(int cnt){
        if(min) return;
        if(cnt==cctvCount){
            for(int i=0; i<R; i++){
                System.arraycopy(mapTemp[i], 0, map[i], 0, C);
            }
            for(int x=0; x<cctvCount; x++){
                check(x, dirArr[x],cctvMap.get(x).kind);
            }
            answer = Math.min(answer, blindSpot);
            if(blindSpot==0) min=true;
            blindSpot = blindSpotTemp;
            return;
        }

        for(int i=0; i<4; i++){
            dirArr[cnt] = i;
            combi(cnt+1);
        }
    }

   
    private static void check(int num, int dir, int kind) { // num cctv번호, dir 방향, kind cctv종류
        if(kind==1){
            if(dir==0){
                move(num,0);
            }else if(dir==1){
                move(num,1);
            }else if(dir==2){
                move(num,2);
            }else if(dir==3){
                move(num,3);
            }
        }else if(kind==2){
            if(dir==2||dir==0){
                move(num,0);
                move(num,2);
            }else{
                move(num,1);
                move(num,3);
            }
        }else if(kind==3){
            if(dir==0){
                move(num,3);
                move(num,0);
            }else if(dir==1){
                move(num,0);
                move(num,1);
            }else if(dir==2){
                move(num,1);
                move(num,2);
            }else{
                move(num,2);
                move(num,3);
            }
        }else if(kind==4){
            if(dir==0){
                move(num,2);
                move(num,3);
                move(num,0);
            }else if(dir==1){
                move(num,3);
                move(num,0);
                move(num,1);
            }else if(dir==2){
                move(num,0);
                move(num,1);
                move(num,2);
            }else{
                move(num,1);
                move(num,2);
                move(num,3);
            }
        }else{
            move(num,0);
            move(num,1);
            move(num,2);
            move(num,3);
        }
    
    }
    static void move(int num, int dir){     // 0 :오른쪽 1: 아래 2: 왼쪽 3: 위쪽
        int r = cctvMap.get(num).r;
        int c = cctvMap.get(num).c;
        if(dir==0){
            while(c<C){
            c +=1;
            if(c>=C) break;
            if(map[r][c]==6) break;
            if(map[r][c]==0){blindSpot--; map[r][c]=-1;}
        }
        }else if(dir==1){
            while(r<R){
                r +=1;
                if(r>=R) break;
                if(map[r][c]==6) break;
                if(map[r][c]==0){blindSpot--; map[r][c]=-1;}
        }
        }else if(dir==2){
            while(c>=0){
                c -=1;
                if(c<0) break;
                if(map[r][c]==6) break;
                if(map[r][c]==0){blindSpot--; map[r][c]=-1;}
        }
        }else{
            while(r<R){
                r -=1;
                if(r<0) break;
                if(map[r][c]==6) break;
                if(map[r][c]==0){blindSpot--; map[r][c]=-1;}
        }
        }
        return;
    }


    static class CctvLocation{
        int r;
        int c;
        int kind; 
        public CctvLocation(int r, int c, int kind){
            this.r = r;
            this.c = c;
            this.kind = kind;
        }
    }
}
