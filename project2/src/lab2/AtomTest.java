package lab2;

public class AtomTest {
	public static void main(String[] args)
	{
		Atom a;
		a = new Atom (10,20,30);
		System.out.println(a.getAtomicMass());
		System.out.println(a.getAtomicCharge());
		
		//System.out.println(a.decay());
	}
}
