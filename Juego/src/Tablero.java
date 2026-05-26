import java.util.Random;

public class Tablero {

    private Celda[][] grilla;
    private int tamanio;

    public Tablero(int tamanio) {
        this.tamanio = tamanio;
        grilla = new Celda[tamanio][tamanio];
        inicializar();
    }

    private void inicializar() {

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                grilla[i][j] = new Celda(i, j, TipoCelda.NORMAL);
            }
        }

        Random random = new Random();

        int filaObjetivo = random.nextInt(tamanio);
        int columnaObjetivo = random.nextInt(tamanio);

        while (filaObjetivo == 0 && columnaObjetivo == 0) {
            filaObjetivo = random.nextInt(tamanio);
            columnaObjetivo = random.nextInt(tamanio);
        }

        grilla[filaObjetivo][columnaObjetivo].setTipo(TipoCelda.OBJETIVO);

          int filaPotenciador = random.nextInt(tamanio);
        int columnaPotenciador = random.nextInt(tamanio);

        while (grilla[filaPotenciador][columnaPotenciador].getTipo() != TipoCelda.NORMAL ||
                (filaPotenciador == 0 && columnaPotenciador == 0)) {
            filaPotenciador = random.nextInt(tamanio);
            columnaPotenciador = random.nextInt(tamanio);
        }

        grilla[filaPotenciador][columnaPotenciador].setTipo(TipoCelda.POTENCIADOR);

        int filaModificador = random.nextInt(tamanio);
        int columnaModificador = random.nextInt(tamanio);

        while (grilla[filaModificador][columnaModificador].getTipo() != TipoCelda.NORMAL ||
                (filaModificador == 0 && columnaModificador == 0)) {
            filaModificador = random.nextInt(tamanio);
            columnaModificador = random.nextInt(tamanio);
        }

        grilla[filaModificador][columnaModificador].setTipo(TipoCelda.MODIFICADOR);
    }

    public void mostrar(Jugador jugador) {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print(obtenerSimbolo(i, j, jugador));
            }
            System.out.println();
        }
    }

    private String obtenerSimbolo(int fila, int columna, Jugador jugador) {
        if (jugador.getFila() == fila && jugador.getColumna() == columna) return "[J] ";
        return switch (grilla[fila][columna].getTipo()) {
            case OBJETIVO    -> "[O] ";
            case POTENCIADOR -> "[P] ";
            case MODIFICADOR -> "[M] ";
            default          -> "[ ] ";
        };
    }

    public Celda getCelda(int fila, int columna) {
        return grilla[fila][columna];
    }

    public int getTamanio() {
        return tamanio;
    }
}