package bytedance;

import 程序员代码面试指南.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Ethan-Walker on 2019/2/15
 */
public class Q103_ZigZagLevel {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> levelList = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        queue.offer(root);

        TreeNode node = null;
        int level = 1, curLevelCount = 1, nextLevelCount = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if ((level & 1) == 1) { // 奇数
                levelList.add(node.val);
            } else {
                stack.push(node.val);
            }

            curLevelCount--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelCount++;

            }

            if (curLevelCount == 0) {
                if ((level & 1) == 0) {
                    // 偶数
                    while (!stack.isEmpty()) {
                        levelList.add(stack.pop());
                    }
                }
                res.add(levelList);
                levelList = new ArrayList<>();
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
                level++;
            }

        }
        return res;

    }
}
