// Good morning! Here's your coding interview problem for today.

// This problem was asked by Google.

// You are given an M by N matrix consisting of booleans that represents a board.
// Each True boolean represents a wall. Each False boolean represents a tile you 
// can walk on.

// Given this matrix, a start coordinate, and an end coordinate, return the 
// minimum number of steps required to reach the end coordinate from the start.
// If there is no possible path, then return null. You can move up, left, down,
// and right. You cannot move through walls. You cannot wrap around the edges of
// the board.

// For example, given the following board:

// [[f, f, f, f],
// [t, t, f, t],
// [f, f, f, f],
// [f, f, f, f]]
// and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum
// number of steps required to reach the end is 7, since we would need to go
// through (1, 2) because there is a wall everywhere else on the second row.


import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;


public class Problem23 
{

	static int minNumberSteps(boolean[][] board, int[] start, int[] end)
	{
		// bounds
		int upper = 0, lower = board[0].length-1, left = 0, right = board.length-1;

		if (start[0] == end[0] && start[1] == end[1])
			return 0;

		int[][] costs = new int[board.length][board[0].length];
		for (int i=0; i < board.length; i++)
			for (int j=0; j < board[0].length; j++)
				costs[i][j] = Integer.MAX_VALUE;
		costs[start[0]][start[1]] = 0;

		// run dijkstras algo
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		int row = start[0], col = start[1];

		if (row > upper && !board[row-1][col])
			q.add(new Integer[]{row-1, col});
		if (row < lower && !board[row+1][col])
			q.add(new Integer[]{row+1, col});
		if (col > left && !board[row][col-1])
			q.add(new Integer[]{row, col-1});
		if (col < right && !board[row][col+1])
			q.add(new Integer[]{row, col+1});

		while (q.peek() != null)
		{
			Integer[] curr = q.remove();
			row = curr[0]; col = curr[1];
			ArrayList<Integer> neighborCosts = new ArrayList<>();

			if (row > upper && !board[row-1][col]) {
				neighborCosts.add(costs[row-1][col]);
				q.add(new Integer[]{row-1, col});
			}
			if (row < lower && !board[row+1][col]) {
				neighborCosts.add(costs[row+1][col]);
				q.add(new Integer[]{row+1, col});
			}
			if (col > left && !board[row][col-1]) {
				neighborCosts.add(costs[row][col-1]);
				q.add(new Integer[]{row, col-1});
			}
			if (col < right && !board[row][col+1]) {
				neighborCosts.add(costs[row][col+1]);
				q.add(new Integer[]{row, col+1});
			}

			costs[row][col] = Collections.min(neighborCosts) + 1;
			if (row == end[0] && col == end[1])
				return costs[row][col];
		}
		return -1;
	}

	public static void main(String []args)
	{
		// given scenario
		boolean[][] board = {{false, false, false, false},
							 {true,  true,  false, true},
							 {false, false, false, false},
							 {false, false, false, false}};

		int minSteps = minNumberSteps(board, new int[]{3, 0}, new int[]{0, 0});
		if (minSteps == -1) System.out.println("NULL");
		else System.out.println("Min Steps required: " + minSteps);

		// test when start is the end
		minSteps = minNumberSteps(board, new int[]{0, 0}, new int[]{0, 0});
		if (minSteps == -1) System.out.println("NULL");
		else System.out.println("Min Steps required: " + minSteps);

		// test when there is no means of reaching end
		board = new boolean[][]{{false, true, false, true, true},
							 	{true, false, false, true, false},
							 	{true, true, true, false, false},
							 	{true, true, false, true, false}};
		minSteps = minNumberSteps(board, new int[]{0, 0}, new int[]{0, 2});
		if (minSteps == -1) System.out.println("NULL");
		else System.out.println("Min Steps required: " + minSteps);

		// more various testing of the algo TODO 
	}
}
