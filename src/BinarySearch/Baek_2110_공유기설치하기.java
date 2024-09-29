package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 수직선 위에 N개의 집
 * 공유기 C개
 * 한 집에 공유기 한 대
 * 가장 인접한 두 공유기 사이의 거리를 최대
 *
 * 2 <= N <= 200,000
 * 2 <= C <= N
 * 0 <= xi <= 1,000,000,000
 */

public class Baek_2110_공유기설치하기 {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i = 0; i < N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        // 이분 탐색을 위해 정렬
        Arrays.sort(house);

        int low = 1; // 두 공유기 최소 거리
        int high = house[N-1] - house[0]; // 두 공유기 최대 거리
        int result = 0;

        while(low <= high){
            // 현재 후보 거리
            int mid = low + (high - low)/2;

            // mid 거리 이상으로 C개 보다 적게 설치하면
            if(canInstall(mid) < C){
                // 현재 미드가 가능
                high = mid - 1; // 상한을 줄임
            }else{
                // 현재 미드가 가능
                result = mid;
                low = mid + 1; // 하한을 올림
            }
        }

        System.out.println(result); // 최소 거리의 최댓값
    }
    
    // distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
    static int canInstall(int distance){
        int count = 1; // 첫 번째 집에 공유기를 설치
        int lastIndex = 0; // 마지막으로 공유기를 설치한 집의 인덱스

        for(int i = 1; i < N; i++){
            if(house[i] - house[lastIndex] >= distance){
                lastIndex = i; // 현재 집에 공유기를 설치
                count += 1;
            }
        }

        return count; // 설치 가능한 공유기 개수 반환
    }
}
