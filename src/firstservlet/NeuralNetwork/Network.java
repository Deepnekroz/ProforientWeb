package firstservlet.NeuralNetwork;




import java.io.PrintWriter;
import java.util.Arrays;


public class Network {
    double[]  enters;
    double[]  inner;
    volatile double[]  outer;
    private int iteratorMy=0;
    volatile double[][] eTOinner;
    volatile double[][] iTOouter;
    double SP = 0.4; //STUDY SPEED

    public double[] getOuter() {
        return outer;
    }

    int[]input;

    public Network(int[] input, int inners, int outers){
        this.enters=new double[input.length];
        this.inner=new double[inners];
        this.outer=new double[outers];

        eTOinner=new double[input.length][inners];
        iTOouter=new double[inners][outers];
        this.input=new int[input.length*input.length];
        this.input=input;
    }
    public void initialize(){
        for(int i = 0; i<enters.length;i++)
            for(int j = 0;j<inner.length;j++)
                eTOinner[i][j]=Math.random()*0.1+0.05;
        for(int i = 0; i<inner.length;i++)
            for(int j = 0;j<outer.length;j++)
                iTOouter[i][j]=Math.random()*0.1+0.05;

    }
    public void run(int[] example){
       /* if(example!=null)
            this.enters=MyMath.intArrayToDouble(example);
            */
        if(example!=null) {
            this.enters = MyMath.intArrayToDouble(example);
        }
        for(int i = 0; i<inner.length;i++){
            inner[i]=0;
            for(int j = 0;j<enters.length;j++){

                inner[i]+=enters[j]*eTOinner[j][i];

            }
            inner[i]= MyMath.sigmoidalFunction(inner[i]);
        }


        for(int i = 0; i<outer.length;i++){
            outer[i]=0;
            for(int j = 0;j<inner.length;j++){
                outer[i]+=inner[j]*iTOouter[j][i];
            }
            outer[i]= MyMath.sigmoidalFunction(outer[i]);

        }
    }
    public void run(){
        run(null);
    }

    public void backPropagation(){
        double innerErrors[]=new double[inner.length];
        double globalError=0;

        do{
            globalError=0;
            for(int i = 0; i<Examples.patterns.length;i++) {
                for (int j = 0; j < enters.length; j++)
                    enters[j] = Examples.patterns[i][j];

                run();
                double endError[] = new double[outer.length];

                for(int k =0; k<Examples.CORRECT_ANSWERS[i].length;k++){
                    endError[k]=Examples.CORRECT_ANSWERS[i][k]-outer[k];

                }



                /*for (int j = 0; j < outer.length; j++){
                    for(int m=0;m<Examples.CORRECT_ANSWERS.length;m++){
                        endError[j]=Examples.CORRECT_ANSWERS[i][m]-outer[j];
                        System.out.print(Examples.CORRECT_ANSWERS[m][i]+", ");
                    }
                    System.out.println("");
                }
                */
                for(int p=0; p<endError.length;p++)
                    globalError+=Math.abs(endError[p]);

                for(int p = 0; p<innerErrors.length;p++)
                    for(int j=0; j<endError.length;j++)
                        innerErrors[p]+=endError[j]*iTOouter[p][j];


                for(int p=0;p<enters.length;p++){
                    for(int j = 0; j<inner.length;j++){
                        eTOinner[p][j]+=SP*innerErrors[j]*enters[p];
                    }
                }

                for(int p=0;p<inner.length;p++){
                    for(int j = 0; j<outer.length;j++){
                        iTOouter[p][j]+=SP*endError[j]*inner[p];
                    }
                }
            }
        //SP*=0.9;
        iteratorMy++;

          System.out.println("Global error: "+globalError+" ,and iterator "+iteratorMy);

        }while(globalError>1.5 && iteratorMy<2000);
    }
    public String giveAnswerExtended(){
        double[] newArray = Arrays.copyOf(outer, outer.length);
        Arrays.sort(newArray);
        int [] professionsDescOrder=new int[5];
        for(int i=newArray.length-1;i>=0;i--)
            for(int j=0;j<outer.length;j++)
                if(newArray[i]==outer[j])
                    professionsDescOrder[i]=j;
        String result="";
        double k = 1/outer[professionsDescOrder[4]];
        for(int i=0, j=4;i<professionsDescOrder.length;i++,j--)
            result+="<b>"+(i+1)+".</b> "+Person.PROFESSION_NAMES[professionsDescOrder[j]]+" ("+(float)(outer[professionsDescOrder[j]]*k*100)+"%)<br />";
        return result;
    }
    public void saveWeight(String filePathE, String filePathO){
        try {
            PrintWriter firstOut = new PrintWriter(filePathE);
            for(int i = 0; i<eTOinner.length;i++){
                String line = "";
                for(int j = 0; j<eTOinner[0].length;j++){
                    line+=eTOinner[i][j]+" ";
                }
                firstOut.println(line);
            }
            firstOut.close();

            PrintWriter secondOut = new PrintWriter(filePathO);
            for(int i = 0; i<iTOouter.length;i++){
                String line = "";
                for(int j = 0; j<iTOouter[0].length;j++){
                    line+=iTOouter[i][j]+" ";
                }
                secondOut.println(line);
            }
            secondOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String giveAnswer(){
        double[] newArray = Arrays.copyOf(outer, outer.length);
        Arrays.sort(newArray);
        double max = newArray[newArray.length-1];
        double preMax = newArray[newArray.length-2];

        int maxInd=-1, preMaxInd=-1;
        for(int i = 0; i<outer.length;i++){
            if(outer[i]==max)maxInd=i;
            if(outer[i]==preMax)preMaxInd=i;
        }

        System.out.println("I think this is  "+Examples.PROFESSIONS[maxInd]+", or less likely "+Examples.PROFESSIONS[preMaxInd]);
        return Examples.PROFESSIONS[maxInd];
    }
   /* public static void main(String[] args) {
        Network net = new Network(new int[11], 10, 5);
        net.initialize();
        System.out.println("studying...");
        long startTime = System.currentTimeMillis();
        net.backPropagation();
        long endTime = System.currentTimeMillis();
        System.out.println("Studying time: "+(endTime-startTime)+" ms, iterations="+iteratorMy);
        System.out.println("I'm smart now! Enter 2-dimensional array: ");
        net.run(Examples.PSYCHOLOGIST);
        net.giveAnswer();
        System.out.println(Arrays.toString(net.outer));


    }
    */
}
