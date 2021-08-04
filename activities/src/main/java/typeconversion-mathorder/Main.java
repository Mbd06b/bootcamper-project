package com.pluralsight.typeconversion.mathorder.review;

public class Main {

	public static void main(String[] args) {
		
		/* TODO Create 4 variable.
		 * 
		 */
		
		  int valA = 21;
	      int valB = 6;
	      int valC = 3;
	      int valD = 1;
	      
	   /*  TODO Math Operators.
	    * 
	    */
	      int result1 = valA - valB / valC;
	      int result2 = (valA - valB) / valC;
	      
	  /* Print Results
	   * 
	   */
	      
	      System.out.println(result1);
	      System.out.println(result2);
	      
	  /* TODO New Math Operator
	   * 
	   */
	      
	      int result3 = valA / valC * valD + valB;
	      
	      int result4 = valA / (valC * (valD + valB));
	      
      /* TODO Add Print Statement
       * 
       */
	      System.out.println(result3);
	      System.out.println(result4);
	
	/* TODO Create Variables
	 * 
	 */
	float floatVal = 1.0f;
	double doubleVal = 4.0d;
	byte byteVal = 7;
	Short shortVal = 7;
	long longVal = 5;
	
	
	/* TODO Cast Variables to get
	 *  
	 */
  short result5 = (short)byteVal;
  short result6 = (short) (byteVal - longVal);
  double result7 = longVal - doubleVal;
  long result8 = (long) (shortVal - longVal + floatVal + doubleVal);
	
	
 	
	/* TODO Add print Statement
	 * 
	 */
  
  System.out.println(result5);
  System.out.println(((Object)result1).getClass().getName());
  
  System.out.println(result6);
  System.out.println(((Object)result2).getClass().getName());
  
  System.out.println(result7);
  System.out.println(((Object)result3).getClass().getName());
  
  System.out.println(result8);
  System.out.println(((Object)result4).getClass().getName());
  
  System.out.println("Success");
}


}







