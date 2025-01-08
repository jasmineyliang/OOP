package hw1;
public class CityTest {

	public static void main(String[] args)
	{
		City c = new City("Paris",75);
		System.out.println(c.getCityName());
		System.out.println(c.hostelCost());
		System.out.println(c.nightsStay(500));
		System.out.println(c.nightsStay(50));
		System.out.println(c.postcardCost());
		System.out.println(c.numPostcards(50));
		
		
		
		
		
		
	}
}
