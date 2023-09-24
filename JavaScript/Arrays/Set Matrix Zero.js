// Set Matrix Zero //

/* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place. */

const matrix = [
    [0, 1, 2, 0],
    [3, 4, 5, 2],
    [1, 3, 1, 5],
];

function setZeroes(matrix) {
    let iterations = 0;

    const indexesPair = [];

    const numOfRows = matrix.length;
    const numOfCols = matrix[0].length;

    for (let index = 0; index < numOfRows * numOfCols; index++) {
        let i = Math.floor(index / numOfCols);
        let j = index % numOfCols;

        if (matrix[i][j] === 0) {
            indexesPair.push([i, j]);
        }
    }

    while (iterations < indexesPair.length) {
        const rowIndex = indexesPair[iterations][0];
        const colIndex = indexesPair[iterations][1];

        for (let i = 0; i < numOfRows; i++) {
            matrix[i][colIndex] = 0;
        }

        for (let j = 0; j < numOfCols; j++) {
            matrix[rowIndex][j] = 0;
        }

        iterations++;
    }

    return matrix;
}

console.log(setZeroes(matrix));

// Brute Force //

// Time -> O((N * M) * (N + M)) + O(N * M) //
// Space -> O(1) //

// function markRow(matrix, n, m, i) {
//     // set all non-zero elements as -1 in the row i:
//     for (let j = 0; j < m; j++) {
//         if (matrix[i][j] !== 0) {
//             matrix[i][j] = -1;
//         }
//     }
// }

// function markCol(matrix, n, m, j) {
//     // set all non-zero elements as -1 in the col j:
//     for (let i = 0; i < n; i++) {
//         if (matrix[i][j] !== 0) {
//             matrix[i][j] = -1;
//         }
//     }
// }

// function zeroMatrix(matrix, n, m) {
//     // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             if (matrix[i][j] === 0) {
//                 markRow(matrix, n, m, i);
//                 markCol(matrix, n, m, j);
//             }
//         }
//     }
//     // Finally, mark all -1 as 0:
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             if (matrix[i][j] === -1) {
//                 matrix[i][j] = 0;
//             }
//         }
//     }
//     return matrix;
// }

// const matrix = [
//     [1, 1, 1],
//     [1, 0, 1],
//     [1, 1, 1],
// ];

// const n = matrix.length;
// const m = matrix[0].length;

// const ans = zeroMatrix(matrix, n, m);

// console.log("The Final matrix is: ");
// for (let i = 0; i < n; i++) {
//     console.log(ans[i].join(" "));
// }

// Better //

// Time -> O(2 * (N * M)) //
// Space -> O(N) + O(M) //

// function zeroMatrix(matrix) {
//     const n = matrix.length;
//     const m = matrix[0].length;
//     const row = new Array(n).fill(0); // row array
//     const col = new Array(m).fill(0); // col array

//     // Traverse the matrix:
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             if (matrix[i][j] === 0) {
//                 // mark ith index of row with 1:
//                 row[i] = 1;

//                 // mark jth index of col with 1:
//                 col[j] = 1;
//             }
//         }
//     }

//     // Finally, mark all (i, j) as 0
//     // if row[i] or col[j] is marked with 1.
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             if (row[i] || col[j]) {
//                 matrix[i][j] = 0;
//             }
//         }
//     }

//     return matrix;
// }

// const matrix = [
//     [1, 1, 1],
//     [1, 0, 1],
//     [1, 1, 1],
// ];
// const ans = zeroMatrix(matrix);

// console.log("The Final matrix is:");
// for (const row of ans) {
//     console.log(row.join(" "));
// }

// Optimal //

// Time -> O(2 * (N * M)) //
// Space -> O(1) //

// function zeroMatrix(matrix) {
//     const n = matrix.length;
//     const m = matrix[0].length;

//     let col0 = 1;
//     // Step 1: Traverse the matrix and mark 1st row & col accordingly:
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             if (matrix[i][j] === 0) {
//                 // Mark i-th row:
//                 matrix[i][0] = 0;

//                 // Mark j-th column:
//                 if (j !== 0) {
//                     matrix[0][j] = 0;
//                 } else {
//                     col0 = 0;
//                 }
//             }
//         }
//     }

//     // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
//     for (let i = 1; i < n; i++) {
//         for (let j = 1; j < m; j++) {
//             if (matrix[i][j] !== 0) {
//                 // Check for col & row:
//                 if (matrix[i][0] === 0 || matrix[0][j] === 0) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }

//     // Step 3: Finally mark the 1st col & then 1st row:
//     if (matrix[0][0] === 0) {
//         for (let j = 0; j < m; j++) {
//             matrix[0][j] = 0;
//         }
//     }
//     if (col0 === 0) {
//         for (let i = 0; i < n; i++) {
//             matrix[i][0] = 0;
//         }
//     }

//     return matrix;
// }

// const matrix = [
//     [1, 1, 1],
//     [1, 0, 1],
//     [1, 1, 1],
// ];
// const ans = zeroMatrix(matrix);

// console.log("The Final matrix is:");
// for (const row of ans) {
//     console.log(row.join(" "));
// }

// LeetCode //

// var setZeroes = function (matrix) {
//     var arr1 = [];
//     var arr2 = [];

//     for (var i = 0; i < matrix.length; i++) {
//         for (var j = 0; j < matrix[i].length; j++) {
//             if (matrix[i][j] === 0) {
//                 arr1.push(i);
//                 arr2.push(j);
//             }
//         }
//     }

//     for (var i = 0; i < arr1.length; i++) {
//         for (var j = 0; j < matrix[0].length; j++) {
//             matrix[arr1[i]][j] = 0;
//         }
//     }
//     for (var i = 0; i < arr2.length; i++) {
//         for (var j = 0; j < matrix.length; j++) {
//             matrix[j][arr2[i]] = 0;
//         }
//     }
// };
