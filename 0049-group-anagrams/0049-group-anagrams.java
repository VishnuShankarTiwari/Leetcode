class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //check for empty inputs
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String , List<String>> map = new HashMap<>();
        for(String str : strs){
            String freq = getFreq(str);

            //if frequency string is present, add string to list
            if(map.containsKey(freq)){
                map.get(freq).add(str);
            }
            else{
                //create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(freq, strList);
            }
        }

        return new ArrayList<>(map.values());
    }

    //helper to get the frequency
    private String getFreq(String str){
        int[] freq = new int[26];
        
        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }

        //start creating the frequency string
        StringBuilder freqStr = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            freqStr.append(c);
            freqStr.append(i);
            c++;
        }
        return freqStr.toString();
    }
}

//TC : O(n + k)
//SC : O(k)   ---> k = string length