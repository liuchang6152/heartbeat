package com.liuchang.heartbeat.sjjg.tree;

import com.liuchang.heartbeat.sjjg.tree.expection.NodeNotContainExpection;

import java.util.List;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 17:41 2020/1/7
 * @ Description：
 * @ Modified By：
 */
public class BinaryTreeClint {
    public static void main(String[] args) throws NodeNotContainExpection {
//        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(12);
//        BinaryTree binaryTree = new BinaryTree(binaryTreeNode);
//        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(11);
//        binaryTree.setLeftNode(binaryTreeNode,binaryTreeNode1);
//        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(1);
//        binaryTree.setLeftNode(binaryTreeNode1,binaryTreeNode2);
//
//        System.out.println(binaryTree.getNodeSize());
//        System.out.println(binaryTree.getTreeDepth());
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(11);
        SortBinaryTree sortBinaryTree = new SortBinaryTree<Integer>(new BinaryTreeNode<>(9));
        sortBinaryTree.addNode(8);
        sortBinaryTree.addNode(10);
        sortBinaryTree.addNode(17);
        sortBinaryTree.addNode(12);
        sortBinaryTree.addNode(4);
        sortBinaryTree.addNode(7);
        sortBinaryTree.addNode(3);
        //sortBinaryTree.addNode(8);
        System.out.println(sortBinaryTree);
        //List<BinaryTreeNode> list = sortBinaryTree.getNodeLine(4);
        //list.forEach((node)-> System.out.println(node.getValue()));
        //System.out.println(sortBinaryTree.delNode(4));
        System.out.println(sortBinaryTree.leftErgodic());
        System.out.println(sortBinaryTree.rightErgodic());
        System.out.println(sortBinaryTree.preErgodic());
        System.out.println(sortBinaryTree.afterErgodic());
        //System.out.println(sortBinaryTree.getNodeLine(12));
//        System.out.println(sortBinaryTree.containsValue(8));
//        System.out.println(sortBinaryTree.containsValue(10));
//        System.out.println(sortBinaryTree.containsValue(17));
//        System.out.println(sortBinaryTree.containsValue(12));
//        System.out.println(sortBinaryTree.containsValue(4));
//        System.out.println(sortBinaryTree.containsValue(7));
//        System.out.println(sortBinaryTree.getParentNode(4));
//        System.out.println(sortBinaryTree.getParentNode(12));
//        System.out.println(sortBinaryTree.getParentNode(9));
//        System.out.println(sortBinaryTree.getParentNode(123));

       //System.out.println(sortBinaryTree);
        //System.out.println(sortBinaryTree);
        //sortBinaryTree.addValue(9);
        //sortBinaryTree.addValue(10);
       // System.out.println(sortBinaryTree);
    }
}
