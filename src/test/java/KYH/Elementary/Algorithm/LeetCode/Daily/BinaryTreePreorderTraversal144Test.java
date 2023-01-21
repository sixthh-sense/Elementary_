package KYH.Elementary.Algorithm.LeetCode.Daily;

import KYH.Elementary.Algorithm.LeetCode.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePreorderTraversal144Test {


    @Test
    void first() {
        // 938번, 2181번 기준 TreeNode라서 144번 TreeNode 표기법과 다른 부분 있음 - 144번 리트코드에선 {1, null, 2, 3}가 입력값.
        TreeNode treeNode = TreeNode.makeTree(new Integer[]{1, null, 2, null, null, 3});
        //TreeNode treeNode = TreeNode.makeTree(new Integer[] {1});
        List<Integer> actual = BinaryTreePreorderTraversal_144.preorderTraversal(treeNode);
        assertThat(new ArrayList<>(Arrays.asList(1, 2, 3))).usingRecursiveComparison().isEqualTo(actual);
    }

    @Test
    void second() {
        // 938번, 2181번 기준 TreeNode라서 144번 TreeNode 표기법과 다른 부분 있음 - 144번 리트코드에선 {1, null, 2, 3}가 입력값.
        TreeNode treeNode = TreeNode.makeTree(new Integer[]{});
        //TreeNode treeNode = TreeNode.makeTree(new Integer[] {1});
        List<Integer> actual = BinaryTreePreorderTraversal_144.preorderTraversal(treeNode);
        assertThat(new ArrayList<>()).usingRecursiveComparison().isEqualTo(actual);
    }

    @Test
    void third() {
        // 938번, 2181번 기준 TreeNode라서 144번 TreeNode 표기법과 다른 부분 있음 - 144번 리트코드에선 {1, null, 2, 3}가 입력값.
        TreeNode treeNode = TreeNode.makeTree(new Integer[]{1});
        //TreeNode treeNode = TreeNode.makeTree(new Integer[] {1});
        List<Integer> actual = BinaryTreePreorderTraversal_144.preorderTraversal(treeNode);
        assertThat(new ArrayList<>(List.of(1))).usingRecursiveComparison().isEqualTo(actual);
    }
}