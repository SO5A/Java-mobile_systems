package lab_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int x = 1;// przejscie po menu
		boolean loop = true;

		while (loop) {
			System.out.println("Menu:\n1.Tr�jk�t:\n2.Kwadtat:\n3.Ko�o:\n4.Wyj�cie");
			Scanner scanner = new Scanner(System.in);
			x = scanner.nextInt();
			switch (x) {
			case 1:
				Triangle trojkat = new Triangle("przk�adowy text");
				trojkat.print();
				break;
			case 2:
				Square kwadrat = new Square();
				kwadrat.print();
			case 3:
				Circle kolo = new Circle();
				kolo.print();
				break;
			default:
				loop = false;
				break;
			}
		}
	}
}
