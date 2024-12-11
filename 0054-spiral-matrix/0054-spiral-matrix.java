class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol){
            //Top boundary
            for (int j = startCol; j <= endCol; j++) {
                list.add(matrix[startRow][j]);
            }

            //Right boundary
            for (int i = startRow + 1; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }

            //Bottom boundary
            for (int j = endCol - 1; j >= startCol; j--){
                if (startRow == endRow) break;
                list.add(matrix[endRow][j]);
            }

            //Left boundary
            for (int i = endRow - 1; i >= startRow + 1; i--){
                if (startCol == endCol) break;
                list.add(matrix[i][startCol]);
            }

            //Update boundaries
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return list;
    }
}

//TC : O(n/2);
//SC : O(n) --> Auxiliary space