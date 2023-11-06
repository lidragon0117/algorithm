package com.lilong.面试;

/**
 * @author :lilong
 * @date :2023-10-16-11:52
 * @description :
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: linwei
 * @Description: 你可以通过 getRootList() 方法获取到一些树的根节点, 请完成:
 * 1. 在 fillPath() 方法中编写相关代码, 为所有节点填充 path (从父节点直达该节点的路径, 包含该节点)
 * 2. 在 print() 方法中编写相关代码, 以层次遍历的方式遍历这两棵树, 结果输出到控制台, 用以查看 path 是否被正常构造
 * 两个方法的完成顺序可调换, 无硬性要求
 */
public class CiderFillPath {

    /**
     * 一个普通的树节点
     * 看一下类的结构就可以, 里面的构造方法、toString、getter、setter 都不重要
     */
    public static class TreeNode<T> {

        private Long id;

        private T content;

        private List<TreeNode<T>> children;

        private List<TreeNode<T>> path;

        public TreeNode(Long id, T content, List<TreeNode<T>> children) {
            this.id = id;
            this.content = content;
            this.children = children;
            this.path = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("content:").append(this.content);

            sb.append(", children:[")
                    .append(this.children.stream().map(TreeNode::getContent).map(String::valueOf).collect(Collectors.joining(", ")))
                    .append("]");

            sb.append(", path:[")
                    .append(this.path.stream().map(TreeNode::getContent).map(String::valueOf).collect(Collectors.joining(", ")))
                    .append("]");

            return sb.toString();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode<T>> children) {
            this.children = children;
        }

        public List<TreeNode<T>> getPath() {
            return path;
        }

        public void setPath(List<TreeNode<T>> path) {
            this.path = path;
        }
    }

    /**
     * 这个方法不重要，不用看
     * an alternative of List.of(), ensure this code can build correctly in JDK lower 11
     */
    public static <T> List<T> list(T... params) {
        return Arrays.stream(params).collect(Collectors.toList());
    }

    /**
     * 返回两颗树的根节点, 这两个树的具体构造为：
     * <p>
     * 1             7
     * 2     3       8     9
     * 4  5   6           10  11
     * 12
     */
    public static List<TreeNode<Integer>> getRootList() {
        return list(
                new TreeNode<>(1L, 1, list(
                        new TreeNode<>(2L, 2, list(
                                new TreeNode<>(4L, 4, list()),
                                new TreeNode<>(5L, 5, list())
                        )),
                        new TreeNode<>(3L, 3, list(
                                new TreeNode<>(6L, 6, list()
                                ))
                        ))
                ),
                new TreeNode<>(7L, 7, list(
                        new TreeNode<>(8L, 8, list()),
                        new TreeNode<>(9L, 9, list(
                                new TreeNode<>(10L, 10, list()),
                                new TreeNode<>(11L, 11, list(
                                        new TreeNode<>(12L, 12, list())
                                ))
                        ))
                ))
        );
    }

    /**
     * 需要完成的方法 1:
     * 为所有树节点填充 path, path 即从父节点直达该节点的路径
     * 比如在上述提供树中, id = 5 的节点对应的 path 是 [1, 2, 5]
     *
     * @param rootNodeList 一些树的根节点
     */
    public static <T> void fillPath(List<TreeNode<T>> rootNodeList) {
        for (TreeNode<T> rootNode : rootNodeList) {
            // fill path for the tree

        }
    }

    /**
     * 需要完成的方法 2:
     * 以层次遍历的方式遍历一些树, 将结果输出到控制台, 用以查看路径是否被正常构造
     *
     * @param rootNodeList 一些树的根节点
     */
    public static <T> void print(List<TreeNode<T>> rootNodeList) {
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        for (TreeNode<T> rootNode : rootNodeList) {
            queue.add(rootNode);
            while (!queue.isEmpty()) {
                TreeNode<T> poll = queue.poll();
                System.out.print(poll.content+" ");
                for (int i = 0; i < poll.children.size(); i++) {
                    queue.add(poll.children.get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<TreeNode<Integer>> rootList = getRootList();
        fillPath(rootList);
        print(rootList);
    }


}
