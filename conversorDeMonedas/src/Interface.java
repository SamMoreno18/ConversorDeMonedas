import java.util.Map;
import java.util.Scanner;

public class Interface {
    public static String seleccionarMonedaBase(Scanner scanner, String monedaInicial, String[] monedas) {
        System.out.println("*******************************************");
        System.out.println("\nGracias por usar  nuestra herramienta");
        System.out.println("Actualmente estas trabajando con: " + monedaInicial);
        System.out.println("¿Deseas cambiar la moneda base? (s/n)");
        System.out.println("*******************************************");
        String cambiarMonedaBase = scanner.next();
        if (cambiarMonedaBase.equalsIgnoreCase("s")) {
            System.out.println("*******************************************");
            System.out.println("Seleccione la nueva moneda base: ");
            for (int i = 0; i < monedas.length; i++) {
                System.out.println((i + 1) + ". " + monedas[i]);
            }
            System.out.println("*******************************************");
            int opcionBase = scanner.nextInt();
            if (opcionBase < 1 || opcionBase > monedas.length) {
                System.out.println("Opción no válida.");
                return monedaInicial;
            }
            return monedas[opcionBase - 1];
        }
        return monedaInicial;
    }

    public static double TypeMoney(Scanner scanner, String monedaBase) {
        System.out.print("Ingrese la cantidad que quieres convertir " + monedaBase + " (o 'salir' para terminar): ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("salir")) {
            return -1;
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número o 'salir'.");
            return TypeMoney(scanner, monedaBase);
        }
    }

    public static String selectDivisa (Scanner scanner, String monedaBase, String[] monedas) {
        System.out.println("*******************************************");
        System.out.println("Seleccione la divisa a la que desea convertir: ");
        for (int i = 0; i < monedas.length; i++) {
            if (!monedas[i].equals(monedaBase)) {
                System.out.println((i + 1) + ". " + monedas[i]);
            }
        }
        System.out.println("*******************************************");
        int opcionObjetivo = scanner.nextInt();
        if (opcionObjetivo < 1 || opcionObjetivo > monedas.length || monedas[opcionObjetivo - 1].equals(monedaBase)) {
            System.out.println("Opción no válida.");
            return null;
        }
        return monedas[opcionObjetivo - 1];
    }

    public static void operations (String monedaBase, String monedaObjetivo, double cantidadBase, Map<String, Double> tasasDeCambio) {
        if (!tasasDeCambio.containsKey(monedaObjetivo)) {
            System.out.println("La tasa de cambio para " + monedaObjetivo + " no está disponible.");
            return;
        }

        double tasaDeCambio = tasasDeCambio.get(monedaObjetivo);
        double cantidadConvertida = cantidadBase * tasaDeCambio;

        System.out.printf("Resultado: %.2f %s%n", cantidadConvertida, monedaObjetivo);
    }
}
