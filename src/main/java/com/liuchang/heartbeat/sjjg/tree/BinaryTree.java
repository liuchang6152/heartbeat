package com.liuchang.heartbeat.sjjg.tree;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:09 2020/1/7
 * @ Description：二叉树
 * @ Modified By：
 */
public class BinaryTree extends AbstractBinaryTree{

    /**
     * 构造一棵空二叉树
     */
    public BinaryTree(){
        this(null);
    }

    /**
     * 初始化一棵带根节点的树
     * @param rootNode
     */
    public BinaryTree(BinaryTreeNode rootNode){
        this.rootNode = rootNode;
        if(rootNode!=null){
            nodeSize++;
        }
    }
    /**
     * 向某节点添加左节点
     * @param treeNode
     * @param leftNode
     * @return
     */
    public BinaryTreeNode setLeftNode(BinaryTreeNode treeNode,BinaryTreeNode leftNode){
        if(!this.contains(treeNode)){
            return null;
        }
        treeNode.setLeftTreeNode(leftNode);
        nodeSize++;
        return leftNode;
    }
    /**
     * 向某节点添加右节点
     * @param treeNode
     * @param rightNode
     * @return
     */
    public BinaryTreeNode setRightNode(BinaryTreeNode treeNode,BinaryTreeNode rightNode){
        if(!this.contains(treeNode)){
            return null;
        }
        treeNode.setRightTreeNode(rightNode);
        nodeSize++;
        return rightNode;
    }

    /**
     * 删除某节点左节点
     * @param treeNode
     * @return
     */
    public boolean delLeftNode(BinaryTreeNode treeNode){
        if(!this.contains(treeNode)){
            return false;
        }
        if(treeNode.getLeftTreeNode()==null){
            return true;
        }
        nodeSize--;
        treeNode.setLeftTreeNode(null);
        return true;
    }
    /**
     * 删除某节点右节点
     * @param treeNode
     * @return
     */
    public boolean delRightNode(BinaryTreeNode treeNode){
        if(!this.contains(treeNode)){
            return false;
        }
        if(treeNode.getRightTreeNode()==null){
            return true;
        }
        rootNode.setRightTreeNode(null);
        nodeSize--;
        treeNode.setLeftTreeNode(null);
        return true;
    }

    @Override
    boolean delNode(Comparable<?> value) {
        return false;
    }
}
