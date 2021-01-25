package com.ds.heap;

public abstract class Heap {

    protected int[] items;
    protected int size;
    protected int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity + 1];
        this.size = 0;
    }

    public int peek() {
        if (size <= 0)
            throw new RuntimeException();

        return items[0];
    }

    public int poll() {
        int item = peek();
        items[0] = items[--size];
        heapifyDown();
        return item;
    }

    public void add(int item) {
        if (size == capacity) throw new RuntimeException();
        items[size++] = item;
        heapifyUp();
    }

    protected int getParentIndex(int index) {
        return index % 2 == 0 ? (index / 2) - 1 : index / 2;
    }

    protected boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    protected int parent(int index) {
        return items[getParentIndex(index)];
    }

    protected int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    protected boolean hasLeft(int index) {
        return getLeftIndex(index) <= size;
    }

    protected int left(int index) {
        return items[getLeftIndex(index)];
    }


    protected int getRightIndex(int index) {
        return 2 * index + 2;
    }

    protected boolean hasRight(int index) {
        return getRightIndex(index) <= size;
    }

    protected int right(int index) {
        return items[getRightIndex(index)];
    }


    protected abstract void heapifyUp();

    protected abstract void heapifyDown();

    protected void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }


}
