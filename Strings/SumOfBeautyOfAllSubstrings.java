/*
 * The beauty of a string is the difference in frequencies between the most
 * frequent and least frequent characters.
 * 
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 */

class SumOfBeautyOfAllSubstrings {

    // Time -> O(n^2) //
    // Space -> O(1) //

    private static int beauty(int[] bucket) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) {
                continue;
            }

            min = Math.min(min, bucket[i]);
            max = Math.max(max, bucket[i]);
        }

        return max - min;
    }

    private static int beautySum(String s) {
        int n = s.length();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] bucket = new int[26];

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                bucket[ch - 'a']++;
                sum += beauty(bucket);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "aabcbaa";

        System.out.println(beautySum(s));
    }
}