package 사전테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3디저트페스티벌 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		// 한 번에 한 명씩 응대 가능.
		// 언제 장인의 부스를 방문할지(a), 얼마만큼의 시간을 소요할지(t), 번호표(id)
		// 2명 이상 대기중이라면 id가 낮은 순서로 시식.
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
		}
		
	}
}