package com.hp.snap;

public class BubbleIndex extends Bubble {
    private int minIndex;
    private int maxIndex;
    private boolean deleted = false;

    public BubbleIndex(int number, int minIndex, int maxIndex) {
        super(number);
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BubbleIndex [number=" + getNumber() + ", minIndex=" + minIndex + ", maxIndex=" + maxIndex + "]";
    }

    

}
