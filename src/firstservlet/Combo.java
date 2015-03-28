package firstservlet;

import firstservlet.NeuralNetwork.Examples;
import firstservlet.NeuralNetwork.Network;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dmitry on 28.03.15.
 */
public class Combo extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int [][]people=new int[5][11];
        people[0]= Examples.ALGORITHMIST;
        people[1]= Examples.ADMINISTRATOR;
        people[2]= Examples.STUDENT;
        people[3]= Examples.TEACHER;
        people[4]= Examples.PSYCHOLOGIST;
        Network net = new Network(new int[11], 40, 5);
        net.initialize();
        System.out.println("studying...");
        net.backPropagation();
        PrintWriter out=resp.getWriter();
        for(int i=0;i<5;i++){
            net.run(people[i]);
            out.println("\n" + net.giveAnswerExtended() + "\n");
        }
        out.close();


    }
}
