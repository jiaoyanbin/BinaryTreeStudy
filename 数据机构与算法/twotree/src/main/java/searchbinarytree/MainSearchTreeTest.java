package searchbinarytree;

/*
       搜索二叉树
       *                 50
       *                /  \
       *              30   60
       *            / \    / \
       *          15  45  55  70

 */
public class MainSearchTreeTest {
    public static void main(String [] args){
        BinaryTree binaryTree = new BinaryTree();
        int [] array = {50,30,20,44,88,33,87,16,7,77};
        for (int i : array) {
            binaryTree.putTreeNode(i);
        }
        binaryTree.centerOrder(binaryTree.searchRoot);


        /**  作业
         * 1 通过给定有序数组生成查找二叉树
         *
         * 2 如何删除一个节点
         *
         * 3 查找后继者
         */
    }
}
