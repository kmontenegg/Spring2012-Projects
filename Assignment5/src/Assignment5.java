import java.util.*;

public class Assignment5 {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Pet pet1 = new Pet("Fido", 3);
		Pet pet2 = new Pet("Furball", 1);
		Pet pet3 = null;
		System.out.println("Welcome to the pet store!");
		String menuSelection = menu();
		while (!menuSelection.equals("E")){
			switch (menuSelection){
			case "A" : 	listPets(pet1, pet2, pet3);
						break;
			case "B" : 	if (pet1 != null){
							pet1.ageUp();
						}
						if (pet2 != null){
							pet2.ageUp();
						}
						if (pet3 != null){
							pet3.ageUp();
						}
						System.out.println("Everyone just got a little older.");
						break;
			case "C" : 	if (pet3 == null){
							System.out.println("Please type in a name for the new pet: ");
							String newName = scan.nextLine();
							System.out.println("Please type in an age for the new pet: ");
							int newAge = scan.nextInt();
							pet3 = new Pet(newName, newAge);
							System.out.println(pet3.getName() + " has arrived in the store.");
							scan.nextLine();
						}
						else{
							System.out.println("The store is full!");
							//scan.nextLine();
						}
						break;
			case "D" :	System.out.println("Type the number of the pet you would like to adopt.");
						int adoptChoice = scan.nextInt();
						switch (adoptChoice){
						case 1 :  if (pet1 != null){
									if (pet1.isAdopted()){
										System.out.println(pet1.getName() + " is already adopted.");
									}
									else{
										pet1.adoptPet();
										System.out.println(pet1.getName() + " has been adopted!");
									}
								  }
								  else{
									System.out.println("That is not a valid pet.");
								  }
								  break;
						case 2 :  if (pet2 != null){
									if (pet2.isAdopted()){
										System.out.println(pet2.getName() + " is already adopted.");
									}
									else{
										pet2.adoptPet();
										System.out.println(pet2.getName() + " has been adopted!");
									}
								  }
						  		  else{
						  			System.out.println("That is not a valid pet.");
						  		  }
								  break;
						case 3 : if (pet3 != null){
									if (pet3.isAdopted()){
										System.out.println(pet3.getName() + " is already adopted.");
									}
									else{
										pet3.adoptPet();
										System.out.println(pet3.getName() + " has been adopted!");
									}
						  		  }
				  		  		  else{
				  		  			  System.out.println("That is not a valid pet.");
				  		  		  }
								  break;
						}
						scan.nextLine();
						break;
			case "F" : System.out.println("You pet all the pets and now you must take one home.");
						break;
			}
			menuSelection = menu();
		}
		System.out.println("Have a good day!");
	}

	private static String menu(){
		System.out.println("Type the letter of your selection.");
		System.out.println("A. List the pets in the store.");
		System.out.println("B. Age up the pets.");
		System.out.println("C. Add a new pet.");
		System.out.println("D. Adopt a pet.");
		System.out.println("E. Quit.");
		System.out.println("F. Pet the Pets <3 <3 <3");
		String selection = scan.nextLine();
		 while (!(selection.equals("A") || selection.equals("B") || selection.equals("C") || selection.equals("D") || selection.equals("E") || selection.equals("F"))){
				System.out.println("Invalid selection!");
				selection = scan.nextLine();
			}
		return selection;
	}
	
	private static void listPets(Pet myPet1, Pet myPet2, Pet myPet3){
		if (myPet1.getAge() == 1){
			if (myPet1.isAdopted()){
				System.out.println(myPet1.getName() + " is " + myPet1.getAge() + " year old and is adopted.");
			}
			else{
				System.out.println(myPet1.getName() + " is " + myPet1.getAge() + " year old and is not adopted.");
			}
		}
		else{
			if (myPet1.isAdopted()){
				System.out.println(myPet1.getName() + " is " + myPet1.getAge() + " years old and is adopted.");
			}
			else{
				System.out.println(myPet1.getName() + " is " + myPet1.getAge() + " years old and is not adopted.");
			}
		}
		/////////////////////
		if (myPet2.getAge() == 1){
			if (myPet2.isAdopted()){
				System.out.println(myPet2.getName() + " is " + myPet2.getAge() + " year old and is adopted.");
			}
			else{
				System.out.println(myPet2.getName() + " is " + myPet2.getAge() + " year old and is not adopted.");
			}
		}
		else{
			if (myPet2.isAdopted()){
				System.out.println(myPet2.getName() + " is " + myPet2.getAge() + " years old and is adopted.");
			}
			else{
				System.out.println(myPet2.getName() + " is " + myPet2.getAge() + " years old and is not adopted.");
			}
		}
		/////////////////////////////
		if(myPet3 != null){
		if (myPet3.getAge() == 1){
			if (myPet3.isAdopted()){
				System.out.println(myPet3.getName() + " is " + myPet3.getAge() + " year old and is adopted.");
			}
			else{
				System.out.println(myPet3.getName() + " is " + myPet3.getAge() + " year old and is not adopted.");
			}
		}
		else{
			if (myPet3.isAdopted()){
				System.out.println(myPet3.getName() + " is " + myPet3.getAge() + " years old and is adopted.");
			}
			else{
				System.out.println(myPet3.getName() + " is " + myPet3.getAge() + " years old and is not adopted.");
			}
		}
		}
	}
	
}
