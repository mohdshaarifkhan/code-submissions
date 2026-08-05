class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        
        while(i < str.length()){
            //Finding # that ends us counting the length section
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }
            //Extract the length of the String
            int length = Integer.parseInt(str.substring(i, j));
            //Length start after # so we use + 1
            int start = j + 1;

            int end = start + length;

            String currentString = str.substring(start, end);

            list.add(currentString);
            //move at the beginning of the next encoded String
            i = end;
        }
        return list;
    }
}
