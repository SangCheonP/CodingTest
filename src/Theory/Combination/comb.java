package Theory.Combination;

import java.util.Arrays;

public class comb {
	static int N = 5, R = 3;
	static String[] cards = { "A", "B", "C", "D", "E" };
	static String[] result = new String[R];
	static boolean[] select = new boolean[N];

	public static void main(String[] args) {
		comb(0, 0);
		// comb2(0,0);
		// comb3(0,0);
	}

	// 조합
	public static void comb(int len, int idx) {
		if (len == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = idx; i < N; i++) {
			result[len] = cards[i];
			// 내 다음 것부터 시작
			comb(len + 1, i + 1);
		}

	}

	// 조합
	public static void comb2(int idx, int cnt) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(select));
			return;
		}
		if (idx == cards.length)
			return;

		// 카드를 선택
		select[idx] = true;
		comb2(idx + 1, cnt + 1);
		// 카드 선택X
		select[idx] = false;
		comb2(idx + 1, cnt);

	}

	// 중복 조합
	public static void comb3(int len, int idx) {
		if (len == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = idx; i < N; i++) {
			result[len] = cards[i];
			// 내 숫자부터 시작
			comb3(len + 1, i);
		}
	}
}