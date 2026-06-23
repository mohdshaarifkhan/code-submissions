class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        for(int i = 0; i < 9; i++){
            Set<Character> seen = new HashSet<>();

            for (int col = 0; col < 9; col++){
                char value = board[i][col];

                if(value == '.'){
                    continue;
                }

                if(seen.contains(value)){
                    return false;
                }
                seen.add(value);
            }
        }

        for(int col = 0; col < 9; col++){
            Set<Character> seen = new HashSet<>();

            for (int i = 0; i < 9; i++){
                char value = board[i][col];

                if(value == '.'){
                    continue;
                }

                if(seen.contains(value)){
                    return false;
                }
                seen.add(value);
            }
        }

        for(int boxRow = 0; boxRow < 9; boxRow += 3){
            for(int boxCol = 0; boxCol < 9; boxCol += 3){
                Set<Character> seen = new HashSet<>();

                for(int row = boxRow; row < boxRow + 3; row++){
                    for(int col = boxCol; col < boxCol + 3; col++){
                        char value = board[row][col];

                        if(value == '.'){
                            continue;
                        }

                        if(seen.contains(value)){
                            return false;
                        }

                        seen.add(value);
                    }
                }
            }
        }
        return true;
    }
}
