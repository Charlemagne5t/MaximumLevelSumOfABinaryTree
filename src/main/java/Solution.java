import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxLevelSum(TreeNode root) {

        return bfs(root);
    }

    private int bfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int levelWithMaxSum = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if (sum > maxSum) {
                levelWithMaxSum = level;
                maxSum = sum;
            }
        }
        return levelWithMaxSum;
    }
}