package binarytree;

import java.util.Stack;

/**
 * 二叉树的数据结构学习类
 */
public class BinaryTree {

    /**
     * 二叉树根节点
     */
    private TreeNode<String> root = null;


    public BinaryTree(){
        root = new TreeNode(1,"A");
    }


    /*****************************************栈方式遍历********************************/
    /**
     * 用栈的方式前序遍历
     */
    public void nonPreOrder(){
       nonPreOrder(root);
    }
    /**
     * 用栈的方式中序遍历
     */
    public void notCenterOrder(){
        notCenterOrder(root);
    }

    /**
     * 用栈的方式后序遍历
     */
    public void nonEndOrder(){
        nonEndOrder(root);
    }
    public void nonPreOrder(TreeNode treeNode){
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()){
            TreeNode<String> root = stack.pop();
            System.out.print(root.data);
            if (root.rightChild != null) {
                stack.push(root.rightChild);
            }
            if (root.leftChild != null) {
                stack.push(root.leftChild);
            }
        }
    }
    private void notCenterOrder(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                stack.push(curNode);
                curNode = curNode.leftChild;
            }
            curNode = stack.pop();
            System.out.print(curNode.data);
            curNode = curNode.rightChild;
        }
    }

    public void nonEndOrder(TreeNode node){
        if (node == null) {
            return;
        }
        TreeNode curNode = root;
        TreeNode lastNode = null;

        Stack<TreeNode<String>> stack = new Stack<>();
        while (curNode!=null || !stack.empty()){
            while (curNode != null){
                //压入左子树结点
                stack.push(curNode);
                curNode = curNode.leftChild;
            }

            curNode = stack.get(stack.size()-1);

            if (curNode.rightChild != null && (lastNode != curNode.rightChild))//考虑栈顶结点的右子树结点。存在且没被访问过，将右子树结点压入栈中
            {
                curNode = curNode.rightChild;
            }else if ((curNode.rightChild == null) || (lastNode == curNode.rightChild)){//右子树结点为空或者已经被访问过，则访问栈顶结点并弹出
                System.out.print(curNode.data);
                lastNode = curNode;
                stack.pop();
                //cur置空作用在于当原栈顶结点被访问并弹出后，下一层while是将当前栈顶结点的左子树入栈，当前栈顶结点的左子树已经被遍历过，
                //因此会造成死循环，所以将cur置空，直接考虑当前栈顶结点的右子树
                //一旦某个结点入栈，首先会遍历这个结点的左子树，然后考虑右子树的情况
                curNode = null;

            }
        }

    }
    //-----------------------------------------------------------------栈方式遍历结束

    /************************************递归方式遍历********************************************/
    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    /**
     * 中序遍历
     */
    public void centerOrder( ){
        centerOrder(root);
        System.out.println();
    }
    /**
     * 后序遍历
     */
    public void endOrder( ){
        endOrder(root);
        System.out.println();
    }


    public void preOrder(TreeNode node){
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    public void centerOrder(TreeNode node){
        if (node == null) {
            return;
        }
        centerOrder(node.leftChild);
        System.out.print(node.data);
        centerOrder(node.rightChild);
    }

    public void endOrder(TreeNode node){
        if (node == null) {
            return;
        }
        endOrder(node.leftChild);
        endOrder(node.rightChild);
        System.out.print(node.data);
    }
  //-------------------------------------------------------------递归遍历方式结束


    public int getHeight(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        }
        int i = getHeight(treeNode.leftChild);
        int j = getHeight(treeNode.rightChild);

        return i>j?i+1:j+1;
    }

    /**
     * 获取二叉树高
     * @return
     */
    public int getHeight(){
        return getHeight(root);
    }

    /**
     * 获取二叉树的节点数
     * @return
     */
    public int getSize(){
        return getSize(root);
    }

    /**
     * 获取二叉树的节点数
     * @param node
     * @return
     */
    public int getSize(TreeNode node){
        if (node == null) {
            return  0;
        }
        return 1+getSize(node.leftChild)+getSize(node.rightChild);
    }
    /**
     * 构建二叉树
     *                  A
     *                /  \
     *              B     C
     *            / \      \
     *           D   E      F
     */
    public void createBinaryTree(){
        TreeNode<String> nodeB = new TreeNode<>(2,"B");
        TreeNode<String> nodeC = new TreeNode<>(3,"C");
        TreeNode<String> nodeD = new TreeNode<>(4,"D");
        TreeNode<String> nodeE = new TreeNode<>(5,"E");
        TreeNode<String> nodeF = new TreeNode<>(6,"F");

        root.leftChild = nodeB;
        root.rightChild = nodeC;

        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;

        nodeC.rightChild = nodeF;
    }

    /**
     * 二叉树节点结构类
     */
    public class TreeNode<T>{
        private int index;
        private T data;

        private TreeNode leftChild;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        private TreeNode rightChild;

        public TreeNode(int index,T data){
            this.index = index;
            this.data = data;
        }
    }
}
