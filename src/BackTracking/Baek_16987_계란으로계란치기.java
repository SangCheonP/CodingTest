package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계란 -> 내구도, 무게
 * 내구도는 상대 계란의 무게만큼 깍임
 * 내구도가 0이하가 되면 계란이 깨짐
 */
public class Baek_16987_계란으로계란치기 {
    static class Egg {
        int durability, weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static int N, result;
    static Egg[] eggs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 계란 객체 초기화
            eggs[i] = new Egg(d, w);
        }

        result = 0;

        // 첫 번째 계란부터 백트래킹 시작
        dfs(0);

        // 최종 결과 출력
        System.out.println(result);
    }

    static void dfs(int idx) {
        // 종료 조건: 마지막 계란을 넘어섰을 때
        if (idx == N) {
            updateMaxBrokenEggs();
            return;
        }

        // 현재 계란이 깨져 있다면, 다음 계란으로 넘어감
        if (eggs[idx].durability <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean hit = false;

        // 다른 계란들 중 깨지지 않은 계란을 찾음
        for (int i = 0; i < N; i++) {
            if (i == idx || eggs[i].durability <= 0) continue;

            // 계란 내구도 조정
            eggs[idx].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[idx].weight;

            // 다음 단계로 진행
            dfs(idx + 1);

            // 백트래킹: 계란 내구도 원상 복구
            eggs[idx].durability += eggs[i].weight;
            eggs[i].durability += eggs[idx].weight;

            hit = true;
        }

        // 칠 수 있는 계란이 없을 경우, 다음 계란으로 넘어감
        if (!hit) {
            dfs(idx + 1);
        }
    }

    static void updateMaxBrokenEggs() {
        int tmp = 0;

        for (Egg e : eggs) {
            if (e.durability <= 0) tmp++;
        }

        result = Math.max(result, tmp);
    }
}
