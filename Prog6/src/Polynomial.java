import java.math.*;

public class Polynomial implements Quantity {

	private int terms = 0;           //Number of terms in the polynomial
	private Term[] polyArray;        //The Term array (or Polynomial)
	
	public Polynomial(){
		polyArray = new Term[10];
	}
	
	public Polynomial add(Polynomial p){
		Polynomial added = new Polynomial();
		for (int i = 0; i < p.terms; i++)
		{
			added.addTerm(p.polyArray[i].getCoefficient(), p.polyArray[i].getExponent());
		}
		for (int j = 0; j < this.terms; j++)
		{
			added.addTerm(polyArray[j].getCoefficient(), polyArray[j].getExponent());
		}
		return added;
	}
	
	public void addTerm(double c, int e){
		if (terms == polyArray.length-1)                      //Grow Array if necessary
		{
			Term[] newArray = new Term[polyArray.length+10];
			for (int j = 0; j < polyArray.length; j++)
			{
				newArray[j] = polyArray[j];
			}
			polyArray = newArray;
		}
		
		boolean done = false;                     //If there is a term with the same exponent, simply add the coefficients
		for (int i = 0; i < terms; i++)
		{
			if (polyArray[i].getExponent() == e)
			{
				polyArray[i].setCoefficient(polyArray[i].getCoefficient() + c);
				done = true;
			}
		}
		if (!done)                      //If this is a new exponent, add a new term
		{
			polyArray[terms] = new Term(c, e);
			terms++;
		}
	}
	
	public Polynomial replicate(){
		Polynomial replica = new Polynomial();
		for (int i = 0; i < this.terms; i++)
		{
			replica.addTerm(polyArray[i].getCoefficient(), polyArray[i].getExponent());
		}
		return replica;
	}
	
	public boolean equals(Polynomial p){
		if (this.holding() != p.holding())
		{
			return false;
		}
		else
		{
			for (int i = 0; i < this.terms; i++)
			{
				int currentExponent = polyArray[i].getExponent();
				if (this.getCoefficient(currentExponent) != p.getCoefficient(currentExponent))
				{
					return false;
				}
			}
			return true;

		}
	}
	
	
	
	public double evaluate(double x){
		double result = 0;
		
		for (int i = 0; i < terms; i++)
		{
			result += Math.pow((polyArray[i].getCoefficient() * x), polyArray[i].getExponent());
		}
		
		return result;
	}

	public double getCoefficient(int e){
		for (int i = 0; i < terms; i++)
		{
			if (polyArray[i].getExponent() == e)
			{
				return polyArray[i].getCoefficient();
			}
		}
		return 0;
	}
	
	public boolean isEmpty() {
		if (terms > 0){
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean isFull() {
		return false;
	}

	public int holding() {
		int result = 0;
		for (int i = 0; i < terms; i++)
		{
			if (polyArray[i].getCoefficient() != 0)
			{
				result++;
			}
		}
		return result;
	}
	
	public Polynomial negate(){
		Polynomial neg = new Polynomial();
		for (int i = 0; i < this.terms; i++)
		{
			neg.addTerm(polyArray[i].getCoefficient() * -1, polyArray[i].getExponent());
		}
		return neg;
	}
	
	public void scalarMultiply(double s){
		for (int i = 0; i < this.terms; i++)
		{
			polyArray[i].setCoefficient(polyArray[i].getCoefficient() * s);
		}
	}
	
	public String toString(){
		String result = "";
		result += "(" + polyArray[0].getCoefficient() + ")x ^ (" + polyArray[0].getExponent() + ")";
		
		for (int i = 1; i < terms; i++)
		{
			result += " " + polyArray[i].getSign() + " ";
			
			if (polyArray[i].getCoefficient() < 0)
			{
				result += "(" + (polyArray[i].getCoefficient() * -1) + ")x ^ (" + polyArray[i].getExponent() + ")";
			}
			else
			{
				result += "(" + polyArray[i].getCoefficient() + ")x ^ (" + polyArray[i].getExponent() + ")";
			}
		}
		
		return result;
	}

}
