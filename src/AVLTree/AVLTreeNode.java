package AVLTree;

/**
 * 平衡二叉树节点
 */
public class AVLTreeNode {

    /**
     * 左子树
     */
    public AVLTreeNode leftNode;
    /**
     * 右子树
     */
    public AVLTreeNode rightNode;
    /**
     * 当前结点的高度
     */
    public int height;
    /**
     * 节点的数据
     */
    public int data;

    public AVLTreeNode(int data) {
        this.data = data;
    }
}
