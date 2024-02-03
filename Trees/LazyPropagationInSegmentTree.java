public class LazyPropagationInSegmentTree {
    public int[] segmentTree;
    public int[] lazyTree;

    LazyPropagationInSegmentTree(int[] arr) {
        int n = arr.length;
        segmentTree = new int[4 * n];
        lazyTree = new int[4 * n];
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

    public void update(int index, int low, int high, int left, int right, int value) {
        if (lazyTree[index] != 0) {
            segmentTree[index] += (high - low + 1) * lazyTree[index];
            // Min Query -> segmentTree[index] += lazyTree[index] //

            if (low != high) {
                lazyTree[2 * index + 1] += lazyTree[index];
                lazyTree[2 * index + 2] += lazyTree[index];
            }
            lazyTree[index] = 0;
        }

        if (right < low || high < left) {
            return;
        }

        if (low >= left && high <= right) {
            segmentTree[index] += (high - low + 1) * value;
            // Min Query -> segmentTree[index] += value //

            if (low != high) {
                lazyTree[2 * index + 1] += value;
                lazyTree[2 * index + 2] += value;
            }
            return;
        }

        int middle = low + (high - low) / 2;

        update(2 * index + 1, low, middle, left, right, value);
        update(2 * index + 2, middle + 1, high, left, right, value);

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
        // Min Query -> Math.min() //
    }

    public int query(int index, int low, int high, int queryLeft, int queryRight) {
        if (lazyTree[index] != 0) {
            segmentTree[index] += (high - low + 1) * lazyTree[index];
            // Min Query -> segmentTree[index] += lazyTree[index] //

            if (low != high) {
                lazyTree[2 * index + 1] += lazyTree[index];
                lazyTree[2 * index + 2] += lazyTree[index];
            }
            lazyTree[index] = 0;
        }

        if (queryRight < low || high < queryLeft) {
            return 0;
            // Min Query -> Integer.MAX_VALUE //
        }

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

        LazyPropagationInSegmentTree segmentTree = new LazyPropagationInSegmentTree(arr);

        segmentTree.buildSegmentTree(arr, 0, 0, n - 1);

        System.out.println(segmentTree.query(0, 0, n - 1, 1, 4));

        segmentTree.update(0, 0, n - 1, 2, 4, 5);

        System.out.println(segmentTree.query(0, 0, n - 1, 1, 4));
    }
}
