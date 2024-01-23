import java.util.ArrayList;
import java.util.List;

public class GenerateSubarrays {
    public static List<List<Integer>> generateSubarrays(int[] arr) {
        int n = arr.length;

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> subarray = new ArrayList<Integer>();
                for (int k = i; k <= j; k++) {
                    subarray.add(arr[k]);
                }
                res.add(subarray);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21, 47, 73 };

        List<List<Integer>> ans = generateSubarrays(arr);

        System.out.println(ans);
    }
}
