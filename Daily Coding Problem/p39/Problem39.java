// Good morning! Here's your coding interview problem for today.

// This problem was asked by Dropbox.

// Conway's Game of Life takes place on an infinite two-dimensional board of 
// square cells. Each cell is either dead or alive, and at each tick, the 
// following rules apply:

// Any live cell with less than two live neighbours dies.
// Any live cell with two or three live neighbours remains living.
// Any live cell with more than three live neighbours dies.
// Any dead cell with exactly three live neighbours becomes a live cell.
// A cell neighbours another cell if it is horizontally, vertically, or 
// diagonally adjacent.

// Implement Conway's Game of Life. It should be able to be initialized with a 
// starting list of live cell coordinates and the number of steps it should run 
// for. Once initialized, it should print out the board state at each step. 
// Since it's an infinite board, print out only the relevant coordinates, i.e. 
// from the top-leftmost live cell to bottom-rightmost live cell.

// You can represent a live cell with an asterisk (*) and a dead cell with a 
// dot (.).

package P39;

import java.util.ArrayList;


class Solution
{
    class Cell
    {
        private int x;
        private int y;

        Cell(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        // getters
        public int getX()
        {
            return this.x;
        }

        public int getY()
        {
            return this.y;
        }

        // setters
        public void setX(int x)
        {
            this.x = x;
        }

        public void setY(int y)
        {
            this.y = y;
        }
    }

    private static final char LIVE_CELL = '*';
    private static final char DEAD_CELL = '.';

    private ArrayList<ArrayList<Character>> board;

    Solution(ArrayList<Integer[]> initBoard)
    {
        
    }

    public static void gameOfLife()
    {

    }
}


public class Problem39
{
    public static void main(String[] args)
    {

    }
}
