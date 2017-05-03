
public class Term {

	private double coefficient;
	private int exponent;
	private String sign;
	
	public Term(double c, int e){
		coefficient = c;
		exponent = e;
		if (coefficient >= 0)
		{
			sign = "+";
		}
		else
		{
			sign = "-";
		}
	}

	public String getSign() {
		return sign;
	}
	
	public int getExponent() {
		return exponent;
	}

	public double getCoefficient() {
		return coefficient;
	}
	
	public void setSign(String s)
	{
		this.sign = s;
	}
	
	public void setExponent(int e){
		this.exponent = e;
	}
	
	public void setCoefficient(double c){
		this.coefficient = c;
		
		if (c >= 0)
		{
			this.setSign("+");
		}
		else
		{
			this.setSign("-");
		}
	}
}
