package exercicioPolimorfismo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();

		for (int x = 0; x < n; x++) {
			System.out.println("\nDados do Produto #" + (x + 1));

			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.print("Price: ");
			double preco = sc.nextDouble();

			if (ch == 'i') {
				System.out.print("Custo alfandegário: ");
				double cf = sc.nextDouble();
				Product ip = new ImportedProduct(nome, preco, cf);
				list.add(ip);
			} else {
				if (ch == 'c') {
					Product pC = new Product(nome, preco);
					list.add(pC);
				} else if (ch == 'u') {
					System.out.print("Data de fabricação (DD/MM/YYYY): ");
					date = sdf.parse(sc.next());
					Product pU = new UsedProduct(nome, preco, date);
					list.add(pU);
				}
			}

		}

		System.out.println("\nPRICE TAGS\n");

		for (Product p : list) {
			System.out.println(p.priceTag());

		}

		sc.close();

	}

}
