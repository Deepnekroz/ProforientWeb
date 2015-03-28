package firstservlet;


import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import firstservlet.NeuralNetwork.Network;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by dmitry on 03.03.15.
 */
public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Network net = new Network(new int[11], 40, 5);
        net.initialize();
        System.out.println("studying...");
        net.backPropagation();



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
        try {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            if(isTextFormat){
                out.println(net.giveAnswer());
            }else{
                float[] array = new float[net.getOuter().length];
                for(int i = 0; i<array.length;i++)
                    array[i]=(float)Math.round(net.getOuter()[i] * 100000) / 100000;
                JSONArray jsonArray = new JSONArray(Arrays.toString(array));
                System.out.println(jsonArray);
                out.println(jsonArray);
            }



            out.close();
        }catch(JSONException e){
            e.printStackTrace();
        }



    }


}
