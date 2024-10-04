package Greedy;


/**
 * N개 보석
 * 무게: M, 가격: V
 * 가방 K개
 * 각 가방 최대 무게 C
 * 가방당 최대 한 개
 * 
 * 훔칠 수 있는 최대 가격은?
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 가방과 보석을 무게 오름차순으로 정렬
 * 2. 해당 가방에 들어갈 수 있는 모든 보석을 구함
 * 3. 그 중에서 가장 비싼 것을 PQ에서 제외(해당 가방에 보석을 넣음)
 * 4. 다음 가방으로 넘어감
 */

/**
 * 1. Comparator -> compare
 * 2. Comparator.reverseOrder()
 * 3. j를 이용하여 현재까지 확인한 보석 위치 저장
 */
public class Baek_1202_보석도둑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석의 수
        int K = Integer.parseInt(st.nextToken()); // 가방의 수

        int[][] jams = new int[N][2]; // 보석: [무게, 가격]
        int[] bags = new int[K]; // 가방의 용량

        // 보석 정보 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); // 보석 무게
            int V = Integer.parseInt(st.nextToken()); // 보석 가격

            jams[i][0] = M;
            jams[i][1] = V;
        }

        // 가방 정보 입력
        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석을 무게 오름차순으로 정렬
        Arrays.sort(jams, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]); // 무게가 같으면 가격 오름차순
                return Integer.compare(o1[0], o2[0]); // 무게 오름차순
            }
        });

        Arrays.sort(bags); // 가방을 무게 오름차순으로 정렬

        // 우선순위 큐: 가격 내림차순 (최대 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long result = 0; // 총 가격
        int j = 0; // 현재 보석의 인덱스
        
        for(int b = 0; b < K; b++){
            // 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 추가
            while(j < N && jams[j][0] <= bags[b]) {
                pq.offer(jams[j][1]); // 보석의 가격을 큐에 추가
                j++;
            }

            // 가장 높은 가격의 보석을 선택
            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
