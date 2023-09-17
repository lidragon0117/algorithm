package com.lilong.代码随想录.列表转树;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author :lilong
 * @date :2023-09-16-21:39
 * @description : 列表转树
 */
public class TransFormListToTree {
    /**
     * 列表转树
     *
     * @param nodes 集合列表
     */
    public void listTransTree(List<Node> nodes) {
        //根据ID 进行分组
        Map<Integer, List<Node>> nodeMap = nodes.stream().collect(Collectors.groupingBy(Node::getParentId));
        nodes.forEach(node->node.setChildList(nodeMap.getOrDefault(node.getId(),new ArrayList<>())));
        //设置一级列表
        nodes.stream().filter(node -> "-1".equals(node.getParentId())).collect(Collectors.toList());
    }
}
