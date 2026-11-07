class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFrequency = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s1.length(); i++){
            windowFrequency[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Freq, windowFrequency)){
            return true;
        }

        for(int i = s1.length(); i < s2.length(); i++){
            int incoming = s2.charAt(i);
            int outgoing = s2.charAt(i - s1.length());

            windowFrequency[incoming - 'a']++;
            windowFrequency[outgoing - 'a']--;

            if(Arrays.equals(s1Freq, windowFrequency)){
                return true;
            }
        }
        return false;
    }
}
