
public class Maze {
	
	private int width;
	private int height;
	private char [][] maze;
	
	
	public Maze (int height, int width) {
		
		this.width = width;
		this.height = height;
		maze = new char[height][width];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void set(char character, int row, int column) {
		
		maze[row][column] = character;
		
	}
	
	public char get (int row, int col) {
		return maze[row][col];
	}
	
	private boolean validMove (int row, int col) {
		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
			return false;
		}
		return maze[row][col] != '#' && maze[row][col] != '.';
	}
	public String solve (int startrow, int startcol, int endrow, int endcol) {
		
		
		// Must use recursion
		// Must return a String of the form: r,c-r1,c1-r2,c2
		if (startrow == endrow && startcol == endcol) {
			return startrow + "," + startcol;
		}
		
		// drop breadcrumb
		char crumb = maze[startrow][startcol];
		maze[startrow][startcol] = '.';
		
		MazeView v = new MazeView(this);
		System.out.println();
		v.drawMaze();
		
		String result = null;
		
		// East
		if (validMove(startrow, startcol + 1)) {
			result = solve(startrow, startcol + 1, endrow, endcol);
			if (result != null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		// South
		if (validMove(startrow + 1, startcol)) {
			result = solve(startrow + 1, startcol, endrow, endcol);
			if (result!= null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		// West
		if (validMove(startrow, startcol - 1)) {
			result = solve(startrow, startcol - 1, endrow, endcol);
			if (result!= null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		// North
		if (validMove(startrow - 1, startcol)) {
			result = solve(startrow - 1, startcol, endrow, endcol);
			if (result!= null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		// Backtrack
		maze[startrow][startcol] = crumb;
		
		return null;
	}
    }
	
