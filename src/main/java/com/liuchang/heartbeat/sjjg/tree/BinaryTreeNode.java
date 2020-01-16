package com.liuchang.heartbeat.sjjg.tree;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:03 2020/1/7
 * @ Description：
 * @ Modified By：
 */
public final class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode leftTreeNode;
    private BinaryTreeNode rightTreeNode;
    public BinaryTreeNode(T value){
        if(value == null){
            throw new NullPointerException();
        }
        this.value = value;
    }

    /**
     * 是否叶子节点
     * @return
     */
    public boolean isLeaf(){
        return leftTreeNode==null&&rightTreeNode==null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public BinaryTreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public BinaryTreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    void setLeftTreeNode(BinaryTreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    void setRightTreeNode(BinaryTreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BinaryTreeNode)){
            return false;
        }
        BinaryTreeNode binaryTreeNode = (BinaryTreeNode)obj;
        if(!binaryTreeNode.value.equals(this.value)){
            return false;
        }
        if(binaryTreeNode.leftTreeNode == null&&binaryTreeNode.rightTreeNode == null){
            return this.leftTreeNode == null&&this.rightTreeNode == null;
        }
        if(binaryTreeNode.leftTreeNode == null){
            return this.leftTreeNode == null&&binaryTreeNode.rightTreeNode.equals(this.rightTreeNode);
        }
        if(binaryTreeNode.rightTreeNode == null){
            return this.rightTreeNode == null&&binaryTreeNode.leftTreeNode.equals(this.leftTreeNode);
        }
        return this.rightTreeNode.equals(binaryTreeNode.rightTreeNode)&&this.leftTreeNode.equals(binaryTreeNode.leftTreeNode);
    }

    @Override
    public String toString() {
       if(this.value == null){
           return "";
       }
       else{
           return this.value.toString();

       }
    }
}
