package com.hp.ds.heap;

public class MinHeap extends Heap {

    public MinHeap(int capacity) {
        super(capacity);
    }

    protected void heapifyUp() {
        int index = size - 1;

        while (hasParent(index)) {
            if (parent(index) > items[index]) {
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
            int smallerIndex = getLeftIndex(index);
            if (hasRight(index) && left(index) > right(index)) {
                smallerIndex = getRightIndex(index);
            }
            if (items[index] > items[smallerIndex]) {
                swap(index, smallerIndex);
            }
            index = smallerIndex;
        }


    }
}

