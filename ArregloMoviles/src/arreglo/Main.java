package arreglo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Arreglo> arreglos = new ArrayList<Arreglo>();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		char l = 0;
		int num_arreglos = 0;
		boolean salir = false;
		LocalDate fecha_entrega;

		do {
			System.out.print("Introduce código del empleado " + (empleados.size() + 1) + ": ");
			String codigo = sc.nextLine();
			while (!codigo.matches("[A-Z][0-9]{1,3}")) {
				System.out.println("Código inválido.");
				System.out.print("Introduce otro código: ");
				codigo = sc.nextLine();
			}
			empleados.add(new Empleado(codigo));
			if (empleados.size() >= 2) {
				System.out.print("¿Quieres añadir más empleados? (S/N): ");
				l = sc.nextLine().charAt(0);
				while (l != 'S' && l != 'N') {
					System.out.println("Opción inválida.");
					System.out.print("¿Quieres añadir más empleados? (S/N): ");
					l = sc.nextLine().charAt(0);
				}
			}
		} while (l != 'N');
		do {
			switch (menu()) {
			case 1:
				if (arreglos.size() < 10) {
					System.out.print("1. Normal. \n2. Garantia. \n3. Urgente. \n\tElige el tipo de arreglo: ");
					int tipo = sc.nextInt();
					while (tipo < 1 || tipo > 3) {
						System.out.println("Tipo inválido");
						System.out.print("1. Normal. \n2. Garantia. \n3. Urgente. \n\tElige el tipo de arreglo: ");
						tipo = sc.nextInt();
					}
					if (tipo == 1)
						arreglos.add(new Normal());
					if (tipo == 2)
						arreglos.add(new Garantia());
					if (tipo == 3) {
						while (true) {
							try {
								System.out.print("Introduce fecha cuando se entrega: ");
								fecha_entrega = LocalDate.parse(sc.nextLine());
								break;
							} catch (DateTimeParseException e) {
								System.out.println("Fecha inválida");
							}
						}
						arreglos.add(new Urgente(fecha_entrega));
					}
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				salir = true;
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		} while (!salir);
	}

	public static int menu() {
		int opc = 0;
		do {
			try {
				System.out.println(
						"1. Llega un usuario.\n2. Empleado realiza un arreglo.\n3. Empleado finaliza un arreglo.\n4. Ordenar array de arreglos.\n5. Actualizar el precio.\n6. Salir.");
				opc = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Número inválido");
			}
		} while (true);
		return opc;
	}
}
