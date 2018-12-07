package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/12/7 16:18
 */
public interface Map<K, V> {

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();

    boolean containsKey(K key);

    boolean isEmpty();
}
