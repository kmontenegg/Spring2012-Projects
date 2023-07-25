/**
 * The model for John Conway's Game of Life.
 * 
 * @author Kevin Montenegro
 * 
 *         This class has all needed methods as stubs. Comments explain each
 *         method.
 * 
 */
public class GameOfLife {

	private boolean[][] grid = null;
	private int nRows = 0;
	private int nCols = 0;

	/**
	 * Write the constructor so it takes two integer arguments to represent the
	 * number of rows and columns in the game of life. The constructor creates a
	 * society with no cells but space to store rows*cols cells.
	 * 
	 * @param rows
	 *            The height of the grid that shows the cells.
	 * @param cols
	 *            The width of the grid that shows the cells.
	 */
	public GameOfLife(int rows, int cols) {
		// Complete this method.
		nRows = rows;
		nCols = cols;
		grid = new boolean[rows][cols];
	}

	/**
	 * Return the number of rows, which can be indexed from 0..numberOfRows()-1.
	 * 
	 * @return The height of the society.
	 */
	public int numberOfRows() {
		return nRows;
	}

	/**
	 * The number of columns, which can be indexed from 0..numberOfColumns()-1.
	 * 
	 * @return The height of the society.
	 */
	public int numberOfColumns() {
		return nCols;
	}

	/**
	 * Place a new cell in the society. Precondition: row and col are in range.
	 * 
	 * @param row
	 *            The row to grow the cell.
	 * @param col
	 *            The column to grow the cell.
	 */
	public void growCellAt(int row, int col) {
		// Complete this method
		grid[row][col] = true;
	}

	public void killCellAt(int row, int col) {
		// Complete this method
		grid[row][col] = false;
	}

	/**
	 * 5) Return true if there is a cell at the given row and column. Return
	 * false if there is none at the specified location.
	 * 
	 * @param row
	 *            The row to check.
	 * @param col
	 *            The column to check.
	 * @return True if there is a cell at the given row or false if none
	 */
	public boolean cellAt(int row, int col) {
		if (grid[row][col]) {
			return true;
		}
		return false;
	}

