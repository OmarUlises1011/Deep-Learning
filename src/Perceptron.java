
public abstract class Perceptron {
//aqui declaro w1 y w2 que son los pesos y b la bias se inician en 0
    protected double w1;
    protected double w2;
    protected double b;

    protected patron[] patrones;

    public Perceptron(patron[] patrones) {
        this.patrones = patrones;
        this.w1 = 0.0;
        this.w2 = 0.0;
        this.b = 0.0;
    }
// aqui hago la suma ponderada con esta formula w1x1+w2x2+b y sirve para combinar las entradas,aplicar los pesos y parta saber si sera 1 o 0
    protected double sumaPonderada(double x1, double x2) {
        return (w1 * x1) + (w2 * x2) + b;
    }
//Funcion de activacion
// Si la suma ≥ 0 → devuelve 1
//Si la suma < 0 → devuelve 0
    protected int activacion(double suma) {
        return (suma >= 0) ? 1 : 0;
    }
// aqui se actualizan los pesos en caso de que hay error si acierta no actualizqa
    protected abstract void actualizarPesos(patron p, int salidaReal);

    public void entrenar(int epocas) {
        for (int e = 1; e <= epocas; e++) {
            boolean sinErrores = true;

            for (patron p : patrones) {
                double suma = sumaPonderada(p.x1, p.x2);
                int salida = activacion(suma);
                int error = p.salidaEsperada - salida;

                if (error != 0) {
                    sinErrores = false;
                    actualizarPesos(p, salida);
                }
            }

            if (sinErrores) {
                break;
            }
        }
    }

    public void imprimirResultados(String titulo) {
        System.out.println("\n" + titulo);
        System.out.println("Pesos finales:");
        System.out.println("w1 = " + w1);
        System.out.println("w2 = " + w2);
        System.out.println("b  = " + b);

        System.out.println("\nCálculos paso a paso:");
        for (patron p : patrones) {
            double suma = sumaPonderada(p.x1, p.x2);
            int salida = activacion(suma);

            System.out.println("Patrón (" + p.x1 + ", " + p.x2 + ")");
            System.out.println("  Suma ponderada = (" + w1 + "*" + p.x1 + ") + ("
                    + w2 + "*" + p.x2 + ") + " + b + " = " + suma);
            System.out.println("  Activación = " + salida +
                    " | Esperado = " + p.salidaEsperada);
        }
    }
}
