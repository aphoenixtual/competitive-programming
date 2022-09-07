/*
Example 1:

        Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
        Output: 13
        Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
        Example 2:

        Input: matrix = [[-5]], k = 1
        Output: -5
*/
package BinarySearch;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = getLowerNum(matrix, mid);
            if(count < k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    private int getLowerNum(int[][] matrix, int num){
        int n = matrix.length;
        int row = n - 1, col = 0;
        int res = 0;
        while(row >= 0 && col < n){
            if(matrix[row][col] > num)
                row--;
            else{
                res += row + 1;
                col++;
            }
        }
        return res;
    }
}
