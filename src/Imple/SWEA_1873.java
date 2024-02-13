package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 1873 배틀필드 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
 */
public class SWEA_1873 {
    // 상, 우, 하, 좌
    public static int[] di = {-1, 0, 1, 0};
    public static int[] dj = {0, 1, 0, -1};
    public static Tank tank;
    public static char[][] map;
    public static int cmdCnt;
    public static char[] cmds;
    public static class Tank{
        int i;
        int j;
        char status;
        //dir: 1: 상, 2: 우, 3: 하, 4: 좌;
        int dir;

        public Tank(int i, int j, char status){
            this.i = i;
            this.j = j;
            this.status = status;
            switch (status){
                case '^':
                    this.dir = 0;
                    break;
                case '>':
                    this.dir = 1;
                    break;
                case 'v':
                    this.dir = 2;
                    break;
                case '<':
                    this.dir = 3;
                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // H: 높이, W: 너비
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // 맵 배열
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            // 명령 개수
            cmdCnt = Integer.parseInt(br.readLine());
            // 명령 배열
            cmds = br.readLine().toCharArray();
            
            tank = null;

            // 초기 탱크 위치 설정
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j] == '<' || map[i][j] == '>' ||map[i][j] == 'v' ||map[i][j] == '^'){
                        tank = new Tank(i, j, map[i][j]);
                        break;
                    }
                }
            }

            for (int i = 0; i < cmdCnt; i++) {
                switch (cmds[i]){
                    // 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동
                    case 'U':
                        MoveTank(tank, map, '^');
                        break;
                    // 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동
                    case 'D':
                        MoveTank(tank, map, 'v');
                        break;
                    // 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
                    case 'L':
                        MoveTank(tank, map, '<');
                        break;
                    // 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동
                    case 'R':
                        MoveTank(tank, map, '>');
                        break;
                    // 바라보고 있는 방향으로 포탄을 발사
                    case 'S':
                        Shoot(tank, map);
                        break;
                }
            }

            System.out.print("#" + tc +" ");

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    // 탱크를 움직이는 함수
    public static void MoveTank(Tank tank, char[][] map, char cmd){
        tank.status = cmd;
        switch (cmd){
            case '^':
                tank.dir = 0;
                break;
            case '>':
                tank.dir = 1;
                break;
            case 'v':
                tank.dir = 2;
                break;
            case '<':
                tank.dir = 3;
                break;
        }

        // 지도에 탱크 새로고침
        map[tank.i][tank.j] = cmd;

        // 탱크가 바라보는 방향의 다음 idx
        int ni = tank.i + di[tank.dir];
        int nj = tank.j + dj[tank.dir];

        // 범위 안이면
        if(0 <= ni && ni < map.length && 0 <= nj && nj < map[0].length){
            // 다음 칸이 평지면
            if(map[ni][nj] == '.'){
                map[ni][nj] = tank.status;
                map[tank.i][tank.j] = '.';
                tank.i = ni;
                tank.j = nj;
            }
        }
    }

    public static void Shoot(Tank tank, char[][] map) {
        int ni = tank.i + di[tank.dir];
        int nj = tank.j + dj[tank.dir];

        while (true) {
            // 포탄이 범위 안이면
            if (0 <= ni && ni < map.length && 0 <= nj && nj < map[0].length) {
                // 벽돌
                if (map[ni][nj] == '*') {
                    map[ni][nj] = '.';
                    break;
                    // 강철벽
                } else if (map[ni][nj] == '#') {
                    break;
                    // 물, 평지
                } else {
                    ni += di[tank.dir];
                    nj += dj[tank.dir];
                }
            }else{
                break;
            }
        }
    }
}
