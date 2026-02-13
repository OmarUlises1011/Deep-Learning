
public class PerceptronConV extends Perceptron{

    private double eta;

    public PerceptronConV(patron[] patrones, double eta) {
        super(patrones);
        this.eta = eta;
    }

    @Override
    protected void actualizarPesos(patron p, int salidaReal) {
        int error = p.salidaEsperada - salidaReal;

        w1 = w1 + eta * error * p.x1;
        w2 = w2 + eta * error * p.x2;
        b  = b  + eta * error;
    }
}
