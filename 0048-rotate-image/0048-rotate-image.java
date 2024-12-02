class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //Transpose the matrix
        for(int i=0; i<=n-2; i++){
            for(int j=i+1; j<=n-1; j++){
                swap(matrix, i, j);
            }
        }

        //reverse every row
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                reverse(matrix, i, j);
            }
            
        }
    }

    //method to swap elements in matrix
    public void swap(int[][] matrix, int i, int j){
        int temp = 0;
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    //method to reverse row
    public void reverse(int[][] matrix, int i, int j){
        int n = matrix.length;
        int temp = 0;
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][n-j-1];
        matrix[i][n-j-1] = temp;
    }
}

//TC : O(n/2 * n/2 + n * n/2)
//SC : O(1)