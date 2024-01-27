/*
 * The median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value, and the median is the mean of the two
 * middle values.
 * 
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * 
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data
 * structure.
 * double findMedian() returns the median of all elements so far. Answers within
 * 10-5 of the actual answer will be accepted.
 */

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    public MedianFinder() {
        small = new PriorityQueue<Integer>((x, y) -> y - x);
        large = new PriorityQueue<Integer>();
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }

        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}

// class MedianFinder {
// static final int MIN_VAL = -100000;
// static final int MAX_VAL = 100000;
// int[] numberCount = new int[MAX_VAL - MIN_VAL + 2];
// int medianIndex = -1;
// int medianPosInCount = -1;
// int left = -1;
// int right = -1;

// public MedianFinder() {

// }

// public void addNum(int num) {
// int index = num - MIN_VAL;
// numberCount[index]++;

// if (medianIndex == -1) {
// medianIndex = index;
// medianPosInCount = 0;
// left = 0;
// right = 0;
// } else if (index < medianIndex) {
// left++;
// } else if (index > medianIndex) {
// right++;
// } else {
// right++;
// }

// if (right - left > 1) {
// moveUp();
// right--;
// left++;
// }

// if (left - right > 1) {
// moveDown();
// left--;
// right++;
// }
// }

// private void moveUp() {
// medianPosInCount++;
// if (medianPosInCount >= numberCount[medianIndex]) {
// medianIndex++;
// medianPosInCount = -1;
// moveUp();
// }
// }

// private void moveDown() {
// medianPosInCount--;
// if (medianPosInCount < 0) {
// medianIndex--;
// medianPosInCount = numberCount[medianIndex];
// moveDown();
// }
// }

// public double findMedian() {
// if (left == right) {
// return medianIndex + MIN_VAL;
// } else if (left < right) {
// int first = medianIndex + MIN_VAL;
// int second = getNext(medianIndex, medianPosInCount) + MIN_VAL;
// return (first + second) / 2.0;
// } else {
// int first = medianIndex + MIN_VAL;
// int previous = getPrev(medianIndex, medianPosInCount) + MIN_VAL;
// return (first + previous) / 2.0;
// }

// }

// private int getNext(int index, int position) {
// position++;
// if (position >= numberCount[index]) {
// index++;
// position = -1;
// return getNext(index, position);
// }
// return index;
// }

// private int getPrev(int index, int position) {
// position--;
// if (position < 0) {
// index--;
// position = numberCount[index];
// return getPrev(index, position);
// }
// return index;
// }
// }
