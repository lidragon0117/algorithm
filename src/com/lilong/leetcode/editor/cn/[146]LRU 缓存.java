package com.lilong.leetcode.editor.cn;

class LRUCache {
    //定制结点
    class Node{
        int key;
        int value;
        Node next;
        Node pre;
        public Node(){

        }
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }

    }
    Map<Integer ,Node> cache=new HashMap<>();
    private int size;
    private int capacity;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        this.head=new Node();
        this.tail=new Node();
        this.head.next=tail;
        tail.pre=head;

    }

    public int get(int key) {
        Node node=cache.get(key);
        if(node==null){
            return -1;
        }
        // 将节点间移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node=cache.get(key);
        if(node==null){
            //不存在的话就创建
            Node nodeNew =new Node(key,value);
            //添加到hash表中
            cache.put(key,nodeNew);
            //添加到双向链表
            addToHead(nodeNew);
            size++;
            if(size>capacity){
                // 表示超出容量了 就得讲最后一个删除，删除缓存中
                Node nodeTail=removeNodeByTail();
                cache.remove(nodeTail.key);
                size--;
            }
        }else{
            // 表示已经存在 直接将该值移到头部
            node.value=value;
            //移动到头部
            moveToHead(node);
        }
    }
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private void addToHead(Node node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    private Node removeNodeByTail(){
        Node node=tail.pre;
        removeNode(tail.pre);
        return node;
    }
    private void removeCacheByKey(){

    }
    public void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
