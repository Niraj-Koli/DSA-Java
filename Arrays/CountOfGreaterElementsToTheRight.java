/*
 * You are given an array 'arr' of length 'N'.
 * 
 * You are given 'Q' queries, and for each query, you are given an index(0-based
 * indexing).
 * 
 * Answer to each query is the number of the strictly greater elements to the
 * right of the given index element.
 * 
 * You must return an array 'answer' of length ’N’, where ‘answer[i]’ is the
 * answer to the ‘ith’ query.
 */

class CountOfGreaterElementsToTheRight {

    // Time -> O(n * m) //
    // Space -> O(m) //

    private static int[] countGreater(int[] nums, int[] query) {
        int n = nums.length;
        int m = query.length;

        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            int queryIndex = query[i];

            for (int j = queryIndex + 1; j < n; j++) {
                if (nums[j] > nums[queryIndex]) {
                    res[i]++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 6, 5, 8, 9, 13, 4 };
        int[] query = { 0, 1, 5 };

        int[] ans = countGreater(nums, query);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}