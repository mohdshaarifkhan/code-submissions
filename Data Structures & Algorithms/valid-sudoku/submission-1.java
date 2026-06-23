class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> seen = new HashSet<>();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char value = board[row][col];

                if(value == '.'){
                    continue;
                }

                String rowKey = value + " in row " + row;
                String colKey = value + " in col " + col;
                String boxKey = value + " in box " + (row/3) + "," + (col/3);


                if(seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)){
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }
}
