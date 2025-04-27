import java.util.Random;

public class JuegoBatalla {
    //atributos
    private Robot[] robots;
    private int cantidadRobots;

    //contructor robot
    public JuegoBatalla(int capacidadMaxima) {
        robots = new Robot[capacidadMaxima]; //array de los robot
        cantidadRobots = 0; //contador de la cantidad de robot que se han creado
    }

    public void anadirRobort(Robot robot) {
        if (cantidadRobots < robots.length) { //no agrega un robort si esta lleno el array
            robots[cantidadRobots] = robot;
            cantidadRobots++;
        } else {
            System.out.println("No hay espacio para mas robor");
        }
    }

    //getters
    public Robot[] getRobots() { 
        return robots;
    }

    public int getCantidadRobots() {
        return cantidadRobots;
    }

    //setters
    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }

    public void setCantidadRobots() {
        this.cantidadRobots = cantidadRobots;
    }


    //inicio de batalla 
    public void iniciarBatalla() {
        if (cantidadRobots < 2 ) { //para la batalla minimo se ocupan dos robort
            System.out.println("Faltan robort para iniciar batalla");
            return; //si hay una cantidadRobots < 2 entonces termina la prueba 
        }
        
        Random random = new Random();//genera numeros al azar, nos ayudara a darles valores de ataque y vida al azar entre las restricciones

        while (true) {
            //estado de los robots
            System.out.println("\n Estado de los robots");
            for(int i = 0; i < cantidadRobots; i++) {
                Robot robot = robots[i];
                System.out.println(robot.getNombre() + "-" + robot.getAtaque() + " puntos de vida");
            }

            //el que realiza el ataca
            int indiceAtacante = random.nextInt(cantidadRobots);
            Robot atacante = robots[indiceAtacante];

            //oponente alegido al azar al que ataca
            int indiceAtacado;
            do {
                indiceAtacado = random.nextInt(cantidadRobots);
            } while (indiceAtacado == indiceAtacante);
            Robot atacado = robots[indiceAtacado];

            //ataque al robot elegido
            System.out.println("\n" + atacante.getNombre() + " realiza el ataque a " + atacado.getNombre() + " !!" );
            atacante.atacar(atacado); //resta los puntos de vida del robot atacado

            //los robot con 0 de vida seran eliminados de la lista 
            for(int i = 0; i < cantidadRobots; i++) {
                if (robots[i].estadoRobot() == false) {
                    System.out.println(robots[i].getNombre() + " fue reducido");
                    
                    for (int j = i ; j < cantidadRobots - 1; j++) {
                        robots[j] = robots[j + 1];
                    }
                    cantidadRobots--; //cuando un robot es movido este compueva el numero que robot que estan ahora en la lista despues de ser eliminado el que llego a cero
                    i--;
                }
            }

            // verificar que quede solo un robot o si no queda ninguno
            if (cantidadRobots == 1) {
                System.out.println("\n" + robots[0].getNombre() + " resulto vencedor");
                break;
            } else if (cantidadRobots == 0) {
                System.out.println("\n Todos los robot estan destruidos");
                break;
            } 
        } 
    }
        public void mostrarGanador() {
            if (cantidadRobots == 1) {
                System.out.println( robots[0].getNombre() + "¡Has emergido victorioso de la batalla, alzado como el triunfador!");
        } else {
            System.out.println("La batalla terminó, pero nadie vivió para contarlo. ¿Ganó la crueldad de los algoritmos? ");
        }
    }

    public  static void main(String[] args) {
        int cantidadMaxima = 6;
        JuegoBatalla juego = new JuegoBatalla(cantidadMaxima);

        juego.anadirRobort(new Robot("Leo", 90, 17));
        juego.anadirRobort(new Robot("Daniel", 85, 16));
        juego.anadirRobort(new Robot("Pablo", 75, 15));
        juego.anadirRobort(new Robot("Randal", 60, 20));
        juego.anadirRobort(new Robot("Jose", 92, 10));
        juego.anadirRobort(new Robot("Olman", 89, 12));
        
        juego.iniciarBatalla();
    }
}

















