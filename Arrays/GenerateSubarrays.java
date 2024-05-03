import java.util.ArrayList;

class GenerateSubarrays {

    // Time -> O(n^3) //
    // Space -> O(n^2) //

    private static ArrayList<ArrayList<Integer>> generateSubarrays(int[] arr) {
        int n = arr.length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> subarray = new ArrayList<Integer>();

                for (int k = i; k <= j; k++) {
                    subarray.add(arr[k]);
                }

                res.add(subarray);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21 };

        System.out.println(generateSubarrays(arr));
    }
}
