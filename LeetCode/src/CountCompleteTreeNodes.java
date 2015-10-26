/**
 * Created by yaodh on 15/10/21.
 */
public class CountCompleteTreeNodes {
    /*
    int countNodes(TreeNode* root) {
    if(!root) return 0;
    TreeNode *temp = root;
    int height = 0, count = 0, level;
    while(temp) {
        temp = temp->left;
        height ++;
    }
    temp = root;
    level = height - 2;
    while(level >= 0) {
        TreeNode *left = temp->left;
        for(int i = 0;i < level;i ++) {
            left = left->right;
        }
        if(left) {
            temp = temp->right;
            count += (1 << level);
        } else temp = temp->left;
        level --;
    }
    if(temp) count ++;
    return (1 << (height - 1)) + count - 1;
}
     */
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        TreeNode tmp = root;
        while(tmp != null) {
            tmp = tmp.left;
            depth++;
        }
        tmp = root;
        int count = 0;
        int level = depth - 2;
        while(level >= 0) {
            TreeNode left = tmp.left;
            for(int i=0;i<level;i++) {
                left = left.right;
            }
            if(left != null) {
                tmp = tmp.right;
                count += (1 << level);
            }
            level--;
        }
        if(tmp != null) {
            count++;
        }
        return (1<<(depth-1)) + count - 1;
    }
//    public int countNodes(TreeNode root) {
//        int depth = 0;
//        TreeNode left = root, right = root;
//        while(left != null && right != null) {
//            left = left.left;
//            right = right.right;
//            depth++;
//        }
//        if(left == null && right == null) {
//            return (1<<depth) - 1;
//        }
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
}
