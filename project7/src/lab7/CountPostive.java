package lab7;

public class CountPostive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] Positive(int[] numbers) {

		int total = 0;
		for (int i = 0; i < numbers.length; i += 1) {
			if (numbers[i] > 0) {
				total += 1;
			}
		}
		int index = 0;
		int[] positive = new int[total];
		for (int i = 1; i < positive.length; i++) {
			if (positive[i] > 0) {
				int num = numbers[i];
				positive[index] = num;
				index++;
			}
		}

		return positive;

	}
	
	public static int[] randomExperiment(int max, int iters) {
		
	}

}
