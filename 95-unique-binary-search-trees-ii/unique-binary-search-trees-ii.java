class Solution {
    List<TreeNode>[][] cache;


    public List<TreeNode> generateTrees(int n) {
        this.cache = new ArrayList[n + 1][n + 1];
        return getUniqueTrees(1, n);
    }


    public List<TreeNode> getUniqueTrees(int l, int r) {
        List<TreeNode> node = new ArrayList<>();


        if (l > r) {
            node.add(null);
            return node;
        }


        if (this.cache[l][r] != null)
            return this.cache[l][r];


        for (int i = l; i <= r; i++) {
            List<TreeNode> leftSubtrees = getUniqueTrees(l, i - 1);
            List<TreeNode> rightSubtrees = getUniqueTrees(i + 1, r);


            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode n = new TreeNode(i);


                    n.left = leftSubtree;
                    n.right = rightSubtree;
                    node.add(n);
                }
            }
        }


        this.cache[l][r] = node;
        return node;
    }
}