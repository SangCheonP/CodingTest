package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_17143_낚시왕 {
    public static int R, C;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};
    public static List<Shark> sharkIdx;
    public static Shark[][] map;
    public static class Shark{
        // r, c : 위치
        // s : 속력
        // d : 방향
        // z : 크기
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shark shark = (Shark) o;
            return r == shark.r && c == shark.c && s == shark.s && d == shark.d && z == shark.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, s, d, z);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1 ~ R / 1 ~ C 까지만 사용
        map = new Shark[R + 1][C + 1];
        sharkIdx = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d, z);

            map[r][c] = shark;
            sharkIdx.add(shark);

        }

        int time = 0, result = 0;
        while(++time <= C){
            // 상어 잡기
            result += catchSharK(time);

            Shark[][] cp = new Shark[R + 1][C + 1];
            for (int i = 0; i < R+1; i++) {
                Arrays.fill(cp[i], null);
            }

            Shark big, small = null;

            // 상어 이동
            for(Shark shark : sharkIdx){
                Shark s = moveShark(shark);
                
                // 상어가 없으면
                if(cp[s.r][s.c] == null) {
                    cp[s.r][s.c] = s;
                // 상어가 있어 더 큰 사이즈 상어를 넣음
                }else{
                    big = (s.z >= cp[s.r][s.c].z ? s : cp[s.r][s.c]);
                    small = (s.z < cp[s.r][s.c].z ? s : cp[s.r][s.c]);

                    cp[s.r][s.c] = big;
                }
            }

            if(small != null){
                for(int idx = 0; idx < sharkIdx.size(); idx++){
                    if(sharkIdx.get(idx).equals(small)){
                        sharkIdx.remove(idx);
                        break;
                    }
                }
            }

            for (int i = 1; i < R+1; i++) {
                for (int j = 1; j < C + 1; j++) {
                    map[i][j] = cp[i][j];
                }
            }
        }
        System.out.println(result);
    }

    public static int catchSharK(int time){
        for(int i = 1; i < R+1; i++){
            if(map[i][time] != null){
                // 상어 없애기
                for(int s = 0; s < sharkIdx.size(); s++){
                    if(sharkIdx.get(s).equals(map[i][time])){
                        sharkIdx.remove(s);
                        break;
                    }
                }

                int w = map[i][time].z;

                map[i][time] = null;

                // 잡은 상어 무게 리턴
                return w;
            }
        }
        return 0;
    }

    public static Shark moveShark(Shark shark){
        int curi = shark.r;
        int curj = shark.c;
        int curd = shark.d;

        for(int i = 1; i <= shark.s; i++ ){
            int ni = curi + di[curd];
            int nj = curj + dj[curd];

            if(ni == 0 || nj == 0 || ni == R+1 || nj == C+1){
                // 방향 변경
                if(curd == 0){
                    curd = 1;
                } else if(curd == 1){
                    curd = 0;
                } else if(curd == 2){
                    curd = 3;
                } else if(curd == 3){
                    curd = 2;
                }

                curi += di[curd];
                curj += dj[curd];

            }else{
                curi = ni;
                curj = nj;
            }
        }

        // 최종 상어의 위치가 정해지면

        shark.r = curi;
        shark.c = curj;
        shark.d = curd;

        return shark;
    }
}

