package com.ddstudy.ds;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 创建一颗哈夫曼树（二叉树结构）。
 * 哈夫曼树介绍 https://zhuanlan.zhihu.com/p/127021911
 */
@SuppressWarnings("all")
public class CreateHuffmanBinaryTree {

    static class Node implements Comparable<Node> {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this(val, null, null);
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            //从小到大排序
            return this.val - o.val;
        }
    }

    /**
     * 回一下手动计算哈夫曼树的过程。
     * 每次都找待合并节点中权值最小的两个点，把它们合并，然后把合并后的节点添加到待合并的点中。
     *
     * @param arr
     * @return
     */
    public Node createHuffman(int... arr) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int element : arr) {
            queue.add(new Node(element));
        }
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node(left.val + right.val, left, right);
            queue.add(parent);
        }
        return queue.poll();
    }


    /**
     * 层序遍历
     *
     * @param node
     */
    public void layerOrder(Node node) {
        if (node == null) throw new IllegalArgumentException("输入为空");
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int curLayerCount = queue.size(); // 获得当前层的节点个数
            for (int i = 0; i < curLayerCount; i++) {
                Node cur = queue.poll();
                System.out.format("%s \t", cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CreateHuffmanBinaryTree createHuffmanBinaryTree = new CreateHuffmanBinaryTree();
        Node huffman = createHuffmanBinaryTree.createHuffman(13, 7, 8, 3, 29, 6, 1);
        createHuffmanBinaryTree.layerOrder(huffman);
    }
}
