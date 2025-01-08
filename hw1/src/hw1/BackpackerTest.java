package hw1;

public class BackpackerTest {

	public static void main(String[] args) {
		// a few cities to visit
		City paris = new City("Paris", 75);
		City rome = new City("Rome", 50);
		// start out in Paris
		Backpacker t = new Backpacker(500, paris);
		// initial state
		System.out.println(t.getCurrentCity()); // expected "Paris"
		System.out.println(t.getJournal()); // expected "Paris(start)"
		// try going to Rome
		t.visit(rome, 2);
		System.out.println(t.getCurrentCity()); // expected "Rome"
		System.out.println(t.getJournal()); // expected "Paris(start),Rome(2)"
		// back to Paris for a week
		t.visit(paris, 7);
		System.out.println(t.getCurrentCity()); // expected "Paris"
		System.out.println(t.getJournal()); // "Paris(start),Rome(2),Paris(7)"
		t = new Backpacker(500, paris); // start over
		// initial state
		System.out.println(t.getCurrentMoney()); // expected 500
		// visit a city
		t.visit(rome, 2);
		System.out.println(t.getCurrentMoney()); // expected 400
		//When we go back to Paris for a week, it's a bit different. We determine (from the City object) that 400 euros is enough for only 5 nights. The desired number is 7 nights, and the smaller of these values is 5. So we buy lodging for only 5 nights, at a cost of 5 * 75 = 375 euros. We should have 25 euros left. This also implies that we slept in the train station for 7 - 5 = 2 nights.
		t.visit(paris, 7);
		System.out.println(t.getCurrentMoney()); // expected 25
		System.out.println(t.getNightsInStation()); // expected 2
//		Paris is a lot of fun, so we stay another week. This time we discover we have only enough money for zero nights lodging. The smaller of zero and 7 is zero, so we purchase zero nights lodging at a cost of zero times 75. So we still have 25 euros, but we've slept another 7 -0 = 7 nights in the train station.
		t.visit(paris, 7);
		System.out.println(t.getCurrentMoney()); // expected 25
		System.out.println(t.getNightsInStation()); // expected 9
		
		t.sendPostcardsHome(1);
		System.out.println(t.getCurrentMoney()); // expected 21
		//Before we call home and ask for more money, let's really get on Mom and Dad's good side. Try sending 12 postcards! With 21 euros, the maximum number of postcards we can send is 5. The smaller of 5 and 12 is 5, so that's the number we actually send. We should see our funds go down by 5 times the postcard cost, or 20 euros, leaving us one euro.
		t.sendPostcardsHome(12);
		System.out.println(t.getCurrentMoney()); // expected 1
//		At this point we're technically SOL: we have 1 euro, the cost of sending a postcard is 4 euros, and the expression 4 > 1 is true.
		System.out.println(t.isSOL()); // expected true
//		But, we've sent a total of 6 postcards home. When we call and ask for money, our funds should go up by 6 times SYMPATHY_FACTOR, 6 * 30 = 180, leaving us sitting pretty with 181 euros.
		t.callHomeForMoney();
		System.out.println(t.getCurrentMoney()); // expected 181
		t.callHomeForMoney();
		System.out.println(t.getCurrentMoney()); // still just 181
		
		

	}

}
