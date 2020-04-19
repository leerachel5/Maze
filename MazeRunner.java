public class MazeRunner {
	
	public static void main(String[] args)
	{
		char[][] test = 
			{
					{'*', '*', '*'},
					{'*', ' ', '*'},
					{'*', ' ', '*'},
										
			};
		
		char[][] largeExit  =
			{
					{'*', '*', '*', '*', '*', '*', '*', '*', '*', },
					{'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', },
					{'*', ' ', '*', '*', '*', '*', '*', ' ', '*', },
					{'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*', },
					{'*', ' ', '*', ' ', '*', '*', '*', ' ', '*', },
					{'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', },
					{'*', '*', '*', ' ', '*', ' ', '*', ' ', '*', },
					{'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', },
					{'*', ' ', '*', '*', '*', '*', '*', ' ', '*', },
			};
		
		char[][] largeNoExit  =
			{
					{'*', '*', '*', '*', '*', '*', '*', '*', '*', },
					{'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', },
					{'*', ' ', '*', '*', '*', '*', '*', ' ', '*', },
					{'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*', },
					{'*', ' ', '*', ' ', '*', '*', '*', ' ', '*', },
					{'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', },
					{'*', '*', '*', ' ', '*', ' ', '*', ' ', '*', },
					{'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', },
					{'*', '*', '*', '*', '*', '*', '*', '*', '*', },
			};
		
		Maze m1 = new Maze(test);
		System.out.println("Maze test has an exit:"+ m1.hasExit(new Location(1,1)));
		System.out.println("Expected: true");

		
		Maze m2 = new Maze(largeExit);
		System.out.println("Maze largeExit has an exit:"+ m2.hasExit(new Location(2,1)));
		System.out.println("Expected: true");

		
		Maze m3 = new Maze(largeNoExit);
		System.out.println("Maze LargeNoExit has an exit:"+ m3.hasExit(new Location(2,1)));
		System.out.println("Expected: false");
	}

}