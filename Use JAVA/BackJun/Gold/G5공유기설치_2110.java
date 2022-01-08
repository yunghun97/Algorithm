package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5공유기설치_2110 {
    static int[] house;
    static int N,C; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        house = new int[N];

        for(int i = 0; i< N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house); // 이분탐색을 위한 초기 정렬

        int mindis = 1;
        int maxdis = house[N-1] - house[0]+1; // 최대값

        while(mindis<maxdis){ // Upper Bound 
            int mid = (mindis+maxdis) / 2;
            if(checkInstall(mid)< C){ // UpperBound; LowerBound -> (<=C)
                maxdis = mid; // 해당 거리로 공유기를 C개이상 놓을 수 없으므로 거리를 줄여준다.
            }else{ // 설치가 C개 이상 가능하므로 거리를 늘린다.
                mindis = mid+1;
            }
        }
        bw.write(String.valueOf(mindis-1)); // 값을 초과하는 첫 번쨰 값을 가리키므로 -1
        bw.flush();
    }
    private static int checkInstall(int dis) {
        int count = 1;
        int lastLocate = house[0];  // 처음으로 설치하는 집 숫자
        for(int i = 1; i < house.length; i++) {
			int locate = house[i];
			
            /* 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간거리가 최소 거리보다 크거나 같을 때
            *  설치 개수 추가 및 설치 위치 갱신
			*  마지막 설치 위치를 갱신해준다. 
			*/
			if(locate - lastLocate >= dis) {
				count++;
				lastLocate = locate;
			}
            if(count>=C) return count;
		}
		return count;
    }
}
//https://www.acmicpc.net/problem/2110