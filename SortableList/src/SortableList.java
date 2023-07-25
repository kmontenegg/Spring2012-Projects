/**
 * 
 * @author Kevin Montenegro
 * 
 * @param <E>
 *            The generic argument that states what type of data this
 *            SortableList will hold.
 */
public class SortableList<E extends Comparable<E>> {

	private Object[] elements;
	private boolean isSorted;
	private int size;

	/**
	 * Create a new Object array of capacity 20 (MUST BE 20), set the size to
	 * zero, and set isSorted to false;
	 */
	public SortableList() {
		elements = new Object[20];
		size = 0;
		isSorted = false;
	}

	/**
	 * Adds the passed element at index size (at the end of the list) to the
	 * array. Will grow the array if necessary.
	 * 
	 * If adding the next value ruins the sort the array, set isSorted to false
	 * 
	 * @param data
	 *            The element being added at the 'end' of this SortableList, at
	 *            index size()
	 */
	public void add(E data) {

		if (size >= elements.length - 1) {
			Object[] temp = new Object[size + 20];
			for (int i = 0; i <= size; i++) {
				temp[i] = elements[i];
			}
			elements = temp;
			elements[size] = data;
			size++;
		} else {
			elements[size] = data;
			size++;
		}
		if (size == 1) {
			isSorted = true;
		} else {
			if (data.compareTo(this.get(size - 2)) < 0) {
				isSorted = false;
			}
		}

	}

	/**
	 * Returns the data at the given index.
	 * 
	 * @param index
	 *            The location of the element.
	 * @return The element at the given index or null if there isn't data at the
	 *         given index
	 * 
	 *         Precondition: 0 <= index <= size()
	 */

	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) elements[index];
	}

	/**
	 * Removes the first occurrence of the passed data from this Sortable List
	 * and returns true. If the passed data isn't in this Sortable List, return
	 * false.
	 * 
	 * All data after the removed element should be shifted to the left. For
	 * example: [1, 2, 3, 4, 5, 6, 7, 8] will become this after removing 4: [1,
	 * 2, 3, 5, 6, 7, 8]
	 * 
	 * @param data
	 *            The element that equals data will be removed if found
	 * @return true if the data was removed, false otherwise.
	 */
	public boolean remove(E data) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == data && i > 1) {
				Object[] temp = new Object[elements.length];
				for (int j = i - 1; j >= 0; j--) {
					temp[j] = elements[j];
				}
				for (int k = i; k <= size; k++) {
					temp[k] = elements[k + 1];
				}
				elements = temp;
				size--;
				return true;
			} else if (elements[i] == data && i == 1) {
				Object[] temp = new Object[elements.length];
				temp[0] = elements[0];
				for (int j = 1; j < size; j++) {
					temp[j] = elements[j];
				}
				elements = temp;
				size--;
				return true;
			} else if (elements[i] == data && i == 0) {
				Object[] temp = new Object[elements.length];
				for (int k = i; k <= size; k++) {
					temp[k] = elements[k + 1];
				}
				elements = temp;
				size--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the number of elements currently contained in this Sortable List.
	 * 
	 * @return the number of elements that have been added so far
	 */
	public int size() {
		return size;
	}

	/**
	 * Return whether this Sortable List is sorted.
	 * 
	 * @return whether the list is sorted
	 */
	public boolean isSorted() {
		if (size > 0) {
			for (int i = 0; i < size - 1; i++) { // Use size-1 to avoid null
													// pointer exceptions and
													// unknown sources
				if (this.get(i).compareTo(this.get(i + 1)) <= 0) {
					isSorted = true;
				} else {
					isSorted = false;
				}
			}
		} else {
			isSorted = true;
		}
		return isSorted;
	}

	/**
	 * Uses the Insertion Sort algorithm to put all data in ascending order
	 * (smallest to largest)
	 * 
	 * Only sort the data if it's not currently sorted.
	 */
	public void sort() {
		Object temp;
		if (size <= 1) {
			return;
		} else {
			for (int i = 1; i < size; i++) {
				if (this.get(i).compareTo(this.get(i - 1)) >= 0) {

				} else {
					int index = i;
					while (this.get(index).compareTo(this.get(index - 1)) < 0
							&& index > 1) {
						temp = this.get(index);
						this.elements[index] = this.elements[index - 1];
						this.elements[index - 1] = temp;
						index--;
					}
				}
			}
			//System.out.println("first sort: "+this.toString());
			if (!this.isSorted) {
				
				Object temp2 = this.get(0);
				int index2 = 1;
				while (this.get(index2).compareTo(this.get(0)) < 0) {
					index2++;
				}
				//System.out.println("Index2: " + index2);
				Object[] tempElements = new Object[elements.length];
				for (int k = 0; k < index2; k++) {
					tempElements[k] = elements[k + 1];
				}
				for (int l = index2 + 1; l < size; l++) {
					tempElements[l] = elements[l];
				}
				tempElements[index2] = temp2;
				elements = tempElements;
			}
		}

	}

	/**
	 * reverses the data in the array. The first element becomes last, the
	 * second element becomes second last, and so on.
	 */
	public void reverse() {
		Object[] temp = new Object[elements.length];
		for (int i = 0; i < size; i++) {
			temp[i] = elements[size - 1 - i];
		}
		elements = temp;
	}

	/**
	 * returns a String that starts with a bracket, then has elements separated
	 * by commas and spaces. It should also end with a closing bracket.
	 * 
	 * For example, if we added 10, 54, and 7 to this SortableList, toString()
	 * should return:
	 * 
	 * "[10, 54, 7]"
	 * 
	 * If we added "Lane", "Tyson", "Rick", and "Cody" it should return
	 * "[Lane, Tyson, Rick, Cody]"
	 * 
	 * An empty list should return "[]"
	 */
	public String toString() {
		String str = "[";
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (i + 1 == size) {
					str += elements[i] + "]";
				} else {
					str += elements[i] + ", ";
				}
			}
		} else {
			str = "[]";
		}
		return str;
	}

}