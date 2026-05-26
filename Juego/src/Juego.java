import java.util.Scanner;

public class Juego {

    private Tablero tablero;
    private Jugador jugador;
    private Scanner scanner;

    public Juego() {
        tablero = new Tablero(5);
        jugador = new Jugador();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        boolean jugando = true;

        while (jugando) {

            tablero.mostrar(jugador);
            System.out.println("Puntaje: " + jugador.getPuntaje());
            System.out.println("Mover: W= Arriba  S= Abajo  A= Izquierda  D= Derecha");

            String opcion = scanner.nextLine().toUpperCase();

            int nuevaFila    = jugador.getFila();
            int nuevaColumna = jugador.getColumna();

            switch (opcion) {
                case "W": nuevaFila--;    break;
                case "S": nuevaFila++;    break;
                case "A": nuevaColumna--; break;
                case "D": nuevaColumna++; break;
                default:
                    System.out.println("Movimiento inválido");
                    continue;
            }

            if (nuevaFila < 0 || nuevaFila >= tablero.getTamanio() ||
                    nuevaColumna < 0 || nuevaColumna >= tablero.getTamanio()) {
                System.out.println("Movimiento fuera del tablero");
                continue;
            }

            jugador.mover(nuevaFila, nuevaColumna, opcion);

            Celda celda = tablero.getCelda(nuevaFila, nuevaColumna);

            switch (celda.getTipo()) {

                case OBJETIVO:
                    System.out.println("Llegaste al objetivo Puntaje final: " + jugador.getPuntaje());
                    jugando = false;
                    break;

                case POTENCIADOR:
                    jugador.duplicarPuntaje();
                    System.out.println("Potenciador Puntaje duplicado: " + jugador.getPuntaje());
                    celda.setTipo(TipoCelda.NORMAL);
                    break;

                case MODIFICADOR:
                    jugador.sumarPuntos(50);
                    System.out.println("Modificador +50 puntos: " + jugador.getPuntaje());
                    celda.setTipo(TipoCelda.NORMAL);
                    break;

                case NORMAL:
                    break;
            }
        }

        scanner.close();
    }
}