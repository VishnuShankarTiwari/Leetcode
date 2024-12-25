class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // int[] col = new int[m]; --> matrix[0][..]
        // int[] row = new int[n]; --> matrix[..][0]
        int col0 = 1;

        //mark 0 for every row & col in matrix to first row and col of matrix itself
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    //mark the ith row
                    matrix[i][0] = 0;
                    //mark the jth col
                    if(j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] != 0){
                    //check for col & row
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        //separatly marking the first row & first col in matrix
        if(matrix[0][0] == 0){
            for(int j=0; j<m; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i=0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}

//TC : O(2(n x m)) 
//SC : 0(1)