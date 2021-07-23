package SSAFYWorkShop;
public class DigiTest2 {
    public static void main(String[] args) {
        final int N = 7;
        int emptyCount = 0, numCount = 0;
        for(int i=0; i<N; i++){
            // 공백 처리해서 찍는 부분
            if(emptyCount != 0){
                System.out.printf("%"+ emptyCount*3+"s"," ");
            }
            //숫자 출력
            for(int j=0; j< N-emptyCount*2;j++){
                System.out.printf("%3d",++numCount);
            }
            // 공백 카운트 증가와 감소
            if(i < N/2) emptyCount++;
            else emptyCount--;
            System.out.println();
        }
    }

}
