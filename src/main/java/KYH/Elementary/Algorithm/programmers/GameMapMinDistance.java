package KYH.Elementary.Algorithm.programmers;

import java.util.*;


class GameMapMinDistance { // 참고 사이트: https://geunzrial.tistory.com/115
    public static void main(String[] args){
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        GameMapMinDistance minDistance = new GameMapMinDistance();
        System.out.println(minDistance.solution(maps));
    }

    public int solution(int[][] maps) {
        // n: 세로길이, m: 가로길이
        int m = maps.length, n = maps[0].length;
        int answer, x, y, nx, ny;

        // 세로로 봤을 때 상하좌우로 이동하는 좌표
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // 방문한 곳 표시
        boolean[][] visited= new boolean[m][n];

        Queue<Integer> queue= new LinkedList<>();

        queue.offer(0);
        queue.offer(0);
        visited[0][0]= true;

        while(!queue.isEmpty()){
            x= queue.poll();
            y= queue.poll(); // <주의> unboxing may produce NullPointerException

            for(int i = 0; i < dx.length; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if(maps[nx][ny]==0) continue;
                if(!visited[nx][ny]){
                    queue.offer(nx);
                    queue.offer(ny);
                    maps[nx][ny] = maps[x][y]+1;
                    visited[nx][ny] = true;
                }
            }
        }
        answer = maps[m - 1][n - 1];
        if (maps[m - 1][n - 1] == 1) answer = -1;

        return answer;
    }
}
