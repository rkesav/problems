package tree;


import java.util.List;

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

class MaxPathSum {
    int globalMax;
    public int maxPathSum(TreeNode root) {
        globalMax = root.val;
        int maxSumIncludingRoot = maxSumIncludingRoot(root);

        return globalMax > maxSumIncludingRoot ? globalMax:maxSumIncludingRoot;
    }

    private int maxSumIncludingRoot(TreeNode root) {
        int maxSumIncludingRoot;
        if (root.left == null && root.right == null) {
            maxSumIncludingRoot = root.val;
        } else if (root.left == null) {
            int rightSum = maxSumIncludingRoot(root.right);
            maxSumIncludingRoot = List.of(root.val, root.val + rightSum).stream().max(Integer::compareTo).get();

        } else if (root.right == null) {
            int leftSum = maxSumIncludingRoot(root.left);
            maxSumIncludingRoot = List.of(root.val, root.val + leftSum).stream().max(Integer::compareTo).get();

        } else {
            int leftSum = maxSumIncludingRoot(root.left);
            int rightSum = maxSumIncludingRoot(root.right);
            maxSumIncludingRoot = List.of(root.val, root.val + leftSum, root.val + rightSum).stream().max(Integer::compareTo).get();
            int sumAtRoot = root.val + rightSum + leftSum;
            if (sumAtRoot > globalMax) {
                globalMax = sumAtRoot;
            }
        }

        if (maxSumIncludingRoot > globalMax) {
            globalMax = maxSumIncludingRoot;
        }
        return maxSumIncludingRoot;
    }

}