package lab5;

public class Basketball {
	private boolean isInflated;
	private double diameter;
	
	public Basketball(double givenDiameter)
	  {
		isInflated = false;
	    diameter = givenDiameter;
	  }

	  public boolean isDribbleable()
	  {
		  return isInflated;
	  }

	  public double getDiameter()
	  {
	    return 0;
	  }

	  public double getCircumference()
	  {
	    return 0;
	  }

	  public void inflate()
	  {
		  isInflated = true;
	  }
}
