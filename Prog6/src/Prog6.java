import java.util.*;

public class Prog6 {
	public static void main (String[] args){
		Polynomial poly = new Polynomial();
		
		poly.addTerm(2, 3);
		poly.addTerm(-1, 0);
		poly.addTerm(1, -4);
		
		System.out.println(poly.toString());
		System.out.println("Holding Terms: " + poly.holding());
		System.out.println("Is Full? " + poly.isFull());
		System.out.println("Is Empty? " + poly.isEmpty());
		System.out.println("Adding Term 3 ^ 6\n");
		
		poly.addTerm(3, 6);
		
		System.out.println(poly.toString());
		System.out.println("Holding Terms: " + poly.holding());
		System.out.println("Is Full? " + poly.isFull());
		System.out.println("Is Empty? " + poly.isEmpty());
		System.out.println("Adding Term -10 ^ 2\n");

		poly.addTerm(-10, 2);
		
		System.out.println(poly.toString());
		System.out.println("Holding Terms: " + poly.holding());
		System.out.println("Is Full? " + poly.isFull());
		System.out.println("Is Empty? " + poly.isEmpty());
		System.out.println("Negating...\n");
		
		Polynomial polyNeg = poly.negate();
		
		System.out.println(polyNeg.toString());
		System.out.println("Holding Terms: " + polyNeg.holding());
		System.out.println("Is Full? " + polyNeg.isFull());
		System.out.println("Is Empty? " + polyNeg.isEmpty());
		System.out.println("Scalar Multiplication by 4 to negated polynomial...\n");
		
		polyNeg.scalarMultiply(4);
		
		System.out.println(polyNeg.toString());
		System.out.println("Holding Terms: " + polyNeg.holding());
		System.out.println("Is Full? " + polyNeg.isFull());
		System.out.println("Is Empty? " + polyNeg.isEmpty());
		System.out.println("Replicating...\n");
		
		Polynomial polyNegRep = polyNeg.replicate();
		
		System.out.println(polyNegRep.toString());
		System.out.println("Holding Terms: " + polyNegRep.holding());
		System.out.println("Is Full? " + polyNegRep.isFull());
		System.out.println("Is Empty? " + polyNegRep.isEmpty());
		System.out.println("Add Term 5 ^ 3\n");
		
		polyNegRep.addTerm(5, 3);
		
		System.out.println(polyNegRep.toString());
		System.out.println("Holding Terms: " + polyNegRep.holding());
		System.out.println("Is Full? " + polyNegRep.isFull());
		System.out.println("Is Empty? " + polyNegRep.isEmpty());
		System.out.println("Add Term 8 ^ -4\n");

		polyNegRep.addTerm(8, -4);
		
		System.out.println(polyNegRep.toString());
		System.out.println("Holding Terms: " + polyNegRep.holding());
		System.out.println("Is Full? " + polyNegRep.isFull());
		System.out.println("Is Empty? " + polyNegRep.isEmpty());
		
		System.out.println("\nAdding \n" +
				           polyNeg.toString() +
				           "\nto\n" +
				           polyNegRep.toString() + "\n");
		
		Polynomial polyAdd = polyNeg.add(polyNegRep);
		
		System.out.println(polyAdd.toString());
		System.out.println("Holding Terms: " + polyAdd.holding());
		System.out.println("Is Full? " + polyAdd.isFull());
		System.out.println("Is Empty? " + polyAdd.isEmpty());
		
		System.out.println("\nAre\n" +
		                   polyNeg.toString() +
		                   "\nand\n" +
		                   polyNegRep.toString() + 
		                   "\nequal?");
		System.out.println(polyNeg.equals(polyNegRep));
		
		Polynomial polyAddRep = polyAdd.replicate();
		
		System.out.println("\nAre\n" +
		                   polyAdd.toString() +
		                   "\nand\n" +
		                   polyAddRep.toString() + 
		                   "\nequal?");
		System.out.println(polyAdd.equals(polyAddRep));
		
		Polynomial polyEval = new Polynomial();
		polyEval.addTerm(2, 3);
		polyEval.addTerm(8, 2);
		polyEval.addTerm(5, 1);

		
		System.out.println("\nEvaluating\n" +
				           polyEval.toString() +
				           "\nwhen x = 3...");
		System.out.println(polyEval.evaluate(3));

	}
}
