public class PerceptronSinV extends Perceptron {

    public PerceptronSinV(patron[] patrones) {
        super(patrones);
    }

    @Override
    protected void actualizarPesos(patron p, int salidaReal) {
        int error = p.salidaEsperada - salidaReal;

        w1 = w1 + error * p.x1;
        w2 = w2 + error * p.x2;
        b  = b  + error;
    }
}