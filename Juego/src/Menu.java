import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void mostrar() {

        boolean corriendo = true;

        while (corriendo) {

            System.out.println("====================");
            System.out.println("   JUEGO DE TABLERO  ");
            System.out.println("====================");
            System.out.println("1. Jugar");
            System.out.println("2. Instrucciones");
            System.out.println("3. Salir");
            System.out.print("Elegí una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    Juego juego = new Juego();
                    juego.iniciar();
                    corriendo = false;
                    break;

                case "2":
                    mostrarInstrucciones();
                    break;

                case "3":
                    System.out.println("Nos merecemos el 10, gracias:)");
                    corriendo = false;
                    break;

                default:
                    System.out.println("Opción inválida, intentá de nuevo");
            }
        }

        scanner.close();
    }

    private void mostrarInstrucciones() {

        System.out.println("====================");
        System.out.println("    INSTRUCCIONES    ");
        System.out.println("====================");
        System.out.println("- Movete con W/A/S/D");
        System.out.println("- No podés volver hacia atrás");
        System.out.println("- [O] Objetivo: termina el juego");
        System.out.println("- [P] Potenciador: duplica tu puntaje");
        System.out.println("- [M] Modificador: suma 50 puntos");
        System.out.println("- Empezás con 100 puntos en [0][0]");
    }
}