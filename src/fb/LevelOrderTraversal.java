package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }
        int level = 0;
        levelOrderTraversal(root, level, levelOrderList);
        return levelOrderList;
    }

    private void levelOrderTraversal(TreeNode node, int level, List<List<Integer>> levelOrderList) {
        if (node == null) {
            return;
        }
        List<Integer> listForLevel = null;
        if (levelOrderList.size() > level) {
            listForLevel = levelOrderList.get(level);
        } else {
            listForLevel = new ArrayList<>();
            levelOrderList.add(listForLevel);
        }
        listForLevel.add(node.val);
        levelOrderTraversal(node.left, level+1, levelOrderList);
        levelOrderTraversal(node.right, level+1, levelOrderList);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
    }
}