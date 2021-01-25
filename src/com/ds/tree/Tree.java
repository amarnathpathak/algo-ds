package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    protected T value;
    protected List<Tree> childs;

    public Tree() {
        childs = new ArrayList<Tree>();
    }

    public Tree(T value) {
        this();
        this.value = value;
    }

    public Tree(T value, List<Tree> childs) {
        this();
        this.value = value;
        if (childs != null) {
            this.childs.addAll(childs);
        }

    }

    public void addChild(Tree tree) {
        this.childs.add(tree);
    }


}
