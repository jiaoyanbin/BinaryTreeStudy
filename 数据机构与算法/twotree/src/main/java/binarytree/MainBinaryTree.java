package binarytree;

public class MainBinaryTree {
    public static void main(String [] args){
        BinaryTree binaryTree = new BinaryTree();

        /*
          构建二叉树
                           A
                         /  \
                       B     C
                     / \      \
                    D   E      F
         */
        binaryTree.createBinaryTree();

        System.out.println("二叉树高度="+binaryTree.getHeight());
        System.out.println("二叉树节点数="+binaryTree.getSize());

        System.out.println("===========用递归迭代方式================");
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.centerOrder();
        System.out.println("后序遍历");
        binaryTree.endOrder();

        System.out.println("===========用栈迭代方式================");
        System.out.println("前序遍历");
        binaryTree.nonPreOrder();
        System.out.println();
        System.out.println("中序遍历");
        binaryTree.notCenterOrder();
        System.out.println();
        System.out.println("后序遍历");
        binaryTree.nonEndOrder();


        /*
          用递归法前序生成二叉树
               *                  A
               *                /  \
               *              B     C
               *            / \    / \
               *           D   E  #   F
               *         /\   /\     /\
               *        # #  # #    # #
               ABD##E##C#F##

               A  0B  1D  2E  5C  8F  10
         */
        binaryTree.createBinaryTreePre();
        binaryTree.preOrder();


        /*
          用栈法前序生成二叉树 TODO
               *                  A
               *                /  \
               *              B     C
               *            / \    / \
               *           D   E  #   F
               *         /\   /\     /\
               *        # #  # #    # #
               ABD##E##C#F##

               A  0B  1D  2E  5C  8F  10
         */




    }
}
