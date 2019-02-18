package com.alibaba.xinan;

/**
 * Quick find
 *
 * @author XinAnzzZ
 * @date 2019/2/11 10:39
 */
public class UnionFind1 implements IUnionFind {

    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /*** 查找元素p所对应的集合编号 */
    private int find(int p) {
        if (p < 0 || p > id.length) {
            throw new IllegalArgumentException();
        }
        return id[p];
    }
}
