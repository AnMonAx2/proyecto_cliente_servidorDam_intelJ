import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * created by sinNombre on dic., 25/12/2021☺
 */
public class Taller_IntelliJ {
    public static void main(String[] args) {

        String[] args2={"1","2"};
        System.out.println("args = " + Arrays.deepToString(args2));
        System.out.println("args2 = " + args2);


        int     metodo = metodo(7);
        Pattern p= Pattern.compile("[A-Za-z]");



        for (int i = 0; i <3 ; i++) extracted(3<4,  "es menor", "es mayor");

    }

    private static void extracted(boolean b, String s, String s2) {
        if(b) System.out.println(s);
        else System.out.println(s2);

    }



    public static int  metodo(int n){
    return n+10;

    }

    public static void metodo2(){
        int i=1;
        int i2=1;
        double i3=1;
        double i4=1;

    }

    public static void metodo3(){
        int i=1;
        int i2=1;
        int i3=1;
        int i4=1;

    }

    public static void metodo4(){
        int i=1;
        int i2=1;
        int i3=1;
        int i4=1;

    }
}
