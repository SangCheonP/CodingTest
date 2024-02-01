package Theory.Permutation;

import java.util.Arrays;

public class perm {
	static int N = 5, R = 3;
	static String[] cards = {"A", "B", "C", "D", "E"};
	static boolean[] used = new boolean[N];
	static String[] result = new String[R];
	
	public static void main(String[] args) {
		perm(0);
		perm2(0);
	}
	
	static void perm2(int idx) { // 비중복 순열
		if(idx == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i < N; i++) { // A 카드부터 검사
			if(used[i] == false) { // 해당 카드가 사용X
				used[i] = true; // 사용한다 표시
				result[idx] = cards[i]; // 선택한 카드 내 위치에 놓기
				perm2(idx + 1); // 다음 위치 부르러 감
				used[i] = false; // 사용한 카드 원래대로 돌려놓기
			}
		}
	}
	
	static void perm(int idx) { // 중복 순열
		if(R == idx) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[idx] = cards[i]; // 내 위치에 카드 놓기
			perm(idx + 1); // 다음 위치 부르기
		}
	}

}