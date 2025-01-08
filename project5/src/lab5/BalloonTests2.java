package lab5;
import balloon4.Balloon;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
public class BalloonTests2 {

private Balloon bb; 
	
	@Before
	public void setup()  // runs before every test case
    {
      bb = new Balloon(-6);
    }
	
	@Test
	public void testInitial() {
		assertEquals(false, bb.isPopped());
	}
	
	@Test
    public void testInitialRadius()
    {
      assertEquals(0, bb.getRadius());
    }
	
    @Test
    public void testBlowHigher()
    {
      bb.blow(4);
      assertEquals(true, bb.isPopped());
    }
    
    
    @Test
    public void testBlowNegative()
    {
      bb.blow(-6);
      assertEquals(0, bb.getRadius());
      assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testDeflate()
    {
      bb.deflate();
      assertEquals(0, bb.getRadius());
      assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testPop()
    {
      bb.pop();
      assertEquals(0, bb.getRadius());
      assertEquals(true, bb.isPopped());
      bb.blow(5);
      assertEquals(0, bb.getRadius());
    }
}
