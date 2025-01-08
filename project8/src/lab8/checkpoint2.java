package lab8;
import java.util.ArrayList;
public class checkpoint2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<>();
	    list.add("A");
	      list.add("B");
	      list.add("C");
	      list.add("A");
	    System.out.println("Before "+list);
	   removeDuplicates(list);
	   System.out.println("After "+list);

	}
	
	

	public static void removeDuplicates (ArrayList words) {
	    for(int i=words.size()-1; i>0; i--) {
	        for(int j=i-1; j>=0; j--) {
	            if(words.get(i).equals(words.get(j))) {
	            	words.remove(i);
	                break;
	            }
	        }
	    }
	}
}
