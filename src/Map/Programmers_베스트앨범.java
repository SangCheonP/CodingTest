package Map;

import java.util.*;

class Programmers_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 수 계산
        Map<String, Integer> genreSumPlay = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreSumPlay.put(genres[i], genreSumPlay.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 장르별 노래 정보 저장
        Map<String, List<Song>> songMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            songMap.putIfAbsent(genres[i], new LinkedList<>());
            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 3. 장르 정렬 (총 재생 수 기준 내림차순)
        List<String> genreOrder = new ArrayList<>(genreSumPlay.keySet());
        genreOrder.sort((a, b) -> genreSumPlay.get(b) - genreSumPlay.get(a));

        // 4. 결과 생성
        List<Integer> result = new ArrayList<>();
        for (String genre : genreOrder) {
            List<Song> songs = songMap.get(genre);

            // 장르별 노래 정렬 (재생 수 내림차순, 고유 번호 오름차순)
            songs.sort((a, b) -> {
                if (b.play == a.play) return a.idx - b.idx;
                return b.play - a.play;
            });

            // 상위 2곡 선택
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).idx);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // Song 클래스
    private static class Song {
        int idx;  // 고유 번호
        int play; // 재생 수

        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }
}
