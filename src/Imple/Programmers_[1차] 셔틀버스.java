/**
* 1. 타임테이블을 정렬
* 2. 버스 도착 시간 리스트 생성
* 3. 버스에 인원 수에 맞게 넣음
* 4. 마지막 버스에 콘이 탈 수 있는 지 체크
* 4-1. 탈 수 있으면 해당 버스 도착 시간으로 리턴
* 4-2. 탈 수 없으면, 해당 버스 마지막으로 탄 사람의 시각 - 1분
**/

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 1. 크루 도착 시간 정렬 (분 단위 변환)
        List<Integer> crewTimes = new ArrayList<>();
        for (String time : timetable) {
            int hh = Integer.parseInt(time.split(":")[0]);
            int mm = Integer.parseInt(time.split(":")[1]);
            crewTimes.add(hh * 60 + mm); // HH:MM → 분 변환
        }
        Collections.sort(crewTimes); // 오름차순 정렬

        // 2. 셔틀 도착 시간 리스트 생성
        List<Integer> busTimes = new ArrayList<>();
        int firstBusTime = 9 * 60; // 09:00 → 540분
        for (int i = 0; i < n; i++) {
            busTimes.add(firstBusTime + i * t);
        }

        // 3. 버스에 탑승할 크루 관리
        int crewIndex = 0; // 현재 크루 인덱스
        int lastCrewTime = 0; // 마지막 크루 탑승 시간
        int lastBusTime = busTimes.get(busTimes.size() - 1); // 마지막 셔틀 도착 시간
        int lastCrewOnLastBus = -1; // 마지막 버스에서 가장 늦게 탄 크루의 시간
        int countOnLastBus = 0; // 마지막 버스의 탑승 인원

        for (int busTime : busTimes) {
            int count = 0; // 현재 버스에 탄 크루 수
            
            // 현재 버스에 탈 수 있는 크루 찾기
            while (crewIndex < crewTimes.size() && crewTimes.get(crewIndex) <= busTime && count < m) {
                lastCrewTime = crewTimes.get(crewIndex); // 마지막으로 탑승한 크루 시간
                if (busTime == lastBusTime) { // 마지막 버스일 경우
                    lastCrewOnLastBus = lastCrewTime;
                    countOnLastBus++;
                }
                crewIndex++;
                count++;
            }
        }

        // 4. 콘이 탈 수 있는 시간 계산
        int answerTime;
        if (countOnLastBus < m) { // 마지막 버스에 빈 자리 있음 → 그대로 탑승
            answerTime = lastBusTime;
        } else { // 마지막 버스가 꽉 찼다면 마지막 크루보다 1분 일찍 도착해야 함
            answerTime = lastCrewOnLastBus - 1;
        }

        // 5. HH:MM 형식으로 변환
        String hh = String.format("%02d", answerTime / 60);
        String mm = String.format("%02d", answerTime % 60);
        return hh + ":" + mm;
    }
}
