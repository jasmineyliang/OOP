package postage3;

public class PostageUtil {
	public static double computePostage(double weight)
	  {
		  double cost;
		  cost = 0.47;
		  
		  if (weight >1) {
			  cost = 0.47 + Math.ceil(weight - 1) * 0.21;
			  }
		  
		  if (weight>3.5) {
		    	  cost = 0.94 + Math.ceil(weight - 1) * 0.21;
		    	  }
		  
		  
		  
		  
		  
	      //return 0.0;
		  return cost;
	  }
}
