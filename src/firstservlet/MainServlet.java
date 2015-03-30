package firstservlet;


import firstservlet.NeuralNetwork.Network;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Network net = new Network(new int[11], 15, 5);
        net.initialize();
        System.out.println("studying...");
        net.backPropagation();

        PrintWriter out = resp.getWriter();
        try {
            int style = Integer.parseInt(req.getParameter("style"));
            int health = Integer.parseInt(req.getParameter("health"));
            int ambitions = Integer.parseInt(req.getParameter("ambitions"));
            int interests = Integer.parseInt(req.getParameter("interests"));
            int education = Integer.parseInt(req.getParameter("education"));
            int gender = Integer.parseInt(req.getParameter("gender"));

            int age = Integer.parseInt(req.getParameter("age"));
            int foreign = Integer.parseInt(req.getParameter("foreign"));
            int iq = Integer.parseInt(req.getParameter("iq"));
            int god = Integer.parseInt(req.getParameter("god"));
            int politics = Integer.parseInt(req.getParameter("politics"));
            boolean isTextFormat = Boolean.parseBoolean(req.getParameter("isText"));

            if(age>20 && age<40)
                age=1;
            else if(age>=40)
                age=2;
            else
                age=1;

            if(iq>100 && iq<110)
                iq=1;
            else if(iq>=110)
                iq=0;
            else
                iq=2;

            int[] inputVector = {
                    style,
                    health,
                    ambitions,
                    interests,
                    education,
                    gender,
                    age,
                    foreign,
                    iq,
                    god,
                    politics
            };


            net.run(inputVector);
            resp.setContentType("text/html");
            if(isTextFormat){
                out.println(net.giveAnswerExtended());
            }else{
                float[] array = new float[net.getOuter().length];
                for(int i = 0; i<array.length;i++)
                    array[i]=(float)Math.round(net.getOuter()[i] * 100000) / 100000;
                out.println(Arrays.toString(array));
            }

        }catch(NumberFormatException e){
            out.println("Incorrect data passed");
            e.printStackTrace();
        }finally {
            out.close();
        }



    }


}
