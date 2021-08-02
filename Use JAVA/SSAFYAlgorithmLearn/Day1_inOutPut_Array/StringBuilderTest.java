package SSAFYAlgorithmLearn.Day1_inOutPut_Array;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("SSAFY!!");

        sb.setLength(sb.length()-2); // 현재 sb 길이에서-2만큼
        System.out.println(sb.toString());
    }
    
}
