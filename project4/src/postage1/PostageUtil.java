package postage1;
import java.util.Scanner;
public class PostageUtil{
	public static void main(String[] args) {
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
      
      Scanner scanner = new Scanner (System.in);
      System.out.print("Enter a weight: ");
      double weight = scanner.nextDouble();
      
	  double cost;
	  if (weight <=1) {
		  cost = 0.47;
	  }
	  
	  if (weight<=3.5) {
		  cost = 0.47 + Math.ceil(weight - 1) * 0.21;
		  
	  }
				 
	  else {
		  cost = 0.94 + Math.ceil(weight - 1) * 0.21;
	  }
      //return 0.0;
	  //return cost;
	  System.out.println(cost);
  }
}