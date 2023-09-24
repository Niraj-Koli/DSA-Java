/* Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown: */

const numRows = 5;

function generate(numRows) {
    let triangle = [[1]];

    for (let i = 1; i < numRows; i++) {
        let row = [1];

        let prevRow = i - 1;

        for (let j = 1; j < i; j++) {
            let sum = triangle[prevRow][j - 1] + triangle[prevRow][j];

            row.push(sum);
        }

        row.push(1);

        triangle.push(row);
    }

    return triangle;
}

console.log(generate(numRows));

// Variation 1 //

// Time -> O(c) //
// Space -> O(1) //

// function nCr(n, r) {
//     let res = 1;

//     // calculating nCr:
//     for (let i = 0; i < r; i++) {
//         res = res * (n - i);
//         res = res / (i + 1);
//     }
//     return res;
// }

// function pascalTriangle(r, c) {
//     const element = nCr(r - 1, c - 1);
//     return element;
// }

// const r = 5; // row number
// const c = 3; // col number
// const element = pascalTriangle(r, c);
// console.log(`The element at position (${r},${c}) is: ${element}`);

// Variation 2 //

// Time -> O(n) //
// Space -> O(1) //

// function pascalTriangle(n) {
//     let ans = 1;
//     console.log(ans + " "); // printing 1st element

//     //Printing the rest of the part:
//     for (let i = 1; i < n; i++) {
//         ans = ans * (n - i);
//         ans = ans / i;
//         console.log(ans + " ");
//     }
//     console.log("n");
// }

// const n = 5;
// pascalTriangle(n);

// Variation 3 //

// Time -> O(n^2) //
// Space -> O(1) //

// function generateRow(row) {
//     let ans = 1;
//     let ansRow = [1]; // inserting the 1st element

//     // calculate the rest of the elements:
//     for (let col = 1; col < row; col++) {
//         ans = ans * (row - col);
//         ans = ans / col;
//         ansRow.push(ans);
//     }
//     return ansRow;
// }

// function pascalTriangle(n) {
//     let ans = [];

//     // store the entire pascal's triangle:
//     for (let row = 1; row <= n; row++) {
//         ans.push(generateRow(row));
//     }
//     return ans;
// }

// let n = 5;
// let ans = pascalTriangle(n);
// for (let i = 0; i < ans.length; i++) {
//     console.log(ans[i].join(" "));
// }

// LeetCode //

// var generate = function (numRows) {
//     let triangle = [[1]];

//     for (let i = 1; i < numRows; i++) {
//         let row = [1];

//         for (let j = 1; j < i; j++) {
//             row.push(triangle[i - 1][j - 1] + triangle[i - 1][j]);
//         }

//         row.push(1);

//         triangle.push(row);
//     }

//     return triangle;
// };
