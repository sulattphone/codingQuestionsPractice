class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List result = new ArrayList();
        
        for(int i=0; i<strs.length; i++)
        {
            String s = strs[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedS = String.valueOf(arr);
            
            if(map.containsKey(sortedS))
            {
                map.get(sortedS).add(s);
            }
            else
            {
                map.put(sortedS, new ArrayList());
                map.get(sortedS).add(s);
            }
        }
        for(List l : map.values())
        {
            result.add(l);
        }
        
        return result;
    }
}
