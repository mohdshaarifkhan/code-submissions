class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
           return false;
        }

        int[] count = new int[26];

        for(char i: s.toCharArray()){
            count[i -'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i)-'a']--;
        }

        for(int freq: count){
            if(freq != 0){
                return false;
            }
        }
        return true;
    }
}
