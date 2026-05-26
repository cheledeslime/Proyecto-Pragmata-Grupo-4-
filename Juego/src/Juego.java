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

            System.out.println("Mover:");
            System.out.println("W = arriba");
            System.out.println("S = abajo");
            System.out.println("A = izquierda");
            System.out.println("D = derecha");

            String opcion = scanner.nextLine().toUpperCase();

            int nuevaFila = jugador.getFila();
            int nuevaColumna = jugador.getColumna();

            switch (opcion) {

                case "W":
                    nuevaFila--;
                    break;

                case "S":
                    nuevaFila++;
                    break;

                case "A":
                    nuevaColumna--;
                    break;

                case "D":
                    nuevaColumna++;
                    break;

                default:
                    System.out.println("Movimiento inválido");
                    continue;
            }
