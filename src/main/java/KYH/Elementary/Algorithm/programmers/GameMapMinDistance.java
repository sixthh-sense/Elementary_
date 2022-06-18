package KYH.Elementary.Algorithm.programmers;

import java.util.*;


class GameMapMinDistance { // 참고 사이트: https://geunzrial.tistory.com/115
    public static void main(String[] args){
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(maps[0][1]); // 0 index 0번째 행의 index 1번째 열
        System.out.println(maps[1][0]); // 1
        GameMapMinDistance minDistance = new GameMapMinDistance();
        System.out.println(minDistance.solution(maps));
    }

    public int solution(int[][] maps) {
        // n: 가로길이, m: 세로길이 (가로, 세로 정할 때 헷갈리지 않게 조심)
        int n = maps.length, m = maps[0].length;
        int answer, x, y, nx, ny;

        // 세로로 봤을 때 상하좌우로 이동하는 좌표
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // 방문한 곳 표시
        boolean[][] visited= new boolean[n][m];

        Queue<Integer> queue= new LinkedList<>();

        queue.offer(0);
        queue.offer(0);
        visited[0][0]= true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll(); // <주의> unboxing may produce NullPointerException

            for(int i = 0; i < dx.length; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                // 범위 밖일 땐 패스
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (maps[nx][ny] == 0) continue;

                if(!visited[nx][ny]){ // 옮긴 좌표가 아직 방문하지 않은 곳이라면
                    queue.offer(nx);
                    queue.offer(ny); // queue에 좌표값 추가하고
                    maps[nx][ny] = maps[x][y] + 1; // 거리 1 추가(갈 수 있는 곳 -> 거리 +1)
                    visited[nx][ny] = true;
                }
            }
        }
        answer = maps[n - 1][m - 1]; // 최종 거리(자동 최소값)
        if (maps[n - 1][m - 1] == 1) answer = -1; // 1이란 건 못 늘어났다는 거니까 답이 없다는 말 -> -1

        return answer;
    }
}
