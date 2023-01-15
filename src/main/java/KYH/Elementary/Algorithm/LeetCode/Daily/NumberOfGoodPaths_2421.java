package KYH.Elementary.Algorithm.LeetCode.Daily;

/* question link: leetcode.com/problems/number-of-good-paths
There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.

You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

A good path is a simple path that satisfies the following conditions:

The starting node and the ending node have the same value.
All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
Return the number of distinct good paths.

Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.

n == vals.length
1 <= n <= 3 * 104
0 <= vals[i] <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges represents a valid tree.
* */

import java.util.*;

/* 문제 해석 - 초기
nodes가 n개 있고 index형식으로 0번째부터 n-1번째까지 있다고 라벨링
edges는 수직계열 구조로 된 각 노드간 이어진 통로고 노드가 n개 있으면 n-1개 있을 수밖에 없음
vals는 0부터 시작하는 인덱스 형식, 인덱스별로 노드에 대응하는 값의 배열
edges[i]는 ai와 bi사이에 있는 미처 제시되지 않은 길?
"좋은 길"의 조건
1) 시작점과 끝점은 같은 값을 지님
2) 시작점과 끝점 사이의 모든 값은 시작점의 값보다 작거나 같아야 함
이런 조건이 있을 때 "중복되지 않은" "좋은 길"의 숫자를 반환하라
* */

// 20230115 - didn't solve by myself, it's the official solution
public class NumberOfGoodPaths_2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int count = vals.length;
        if (count == 1) {
            return count;
        } else if (count == 2) {
            return (vals[0] == vals[1]) ? count + 1 : count;
        }
        Map<Integer, List<Integer>> neighbors = new HashMap<>(); // 인접 인덱스 쌍방향 매핑
        for (int[] point : edges) {
            int x = point[0], y = point[1];
            neighbors.computeIfAbsent(x, value -> new ArrayList<>()).add(y);
            neighbors.computeIfAbsent(y, value -> new ArrayList<>()).add(x);
        }
        System.out.println(neighbors);
        TreeMap<Integer, List<Integer>> nodeValues = new TreeMap<>(); //
        for (int i = 0; i < count; i++) { // 0번째 인덱스 값 - 0번째 인덱스 값과 동일한 값을 가진 인덱스들
            nodeValues.computeIfAbsent(vals[i], value -> new ArrayList<>()).add(i);
        }
        System.out.println(nodeValues);

        UnionFind uf = new UnionFind(count); // parent, rank 초기닶 (node수만큼 있음, parent는 인덱스)
        System.out.println(uf.toString());
        int answer = 0;

        for (int value : nodeValues.keySet()) {
            System.out.println(nodeValues.keySet() + ", " + value);
            for (int node : nodeValues.get(value)) { // value - 인덱스 작은 순부터 검사
                System.out.println(nodeValues.get(value) + ", " + node);
                if (!neighbors.containsKey(node)) {
                    System.out.println(node + "continue");
                    continue;
                }
                for (int neighbor : neighbors.get(node)) {
                    System.out.println(neighbors.get(node) + ", " + neighbor);
                    if (vals[node] >= vals[neighbor]) {
                        System.out.println("node: " + vals[node] + ", neighbor: " + vals[neighbor]);
                        uf.union_set(node, neighbor);
                        System.out.println("union_set: " + uf.toString());
                    }
                }
            }

            Map<Integer, Integer> group = new HashMap<>();

            for (int u : nodeValues.get(value)) {
                group.put(uf.find(u), group.getOrDefault(uf.find(u), 0) + 1);
            }

            for (int key : group.keySet()) {
                int size = group.get(key);
                answer += (size * (size + 1)) / 2;
            }
        }
        return answer;
    }
    public static class UnionFind { //  union-by-rank(참고 링크: https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }

        @Override
        public String toString() {
            return "parent: " + Arrays.toString(parent) + "\nrank: " + Arrays.toString(rank);
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union_set(int x, int y) {
            int xSet = find(x), ySet = find(y);
            if (xSet == ySet) {
                return;
            } else if (rank[xSet] < rank[ySet]) {
                parent[xSet] = ySet;
            } else if (rank[xSet] > rank[ySet]) {
                parent[ySet] = xSet;
            } else {
                parent[ySet] = xSet;
                rank[xSet]++;
            }
        }
    }
}


