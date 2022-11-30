/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + ",");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    sb.append(node.left.val + ",");
                } else sb.append("#,");
                if(node.right != null){
                    queue.add(node.right);
                    sb.append(node.right.val + ",");
                } else sb.append("#,");
            }
        }
        return sb.delete(sb.length()-1, sb.length()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int pointer = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[pointer]));
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(nodes[++pointer].compareTo("#") != 0){
                    node.left = new TreeNode(Integer.parseInt(nodes[pointer]));
                    queue.add(node.left);
                }
                if(nodes[++pointer].compareTo("#") != 0){
                    node.right = new TreeNode(Integer.parseInt(nodes[pointer]));
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
