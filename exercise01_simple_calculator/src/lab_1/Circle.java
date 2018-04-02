package lab_1;

import static java.lang.Math.*;
import java.util.Scanner;

public class Circle extends Figure implements Print {
	double promien;

	public Circle() {
		this.promien = 1;
	}

	@Override
	public double calculateArea() {
		return Math.PI * pow(promien, 2);// pir^2
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * promien;// 2pir
	}

	@Override
	public void print() {
		System.out.println("Podaj promien kola:");
		Scanner scanner = new Scanner(System.in);
		try {
			this.promien = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("????? podaj porwid³owe dane!!");
			return;
		}
		System.out.println("Pole kola wynosi: " + calculateArea() + "\nA jego obwód: " + calculatePerimeter()
				+ "\n-------------------");
	}
}
