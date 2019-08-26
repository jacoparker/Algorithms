// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Dropbox.
//
// Conway's Game of Life takes place on an infinite two-dimensional board of 
// square cells. Each cell is either dead or alive, and at each tick, the 
// following rules apply:
//      - Any live cell with less than two live neighbours dies.
//      - Any live cell with two or three live neighbours remains living.
//      - Any live cell with more than three live neighbours dies.
//      - Any dead cell with exactly three live neighbours becomes a live cell.
// A cell neighbours another cell if it is horizontally, vertically, or 
// diagonally adjacent.
//
// Implement Conway's Game of Life. It should be able to be initialized with a 
// starting list of live cell coordinates and the number of steps it should run 
// for. Once initialized, it should print out the board state at each step. 
// Since it's an infinite board, print out only the relevant coordinates, i.e. 
// from the top-leftmost live cell to bottom-rightmost live cell.
// You can represent a live cell with an asterisk (*) and a dead cell with a 
// dot (.).


import java.util.ArrayList;
import java.util.Scanner;

class GameOfLife
{
    public static final int INITIAL_BOARD_SIZE = 6;
    public static final char DEAD_CELL = '.';
    public static final char LIVE_CELL = '*';

    // for rendering relevant parts of board
    public int minCellX;
    public int minCellY;
    public int maxCellX;
    public int maxCellY;

    private int numLiveCells;
    private char[][] board;  // could also use bool

    public Scanner scnr;

    GameOfLife(int[][] coords)
    {
        this.numLiveCells = coords.length;
        this.maxCellX = 0;
        this.maxCellY = 0;
        this.minCellX = Integer.MAX_VALUE;
        this.minCellY = Integer.MAX_VALUE;
        this.scnr = new Scanner(System.in);

        for (int[] coord: coords)
        {
            int x = coord[0], y = coord[1];
            if (x > this.maxCellX) this.maxCellX = x;
            else if (x < this.minCellX) this.minCellX = x;
            if (y > this.maxCellY) this.maxCellY = y;
            else if (y < this.minCellY) this.minCellY = y;
        }
        
        int offsetX = this.minCellX;
        int offsetY = this.minCellY;
        this.maxCellX = this.maxCellX - this.minCellX + 3;
        this.maxCellY = this.maxCellY - this.minCellY + 3;
        this.minCellX = this.minCellY = 0;

        System.out.println(this.maxCellX + " " + this.maxCellY + " " + this.minCellX + " " + this.minCellY);

        this.board = new char[this.maxCellX][this.maxCellY];

        for (int i=0; i<this.maxCellX; i++)
            for (int j=0; j<this.maxCellY; j++)
                board[i][j] = DEAD_CELL;

        for (int[] coord: coords)
            board[coord[0] - offsetX + 1][coord[1] - offsetY + 1] = LIVE_CELL;

    }

    // getters

    public int getNumLiveCells()
    {
        return this.numLiveCells;
    }

    public char[][] getBoard()
    {
        return this.board;
    }

    // setters

    public void setNumLiveCells(int numLiveCells)
    {
        this.numLiveCells = numLiveCells;
    }

    private boolean isCellAlive(int x, int y)
    {
        int numLiveNeighbors = 0;
        int boundX = this.maxCellX - this.minCellX + 3;
        int boundY = this.maxCellY - this.minCellY + 3;

        // get number of live neighbors
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (i == 0 && j == 0) continue;
                if (i >= 0 && j >= 0 && i+x < this.board.length && j+y < this.board[0].length)
                {
                    if (this.board[x+i][y+j] == GameOfLife.LIVE_CELL)
                        numLiveNeighbors += 1;
                }
            }
        }
        
        if (this.board[x][y] == GameOfLife.LIVE_CELL)
        {
            if (numLiveNeighbors == 2 || numLiveNeighbors == 3)
                return true;
        }
        // dealing with dead cell - if there are three live neighbors its alive!
        else if (numLiveNeighbors == 3)
        {
            return true;
        }
        return false;
    }
    
    public void runSimulation()
    {
        // print initial board
        this.printBoard();

        while (this.getNumLiveCells() > 0)
        {
            if (this.scnr.hasNextLine() && this.scnr.nextLine().equals(""))
            {
                this.update();
                this.printBoard();
            }
        }
    }

    public void update()
    {
        ArrayList<int []> liveCells = new ArrayList<>();
        int currMaxX = 0, currMaxY = 0;
        int currMinX = Integer.MAX_VALUE, currMinY = Integer.MAX_VALUE;

        for (int i=0; i<this.maxCellX; i++)
        {
            for (int j=0; j<this.maxCellY; j++)
            {
                System.out.println("Hello");
                if (this.isCellAlive(i, j))
                {
                    System.out.println("BYE");
                    liveCells.add(new int[]{i, j});
                    if (i > currMaxX) currMaxX = i;
                    if (i < currMinX) currMinX = i;
                    if (j > currMaxY) currMaxY = j;
                    if (j < currMinY) currMinY = j;
                }
            }
        }

        this.minCellX = this.minCellY = 0;
        this.maxCellX = currMaxX - currMinX + 3;
        this.maxCellY = currMaxY - currMinY + 3;

        System.out.println(currMinX + " " + currMaxX + " " + currMinY + " " + currMaxX);

        this.board = new char[currMaxX + 2 -  currMinX][currMaxY + 2 - currMinY];
        for (int i = 0; i < currMaxX - currMinX + 2; i++)
            for (int j = 0; j < currMaxY - currMinY + 2; j++)
                this.board[i][j] = GameOfLife.DEAD_CELL;

        for (int[] coord: liveCells)
            this.board[coord[0]+1-currMinX][coord[1]+1-currMinY] = GameOfLife.LIVE_CELL;

        this.setNumLiveCells(liveCells.size());
    }

    public void printBoard()
    {
        char[][] board = this.getBoard();
        for (int i=0, n=board.length; i<n; i++)
        {
            for (int j=0, m=board[0].length; j<m; j++)
                System.out.print(" " + board[i][j]);
            System.out.println();
        }
    }
}


public class Problem39
{
    public static void main(String[] args)
    {
        // test 1
        int[][] initialBoard = new int[][]{
            {1, 3},
            {3, 5},
            {3, 4},
            {2, 2},
            {1, 5},
            {2, 3}
        };

        GameOfLife game = new GameOfLife(initialBoard);
        game.runSimulation();
    }
}
