package firstservlet.NeuralNetwork;

import java.util.Scanner;

import static firstservlet.NeuralNetwork.Person.*;


public class Examples {
    public static final int[] ALGORITHMIST = {
            STYLE_BUSINESS,
            HEALTH_BAD,
            AMBITIONS_YES,
            HOBBIES_COMP,
            EDUCATION_COURSES,
            GENDER_MAN,
            AGE_BETWEEN_20_40,
            FOREIGN_YES,
            IQ_MORE_110,
            RELIGION_NOT_TRUST,
            POLIT_NOT_INVOLVED
    };
    public static final int[] ADMINISTRATOR = {
            STYLE_CASUAL,
            HEALTH_BAD,
            AMBITIONS_NO,
            HOBBIES_COMP,
            EDUCATION_COURSES,
            GENDER_MAN,
            AGE_BETWEEN_20_40,
            FOREIGN_YES,
            IQ_BETWEEN_100_110,
            RELIGION_NOT_TRUST,
            POLIT_NOT_INVOLVED
    };
    public static final int[] ADMINISTRATOR_TWO = {
            STYLE_CASUAL,
            HEALTH_NORMAL,
            AMBITIONS_NO,
            HOBBIES_COMP,
            EDUCATION_COURSES,
            GENDER_MAN,
            AGE_BETWEEN_20_40,
            FOREIGN_NO,
            IQ_BETWEEN_100_110,
            RELIGION_NOT_TRUST,
            POLIT_NOT_INVOLVED
    };



    public static final int[] TEACHER = {
            STYLE_BUSINESS,
            HEALTH_NORMAL,
            AMBITIONS_NO,
            HOBBIES_EDU,
            EDUCATION_HIGH,
            GENDER_WOMAN,
            AGE_MORE_40,
            FOREIGN_NO,
            IQ_BETWEEN_100_110,
            RELIGION_TRUST,
            POLIT_INVOLVED
    };
    public static final int[] STUDENT = {
            STYLE_SPORT,
            HEALTH_SPORT,
            AMBITIONS_YES,
            HOBBIES_EDU,
            EDUCATION_NO,
            GENDER_MAN,
            AGE_LESS_20,
            FOREIGN_YES,
            IQ_LESS_100,
            RELIGION_TRUST,
            POLIT_INVOLVED
    };
    public static final int[] STUDENT_TWO = {
            STYLE_SPORT,
            HEALTH_SPORT,
            AMBITIONS_YES,
            HOBBIES_EDU,
            EDUCATION_NO,
            GENDER_WOMAN,
            AGE_LESS_20,
            FOREIGN_NO,
            IQ_LESS_100,
            RELIGION_TRUST,
            POLIT_INVOLVED
    };

    public static final int[] PSYCHOLOGIST = {
            STYLE_CASUAL,
            HEALTH_NORMAL,
            AMBITIONS_NO,
            HOBBIES_PSYCHO,
            EDUCATION_HIGH,
            GENDER_WOMAN,
            AGE_MORE_40,
            FOREIGN_NO,
            IQ_LESS_100,
            RELIGION_TRUST,
            POLIT_INVOLVED
    };

    public static void main(String[] args){
        printSum(ALGORITHMIST);
        printSum(ADMINISTRATOR);
        printSum(TEACHER);
        printSum(STUDENT);
        printSum(PSYCHOLOGIST);

    }

    private static void printSum(int[]array){
        int sum=0;
        for(int i =0; i<array.length;i++)
            sum+=array[i];
        System.out.println(sum);
    }

    public static final String[] PROFESSIONS = {
        "ALGORITHMIST",
        "ADMINISTRATOR",
        "TEACHER",
        "STUDENT",
        "PSYCHOLOGIST"
    };

    public static final int[] ALGORITHMIST_CORRECT = {1,0,0,0,0};
    public static final int[] ADMINISTRATOR_CORRECT = {0,1,0,0,0};
    public static final int[] TEACHER_CORRECT = {0,0,1,0,0};
    public static final int[] STUDENT_CORRECT = {0,0,0,1,0};
    public static final int[] PSYCHOLOGIST_CORRECT ={0,0,0,0,1};

    public static final int[][] CORRECT_ANSWERS={
            ALGORITHMIST_CORRECT,
            ADMINISTRATOR_CORRECT,
            TEACHER_CORRECT,
            PSYCHOLOGIST_CORRECT,
            STUDENT_CORRECT,
    };
    public static final int[][] patterns ={
            ALGORITHMIST,
            ADMINISTRATOR,
            TEACHER,
            PSYCHOLOGIST,
            STUDENT,
    };

    public static int[] expandArray(int[][] inner){
        int[]result=new int[inner.length*inner[0].length];
        int iteration=0;
        for(int i = 0;i<inner.length;i++){
            for(int j=0; j<inner[i].length;j++){
                result[iteration]=inner[i][j];
                iteration++;
            }
        }
        return result;
    }
    public static double[] expandArrayFromIntToDouble(int[][] inner){
        double[]result=new double[inner.length*inner[0].length];
        int iteration=0;
        for(int i = 0;i<inner.length;i++){
            for(int j=0; j<inner[i].length;j++){
                result[iteration]=inner[i][j];
                iteration++;
            }
        }
        return result;
    }
    public static int[] inputMatrix(){
        int[] result=new int[10];
        Scanner s = new Scanner(System.in);
        for(int i =0; i<10;i++){
            if(s.hasNextInt())
                result[i]=s.nextInt();
        }
        return result;

    }



    public static final int[] FIRST_MAN = {
            STYLE_BUSINESS,
            HEALTH_NORMAL,
            AMBITIONS_YES,
            HOBBIES_PSYCHO,
            EDUCATION_HIGH,
            GENDER_WOMAN,
            AGE_MORE_40,
            FOREIGN_NO,
            IQ_LESS_100,
            RELIGION_TRUST,
            POLIT_INVOLVED
    };
    public static final int[] SECOND_MAN = {
            STYLE_CASUAL,
            HEALTH_NORMAL,
            AMBITIONS_NO,
            HOBBIES_PSYCHO,
            EDUCATION_COURSES,
            GENDER_WOMAN,
            AGE_LESS_20,
            FOREIGN_NO,
            IQ_BETWEEN_100_110,
            RELIGION_TRUST,
            POLIT_INVOLVED
    };
    public static final int[] THIRD_MAN = {
            STYLE_CASUAL,
            HEALTH_NORMAL,
            AMBITIONS_NO,
            HOBBIES_PSYCHO,
            EDUCATION_HIGH,
            GENDER_MAN,
            AGE_MORE_40,
            FOREIGN_NO,
            IQ_LESS_100,
            RELIGION_NOT_TRUST,
            POLIT_NOT_INVOLVED
    };
    public static final int[][] REAL_PEOPLES = {
            FIRST_MAN,
            SECOND_MAN,
            THIRD_MAN
    };
}
