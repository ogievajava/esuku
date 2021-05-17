package firstLesson;

public class init {

	public static void main(String[] args) {
		
		int counter = 0;

		
		for (counter = 0; counter < 5; counter++) {
			System.out.println(counter);
		}

		for (counter = 1; counter <= 5; counter++) {
			System.out.println(counter);
		}

		for (counter = 1; counter <= 5; counter++) {
			if (counter % 2 != 0) { 
				System.out.println(counter);
			}
		}
		

		for (counter = 5; counter >= 1; counter--) {
			System.out.println(counter);
		}
		
		
		for (counter = 0; counter <= 5; counter++) {
			if (counter % 2 == 0) {
				System.out.println(counter);
			}
		}

	}

}
