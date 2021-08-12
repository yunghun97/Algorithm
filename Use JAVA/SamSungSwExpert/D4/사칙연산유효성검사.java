package SamSungSwExpert.D4;
import java.util.StringTokenizer;
import java.io.*;
public class 사칙연산유효성검사 {       
    public static void main(String[] args) throws FileNotFoundException, IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\사칙연산유효성검사.txt"));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                StringTokenizer st;
                for(int t=1; t<=10; t++){
                    int answer = 1;
                    int size = Integer.parseInt(br.readLine());
                    for(int i=0; i<size; i++){
                        st=new StringTokenizer(br.readLine()," ");
                        if(st.countTokens()==4){
                            st.nextToken();
                            if(Character.isDigit(st.nextToken().charAt(0))){    // 숫자면 유효하지 않음
                                answer=0;
                            }
                        }
                        else{
                            st.nextToken();
                            if(!Character.isDigit(st.nextToken().charAt(0))){   // 리프 노드는 무조건 2번째 값이 숫자여야 됨.
                                answer =0;
                            }
                        }
                    }
                    bw.write("#"+t+" "+answer+"\r\n");
                    bw.flush();
                }//테케 끝
                bw.close();
                br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD&categoryId=AV141176AIwCFAYD&categoryType=CODE&problemTitle=%EC%82%AC%EC%B9%99&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1