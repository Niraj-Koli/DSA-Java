/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. */

const nums = [2, 7, 11, 15];
const target = 9;

function twoSum(nums, target) {
    let map = new Map();

    let n = nums.length;

    for (let i = 0; i < n; i++) {
        let complement = target - nums[i];

        if (map.has(complement)) {
            return [map.get(complement), i];
        } else {
            map.set(nums[i], i);
        }
    }

    return [];
}

console.log(twoSum(nums, target));

// LeetCode //

// var twoSum = function (nums, target) {
//     if (nums.length < 2) {
//         return [];
//     }

//     const obj = {};

//     for (let i = 0; i < nums.length; i++) {
//         const complement = target - nums[i];

//         if (obj[complement] !== undefined) {
//             return [obj[complement], i];
//         }

//         obj[nums[i]] = i;
//     }

//     return [];
// };
