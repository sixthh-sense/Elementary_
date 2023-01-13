package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.*;

public class NumberOfNodesInTheSubTreeWithTheSameLabel_1519 {
    /*
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        return null;
    }
     */
    // official solution link: I'm just uploading the link now but I should swirl it into my brain later time
    // https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/solutions/2864718/number-of-nodes-in-the-sub-tree-with-the-same-label/?orderBy=most_votes

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String labels = "abaedcd";
        System.out.println(Arrays.toString(countSubTrees(n, edges, labels)));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>(); // Integer: n번째 node, List<Integer>: 그 n번째 node에 해당하는 subtree 목록
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a); // 한쪽만 더해주면 안 되니 앞 - 뒤, 뒤 - 앞 양쪽으로 더해줌
            //System.out.println(adj); // 이렇게 for문을 돌리면 결과적으로 모든 edges에 관해 특정 노드 - 노드에 해당하는 subtree 목록이 만들어짐
        }

        int[] ans = new int[n];
        char[] label = labels.toCharArray();
        dfs(0, -1, adj, label, ans); // 깊이 "우선" 탐색, 초기값으로 시작(처음에는 parent가 있을 수가 없으니 -1처리)

        return ans;
    }

    // node, parent -> child, node
    // subtree 목록을 가져왔으니 본인 포함 subtree 중에서 "문자열"이 같은 개수 목록 구하기(인덱스 오름차순)
    public static int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj, char[] labels, int[] ans) {
        int[] nodeCounts = new int[26]; // alphabets
        nodeCounts[labels[node] - 'a'] = 1; // 1개씩 센다

        if (!adj.containsKey(node)) { // 탐색할 거 다 탐색하고 전체 맵에 없는 키까지 조사하기 시작 -> 이전에 저장된 정보 return
            return nodeCounts;
        }

        for (int child : adj.get(node)) { // node가 0일 때부터 탐색이 안될 때까지 반복, 특정 node값일 때 거기에 등록된 subtree 목록 - 개별 값 child
            if (child == parent) { // 동일한 게 subtree일 리가. 중복 건너뛰기
                continue;
            }
            System.out.println("dfs - child: " + child + ", parent; " + node);
            int[] childCounts = dfs(child, node, adj, labels, ans); // 해당하는 값 "1개씩" 짚어내고

            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i]; // return할 nodeCount에 (1개씩) "더한다"
            }
        }
        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }
}
