import java.util.*;
public class Examples {
	
	
	
	
	public static void main(String[] args) {
		
		/*TODO Create Example of if nested statement that 
		 * utilizes conditional logic.
		 */ 
		int students = 150;
		float rooms = 0.0f;
		boolean isThereRoom = true;
		
		float studentPerRoom = rooms == 0.0f ? 0.0f : students/rooms;
		System.out.println(studentPerRoom);
			
			//Exclusive OR && showing the use of Code Block
		if (students >= 200 ^ rooms <= 12) 
			System.out.println("The second Condition evaluated true");
		else 
			System.out.println("Showing that the if statement, only " 
					+ "prosses one line of code unless inside a Block");
		
        if(isThereRoom) {		
        	if(students > 120 && rooms == 0.0f) {
        		System.out.println("We just met three seperate conditions");
        	}else {
        		System.out.println("We didn't meet all the criteria");
        	}
        }else {
        	System.out.println("The boolean isThereRoom was false");
        }
		/*Basic looping
	    TODO Create while loop to calculate fibonacci sequence 1,2,3,5,8
	    */
		
		int upToo=11 , num1 = 0, num2 =1, index = 1;
		
		
		while(index <= upToo){
			System.out.print(num1+" ");
			int sumOfPreviousTwo = num1 + num2;
			if (num1 >0);
			num1 = num2;
			num2 = sumOfPreviousTwo;
			index++;	
		}
		System.out.println();
		System.out.println("This is the Fibonacci sequence up to " +
		upToo + " items");
		
		//Declare Array------------------------------------------------
		String[] faveAnimals = {"Cat", "Dog", "Lion", "Squritle", "Eevee"};
		
		//Show case methods that can be used with arrays
		System.out.println(Arrays.toString(faveAnimals));
		
		System.out.println("I have "+ faveAnimals.length +" animals in my Array");
		
		
		//For Each ----------------------------------------------------
		
		
		for(String animal : faveAnimals) {
			if(animal.equals("Squritle")) {
				System.out.println("Isn't it fun to have a pet " + animal+"!");
			}
			
		}	
	   // Switch example (I changed the special animal so it would be true)
		String specialAnimal = "Eevee"; 
			switch (specialAnimal.charAt(0)) {		
			case'C':
				System.out.println("My favorite animal is " + specialAnimal);
				break;
			case 'D': 
				System.out.println("My favorite animal is " + specialAnimal);
				break;
			case 'L': 
				System.out.println("My favorite animal is " + specialAnimal);
				break;
			case 'S': 
				System.out.println("My favorite animal is " + specialAnimal);
				break;
			case 'E': 
				System.out.println("My favorite animal is " + specialAnimal);
				break;
			default: 
				System.out.println("No case was found for " + specialAnimal);
				
			
			
		}
		
		
	}
}
