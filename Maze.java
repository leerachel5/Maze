
public class Maze {
	private char[][] updatingMaze;
	private char[][] maze;
	private int startRow;
	private int startCol;
	
	public Maze(char[][] maze)
	{
		this.updatingMaze = maze;
		this.maze = maze;
	}
	
	public int getStartRow()
	{
		return startRow;
	}
	
	public int getStartCol()
	{
		return startCol;
	}
	
	public void printMaze()
	{
		int count = 0;
		boolean hasExit = false;
		for (int i = 0; i < updatingMaze.length; i++)
		{
			for (int j = 0; j < updatingMaze[0].length; j++)
			{
				if ((i == 0 || i == updatingMaze.length-1 || j == 0 || j == updatingMaze[0].length) && updatingMaze[i][j] == '.')
				{
					hasExit = true;
				}
			}
		}
		if (hasExit)
		{
			for (int i = 0; i < updatingMaze.length; i++)
			{
				for (int j = 0; j < updatingMaze[0].length; j++)
				{
					if (count < updatingMaze[0].length)
					{
						if (updatingMaze[i][j] == ' ' || updatingMaze[i][j] == '*')
						{
							System.out.print(updatingMaze[i][j]);
						}
						else if (updatingMaze[i][j] == 'x')
						{
							System.out.print(' ');
						}
						else if (updatingMaze[i][j] == '.')
						{
							System.out.print('.');
						}
						count++;
					}
					else
					{
						System.out.println();
						
						if (updatingMaze[i][j] == ' ' || updatingMaze[i][j] == '*')
						{
							System.out.print(updatingMaze[i][j]);
						}
						else if (updatingMaze[i][j] == 'x')
						{
							System.out.print(' ');
						}
						else if (updatingMaze[i][j] == '.')
						{
							System.out.print('.');
						}
						count = 1 ;
					}
				}
			}
			System.out.println();
			System.out.println();
		}
		else //maze has no exit
		{
			for (int i = 0; i < updatingMaze.length; i++)
			{
				for (int j = 0; j < updatingMaze[0].length; j++)
				{
					if (count < updatingMaze[0].length)
					{
						if (updatingMaze[i][j] == ' ' || updatingMaze[i][j] == '*')
						{
							maze[i][j] = updatingMaze[i][j];
							System.out.print(updatingMaze[i][j]);
						}
						else if (updatingMaze[i][j] == 'x')
						{
							maze[i][j] = ' ';
							System.out.print(' ');
						}
						else if (updatingMaze[i][j] == '.')
						{
							maze[i][j] = ' ';
							System.out.print(' ');
						}
						count++;
					}
					else
					{
						System.out.println();
						
						if (updatingMaze[i][j] == ' ' || updatingMaze[i][j] == '*')
						{
							maze[i][j] = updatingMaze[i][j];
							System.out.print(updatingMaze[i][j]);
						}
						else if (updatingMaze[i][j] == 'x')
						{
							maze[i][j] = ' ';
							System.out.print(' ');
						}
						else if (updatingMaze[i][j] == '.')
						{
							maze[i][j] = ' ';
							System.out.print(' ');
						}
						count = 1 ;
					}
				}
			}
			System.out.println();
			System.out.println();
		}
	}
	

	
	public boolean atExit()
	{
		boolean atExit = false;
		for (int i = 0; i < updatingMaze.length; i++)
		{
			for (int j = 0; j < updatingMaze[0].length; j++)
			{
				if ((i == 0 || i == updatingMaze.length-1 || j == 0 || j == updatingMaze[0].length) && updatingMaze[i][j] == '.')
				{
					atExit = true;
				}
			}
		}
		return atExit;
	}
	
	public boolean hasExit(Location location)
	{
		this.startRow = location.getX();
		this.startCol = location.getY();
		hasExit2(location.getX(), location.getY());
		return atExit();
	}
	
	
	public boolean hasExit2(int runRow, int runCol)
	{
		updatingMaze[runRow][runCol] = '.';
		if (!(runRow == this.startRow && runCol == this.startCol) && (runRow == 0 || runRow == updatingMaze.length-1 || runCol == 0 || runCol == updatingMaze[0].length-1))
		{
			return true;
		}
		else
		{
			//check top
			if (updatingMaze[runRow-1][runCol] == ' ' && updatingMaze[runRow][runCol] == '.' && runRow != 0)
			{
				//updatingMaze[runRow-1][runCol] = '.';
				return hasExit2(runRow-1, runCol);
			}
			//check right
			else if (updatingMaze[runRow][runCol+1] == ' ' && updatingMaze[runRow][runCol] == '.' && runCol != updatingMaze[0].length)
			{
				//updatingMaze[runRow][runCol+1] = '.';
				return hasExit2(runRow, runCol+1);
			}
			//check bottom
			else if (updatingMaze[runRow][runCol] == '.' && runRow != updatingMaze.length-1 && updatingMaze[runRow+1][runCol] == ' ' )
			{
				//updatingMaze[runRow+1][runCol] = '.';
				return hasExit2(runRow+1, runCol);

			}
			//check left
			else if (updatingMaze[runRow][runCol-1] == ' ' && updatingMaze[runRow][runCol] == '.' && runCol != 0)
			{
				//updatingMaze[runRow][runCol-1] = '.';
				return hasExit2(runRow, runCol-1);
			}
			else
			{
				updatingMaze[runRow][runCol] = 'x';
				//check top
				if (updatingMaze[runRow-1][runCol] == '.')
				{
					//updatingMaze[runRow-1][runCol] = ' ';
					return hasExit2(runRow-1, runCol);
				}
				//check right
				else if (updatingMaze[runRow][runCol+1] == '.')
				{
					//updatingMaze[runRow][runCol+1] = ' ';
					return hasExit2(runRow, runCol+1);
				}
				//check bottom
				else if (updatingMaze[runRow+1][runCol] == '.')
				{
					//updatingMaze[runRow+1][runCol] = ' ';
					return hasExit2(runRow+1, runCol);
				}
				//check left
				else if (updatingMaze[runRow][runCol-1] == '.')
				{
					//updatingMaze[runRow][runCol-1] = ' ';
					return hasExit2(runRow, runCol-1);
				}
			}
			return false;
		}
	}
}


