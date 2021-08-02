package SamSungSwExpert.D3;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
//import java.util.Arrays;
public class WonJaeMemoryRestore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String result = br.readLine();
            int[] arr1 = new int[result.length()];	// 고쳐야 되는 값
            int[] arr2 = new int[result.length()];	// 메모리 초기값
            //Arrays.fill(arr2,0);
            int count =0;
            for(int a=0; a<result.length(); a++){	// 배열에 저장
            	arr1[a] = result.charAt(a)-'0';
            }
            for(int i=0; i<result.length(); i++){		// 배열에 길이 만큼 for문 돌리겠다
            	if(arr2[i]!=arr1[i]&&arr1[i]==1){		// 1이면 뒤에 값 다 1로
                	count++; arr2[i]=arr1[i];
                    for(int j=i+1; j<result.length(); j++){	// 마지막 값까지 설정 마지막 자리는 어짜피 위에서 돌고 count++하고 끝남
                    	arr2[j] = 1;
                    }
                }
                else if(arr2[i]!=arr1[i]&&arr1[i]==0){		// 마지막 값까지 설정 0 이면 ㅇ으로
                	count++; arr2[i]=arr1[i];
                    for(int j=i+1; j<result.length(); j++){
                    	arr2[j] = 0;
                    }
                }
                else continue;			// 둘 다 일치하는 경우로 count하지 않고 다음 자리로 넘어간다.
            }
        	System.out.printf("#%d %d\n",t,count);
        }
    }
}

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=%EC%9B%90%EC%9E%AC%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

/*
입력
2
0011
100

출력
#1 1
#2 2

*/

//or
/*
char[] arr = br.readLine().toCharArray();
char prev = '0';
for(char c : arr){
    if(c != prev){
        ans+=;
        prev = c;
    }
}

*/