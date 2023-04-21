package Huawei.二叉树深度;

/*
 * 二叉树的深度
 * */
public class Test4Keen {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.right=new TreeNode(5);


        System.out.println(treeDep(root));
    }
    public static  int treeDep(TreeNode root){
        // 定义叶子节点深度是0
        if(root==null){
            return 0;
        }
        int ldepth=treeDep(root.left);
        int rdepth=treeDep(root.right);
        int res=0;
        if(ldepth>rdepth){
            res=ldepth;
        }else{
            res=rdepth;
        }
        return res+1;
    }
}

class TreeNode {
    Integer value = -1;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {

    }

    TreeNode(Integer value) {
        this.value = value;
    }

    TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}