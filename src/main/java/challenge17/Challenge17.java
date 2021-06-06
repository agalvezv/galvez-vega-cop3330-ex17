package challenge17;
//AGV
//6-5-2021
import java.util.Locale;
import java.util.Scanner;

class BAC{
    double a,w,r,h;
    double bacCheck;
    String aS,wS, hS,gS;


    public BAC(){

    }
}

public class Challenge17 {
    //Look into keylistener import if there is time to make a more complicated version of this.
    static final double MAX = Double.MAX_VALUE;


    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        BAC aCheck = new BAC();

        System.out.println("What is your weight?");
        aCheck.wS = inputs.nextLine();
        aCheck.w = numberCheck(aCheck.w, aCheck.wS);
        //System.out.println("Solution successful.");
        //System.out.println(aCheck.w);

        System.out.println("What is your gender?");
        aCheck.gS = inputs.nextLine();
        aCheck.gS = aCheck.gS.toLowerCase();
        //System.out.println(aCheck.gS);

        while(!aCheck.gS.equals("male")&&!aCheck.gS.equals("female"))
        {
            System.out.println("Re-enter value. Type in male or female.");
            aCheck.gS = inputs.nextLine();
            aCheck.gS = aCheck.gS.toLowerCase();
        }

        if(aCheck.gS.equals("male")||aCheck.gS.equals("m"))
        {
            aCheck.r = .73;
        }
        else if(aCheck.gS.equals("female")||aCheck.gS.equals("f"))
        {
            aCheck.r = .66;
        }
        //System.out.println(aCheck.r);


        System.out.println("Tell me the total amount of alcohol you consumed? (In ounces.)");
        aCheck.aS = inputs.nextLine();
        aCheck.a = numberCheck(aCheck.a, aCheck.aS);
        //System.out.println(aCheck.a);

        System.out.println("How many hours have passed since your last drink?");
        aCheck.hS = inputs.nextLine();
        aCheck.h = numberCheck(aCheck.h, aCheck.hS);
        //System.out.println(aCheck.h);

        aCheck.bacCheck=(aCheck.a*5.14);
        //System.out.println(aCheck.bacCheck);
        double div = aCheck.w* aCheck.r;
        //System.out.println(div);
        aCheck.bacCheck=aCheck.bacCheck/div;
        //System.out.println(aCheck.bacCheck);
        aCheck.bacCheck=aCheck.bacCheck-(.15*aCheck.h);
        //System.out.println(aCheck.bacCheck);
        aCheck.bacCheck= Math.round(aCheck.bacCheck*100);
        aCheck.bacCheck=aCheck.bacCheck/100;

        if(aCheck.bacCheck>=.08)
        {
            System.out.println("Your BAC is " + aCheck.bacCheck);
            System.out.println("It is not legal for you to drive.");
        }
        else
        {
            System.out.println("Your BAC is " + aCheck.bacCheck);
            System.out.println("Really. Where is the winery, bro?");
        }


    }

    public static double numberCheck(Double p, String pS) {
        boolean numBool;
        Scanner inputs2 = new Scanner(System.in);
        try {
            p = Double.parseDouble(pS);
            //aCheck.w=numberCheck(aCheck.w);
            //System.out.println(aCheck.w);
        } catch (NumberFormatException rec) {
            numBool = false;
            System.out.println("Input unacceptable. Please enter a numerical value.");
            if(numBool==false)
            {
                while (numBool==false) {
                    pS = inputs2.nextLine();
                    try {
                        p = Double.parseDouble(pS);
                        numBool=true;
                        //aCheck.w=numberCheck(aCheck.w);
                        //System.out.println(aCheck.w);
                    } catch (NumberFormatException rec2) {
                        System.out.println("Input unacceptable. Please enter a numerical value.");

                    }


                }

            }



        }
        return p;
    }
}
