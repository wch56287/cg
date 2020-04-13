package com.changgou.oauth.bianma2;

public class Solution {
    /*** 返回从源字符串到目标字符串的最小操作数
     * * source: 源字符串
     * * target：目标字符串
     * * 返回：最小操作数
     * */
    public static int minOperationCount(String source, String target) {
        int m = source.length();
        int n = target.length();
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            arr[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = 1 + Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1]));
                }
            }
        }
        return arr[m][n];
    }

    public static void main(String args[]) {
        System.out.println(minOperationCount("abc", "cde"));
    }
}