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

class SimplifyPath {

    // Time -> O(n) //
    // Space -> O(n) //

    private static String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String[] newPath = path.split("/");

        for (String str : newPath) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!str.equals("") && !str.equals(".")) {
                stack.offer(str);
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

        System.out.println(simplifyPath(path));
    }
}