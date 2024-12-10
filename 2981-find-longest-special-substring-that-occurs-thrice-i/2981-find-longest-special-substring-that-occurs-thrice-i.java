class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();

        //generate all substring and store in map
        for(int i=0; i<n; i++){
            StringBuilder currString = new StringBuilder();
            for(int j=i; j<n; j++){
                if(currString.length() == 0 ||
                s.charAt(j) == currString.charAt(currString.length()-1)){
                    currString.append(s.charAt(j));
                    String curr = currString.toString();
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                }else{
                    break;
                }
            }
        }

        int maxLen = -1;

        //max substing length calculation from map with frequency atleast 3
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String str = entry.getKey();
            int freq = entry.getValue();
            if(freq > 2){
                maxLen = Math.max(maxLen, str.length());
            }
        }

        return maxLen;
    }
}

//TC : O(n² + map.size())
//SC : O(map.size())
