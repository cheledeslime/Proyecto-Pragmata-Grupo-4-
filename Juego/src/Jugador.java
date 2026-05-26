public class Jugador {

    private int fila;
    private int columna;
    private int puntaje;

    public Jugador() {
        fila = 0;
        columna = 0;
        puntaje = 100;
    }

    public int getFila() { return fila; }
    public int getColumna() { return columna; }
    public int getPuntaje() { return puntaje; }

    public void mover(int nuevaFila, int nuevaColumna, String direccion) {
        fila = nuevaFila;
        columna = nuevaColumna;
    }

    public void duplicarPuntaje() { puntaje *= 2; }
    public void sumarPuntos(int puntos) { puntaje += puntos; }
} 
