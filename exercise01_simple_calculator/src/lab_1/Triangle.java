package lab_1;

import java.util.Scanner;

public class Triangle extends Figure implements Print {
	double a, b;
	String text;

	public Triangle() {
		this.a = 1;
		this.b = 1;
	}

	public Triangle(String a) {
		this.text = a;
	}

	@Override
	public double calculateArea() {
		return 0.5 * this.a * this.b;//
	}

	@Override
	public double calculatePerimeter() {
		return this.a + 2 * this.b;
	}

	@Override
	public void print() {
		System.out.println(text);
		System.out.println("Podaj wymiar podstawy:");
		Scanner scanner = new Scanner(System.in);
		try {
			this.a = scanner.nextDouble();
			System.out.println("Podaj wymiar boku:");
			this.b = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("????? podaj porwid³owe dane!!");
			return;
		}
		if (this.a + this.b > this.b && this.b + this.b > this.a) {
			System.out.println("Pole trojkata wynosi: " + calculateArea() + "\nA jego obwód: " + calculatePerimeter()
					+ "\n-------------------");
		} else {
			System.out.println("Z tych danych trójkata nie z³oze !!");
		}
	}
}
