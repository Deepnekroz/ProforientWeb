package firstservlet;

import firstservlet.NeuralNetwork.Examples;
import firstservlet.NeuralNetwork.Network;
import firstservlet.NeuralNetwork.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by dmitry on 28.03.15.
 */
public class PeopleForProfession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RETURNS PROFESSION MATCH IN NATURAL ORDER


        Network net = new Network(new int[11], 40, 5);
        net.initialize();
        System.out.println("studying...");
        net.backPropagation();

        int peoplesCount = 3;
        double[][]peoplesResults = new double[peoplesCount][5];
        String[] names = {
                "Nadya",
                "Vasiliy",
                "Dmitry"
        };
        net.run(Examples.STUDENT);
        double[] firstManResults = Arrays.copyOf(net.getOuter(), net.getOuter().length);
        peoplesResults[0]=firstManResults;
        net.run(Examples.ADMINISTRATOR);
        double[] secondManResult = Arrays.copyOf(net.getOuter(), net.getOuter().length);
        peoplesResults[1]=secondManResult;
        net.run(Examples.TEACHER);
        double[] thirdManResult =  Arrays.copyOf(net.getOuter(), net.getOuter().length);
        peoplesResults[2]=thirdManResult;

        int requiredProfessionId = Integer.parseInt(req.getParameter("professionId"));
        double[] requiredProfessionVector = new double[3];
        for(int i = 0; i<peoplesCount;i++)
            for(int j = 0; j<5;j++)
                requiredProfessionVector[i]=peoplesResults[i][requiredProfessionId];
        double[] requiredProfessionVectorSorted = Arrays.copyOf(requiredProfessionVector, requiredProfessionVector.length);
        Arrays.sort(requiredProfessionVectorSorted);
        int[] peoplesOrder = new int[peoplesCount];
        for(int i = 0; i<peoplesCount;i++){
            for(int j = 0; j<requiredProfessionVectorSorted.length;j++){
                for(int k = 0; k<requiredProfessionVector.length; k++){
                    if(requiredProfessionVectorSorted[j]==requiredProfessionVector[k]){
                        peoplesOrder[j]=k;
                    }

                }
            }
        }

        System.out.println(Arrays.toString(peoplesOrder));

        PrintWriter out = resp.getWriter();
        out.println("Peopls matches for "+ Person.PROFESSION_NAMES[requiredProfessionId]+": (first - best)");
        for(int i = peoplesCount-1, j = 1; i>=0; i--, j++)
            out.println(j+"."+names[peoplesOrder[i]]+" ("+(float)(requiredProfessionVectorSorted[i]/1)*100+"%)");

    }
}
