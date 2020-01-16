package com.liuchang.heartbeat.sjjg.tree;

import com.liuchang.heartbeat.sjjg.tree.expection.NodeNotContainExpection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:55 2020/1/9
 * @ Description：
 * @ Modified By：
 */
public class SortBinaryTree<T> extends AbstractBinaryTree {
    /**
     * 构造一棵空有序二叉树
     */
    public SortBinaryTree() {
//        this(null);
    }

    /**
     * 初始化一棵带根节点的有序树
     *
     * @param rootNode
     */
    public SortBinaryTree(BinaryTreeNode<Comparable<T>> rootNode) {
        this.rootNode = rootNode;
        if (rootNode != null) {
            nodeSize++;
        }
    }
    /**
     * 添加一个元素
     *
     * @param value
     * @return
     */
    @Override
    public boolean addNode(Object value) {
        try {
            if (this.nodeSize == 0) {
                BinaryTreeNode binaryTreeNode = new BinaryTreeNode(value);
                this.rootNode = binaryTreeNode;
                nodeSize++;
                treeDepth++;
                return true;
            } else {
                if (addValue(rootNode, (Comparable<T>)value))
                    nodeSize++;
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 以binaryTreeNode为根添加value
     *
     * @param binaryTreeNode
     * @param value
     * @return
     */
    private boolean addValue(BinaryTreeNode binaryTreeNode, Comparable<T> value) {
        if (value.compareTo((T) binaryTreeNode.getValue()) == 1) {
            if (binaryTreeNode.getRightTreeNode() != null) {
                return addValue(binaryTreeNode.getRightTreeNode(), value);
            } else {
                binaryTreeNode.setRightTreeNode(new BinaryTreeNode(value));
                return true;
            }
        } else if (value.compareTo((T) binaryTreeNode.getValue()) == -1) {
            if (binaryTreeNode.getLeftTreeNode() != null) {
                return addValue(binaryTreeNode.getLeftTreeNode(), value);
            } else {
                binaryTreeNode.setLeftTreeNode(new BinaryTreeNode(value));
                return true;
            }
        } else {
            return false;
        }

    }

    /**
     * 树是否包含这个值
     *
     * @param value
     * @return
     */
    public boolean containsValue(Comparable<T> value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (rootNode == null) {
            return false;
        } else {
            return containsValueFromNode(rootNode, value);
        }
    }

    /**
     * 以binaryTreeNode为起始找binaryTreeNode的子节点或它本身是否包含value
     *
     * @param binaryTreeNode
     * @param value
     * @return
     */
    private boolean containsValueFromNode(BinaryTreeNode binaryTreeNode, Comparable<T> value) {
        if (value.compareTo((T) binaryTreeNode.getValue()) == 0) {
            return true;
        } else {
            if (value.compareTo((T) binaryTreeNode.getValue()) == -1) {
                return binaryTreeNode.getLeftTreeNode() != null && containsValueFromNode(binaryTreeNode.getLeftTreeNode(), value);
            } else {
                return binaryTreeNode.getRightTreeNode() != null && containsValueFromNode(binaryTreeNode.getRightTreeNode(), value);
            }
        }
    }

    /**
     * 获得从根到BinaryTreeNode的路径List
     *
     * @param value
     * @return
     */
    public List<BinaryTreeNode> getNodeLine(Comparable<T> value) throws NodeNotContainExpection {
        if (value == null) {
            throw new NullPointerException();
        }
        if (rootNode == null) {
            throw new NodeNotContainExpection("this node is not in this tree");
        }
        List<BinaryTreeNode> resultList = new ArrayList<>();
        return getNodeLine(rootNode, value, resultList);
    }

    private List<BinaryTreeNode> getNodeLine(BinaryTreeNode binaryTreeNode, Comparable<T> value, List<BinaryTreeNode> result) {
        if (value.compareTo((T) binaryTreeNode.getValue()) == 0) {
            return result;
        } else {
            if (value.compareTo((T) binaryTreeNode.getValue()) == -1) {
                if (binaryTreeNode.getLeftTreeNode() != null) {
                    result.add(binaryTreeNode);
                    getNodeLine(binaryTreeNode.getLeftTreeNode(), value, result);
                    return result;
                }
            } else {
                if (binaryTreeNode.getRightTreeNode() != null) {
                    result.add(binaryTreeNode);
                    getNodeLine(binaryTreeNode.getRightTreeNode(), value, result);
                    return result;
                }
            }
            return null;
        }
    }

    /**
     * 通过value值获得树节点对象
     *
     * @param value
     * @return
     */
    public BinaryTreeNode getNodeByValue(Comparable<T> value) throws NodeNotContainExpection {
        if (value == null) {
            throw new NullPointerException();
        }
        if (rootNode == null) {
            return null;
        } else {
            return getNodeByValue(rootNode,value);
        }
    }

    /**
     * 从binaryTreeNode开始
     *
     * @param binaryTreeNode
     * @param value
     * @return
     */
    private BinaryTreeNode getNodeByValue(BinaryTreeNode binaryTreeNode, Comparable<T> value) throws NodeNotContainExpection {
        if (binaryTreeNode == null) {
            throw new NodeNotContainExpection("this node is not in this tree");
        }
        if (value.compareTo((T) binaryTreeNode.getValue()) == 0) {
            return binaryTreeNode;
        } else {
            if(value.compareTo((T) binaryTreeNode.getValue()) == -1){
                return getNodeByValue(binaryTreeNode.getLeftTreeNode(), value);
            }
            else{
                return getNodeByValue(binaryTreeNode.getRightTreeNode(), value);
            }
        }
    }
    /**
     * 删除一个节点
     * 情况1：删除的当前节点无左右孩子节点，那么就直接将当前要删除的节点设置为null即可。
     * 情况2：删除的当前节点无左孩子节点，有右孩子节点，那么就将当前要删除的节点设置为右孩子节点即可。
     * 情况3：删除的当前节点无右孩子节点，有左孩子节点，那么就将当前要删除的节点设置为左孩子节点即可。
     * 情况4：删除的当前节点有右孩子节点也有左孩子节点，那么就选出右孩子树中最小的点，设置为当前要删除的节点即可。这种方式既可以保证二叉排序树的性质，由于右孩子树中最小的点，无左孩子节点（如果有左孩子节点，那么就不符合二叉树性质了）。
     * @param value
     * @return
     */
    @Override
    public boolean delNode(Object value) throws NodeNotContainExpection {
        if(value == null){
            throw new NullPointerException();
        }
        BinaryTreeNode binaryTreeNode = getNodeByValue((Comparable<T>) value);
        if(binaryTreeNode == null){
            throw new NodeNotContainExpection("this node is not in this tree");
        }
        //删除的当前节点无左右孩子节点，那么就直接将当前要删除的节点设置为null即可。
        if (binaryTreeNode.getLeftTreeNode()==null&&binaryTreeNode.getRightTreeNode()==null) {
            BinaryTreeNode parentBinaryTreeNode = getParentNode((Comparable<T>)value);
            if(parentBinaryTreeNode != null){
                if(parentBinaryTreeNode.getLeftTreeNode().equals(binaryTreeNode)){
                    parentBinaryTreeNode.setLeftTreeNode(null);
                }
                else{
                    parentBinaryTreeNode.setRightTreeNode(null);
                }
            }
            binaryTreeNode = null;
            nodeSize--;
            return true;
        }
        if (binaryTreeNode.getLeftTreeNode()!=null&&binaryTreeNode.getRightTreeNode()==null){
            BinaryTreeNode parentBinaryTreeNode = getParentNode((Comparable<T>) value);
            parentBinaryTreeNode.setLeftTreeNode(binaryTreeNode.getLeftTreeNode());
            binaryTreeNode = null;
            nodeSize--;
            return true;
        }
        if(binaryTreeNode.getRightTreeNode()!=null&&binaryTreeNode.getLeftTreeNode()==null){
            BinaryTreeNode parentBinaryTreeNode = getParentNode((Comparable<T>)value);
            parentBinaryTreeNode.setRightTreeNode(binaryTreeNode.getRightTreeNode());
            binaryTreeNode = null;
            nodeSize--;
            return true;
        }
        //Comparable<T> rightValue = (Comparable<T>) binaryTreeNode.getRightTreeNode().getValue();
        BinaryTreeNode minNode = getNextNode((Comparable<T>)value);
        Comparable<T> minValue = (Comparable<T>)minNode.getValue();
        if(delNode(minValue)){
            binaryTreeNode.setValue(minValue);
            nodeSize--;
            return true;
        }
        return false;
    }

//    /**
//     * 删除一个节点
//     * 情况1：删除的当前节点无左右孩子节点，那么就直接将当前要删除的节点设置为null即可。
//     * 情况2：删除的当前节点无左孩子节点，有右孩子节点，那么就将当前要删除的节点设置为右孩子节点即可。
//     * 情况3：删除的当前节点无右孩子节点，有左孩子节点，那么就将当前要删除的节点设置为左孩子节点即可。
//     * 情况4：删除的当前节点有右孩子节点也有左孩子节点，那么就选出右孩子树中最小的点，设置为当前要删除的节点即可。这种方式既可以保证二叉排序树的性质，由于右孩子树中最小的点，无左孩子节点（如果有左孩子节点，那么就不符合二叉树性质了）。
//     * @param value
//     * @return
//     */
//    @Override
//    public boolean delNode(Comparable<T> value) throws NodeNotContainExpection {
//        if(value == null){
//            throw new NullPointerException();
//        }
//        BinaryTreeNode binaryTreeNode = getNodeByValue(value);
//        if(binaryTreeNode == null){
//            throw new NodeNotContainExpection("this node is not in this tree");
//        }
//        //删除的当前节点无左右孩子节点，那么就直接将当前要删除的节点设置为null即可。
//        if (binaryTreeNode.getLeftTreeNode()==null&&binaryTreeNode.getRightTreeNode()==null) {
//            BinaryTreeNode parentBinaryTreeNode = getParentNode(value);
//            if(parentBinaryTreeNode != null){
//                if(parentBinaryTreeNode.getLeftTreeNode().equals(binaryTreeNode)){
//                    parentBinaryTreeNode.setLeftTreeNode(null);
//                }
//                else{
//                    parentBinaryTreeNode.setRightTreeNode(null);
//                }
//            }
//            binaryTreeNode = null;
//            nodeSize--;
//            return true;
//        }
//        if (binaryTreeNode.getLeftTreeNode()!=null&&binaryTreeNode.getRightTreeNode()==null){
//            BinaryTreeNode parentBinaryTreeNode = getParentNode(value);
//            parentBinaryTreeNode.setLeftTreeNode(binaryTreeNode.getLeftTreeNode());
//            binaryTreeNode = null;
//            nodeSize--;
//            return true;
//        }
//        if(binaryTreeNode.getRightTreeNode()!=null&&binaryTreeNode.getLeftTreeNode()==null){
//            BinaryTreeNode parentBinaryTreeNode = getParentNode(value);
//            parentBinaryTreeNode.setRightTreeNode(binaryTreeNode.getRightTreeNode());
//            binaryTreeNode = null;
//            nodeSize--;
//            return true;
//        }
//        //Comparable<T> rightValue = (Comparable<T>) binaryTreeNode.getRightTreeNode().getValue();
//        BinaryTreeNode minNode = getNextNode(value);
//        Comparable<T> minValue = (Comparable<T>)minNode.getValue();
//        if(delNode(minValue)){
//            binaryTreeNode.setValue(minValue);
//            nodeSize--;
//            return true;
//        }
//        return false;
//    }

    /**
     * 获取某节点的后继节点
     *
     * @param value
     * @return
     */
    public BinaryTreeNode getNextNode(Comparable<T> value) throws NodeNotContainExpection {
        BinaryTreeNode node = getNodeByValue(value);
        if (node != null) {
            if (node.getRightTreeNode() == null) {
                BinaryTreeNode parentNode = getParentNode(value);
                if (getParentNode(value) == null || value.compareTo((T) parentNode.getValue()) == 1) {
                    return null;
                }
                return parentNode;
            } else {
                BinaryTreeNode paramNode = node.getRightTreeNode();
                while (paramNode != null && paramNode.getLeftTreeNode() != null) {
                    paramNode = paramNode.getLeftTreeNode();
                }
                return paramNode;
            }
        }
        throw new NodeNotContainExpection("this node is not in this tree");
    }

    /**
     * 找出以node为根的最小值的节点
     *
     * @param node
     * @return
     */
    private BinaryTreeNode getMinFromNode(BinaryTreeNode node) throws NodeNotContainExpection {
        if (node.getLeftTreeNode() == null) {
            return node;
        } else {
            return getMinFromNode(node.getLeftTreeNode());
        }
    }

    /**
     * 获得某节点的父节点
     *
     * @param value
     * @return
     * @throws NodeNotContainExpection
     */
    public BinaryTreeNode getParentNode(Comparable<T> value) throws NodeNotContainExpection {
        if (value == null) {
            throw new NullPointerException();
        }
        if (rootNode == null) {
            throw new NodeNotContainExpection("this node is not in this tree");
        }
        if (value.compareTo((T) rootNode.getValue()) == 0) {
            return null;
        } else {
            List<BinaryTreeNode> list = getNodeLine(value);
            return list.get(list.size() - 1);
        }
    }


    @Override
    public boolean delLeftNode(BinaryTreeNode treeNode) {

        return false;
    }

    @Override
    public boolean delRightNode(BinaryTreeNode treeNode) {
        return false;
    }
}
