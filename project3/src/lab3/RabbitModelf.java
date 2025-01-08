package lab3;

public class RabbitModelf {
	private int size;
    private int lastYear;
    private int yearBefore;
    
	  public RabbitModelf()
	  {
		  
	    size = 0;
	    lastYear = 0;
	    yearBefore = 1;
	 
	  }  
	 


	  public int getPopulation()
	  {
		return size;
	  }
	  


	  public void simulateYear()
	  { 
		  size= lastYear + yearBefore;
		  
	  }
	  


	  public void reset()
	  {
	    size = 0;
	    lastYear = 0;
	    yearBefore = 0;
	  }
}