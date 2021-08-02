package BackJun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class 재귀함수가뭔가요B17478 {
    private static StringBuffer sb = new StringBuffer();
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		solve(0, "");
		System.out.println(sb);
	}
	private static void solve(int cnt, String underchar) {
		if (cnt == N) {
			sb.append(underchar + "\"재귀함수가 뭔가요?\"\n");
			sb.append(underchar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(underchar + "라고 답변하였지.\n");
			return;
		}
		sb.append(underchar + "\"재귀함수가 뭔가요?\"\n");
		sb.append(underchar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(underchar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(underchar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		// 결과를 본 후
		solve(cnt + 1, underchar + "____");
		
		sb.append(underchar + "라고 답변하였지.\n");
	}
}
