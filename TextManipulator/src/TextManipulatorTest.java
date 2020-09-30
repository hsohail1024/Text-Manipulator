import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TextManipulatorTest {

    public static void main(String[] args) {
        
        String str = "";
        String frenchWord = "Aucune";
        String engWord = "No";
        
        int frLength = frenchWord.length();
        int engLength = engWord.length();
        
        int diff = engLength - frLength;
        System.out.println(diff);
        
        
        //when comparing english word to french
        if(diff > 0) {
            for(int i = 0; i < diff; i++)
            frenchWord = frenchWord + " ";
        }
        else {
            for(int i = 0; i < Math.abs(diff); i++) {
                engWord = engWord + " ";
            }
        }
     
        System.out.println(engWord);
        System.out.println(frenchWord);
        System.out.println("---------------------");
        
        System.out.println(frenchWord);
        System.out.println(engWord);
        
        
        
//        String frenchWord1 = "bibliotheque";
//        String engWord1 = "library";
//        int diff1 = engWord1.length() - frenchWord1.length();
//        System.out.println(diff1);
//        
//        if(diff1 < 0) {
//            
//            for(int i = 0; i < Math.abs(diff1); i++) {
//                engWord1 = engWord1 + " ";
//            }
//        }
//        
//        System.out.println(engWord1);
//        System.out.println(frenchWord1);
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        String french = "bibliotheque";
//        String eng = "library";
//        int engLength = eng.length();
//        int frenchLength = french.length();
//        
//        String french1 = "Aucune";
//        String eng1 = "No";
//        int french1Length = french1.length();
//        int eng1Length = eng1.length();
//        
//        int diffLength = Math.abs(french.length() - eng.length());
//        int diffLength1 = Math.abs(french1.length()-eng1.length());
//
//        if(engLength >  frenchLength)
//        {
//            french =  String.format("%-" + (french.length() + diffLength) + "s", french);
//           
//            
//        }
//        else
//        {
//             eng = String.format("%-" + (eng.length()+diffLength) +"s", eng);
//       
//        }
//        
//        if(eng1.length() >  french1.length())
//        {
//            french1 =  String.format("%-" + (french1.length() + diffLength1) + "s", french1);
//        
//            
//        }
//        else
//        {
//             eng1 = String.format("%-" + (eng1.length()+diffLength1) +"s", eng1);
//          
//        }
//        
//        System.out.println(eng);
//        System.out.println(french);
//        
//        System.out.println(eng1);
//        System.out.println(french1);

      


}
}
