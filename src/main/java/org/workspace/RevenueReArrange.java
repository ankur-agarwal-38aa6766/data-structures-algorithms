package org.workspace;

import java.util.Deque;
import java.util.LinkedList;

public class RevenueReArrange {
    public int solution(int[] A) {
        Deque<Integer> src = new LinkedList<>();
        for (int value : A) {
            src.add(value);
        }

        Deque<Integer> dest = new LinkedList<>();
        long sum = 0;
        int count = 0;
        int v;
        while (!src.isEmpty()) {
            v = src.peekFirst();
            if (sum + v < 0) {
                if (dest.isEmpty() || dest.peekLast() > v)
                    src.addLast(src.removeFirst());
                else {
                    v = dest.removeLast();
                    src.addLast(v);
                    sum -= v;
                }
                ++count;
            } else {
                v = src.removeFirst();
                dest.add(v);
                sum += v;
            }
        }

        return count;
    }
}
