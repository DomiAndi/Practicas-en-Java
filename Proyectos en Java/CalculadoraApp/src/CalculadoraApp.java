import java.util.Scanner;

public class CalculadoraApp {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("**** Aplicacion Calculadora *****");
        mostrarMenu();

        int operacion;
        try {
          operacion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Por favor ingresa un número válido.");
          continue; // Salta a la siguiente iteración
        }

        if (operacion >= 1 && operacion <= 4) {
          ejecutarOperacionSeleccionada(operacion, scanner);
        } else if (operacion == 5) {
          System.out.println("Hasta pronto...");
          break;
        } else {
          System.out.println("Opcion erronea: " + operacion);
        }
        System.out.println(); // Salto de línea para legibilidad
      }
    } catch (Exception e) {
      System.out.println("Ocurrió un error inesperado: " + e.getMessage());
    }
  }

  private static void mostrarMenu() {
    System.out.println("""
        1. Suma
        2. Resta
        3. Multiplicacion
        4. Division
        5. Salir
        """);
    System.out.print("Operacion a realizar? ");
  }

  private static void ejecutarOperacionSeleccionada(int operacion, Scanner scanner) {
    double operando1 = solicitarOperando("Proporciona valor operando1: ", scanner);
    double operando2 = solicitarOperando("Proporciona valor operando2: ", scanner);

    switch (operacion) {
      case 1 -> mostrarResultado("Suma", sumar(operando1, operando2));
      case 2 -> mostrarResultado("Resta", restar(operando1, operando2));
      case 3 -> mostrarResultado("Multiplicacion", multiplicar(operando1, operando2));
      case 4 -> {
        if (operando2 == 0) {
          System.out.println("Error: No se puede dividir entre cero.");
        } else {
          mostrarResultado("Division", dividir(operando1, operando2));
        }
      }
      default -> System.out.println("Opcion erronea: " + operacion);
    }
  }

  private static double solicitarOperando(String mensaje, Scanner scanner) {
    System.out.print(mensaje);
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, ingresa un número.");
      }
    }
  }

  private static void mostrarResultado(String operacion, double resultado) {
    System.out.println("Resultado " + operacion + ": " + resultado);
  }

  private static double sumar(double a, double b) {
    return a + b;
  }

  private static double restar(double a, double b) {
    return a - b;
  }

  private static double multiplicar(double a, double b) {
    return a * b;
  }

  private static double dividir(double a, double b) {
    return a / b;
  }
}
