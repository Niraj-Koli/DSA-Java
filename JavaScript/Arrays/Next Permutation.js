/* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory. */

// https://www.nayuki.io/page/next-lexicographical-permutation-algorithm //

const nums = [1, 3, 2];

function nextPermutation(nums) {
    let i = nums.length - 2;

    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
    }

    if (i >= 0) {
        let j = nums.length - 1;

        while (nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);
    }

    reverse(nums, i + 1);

    return nums;
}

function swap(nums, i, j) {
    [nums[i], nums[j]] = [nums[j], nums[i]];
}

function reverse(nums, start) {
    let i = start;
    let j = nums.length - 1;

    while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
}

console.log(nextPermutation(nums));

// Optimal //

// Time -> O(3n) //
// Space -> O(1) //

// function nextGreaterPermutation(A) {
//     let n = A.length; // size of the array.

//     // Step 1: Find the break point:
//     let ind = -1; // break point
//     for (let i = n - 2; i >= 0; i--) {
//         if (A[i] < A[i + 1]) {
//             // index i is the break point
//             ind = i;
//             break;
//         }
//     }

//     // If break point does not exist:
//     if (ind == -1) {
//         // reverse the whole array:
//         A.reverse();
//         return A;
//     }

//     // Step 2: Find the next greater element
//     //         and swap it with A[ind]:

//     for (let i = n - 1; i > ind; i--) {
//         if (A[i] > A[ind]) {
//             [A[i], A[ind]] = [A[ind], A[i]]; // swap A[i] and A[ind]
//             break;
//         }
//     }

//     // Step 3: reverse the right half:
//     A.splice(ind + 1, n - ind - 1, ...A.slice(ind + 1).reverse());

//     return A;
// }

// let A = [2, 1, 5, 4, 3, 0, 0];
// let ans = nextGreaterPermutation(A);

// console.log("The next permutation is: [" + ans.join(" ") + "]");

// LeetCode //

// var nextPermutation = function (nums) {
//     const length = nums.length;
//     for (let i = length - 2; i >= 0; i--) {
//         if (nums[i] < nums[i + 1]) {
//             for (let j = length - 1; j > i; j--) {
//                 if (nums[j] > nums[i]) {
//                     swap(nums, i, j);
//                     reverse(nums, i + 1, length - 1);
//                     return;
//                 }
//             }
//         }
//     }
//     nums.reverse();
// };

// const swap = (nums, i, j) => ([nums[i], nums[j]] = [nums[j], nums[i]]);

// const reverse = (nums, start, end) => {
//     while (start < end) {
//         swap(nums, start++, end--);
//     }
// };
