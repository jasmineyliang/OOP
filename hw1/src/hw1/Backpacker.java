package hw1;
/**
 * 
 * @author YuPin Liang, COM S 227 Section C
 *
 */
public class Backpacker {
	/**
	 * set hotel cost per night as private integer hostelcost as an instance variable 
	 * set city name which packpacker visting as private string cityname as an instance variable
	 * set money which packpacker having as private integer money as an instance variable
	 * The cost to mail a postcard from a city is this fraction times the city's hostel cost and set 
	 * this fraction as a static variable POSTCARD_COST = 0.05
	 * */
	public static final int SYMPATHY_FACTOR = 30;
	private int currentmoney;
	private int nightinstation;
	private City currentcity;
	private String journal;
	private int numpost;
/**
 * 
 * @param initialFunds
 * @param initialCity
 * Constructs a Backpacker starting out with the given amount of money in the given city
 */
	public Backpacker(int initialFunds, City initialCity) {

		currentmoney = initialFunds;
		currentcity = initialCity;
		journal = initialCity.getCityName()+"(start)";
		numpost = 0;
		nightinstation = 0;
	}


	/**
	 * 
	 * @return Returns the name of the Backpacker's current city.
	 */
	public String getCurrentCity() {
		 return currentcity.getCityName();
	}


	/**
	 * 
	 * @return Returns the amount of money the Backpacker currently has.
	 */
	public int getCurrentMoney() {
		return currentmoney;
	}
	

	/**
	 * 
	 * @return Returns the Backpacker's journal.
	 */
	public String getJournal() {
		return journal;

	}
	
	/*
	 * Returns true if Backpacker doesn¡¦t have enough money to send postcard from 
	 * the current city.
	 */

	public boolean isSOL() {
		
		if (currentmoney <currentcity.postcardCost()) {
		return true;	
		}
		
		else
		{return false;
		}
	}
	
	
    /**
    * @return Returns the number of nights the Backpacker has spent in a train station when visiting a 
	* city without enough money for hostels.
    */
	public int getNightsInStation() {
		return nightinstation;
	}
	
	
   /**
    * 
    * @param c
    * @param numNights
    * Simulates a visit by this Backpacker to the given city for the given number
    * of nights.
    * The Backpacker's money is reduced based on the number of nights of hostel
    * booked.When the funds are not sufficient for numNights nights of stay in the city,
    * the number of nights spent in the train station is updated accordingly.
    */
	public void visit(City c, int numNights) {
		int hostelnights = currentmoney/c.hostelCost();
		hostelnights = Math.min(numNights,hostelnights);
		currentmoney = currentmoney - c.hostelCost()*hostelnights;
		nightinstation += numNights-hostelnights;
		journal = journal + "," + c.getCityName()+"(" + numNights + ")";
		currentcity = c;
	}
	
	
	/**
	 * 
	 * @param howMany
	 * Sends the given number of postcards, if possible, reducing the Backpacker's 
	 * funds appropriately and increasing the count of postcards sent. If there is 
	 * not enough money, sends as many postcards as possible without allowing the 
	 * funds to go below zero.
	 */
	public void sendPostcardsHome(int howMany)
	{
		if (currentmoney<currentcity.postcardCost()*howMany) {
			int many = currentmoney/currentcity.postcardCost();
			currentmoney = currentmoney-currentcity.postcardCost()*many;
			numpost += many;
		}
		
		else
		{
			currentmoney = currentmoney-currentcity.postcardCost()*howMany;
			numpost += howMany;
		}
	}

	/**
	 * Increases the Backpacker's funds by an amount equal to SYMPATHY_FACTOR
	 * times the number of postcards sent since the last call to this method,
	 * and resets the count of the number of spostcards sent back to zero.
	 */
	public void callHomeForMoney() {
		currentmoney += SYMPATHY_FACTOR*numpost;
		numpost=0;
		
	}
}
