/*
 * Given a string path, which is an absolute path (starting with a slash '/') to
 * a file or directory in a Unix-style file system, convert it to the simplified
 * canonical path.
 * 
 * In a Unix-style file system, a period '.' refers to the current directory, a
 * double period '..' refers to the directory up a level, and any multiple
 * consecutive slashes (i.e. '//') are treated as a single slash '/'. For this
 * problem, any other format of periods such as '...' are treated as
 * file/directory names.
 * 
 * The canonical path should have the following format:
 * 
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to
 * the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 */

import java.util.ArrayDeque;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String[] newPath = path.split("/");

        for (String str : newPath) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!str.equals("") && !str.equals(".")) {
                stack.offerLast(str);
            }
        }

        StringBuilder result = new StringBuilder("/");

        for (String s : stack) {
            result.append(s).append("/");
        }

        if (result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String path = "/home//foo/";

        String answer = simplifyPath(path);

        System.out.println(answer);
    }
}

// class Solution {

// private String[] extend(String[] arr) {
// String[] newArr = new String[arr.length * 2];
// for (int i = 0; i < arr.length; i++) {
// newArr[i] = arr[i];
// }
// return newArr;
// }

// public String simplifyPath(String path) {

// String[] stack = new String[10];
// int sl = 0; // length of the stack
// final int len = path.length();

// int i = 0;
// while (true) {
// while (i < len && path.charAt(i) == '/')
// i++;
// if (i >= len)
// break;

// int j = i;
// while (i < len && path.charAt(i) != '/')
// i++;
// if (i == j + 1 && path.charAt(j) == '.') {
// // ".", do nothing
// } else if (i == j + 2 && path.charAt(j) == '.' && path.charAt(j + 1) == '.')
// {
// // "..", level up
// sl--;
// if (sl < 0)
// sl = 0;
// } else {
// if (sl >= stack.length)
// stack = extend(stack);
// stack[sl] = path.substring(j, i);
// sl++;
// }
// }

// if (sl == 0)
// return "/";

// StringBuilder sb = new StringBuilder();
// for (i = 0; i < sl; i++) {
// sb.append("/");
// sb.append(stack[i]);
// }
// return sb.toString();
// }
// }