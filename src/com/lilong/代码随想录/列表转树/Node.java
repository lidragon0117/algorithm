package com.lilong.代码随想录.列表转树;

import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-16-21:39
 * @description : 列表转树节点
 */
public class Node {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }

    /**
     * 本节点
     */
    private Integer id;

    /**
     * 指向父id
     */
    private Integer parentId;

    private String name;

    private List<Node> childList;

}
