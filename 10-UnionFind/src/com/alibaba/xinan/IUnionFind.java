package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2019/01/26 15:12
 */
public interface IUnionFind {

    void union(int p, int q);

    boolean isConnected(int p, int q);
}
