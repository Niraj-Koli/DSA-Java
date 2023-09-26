/* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

const prices = [2, 4, 1];

function maxProfit(prices) {
    let min = prices[0];
    let max = 0;

    let n = prices.length;

    for (let i = 1; i < n; i++) {
        if (prices[i] < min) {
            min = prices[i];
        } else if (prices[i] - min > max) {
            max = prices[i] - min;
        }
    }

    return max;
}

console.log(maxProfit(prices));

// LeetCode //

// var maxProfit = function (prices) {
//     let res = 0;
//     let curr = 0;
//     let next = 1;

//     while (next < prices.length) {
//         res = Math.max(res, prices[next] - prices[curr]);
//         if (prices[curr] > prices[next]) {
//             curr = next;
//         }
//         next++;
//     }

//     return res;
// };
