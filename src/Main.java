

public class Main {

    public static void main(String[] args) {

        patron[] and = {
                new patron(0, 0, 0),
                new patron(0, 1, 0),
                new patron(1, 0, 0),
                new patron(1, 1, 1)
        };

        PerceptronSinV p1 = new PerceptronSinV(and);
        p1.entrenar(100);
        p1.imprimirResultados("Perceptrón SIN velocidad de aprendizaje (AND)");

        PerceptronConV p2 = new PerceptronConV(and, 0.5);
        p2.entrenar(100);
        p2.imprimirResultados("Perceptrón CON velocidad de aprendizaje (AND)");
    }
}
