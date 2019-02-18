package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2019/2/11 13:03
 */
public class UnionFind2 implements IUnionFind {

    private int[] parent;

    /**
     * 这个 rank 是存储已当前节点为根的每颗树的高度
     */
    private int[] rank;

    public UnionFind2(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 如果p树的rank数更少，也就是树的高度更低，就将p树的根指向q树，反之，将q树的根指向p树
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[pRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /*** 找到节点 p 所在的树的根 */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException();
        }

        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
