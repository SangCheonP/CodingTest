package Set;

import java.util.*;
import java.io.*;

public class Baek_1043_거짓말 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int tCnt = Integer.parseInt(st.nextToken());
        if (tCnt == 0) {
            System.out.println(M);
            return;
        }

        boolean[] chk = new boolean[N + 1];
        for (int i = 0; i < tCnt; i++) {
            int p = Integer.parseInt(st.nextToken());
            chk[p] = true;
        }

        List<Set<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            partyList.add(new HashSet<>());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                partyList.get(i).add(p);
            }
        }

        boolean isFin = false;
        while (!isFin) {
            isFin = true;

            for (Set<Integer> party : partyList) {
                boolean hasTruthKnower = false;
                for (int person : party) {
                    if (chk[person]) {
                        hasTruthKnower = true;
                        break;
                    }
                }

                if (hasTruthKnower) {
                    for (int person : party) {
                        if (!chk[person]) {
                            chk[person] = true;
                            isFin = false;
                        }
                    }
                }
            }
        }

        int result = M;

        for (Set<Integer> party : partyList) {
            for (int person : party) {
                if (chk[person]) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
