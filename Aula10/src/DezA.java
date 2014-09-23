// break and continue
public class DezA {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {//
				continue;
			}
			if (i > 35) {
				break;
			}
			System.out.println(i + "");
		}
	}

}
