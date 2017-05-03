import static org.junit.Assert.*;
import org.junit.Test;

public class GameOfLifeTest {
	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		// System.out.println(society.toString());
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	@Test
	public void testGrowCellAtAndCelAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);
		// System.out.println(society.toString());

		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
	}

	@Test
	public void testNeighborsWrapping() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		society.growCellAt(0, 0);
		society.growCellAt(0, 15);
		society.growCellAt(9, 0);
		society.growCellAt(4, 4);
		//System.out.println(society.toString());
		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(2, society.neighborCount(0, 15));
		assertEquals(2, society.neighborCount(9, 0));
		assertEquals(3, society.neighborCount(9, 15));
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));
		assertEquals(1, society.neighborCount(1, 1));
		assertEquals(2, society.neighborCount(1, 0));
		assertEquals(2, society.neighborCount(0, 1));
		// ... many more assertions expected

	}

	@Test
	public void testFirstExample(){
		GameOfLife society = new GameOfLife(6,5);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 1);
		society.growCellAt(2, 3);
		society.growCellAt(3,2);
		
		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 1));
		assertTrue(society.cellAt(2, 3));
		assertTrue(society.cellAt(3, 2));
		
		assertEquals(1,society.neighborCount(1, 1));
		assertEquals(4,society.neighborCount(2, 2));
		assertEquals(1,society.neighborCount(0, 0));
		assertEquals(1,society.neighborCount(0, 1));
		assertEquals(3,society.neighborCount(3, 2));
		
		//System.out.println(society.toString());
		society.update();
		
		assertTrue(society.cellAt(1,2));
		assertFalse(society.cellAt(1,1));
		assertTrue(society.cellAt(2,3));
		assertFalse(society.cellAt(2,2));
		assertTrue(society.cellAt(3,1));
		
		
		
		
	}
	
	// ... Many more test methods expected
	@Test
	public void testUpdate() {
		GameOfLife society = new GameOfLife(20, 30);
		society.growCellAt(5, 0);
		society.growCellAt(6, 0);
		society.growCellAt(5, 1);
		society.growCellAt(6, 1);
		society.growCellAt(3, 7);
		society.growCellAt(3, 8);
		society.growCellAt(4, 6);
		society.growCellAt(5, 5);
		society.growCellAt(6, 5);
		society.growCellAt(7, 5);
		society.growCellAt(8, 6);
		society.growCellAt(9, 7);
		society.growCellAt(9, 8);
		society.growCellAt(6, 9);
		society.growCellAt(4, 10);
		society.growCellAt(8, 10);
		society.growCellAt(5, 11);
		society.growCellAt(6, 11);
		society.growCellAt(7, 11);
		society.growCellAt(6, 12);
		society.growCellAt(3, 15);
		society.growCellAt(4, 15);
		society.growCellAt(5, 15);
		society.growCellAt(3, 16);
		society.growCellAt(4, 16);
		society.growCellAt(5, 16);
		society.growCellAt(2, 17);
		society.growCellAt(6, 17);
		society.growCellAt(1, 19);
		society.growCellAt(2, 19);
		society.growCellAt(6, 19);
		society.growCellAt(7, 19);
		assertTrue(society.cellAt(7,19));
		assertTrue(society.cellAt(3,15));
		assertTrue(society.cellAt(5, 11));
		assertFalse(society.cellAt(4, 4));
		assertFalse(society.cellAt(4,0));
		assertFalse(society.cellAt(0,0));
		//System.out.println(society.toString());
		society.update();
		/*for (int t = 0; t < 100; t++) {
			society.update();
			System.out.println(society.toString());
		}*/
	}

	@Test
	public void testSection3(){
		GameOfLife society = new GameOfLife(6,5);
		society.growCellAt(0, 0);
		society.growCellAt(0,2);
		society.growCellAt(0,4);
		society.growCellAt(5,2);
		society.growCellAt(5,3);
		society.growCellAt(5,4);
		society.growCellAt(1, 0);

		assertEquals(3,society.neighborCount(0, 0));
		assertEquals(2,society.neighborCount(0, 2));
		assertEquals(4,society.neighborCount(0, 4));
		assertEquals(2,society.neighborCount(5, 2));
		assertEquals(4,society.neighborCount(5, 3));
		assertEquals(3,society.neighborCount(5, 4));
		
		society.update();
		
		assertFalse(society.cellAt(5, 3));
		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(4, 3));
		
		
	}

	@Test
	public void testAllFull(){
		GameOfLife society = new GameOfLife(10,10);
		for (int r = 0; r < 10; r++){
			for (int c = 0; c < 10; c++){
				society.growCellAt(r, c);
			}
		}
		for (int r = 0; r < 10; r++){
			for (int c = 0; c < 10; c++){
				assertEquals(8, society.neighborCount(r, c));
			}
		}
		society.update();
		for (int r = 0; r < 10; r++){
			for (int c = 0; c < 10; c++){
				assertFalse(society.cellAt(r,c));
			}
		}
	}
}
