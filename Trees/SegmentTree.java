public class SegmentTree {
    public int[] segmentTree;

    SegmentTree(int[] arr) {
        int n = arr.length;
        segmentTree = new int[4 * n];
    }

    public void buildSegmentTree(int[] arr, int index, int low, int high) {
        if (low == high) {
            segmentTree[index] = arr[low];
            return;
        }

        int middle = low + (high - low) / 2;

        buildSegmentTree(arr, 2 * index + 1, low, middle);
        buildSegmentTree(arr, 2 * index + 2, middle + 1, high);

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
        // Min Query -> Math.min() //
    }

    public void update(int index, int low, int high, int updateIndex, int value) {
        if (low == high) {
            segmentTree[index] = value;
            return;
        }

        int middle = low + (high - low) / 2;

        if (updateIndex <= middle) {
            update(2 * index + 1, low, middle, updateIndex, value);
        } else {
            update(2 * index + 2, middle + 1, high, updateIndex, value);
        }

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
        // Min Query -> Math.min() //
    }

    public int query(int index, int low, int high, int queryLeft, int queryRight) {
        if (queryRight < low || high < queryLeft) {
            return 0;
        }
        // Min Query -> Integer.MAX_VALUE //

        if (low >= queryLeft && high <= queryRight) {
            return segmentTree[index];
        }

        int middle = low + (high - low) / 2;

        int left = query(2 * index + 1, low, middle, queryLeft, queryRight);
        int right = query(2 * index + 2, middle + 1, high, queryLeft, queryRight);

        return left + right;
        // Min Query -> Math.min() //
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 7, 9, 11 };
        int n = arr.length;

        SegmentTree segmentTree = new SegmentTree(arr);

        segmentTree.buildSegmentTree(arr, 0, 0, n - 1);

        System.out.println(segmentTree.query(0, 0, n - 1, 1, 4));

        segmentTree.update(0, 0, n - 1, 2, 5);

        System.out.println(segmentTree.query(0, 0, n - 1, 1, 4));
    }
}