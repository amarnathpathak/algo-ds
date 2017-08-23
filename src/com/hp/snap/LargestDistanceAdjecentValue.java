package com.hp.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LargestDistanceAdjecentValue {
    public int getDistance(final int[] A) {
        List<BubbleIndex> bIndexs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            bIndexs.add(new BubbleIndex(A[i], i, i));
        }
        Collections.sort(bIndexs, NumberComparator);
        for (int i = 0; i < A.length - 1; i++) {
            BubbleIndex left = bIndexs.get(i);
            BubbleIndex right = bIndexs.get(i + 1);
            if (left.getNumber().equals(right.getNumber())) {
                if (left.getMinIndex() < right.getMinIndex()) {
                    right.setMinIndex(left.getMinIndex());
                }
                if (left.getMaxIndex() > right.getMaxIndex()) {
                    right.setMaxIndex(left.getMaxIndex());
                }
                left.setDeleted(true);
            }
        }
        int maxDistince = -1;
        Iterator<BubbleIndex> biItr = bIndexs.iterator();
        for (int i = 0; i < A.length - 1; i++) {
            BubbleIndex left = bIndexs.get(i);
            BubbleIndex right = bIndexs.get(i + 1);
            if (!left.isDeleted() && !right.isDeleted()) {
                if (maxDistince < Math.abs(left.getMinIndex() - right.getMaxIndex())) {
                    maxDistince = Math.abs(left.getMinIndex() - right.getMaxIndex());
                }
            }
        }
        return maxDistince;
    }

    public static Comparator<BubbleIndex> NumberComparator = new Comparator<BubbleIndex>() {

        @Override
        public int compare(BubbleIndex o1, BubbleIndex o2) {
            return o1.getNumber().compareTo(o2.getNumber());

        }
    };

}
