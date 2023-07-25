
public class Pet {
	private String name;
	private int age;
	private boolean adopted;
	
	public Pet(){
		name = "pet";
		age = 1;
		adopted = false;
	}
	
	public Pet(String myName, int myAge){
		name = myName;
		age = myAge;
		adopted = false;
	}
	
	public void setName(String myName){
		name = myName;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void ageUp(){
		age++;
	}
	
	public boolean isAdopted(){
		return adopted;
	}
	
	public void adoptPet(){
		adopted = true;
	}
}
