class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();

        //generating the value to templist and adding to list
        for(int row=1; row<=numRows; row++){
            List<Integer> temp = new ArrayList<>();
            for(int col=1; col<=row; col++){
                temp.add(nCr(row-1, col-1));
            }
            list.add(temp);
        }

        return list;
    }
    
    //helper to generate the individual value for n, r
    public int nCr(int n, int r){
        int res = 1;
        
        for(int i=0; i<r; i++){
            res = res * (n-i);
            res = res / (i+1);
        }

        return res;
    }
}

//TC : O(n³)
//SC : O(n)