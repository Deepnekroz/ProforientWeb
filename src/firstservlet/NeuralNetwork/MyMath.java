package firstservlet.NeuralNetwork;

/**
 * Created by dmitry on 20.03.15.
 */
public class MyMath {
    public static double sigmoidalFunction(double x){
        return 1/(1+Math.exp(-x));
    }
    public static double derivativeSigmoida(double x){
        return sigmoidalFunction(x)*(1-sigmoidalFunction(x));
    }
    public static double[] intArrayToDouble(int [] array){
        double[]result = new double[array.length];
        for(int i = 0; i<array.length;i++)
            result[i]=array[i];
        return result;
    }
}
