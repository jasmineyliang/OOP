package hw1;
/**
 * @author YuPin Liang, COM S 227 Section C
 */

public class City {

	/**
	 * set hotel cost per night as private integer hostelcost as an instance variable 
	 * set city name which packpacker visting as private string cityname as an instance variable
	 * set money which packpacker having as private integer money as an instance variable
	 * The cost to mail a postcard from a city is this fraction times the city's hostel cost and set 
	 * this fraction as a static variable POSTCARD_COST = 0.05
	 * */	
	private int hostelcost;
	private String cityname;
	private int money;
	public static final double POSTCARD_COST = 0.05;
	
	/**
	 * 
	 * @param givenCityName the city name which is given by Backpacker
	 * @param givenHostelCost the hostel cost which is given by Backpacker
	 * 
	 * A City object just represents a city name along with a cost per night for hostels.
	 * There is a constructor for initializing the city name and hostel cost and there are 
	 * several accessor methods.
	 */
	public City(String givenCityName, int givenHostelCost)
	{
		cityname = givenCityName;
		hostelcost = givenHostelCost;
	}
	
	/**
	 * 
	 * @return Returns cityname to public String getCityName
	 * This method is for returning this city name 
	 */
	public String getCityName()
	{
		return cityname;
	}
	
	/**
	 * 
	 * @return Returns hostelCost to public int hostelCost
	 * This method is for returning this city's hostel cost per night.
	 */
	public int hostelCost()
	{
		return hostelcost;
	}
	
	/**
	 * 
	 * @return Returns the cost to send a postcard from this city
	 * The value is a percentage of the lodging cost specified by the constant POSTCARD_COST, 
	 * rounded to the nearest integer.
	 */
	public int postcardCost()
	{
		return (int) Math.round(hostelcost*POSTCARD_COST);
	}
	
	/**
	 * 
	 * @param moneyAvailable the money available which is given by Backpacker
	 * @return Returns the number of nights of hostel stay in this city that 
	 * a Backpacker could afford with the given amount of money.
	 */
	public int nightsStay(int moneyAvailable)
	{
		money = moneyAvailable;
		return money/hostelcost;
	}
	
	/**
	 * 
	 * @param moneyAvailable the money available which is given by Backpacker
	 * @return Returns the number of postcards that a Backpacker could afford to send 
	 * from this city with the given amount of money.
	 */
	public int numPostcards(int moneyAvailable)
	{
		money = moneyAvailable;
		return (int) Math.floor(money/Math.round(hostelcost*POSTCARD_COST));
	}
}
