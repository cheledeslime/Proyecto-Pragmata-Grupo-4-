public class Celda {

    private int fila;
    private int columna;
    private TipoCelda tipo;

    public Celda(int fila, int columna, TipoCelda tipo) {
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public TipoCelda getTipo() {
        return tipo;
    }

    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }
}