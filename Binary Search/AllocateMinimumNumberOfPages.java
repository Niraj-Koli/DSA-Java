/*
 * Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of
 * pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is
 * to allocate all the books to the students.
 * Allocate books in such a way that:
 * 
 * Each student gets at least one book.
 * Each book should be allocated to only one student.
 * Book allocation should be in a contiguous manner.
 * You have to allocate the book to ‘m’ students such that the maximum number of
 * pages assigned to a student is minimum. If the allocation of books is not
 * possible. return -1
 */

class AllocateMinimumNumberOfPages {

    // Time -> O(n * log(sum - max + 1)) //
    // Space -> O(1) //

    private static int countStudents(int[] pages, int threshold) {
        int n = pages.length;

        int students = 1;
        int pagesAssigned = 0;

        for (int i = 0; i < n; i++) {
            if (pagesAssigned + pages[i] > threshold) {
                students++;
                pagesAssigned = 0;
            }

            pagesAssigned += pages[i];
        }

        return students;
    }

    private static int findPages(int[] pages, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int page : pages) {
            left = Math.max(left, page);
            right += page;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int students = countStudents(pages, mid);

            if (students <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] pages = { 25, 46, 28, 49, 24 };
        int m = 4;

        System.out.println(findPages(pages, m));
    }
}