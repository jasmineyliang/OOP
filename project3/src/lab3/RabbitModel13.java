package lab3;

public class RabbitModel13 {
	private int size;
    private int years;
	  public RabbitModel13()
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
		 
		  size= years%5;
		  
	  }
	  


	  public void reset()
	  {
	    size = 2;
	  }
}
