public class Robot {

    //Atributos para la clase robor
    private String nombre;
    private int puntosVida;
    private int ataque; //vamos a poner el dano como fijo

    //Constructor de clase robor
    public Robot (String nombre, int puntosVida, int ataque) {
        this.nombre = nombre;
        this.puntosVida = Math.min(100, Math.max(50, puntosVida)); // La vida del robor iniciara en 100
        this.ataque = Math.min(20, Math.max(10, ataque)); //valor del ataque entre 10 y 20, se le asigna en la terminal este valor
    }
    
    //getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }
     
    public int getAtaque(){
        return ataque;
    }

    //setters
    
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = Math.max(puntosVida, 0);
    }

    public void setAtaque(int ataque) {
        this.ataque = Math.min(20, Math.max(10, ataque));
    }

    //metodo para atacar a otro robort
    public void atacar(Robot atacado) {
        int dano = this.ataque;
        atacado.setPuntosVida(atacado.getPuntosVida() - dano); //restar el ataque recibido a los puntos de vida
        

        if (atacado.getPuntosVida() <= 0) {
            atacado.setPuntosVida(0);
            System.out.println(this.nombre + "hizo " + atacado.getNombre() + "!");
        
        } else {
            System.out.println(this.getNombre() + "realizo " + dano + " puntos de dano a " + atacado.getNombre());
        }
    }
    //si el robot esta vivo o no
    public boolean estaVivo() {
        return puntosVida > 0 ;
    }
}
