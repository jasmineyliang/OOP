package lab5;
import balloon4.Balloon;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
public class BalloonTests {
	
	private Balloon bb; 
	
	@Before
	public void setup()  // runs before every test case
    {
      bb = new Balloon(5);
    }
	
	@Test
	public void testInitial() {
		assertEquals(false, bb.isPopped());
		assertEquals(0, bb.getRadius());
	}
	

	
    @Test
    public void testBlowHigher()
    {
      bb.blow(4);
      assertEquals(4, bb.getRadius());
      assertEquals(false, bb.isPopped());
    }
	
    @Test
    public void testBlowLower()
    {
      bb.blow(6);
      assertEquals(0, bb.getRadius());
      assertEquals(true, bb.isPopped());
    }
    
    @Test
    public void testBlowTwice()
    {
      bb.blow(3);
      bb.blow(1);
      assertEquals(4, bb.getRadius());
      //assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testDeflate()
    {
      bb.deflate();
      assertEquals(0, bb.getRadius());
      assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testDeflatePop()
    {
      bb.pop();
      bb.deflate();
      assertEquals(0, bb.getRadius());
      assertEquals(true, bb.isPopped());
    }
    
    
    
    
    
    @Test
    public void testPop()
    {
      bb.pop();
      assertEquals(0, bb.getRadius());
      assertEquals(true, bb.isPopped());
      bb.blow(4);
      assertEquals(0, bb.getRadius());
    }
}
