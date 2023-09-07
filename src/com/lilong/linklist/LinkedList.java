package com.lilong.linklist;

/**
 * @author :lilong
 * @date :2023/1/25-8:28
 * @description :链表
 */
public class LinkedList<E> implements List<E>{
    /**
     * 头结点
     */
    private Node<E> first;
    /**
     * 元素节点的数目
     */
    protected int size;

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        size=0;
        first=null;
    }

    /**
     * 链表的大小
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 链表是否包含指定元素
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return true;
    }

    /**
     * 链尾增加元素节点
     * @param element
     */
    @Override
    public void add(E element) {

    }

    /**
     * 获取指定及节点的元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {

        return node(index).element;
    }

    /**
     *
     * 替换指定节点元素
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        return null;
    }

    /**
     * 在指定节点位置增肌节点
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {

    }

    /**
     * 移除指定节点
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * 返回指定节点的下标index
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     * 获得某个位置的节点
     * @param index
     * @return
     */
    private Node<E> node(int index){
        //检查下标是否越界
        rangeIndex(index);
        Node<E> node=first;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    private void rangeIndex(int index) {
        if(index>size){
            runIndexOfException();
        }
    }
    private void runIndexOfException(){
        throw  new IndexOutOfBoundsException("下标越界，size="+size);
    }

    /**
     * node节点类
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }


}
