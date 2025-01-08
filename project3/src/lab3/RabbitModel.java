package lab3;

public class RabbitModel {
	private int size;

	  public RabbitModel()
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
