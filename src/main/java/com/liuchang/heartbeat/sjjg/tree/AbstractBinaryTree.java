package com.liuchang.heartbeat.sjjg.tree;

import com.liuchang.heartbeat.sjjg.tree.expection.NodeNotContainExpection;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 17:02 2020/1/9
 * @ Description：
 * @ Modified By：
 */
public abstract class AbstractBinaryTree {
    /**
     * 节点数量
     */
     long nodeSize;
    /**
     * 树深度
     */
     long treeDepth;
    /**
     * 根节点
     */
     BinaryTreeNode rootNode;

    /**
     * 设置根节点
     * @param rootNode
     * @return
     */
    public boolean setRootNode(BinaryTreeNode rootNode) {
        if(this.rootNode != null){
            return false;
        }
        this.rootNode = rootNode;
        if(rootNode!=null){
            nodeSize++;
        }
        return true;
    }

    /**
     * 获取根节点
     * @return
     */
    public BinaryTreeNode getRootNode(){
        return rootNode;
    }

    /**
     * 获取接点数量
     * @return
     */
    public long getNodeSize(){
        return nodeSize;
    }

    /**
     * 获取树深度
     * @return
     */
    public long getTreeDepth(){
        return getTreeDepth(rootNode);
    }
    private long getTreeDepth(BinaryTreeNode treeNode){
        List<BinaryTreeNode> resultList = new ArrayList<>();
        resultList.add(treeNode);
        while(resultList.size()!=0){
            this.treeDepth++;
            resultList = getAllLeafs(resultList);
        }
        return this.treeDepth;
    }

    private List<BinaryTreeNode> getAllLeafs(List<BinaryTreeNode> list){
        if(list == null&&list.size()==0){
            return null;
        }
        List<BinaryTreeNode> resultList = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getLeftTreeNode()!=null){
                resultList.add(list.get(i).getLeftTreeNode());
            }
            if(list.get(i).getRightTreeNode()!=null){
                resultList.add(list.get(i).getRightTreeNode());
            }
        }
        return resultList;
    }

    /**
     * 是否包括某节点
     * @param treeNode
     * @return
     */
    public boolean contains(BinaryTreeNode treeNode){
        if(rootNode == null||treeNode == null){
            return false;
        }
        return this.containsNew(rootNode,treeNode);
    }

    private boolean containsNew(BinaryTreeNode paramTreeNode,BinaryTreeNode treeNode){
        if(paramTreeNode == null){
            return false;
        }
        return paramTreeNode.equals(treeNode)||this.containsNew(paramTreeNode.getLeftTreeNode(),treeNode)||this.containsNew(paramTreeNode.getRightTreeNode(),treeNode);
    }


    /**
     * 删除某节点左节点
     * @param treeNode
     * @return
     */
    public abstract boolean delLeftNode(BinaryTreeNode treeNode);
    /**
     * 删除某节点右节点
     * @param treeNode
     * @return
     */
    public abstract boolean delRightNode(BinaryTreeNode treeNode);

    @Override
    public String toString() {
        return toTreeString(rootNode);
    }
    /**
     * 获取第n层节点的string，为了tostring用
     * @param
     * @return
     */
    private String toTreeString(BinaryTreeNode treeNode){
        if(treeNode == null){
            return "[]";
        }
        else{
            if(treeNode.getLeftTreeNode()==null&&treeNode.getRightTreeNode()==null){
                return "["+treeNode.toString()+"]";
            }
            else{
                return "["+treeNode.toString()+toTreeString(treeNode.getLeftTreeNode())+toTreeString(treeNode.getRightTreeNode())+"]";
            }
        }
    }

    /**
     * 中序遍历先遍历左节点
     * @return
     */
    public List<BinaryTreeNode> leftErgodic(){
        List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
        return leftErgodic(rootNode,binaryTreeNodes);
    }
    private List<BinaryTreeNode> leftErgodic(BinaryTreeNode treeNode,List<BinaryTreeNode> binaryTreeNodes){
        if(treeNode == null){
            return binaryTreeNodes;
        }
        leftErgodic(treeNode.getLeftTreeNode(),binaryTreeNodes);
        binaryTreeNodes.add(treeNode);
        leftErgodic(treeNode.getRightTreeNode(),binaryTreeNodes);
        return binaryTreeNodes;
    }
    /**
     * 中序遍历先遍历右节点
     * @return
     */
    public List<BinaryTreeNode> rightErgodic(){
        List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
        return rightErgodic(rootNode,binaryTreeNodes);
    }

    private List<BinaryTreeNode> rightErgodic(BinaryTreeNode treeNode,List<BinaryTreeNode> binaryTreeNodes){
        if(treeNode == null){
            return binaryTreeNodes;
        }
        rightErgodic(treeNode.getRightTreeNode(),binaryTreeNodes);
        binaryTreeNodes.add(treeNode);
        rightErgodic(treeNode.getLeftTreeNode(),binaryTreeNodes);
        return binaryTreeNodes;
    }
    /**
     * 先序遍历
     * @return
     */
    public List<BinaryTreeNode> preErgodic(){
        List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
        return preErgodic(rootNode,binaryTreeNodes);
    }

    private List<BinaryTreeNode> preErgodic(BinaryTreeNode treeNode,List<BinaryTreeNode> binaryTreeNodes){
        if(treeNode == null){
            return binaryTreeNodes;
        }
        binaryTreeNodes.add(treeNode);
        preErgodic(treeNode.getLeftTreeNode(),binaryTreeNodes);
        preErgodic(treeNode.getRightTreeNode(),binaryTreeNodes);
        return binaryTreeNodes;
    }
    /**
     * 后序遍历
     * @return
     */
    public List<BinaryTreeNode> afterErgodic(){
        List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
        return afterErgodic(rootNode,binaryTreeNodes);
    }

    private List<BinaryTreeNode> afterErgodic(BinaryTreeNode treeNode,List<BinaryTreeNode> binaryTreeNodes){
        if(treeNode == null){
            return binaryTreeNodes;
        }
        afterErgodic(treeNode.getLeftTreeNode(),binaryTreeNodes);
        afterErgodic(treeNode.getRightTreeNode(),binaryTreeNodes);
        binaryTreeNodes.add(treeNode);
        return binaryTreeNodes;
    }

    /**
     * 删除某节点
     * @return
     */
    abstract boolean delNode(Object value) throws NodeNotContainExpection;

    /**
     * 增加某节点
     * @return
     */
    abstract boolean addNode(Object value);






}
