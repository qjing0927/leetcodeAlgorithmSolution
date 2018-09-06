package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSoduku {

//	Collect the set of things we see, encoded as strings. For example:
//
//		'4' in row 7 is encoded as "4 in row 7".
//		'4' in column 7 is encoded as "7 in column 4".
//		'4' in the top-right block is encoded as " 4 in block 0-2".
//		Scream false if we ever fail to add something because it was already added (i.e., seen before).
	public boolean validSudoku(char[][] board) {
		Set seen = new HashSet();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				char number = board[i][j];
				if (number != '.')
					if (!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j)
							|| !seen.add(number + " in block " + i / 3 + "-" + j / 3))
						return false;
			}
		}
		return true;
	}

	/**
	 * Straight solution Each row must contain the digits 1-9 without repetition.
	 * Each column must contain the digits 1-9 without repetition. Each of the 9 3x3
	 * sub-boxes of the grid must contain the digits 1-9 without repetition.
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!isRowValid(i, j, board, board[i][j]) || !isColumnValid(i, j, board, board[i][j])
							|| !isSquareValid(i, j, board, board[i][j]))
						return false;
				}
			}
		return true;
	}

	private boolean isColumnValid(int row, int column, char[][] board, char target) {

		for (int i = 0; i < 9; i++) {
			if (board[i][column] == target && i != row)
				return false;
		}

		return true;
	}

	private boolean isSquareValid(int row, int column, char[][] board, char c) {

		int rw = 3 * (row / 3);
		int cl = 3 * (column / 3);
		for (int i = rw; i < rw + 3; i++) {
			for (int j = cl; j < cl + 3; j++) {
				if (board[i][j] == c && i != row && j != column)
					return false;
			}
		}
		return true;

	}

	private boolean isRowValid(int row, int column, char[][] board, char target) {

		for (int j = 0; j < 9; j++) {
			if (board[row][j] == target && j != column)
				return false;
		}

		return true;
	}
}
