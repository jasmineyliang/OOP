package lab3;
import java.util.Random;

public class RabbitModelRan {
	private int size;
    private int years;
	  public RabbitModelRan()
	  {
		  
	    size = 0;
	    years = 0;
	 
	  }  
	 


	  public int getPopulation()
	  {
		return size;
	  }
	  


	  public void simulateYear()
	  {
		  
		 
		  
		  Random rand = new Random(10);
		  //years = years + rand.nextInt(10);
		  size = size + rand.nextInt(10); 
	  }
	  


	  public void reset()
	  {
	    size = 0;
	    years = 0;
	  }
}