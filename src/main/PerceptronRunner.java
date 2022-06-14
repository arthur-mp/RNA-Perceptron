package main;

public class PerceptronRunner {

    // AND
    // private static double[][][] baseDados = { { { 0, 0 }, { 0 } },
    // { { 0, 1 }, { 0 } },
    // { { 1, 0 }, { 0 } },
    // { { 1, 1 }, { 1 } } };

    // OR
    // private static double[][][] baseDados = { { { 0, 0 }, { 0 } },
    // { { 0, 1 }, { 1 } },
    // { { 1, 0 }, { 1 } },
    // { { 1, 1 }, { 1 } } };

    // XOR
    // private static double[][][] baseDados = { { { 0, 0 }, { 0 } },
    // { { 0, 1 }, { 1 } },
    // { { 1, 0 }, { 1 } },
    // { { 1, 1 }, { 0 } } };

    // Robô
    private static Double[][][] baseDados = { { { 0.0, 0.0, 0.0 }, { 1.0, 1.0 } },
            { { 0.0, 0.0, 1.0 }, { 0.0, 1.0 } },
            { { 0.0, 1.0, 0.0 }, { 1.0, 0.0 } },
            { { 0.0, 1.0, 1.0 }, { 0.0, 1.0 } },
            { { 1.0, 0.0, 0.0 }, { 1.0, 0.0 } },
            { { 1.0, 0.0, 1.0 }, { 1.0, 0.0 } },
            { { 1.0, 1.0, 0.0 }, { 1.0, 0.0 } },
            { { 1.0, 1.0, 1.0 }, { 1.0, 0.0 } } };

    public static void main(String[] args) throws Exception {
        Perceptron p = new Perceptron(baseDados[0][0].length, baseDados[0][1].length, 0.1);

        double erroEp = 0;
        double erroAm = 0;

        for (int e = 0; e < 1000; e++) {
            erroEp = 0;

            for (int a = 0; a < baseDados.length; a++) {
                Double[] x = baseDados[a][0];
                Double[] y = baseDados[a][1];
                Double[] out = p.learn(x, y);

                for (int j = 0; j < out.length; j++) {
                    erroAm += Math.abs(y[j] - out[j]);
                }

                erroEp += erroAm;
                erroAm = 0;
            }

            System.out.println("Epoca: " + (e + 1) + " - erro: " + erroEp);
        }

        Double[][] w = p.getW();
        for (int j = 0; j < w[0].length; j++) {
            for (int i = 0; i < w.length; i++) {
                System.out.println(w[i][j].toString());
            }

        }
    }
}
