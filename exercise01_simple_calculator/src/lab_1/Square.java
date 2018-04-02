package lab_1;

import static java.lang.Math.pow;
import java.util.Scanner;

public class Square extends Figure implements Print {
	double a;

	public Square() {
		this.a = 1;
	}

	@Override
	public double calculateArea() {
		return this.a * this.a;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * pow(this.a, 2);
	}

	@Override
	public void print() {
		System.out.println("Podaj wymiar kwadratu:");
		Scanner scanner = new Scanner(System.in);
		try {
			this.a = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("????? podaj porwid³owe dane!!");
			return;
		}
		System.out.println("Pole kwadratu wynosi: " + calculateArea() + "\nA jego obwód: " + calculatePerimeter()
				+ "\n-------------------");
	}
}