	/**
	 * Return one big string of cells to represent the current state of the
	 * society of cells (see output below where '.' represents an empty space
	 * and 'O' is a live cell. There is no need to test toString. Simply use it
	 * to visually inspect if needed. Here is one sample output from toString:
	 * 
	 * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
	 * society.growCellAt(2, 3); society.growCellAt(3, 4);
	 * System.out.println(society.toString());
	 * 
	 * Output .............. ..O........... ...O.......... ....O.........
	 * 
	 * @return A textual representation of this society of cells.
	 */
	@Override
	public String toString() {
		String societyString = " ";
		for (int c = 0; c < nCols; c++) {
			societyString += " " + (c % 10) + " ";
		}
		societyString += "\n0";
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				if (grid[r][c]) {
					if (c == nCols - 1) {
						societyString += " O\n" + ((r + 1) % 10) + "";
					} else {
						societyString += " O ";
					}

				} else {
					if (c == nCols - 1) {
						societyString += " .\n" + ((r + 1) % 10) + "";
					} else {
						societyString += " . ";
					}
				}
			}
		}
		return societyString;
	}

	/**
	 * Count the neighbors around the given location. Use wraparound. A cell in
	 * row 0 has neighbors in the last row if a cell is in the same column, or
	 * the column to the left or right. In this example, cell 0,5 has two
	 * neighbors in the last row, cell 2,8 has four neighbors, cell 2,0 has four
	 * neighbors, cell 1,0 has three neighbors. The cell at 3,8 has 3 neighbors.
	 * The potential location for a cell at 4,8 would have three neighbors.
	 * 
	 * .....O..O O........ O.......O O.......O ....O.O..
	 * 
	 * 
	 * The return values should always be in the range of 0 through 8.
	 * 
	 * @return The number of neighbors around any cell using wrap around.
	 */
	public int neighborCount(int row, int col) {
		int neighbors = 0;
		if (row == 0 && col == 0) {
			if (grid[row + 1][col]) // down
			{
				neighbors++;
			}
			if (grid[row + 1][col + 1]) // down-right
			{
				neighbors++;
			}
			if (grid[row][col + 1]) // right
			{
				neighbors++;
			}
			if (grid[nRows - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][nCols - 1]) // left
			{
				neighbors++;
			}
			if (grid[row + 1][nCols - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[nRows - 1][nCols - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[nRows - 1][col + 1]) // up-right
			{
				neighbors++;
			}
		} else if (row == 0 && col == nCols - 1) {
			if (grid[row + 1][col]) // down
			{
				neighbors++;
			}
			if (grid[row + 1][0]) // down-right
			{
				neighbors++;
			}
			if (grid[row][0]) // right
			{
				neighbors++;
			}
			if (grid[nRows - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][col - 1]) // left
			{
				neighbors++;
			}
			if (grid[row + 1][col - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[nRows - 1][col - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[nRows - 1][0]) // up-right
			{
				neighbors++;
			}
		} else if (row == nRows - 1 && col == 0) {
			if (grid[0][col]) // down
			{
				neighbors++;
			}
			if (grid[0][col + 1]) // down-right
			{
				neighbors++;
			}
			if (grid[row][col + 1]) // right
			{
				neighbors++;
			}
			if (grid[row - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][nCols - 1]) // left
			{
				neighbors++;
			}
			if (grid[0][nCols - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[row - 1][nCols - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[row - 1][col + 1]) // up-right
			{
				neighbors++;
			}
		} else if (row == nRows - 1 && col == nCols - 1) {
			if (grid[0][col]) // down
			{
				neighbors++;
			}
			if (grid[0][0]) // down-right
			{
				neighbors++;
			}
			if (grid[row][0]) // right
			{
				neighbors++;
			}
			if (grid[row - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][col - 1]) // left
			{
				neighbors++;
			}
			if (grid[0][col - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[row - 1][col - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[row - 1][0]) // up-right
			{
				neighbors++;
			}
		} else if (row == 0 && col != 0 && col != nCols - 1) {
			if (grid[row + 1][col]) // down
			{
				neighbors++;
			}
			if (grid[row + 1][col + 1]) // down-right
			{
				neighbors++;
			}
			if (grid[row][col + 1]) // right
			{
				neighbors++;
			}
			if (grid[nRows - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][col - 1]) // left
			{
				neighbors++;
			}
			if (grid[row + 1][col - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[nRows - 1][col - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[nRows - 1][col + 1]) // up-right
			{
				neighbors++;
			}
		} else if (row == nRows - 1 && col != 0 && col != nCols - 1) {
			if (grid[0][col]) // down
			{
				neighbors++;
			}
			if (grid[0][col + 1]) // down-right
			{
				neighbors++;
			}
			if (grid[row][col + 1]) // right
			{
				neighbors++;
			}
			if (grid[row - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][col - 1]) // left
			{
				neighbors++;
			}
			if (grid[0][col - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[row - 1][col - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[row - 1][col + 1]) // up-right
			{
				neighbors++;
			}
		} else if (col == 0 && row != 0 && row != nRows - 1) {
			if (grid[row + 1][col]) // down
			{
				neighbors++;
			}
			if (grid[row + 1][col + 1]) // down-right
			{
				neighbors++;
			}
			if (grid[row][col + 1]) // right
			{
				neighbors++;
			}
			if (grid[row - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][nCols - 1]) // left
			{
				neighbors++;
			}
			if (grid[row + 1][nCols - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[row - 1][nCols - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[row - 1][col + 1]) // up-right
			{
				neighbors++;
			}
		} else if (col == nCols - 1 && row != 0 && row != nRows - 1) {
			if (grid[row + 1][col]) // down
			{
				neighbors++;
			}
			if (grid[row + 1][0]) // down-right
			{
				neighbors++;
			}
			if (grid[row][0]) // right
			{
				neighbors++;
			}
			if (grid[row - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][col - 1]) // left
			{
				neighbors++;
			}
			if (grid[row + 1][col - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[row - 1][col - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[row - 1][0]) // up-right
			{
				neighbors++;
			}
		} else {
			if (grid[row + 1][col]) // down
			{
				neighbors++;
			}
			if (grid[row + 1][col + 1]) // down-right
			{
				neighbors++;
			}
			if (grid[row][col + 1]) // right
			{
				neighbors++;
			}
			if (grid[row - 1][col]) // up
			{
				neighbors++;
			}
			if (grid[row][col - 1]) // left
			{
				neighbors++;
			}
			if (grid[row + 1][col - 1]) // down-left
			{
				neighbors++;
			}
			if (grid[row - 1][col - 1]) // up-left
			{
				neighbors++;
			}
			if (grid[row - 1][col + 1]) // up-right
			{
				neighbors++;
			}
		}
		return neighbors;
	}

	/**
	 * Update the state to represent the next society. Typically, some cells
	 * will die off while others are born.
	 */
	public void update() {
		// Complete this method
		boolean[][] oldGrid = new boolean[nRows][nCols];
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				oldGrid[r][c] = grid[r][c];
			}
		}
		GameOfLife oldSociety = new GameOfLife(nRows,nCols);
		oldSociety.grid = oldGrid;
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				if (oldSociety.neighborCount(r, c) == 3 && !oldSociety.cellAt(r, c)) {
					this.growCellAt(r, c);
				}
				if (oldSociety.cellAt(r, c) && oldSociety.neighborCount(r,c) < 2)
				{
					this.killCellAt(r, c);
				}
				if (oldSociety.cellAt(r, c) && oldSociety.neighborCount(r, c) > 3) {
					this.killCellAt(r, c);
				}

			}
		}
		//System.out.println(this.toString());
	}
}
