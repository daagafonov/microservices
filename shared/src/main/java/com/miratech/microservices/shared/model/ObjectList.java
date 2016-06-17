package com.miratech.microservices.shared.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectList<T> {

    private List<T> list;

    public ObjectList() {

    }

    public ObjectList(List<T> list) {
        getList().addAll(list);
    }

    public List<T> getList() {
        if (list == null) {
            list = new ArrayList<T>();
        }
        return list;
    }

    public void add(T obj) {
        getList().add(obj);
    }

    public void clear() {
        getList().clear();
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
