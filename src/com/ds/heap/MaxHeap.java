package com.ds.heap;

public class MaxHeap extends Heap {

    public MaxHeap(int capacity) {
        super(capacity);
    }

    protected void heapifyUp() {
        int index = size - 1;

        while (hasParent(index)) {
            if (parent(index) < items[index]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            } else {
                break;
            }
        }

    }

    protected void heapifyDown() {
        int index = 0;

        while (hasLeft(index)) {
            int biggerIndex = getLeftIndex(index);
            if (hasRight(index) && left(index) < right(index)) {
                biggerIndex = getRightIndex(index);
            }
            if (items[index] < items[biggerIndex]) {
                swap(index, biggerIndex);
            }
            index = biggerIndex;
        }


    }
}

