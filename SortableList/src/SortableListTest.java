import static org.junit.Assert.*;
import org.junit.Test;
import java.math.*;
import java.util.Random;

public class SortableListTest {

	@Test
	public void testAddSizeAndGet() {
		SortableList<Integer> ints = new SortableList<Integer>();
		SortableList<String> names = new SortableList<String>();

		// Add a few elements to ints
		assertEquals(0, ints.size());
		ints.add(79);
		ints.add(92);
		ints.add(87);
		assertEquals(3, ints.size());
		assertFalse(ints.isSorted());
		// The casts is needed for JUnit's assertEquals method
		assertEquals(79, (int) ints.get(0));
		assertEquals(92, (int) ints.get(1));
		assertEquals(87, (int) ints.get(2));

		// Add a few elements to name
		assertEquals(0, names.size());
		names.add("Cody");
		names.add("Tyson");
		names.add("Lane");
		assertEquals(3, names.size());
		assertEquals("Cody", names.get(0));
		assertEquals("Tyson", names.get(1));
		assertEquals("Lane", names.get(2));
		assertFalse(names.isSorted());
	}

	@Test
	public void testSort() {
		SortableList<Integer> ints = new SortableList<Integer>();
		SortableList<String> names = new SortableList<String>();

		/*// Add a few elements to ints
		assertEquals(0, ints.size());
		ints.add(79);
		ints.add(92);
		ints.add(85);
		ints.add(75);
		assertEquals(4, ints.size());
		assertFalse(ints.isSorted());
		// The casts is needed for JUnit's assertEquals method
		assertEquals(79, (int) ints.get(0));
		assertEquals(92, (int) ints.get(1));
		assertEquals(85, (int) ints.get(2));
		//SORT
		System.out.println("Pre-sorted: "+ints.toString());
		ints.sort();
		assertTrue(ints.isSorted());
		System.out.println("Sorted: "+ints.toString());
		assertEquals(75, (int) ints.get(0));
		assertEquals(85, (int) ints.get(2));
		assertEquals(92, (int) ints.get(3));*/

		// Add a few elements to name
		assertEquals(0, names.size());
		names.add("Cody");
		names.add("Tyson");
		names.add("Lane");
		
		assertEquals(3, names.size());
		assertEquals("Cody", names.get(0));
		assertEquals("Tyson", names.get(1));
		assertEquals("Lane", names.get(2));
		assertFalse(names.isSorted());
		//SORT
		names.sort();
		assertTrue(names.isSorted());
	}

	@Test
	public void testToString() {
		SortableList<Integer> ints = new SortableList<Integer>();
		SortableList<String> names = new SortableList<String>();

		// Add a few elements to ints
		assertEquals(0, ints.size());
		ints.add(79);
		ints.add(92);
		ints.add(87);
		assertEquals(3, ints.size());

		assertEquals("[79, 92, 87]", ints.toString());

		// Add a few elements to name
		assertEquals(0, names.size());
		names.add("Cody");
		names.add("Tyson");
		names.add("Lane");
		assertEquals(3, names.size());

		assertEquals("[Cody, Tyson, Lane]", names.toString());
	}

	@Test
	public void testRemove(){
		SortableList<Integer> ints = new SortableList<Integer>();

		// Add a few elements to ints
		assertEquals(0, ints.size());
		ints.add(79);
		ints.add(92);
		ints.add(93);
		ints.add(93);
		ints.add(87);
		assertEquals(5, ints.size());
		assertEquals("[79, 92, 93, 93, 87]", ints.toString());
		assertEquals(92, (int) ints.get(1));
		assertEquals(87, (int) ints.get(4));
		assertTrue(ints.remove(87));
		assertEquals(4, ints.size());
		assertEquals(79, (int) ints.get(0));
		assertEquals("[79, 92, 93, 93]", ints.toString());
		assertTrue(ints.remove(93));
		assertEquals("[79, 92, 93]", ints.toString());
		assertTrue(ints.remove(92));
		assertTrue(ints.remove(79));
		
		assertFalse(ints.remove(100));
		assertFalse(ints.remove(1123));
		assertFalse(ints.remove(345));
		assertFalse(ints.remove(23));
		
	}

	@Test
	public void testGrow(){
		SortableList<Integer> ints = new SortableList<Integer>();

		// Add a few elements to ints
		assertEquals(0, ints.size());
		ints.add(79);
		ints.add(92);
		ints.add(87);
		assertEquals(3, ints.size());
		assertFalse(ints.isSorted());
		// The casts is needed for JUnit's assertEquals method
		assertEquals(79, (int) ints.get(0));
		assertEquals(92, (int) ints.get(1));
		assertEquals(87, (int) ints.get(2));
		for (int i = 0; i < 60; i++)
		{
			ints.add((int) Math.random()*100);
		}
		assertEquals(63, ints.size());
	}
	
	@Test
	public void testZeroSize(){
		SortableList<Integer> ints = new SortableList<Integer>();

		assertEquals(0, ints.size());
		assertTrue(ints.isSorted());
		assertEquals("[]", ints.toString());
		ints.sort();
	}

	@Test
	public void testReverse(){
		SortableList<Integer> ints = new SortableList<Integer>();

		// Add a few elements to ints
		assertEquals(0, ints.size());
		ints.add(79);
		ints.add(92);
		ints.add(87);
		assertEquals(3, ints.size());
		assertFalse(ints.isSorted());
		// The casts is needed for JUnit's assertEquals method
		assertEquals(79, (int) ints.get(0));
		assertEquals(92, (int) ints.get(1));
		assertEquals(87, (int) ints.get(2));
		
		//REVERSE!
		ints.reverse();
		assertEquals(3,ints.size());
		assertEquals(87, (int) ints.get(0));
		assertEquals(92, (int) ints.get(1));
		assertEquals(79, (int) ints.get(2));
	}

	@Test
	public void testSortOnRandomData(){
		SortableList<Integer> ints = new SortableList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 20; i++){
			ints.add(rand.nextInt(20));
		}
		//assertFalse(ints.isSorted());
		ints.sort();
		//System.out.println(ints.toString());
		assertTrue(ints.isSorted());
	}
	
}
