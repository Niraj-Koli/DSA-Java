/*
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> result = new ArrayList<String>();

    public static void generateBalancedParenthesis(int open, int close, String output) {
        if (open == 0 && close == 0) {
            result.add(output);
            return;
        }

        if (open != 0) {
            generateBalancedParenthesis(open - 1, close, output + "(");
        }

        if (close > open) {
            generateBalancedParenthesis(open, close - 1, output + ")");
        }
    }

    public static List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;

        String output = "";

        generateBalancedParenthesis(open, close, output);

        return result;
    }

    public static void main(String[] args) {
        int n = 3;

        List<String> answer = generateParenthesis(n);

        System.out.println(answer);
    }
}

// import java.util.*;
// import java.io.*;

// class Solution {
// static ArrayList<String> result;
// static int size;

// public ArrayList<String> generateParenthesis(int n) {
// size = n;
// StringBuilder sb = new StringBuilder();
// result = new ArrayList<>();
// backTrack(0, 0, sb);

// return result;
// }

// void backTrack(int n, int openCnt, StringBuilder parentheses) {
// if (n == size) {
// if (openCnt == 0) {
// result.add(parentheses.toString());
// return;
// }
// }

// if (n < size) {
// backTrack(n + 1, openCnt + 1, parentheses.append("("));
// parentheses.deleteCharAt(parentheses.length() - 1);
// }

// if (openCnt > 0) {
// backTrack(n, openCnt - 1, parentheses.append(")"));
// parentheses.deleteCharAt(parentheses.length() - 1);
// }
// }
// }