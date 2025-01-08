package lab3;

public class RabbitModel12 {
	private int size;

	  public RabbitModel12()
	  {
	    size = 2;
	  }  
	 


	  public int getPopulation()
	  {
		return size;
	  }
	  


	  public void simulateYear()
	  {
		 
		  size=size+1;
	  }
	  


	  public void reset()
	  {
	    size = 2;
	  }
}
