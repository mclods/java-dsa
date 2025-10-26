package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/valid-sudoku/description/
public class ValidSudoku {
    public boolean checkInvalidityAndAddToMap(HashMap<Integer, HashSet<Character>> map, int key, char value) {
        HashSet<Character> values;

        if(map.containsKey(key)) {
            values = map.get(key);

            if(values.contains(value)) {
                return true;
            }
        } else {
            values = new HashSet<>();
        }

        values.add(value);
        map.put(key, values);

        return false;
    }

    public int getSubBoxIndex(int row, int col) {
        if(row <= 2) {
            if(col <= 2) {
                return 0;
            } else if(col <= 5) {
                return 1;
            } else {
                return 2;
            }
        } else if(row <= 5) {
            if(col <= 2) {
                return 3;
            } else if(col <= 5) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if(col <= 2) {
                return 6;
            } else if(col <= 5) {
                return 7;
            } else {
                return 8;
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        HashMap<Integer, HashSet<Character>> columnDigitMap = new HashMap<>(),
                subBoxDigitMap = new HashMap<>();

        for(int i=0; i<9; ++i) {
            int[] rowDigitsCount =  new int[9];

            for(int j=0; j<9; ++j) {
                if(board[i][j] == '.') {
                    continue;
                }

                // Check Row Validity
                if(rowDigitsCount[board[i][j] - '1'] == 1) {
                    isValid = false;
                    break;
                } else {
                    rowDigitsCount[board[i][j] - '1']++;
                }

                // Check column validity
                if(checkInvalidityAndAddToMap(columnDigitMap, j, board[i][j])) {
                    isValid = false;
                    break;
                }

                // Check subBox Validity
                if(checkInvalidityAndAddToMap(subBoxDigitMap, getSubBoxIndex(i, j), board[i][j])) {
                    isValid = false;
                    break;
                }
            }

            if(!isValid) {
                break;
            }
        }

        return isValid;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[9][9];
        for(int i=0; i<9; ++i) {
            String[] inputs = br.readLine().split(" ");

            for(int j=0; j<9; ++j) {
                board[i][j] = inputs[j].charAt(0);
            }
        }

        boolean output = new ValidSudoku().isValidSudoku(board);
        System.out.println(output);
    }
}
