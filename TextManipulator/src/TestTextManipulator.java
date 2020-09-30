/**
 * This file contains testing methods for the TextManipulator project.
 * These methods are intended to serve several objectives:
 * 1) provide an example of a way to incrementally test your code
 * 2) provide example method calls for the TextManipulator methods
 * 3) provide examples of creating, accessing and modifying arrayLists
 * 4) translating and matching cases
 * 
 * Some of the provided comments within this file explain
 * Java code as they are intended to help you learn Java.  However,
 * your comments and comments in professional code, should
 * summarize the purpose of the code, not explain the meaning
 * of the specific Java constructs.
 *    
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


/**
 * This class contains a few methods for testing methods in the TextManipulator
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 * 
 * @author Jim Williams
 * @author FIXME Huzaifa Sohail
 *
 */
public class TestTextManipulator {

    /**
     * This is the main method that runs the various tests. Uncomment the tests
     * when you are ready for them to run.
     * 
     * @param args  (unused)
     */
    public static void main(String [] args) {

        
        // Milestone 2
        //testMatchCase();
        //testTranslate();
        
        // Milestone 3
        //testReverse();
        //testpigLatin();
        //reverseLine();
        //testManipulate(); //NOT YET WORKED ON
        
    }
    
    /**
     * This is intended to run some tests on the matchCase method. 
     * 1. Using a template of how we want the original string to match up with (upper or lower case) and 
     * making sure that each character in that index matches up with the correct case as the template.
     * If template is shorter than the original, the remaining original characters will be lowercase.
     * 
     */
    private static void testMatchCase() {
     
        //String template = "WIscOnSiN";
        String template = "XXxxXxXxX";
        String original = "Wisconsin";
        String expectedOutput = "WIscOnSiN";
        boolean error = true;
        
       String newOriginal =  TextManipulator.matchCase(template, original);
       System.out.println("------------------------------------------------------------------------------------------");
       System.out.println("                                    MATCHCASE TEST                                        ");
       System.out.println("------------------------------------------------------------------------------------------");
       System.out.println("Test Case 1");
       System.out.println("Template: XXxxXxXxX\nOriginal: Wisconsin\nExpected output is WIscOnSiN, got " + newOriginal);
       
       if(newOriginal.equals(expectedOutput)) {
           System.out.println("MatchCase Test Passed!");
       }
       else {
           System.out.println("MatchCase Test Failed!");
       }
       System.out.println("-------------------------------------------------------------------------------------------");
       
       template = "XxXxXXXXXXxxXXXXX";
       original = "enCephaLitis";
       expectedOutput = "EnCePHALITis";
       
       
       newOriginal = TextManipulator.matchCase(template, original);
       System.out.println("Test Case 2");
       System.out.println("Template: XxXxXXXXXXxxXXXXX\nOriginal: enCephaLitis\nExpected output is EnCePHALITis, got " + newOriginal);
       
       if(newOriginal.equals(expectedOutput)) {
           System.out.println("MatchCase Test Passed!");
       }
       else {
           System.out.println("MatchCase Test Failed!");
       }
       System.out.println("-------------------------------------------------------------------------------------------");
       
       template = "xxXxXXXXx";
       original = "OnoMatopOeIA";
       expectedOutput = "onOmATOPoeia";
       
       newOriginal = TextManipulator.matchCase(template, original);
       System.out.println("Test Case 3");
       System.out.println("Template: xxXxXXXXx\nOriginal: OnoMatopOeIA\nExpected output is onOmATOPoeia, got " + newOriginal);
       
       if(newOriginal.equals(expectedOutput)) {
           System.out.println("MatchCase Test Passed!");
       }
       else {
           System.out.println("MatchCase Test Failed!");
       }
       System.out.println("-------------------------------------------------------------------------------------------");
       
       template = "xX";
       original = "writABlE";
       expectedOutput = "wRitable";
       
       newOriginal = TextManipulator.matchCase(template, original);
       System.out.println("Test Case 4");
       System.out.println("Template: " + template + "\nOriginal: " + original +" \nExpected output is " + expectedOutput + ", got " + newOriginal);
       
       if(newOriginal.equals(expectedOutput)) {
           System.out.println("MatchCase Test Passed!");
       }
       else {
           System.out.println("MatchCase Test Failed!");
       }
    }   
    
    private static void testTranslate() {
        ArrayList<String[]> dictionary = new ArrayList<String[]>();
        String[] engAndFrenchWords = new String[2];
        
        engAndFrenchWords[0] = "star";
        engAndFrenchWords[1] = "étoile";
        dictionary.add(engAndFrenchWords);
        
        String engWord = "star";
        String frenchWord;
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("                                    TRANSLATE TEST                                 ");
        System.out.println("-----------------------------------------------------------------------------------");
        
        frenchWord = TextManipulator.translate(engWord, dictionary);
        
        System.out.println("ENGLISH WORD: " + engWord + " Expected French Word: étoile, " + "got: " + frenchWord);
        
        if(engAndFrenchWords[1].equals(frenchWord)) {
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test failed");
        }
        
        dictionary.clear();
        
        System.out.println("-----------------------------------------------------------------------------------------");
        
        engAndFrenchWords[0] = "old";
        engAndFrenchWords[1] = "vie(ux/ille)";
        dictionary.add(engAndFrenchWords);
        
        
        engWord = "old";
        
        
        frenchWord = TextManipulator.translate(engWord, dictionary);
        
        System.out.println("ENGLISH WORD: " + engWord + " Expected French Word: vie(us/ille), " + "got: " + frenchWord);
        
        if(engAndFrenchWords[1].equals(frenchWord)) {
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test failed");
        }
        
        
        System.out.println("-----------------------------------------------------------------------------------------");
        
        engAndFrenchWords[0] = "fish";
        engAndFrenchWords[1] = "poisson";
        dictionary.add(engAndFrenchWords);
        
        
        engWord = "fish";
        
        
        frenchWord = TextManipulator.translate(engWord, dictionary);
        
        System.out.println("ENGLISH WORD: " + engWord + " Expected French Word: poisson, " + "got: " + frenchWord);
        
        if(engAndFrenchWords[1].equals(frenchWord)) {
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test failed");
        }
        System.out.println("-----------------------------------------------------------------------------------");

    }
    
    private static void testManipulate() {
        //Review the eraseMap method header carefully and write
        //tests to check whether the method is working correctly.
        System.out.println("Need to write testEraseMap tests.");
    }
    
    private static void testReverse() {
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("                               REVERSE WORD TEST                                   ");
        System.out.println("-----------------------------------------------------------------------------------");
        
        String beforeRev = "Hello World";
        
        String afterRev = "Dlrow Olleh";
        
        String[] revWord = new String[2];
        
        String reverse = "";
        
        reverse = TextManipulator.reverse(beforeRev);

        System.out.println("Test 1");
        System.out.println("before reverse word: " + beforeRev);
        System.out.println("expected: " + afterRev);
        
        System.out.println("The reverse would be: "+ reverse);
      
        if(afterRev.equals(reverse)) {
            System.out.println("Test passed.");
        }
        else {
            System.out.println("Test failed.");
        }
        
        System.out.println();
        
         beforeRev = "aZErty";
        
         afterRev = "yTReza";
        
        revWord = new String[2];
        
        reverse = "";
        
        reverse = TextManipulator.reverse(beforeRev);
        
        System.out.println("Test 2");
        System.out.println("before reverse word: " + beforeRev);
        System.out.println("expected: " + afterRev);
        
        System.out.println("The reverse would be: "+ reverse);
      
        if(afterRev.equals(reverse)) {
            System.out.println("Test passed.");
        }
        else {
            System.out.println("Test failed.");
        }
        System.out.println();
        
        
        beforeRev = "Kobe BrYant";
        
        afterRev = "TnayrB Ebok";
       
       revWord = new String[2];
       
       reverse = "";
       
       reverse = TextManipulator.reverse(beforeRev);
       
       System.out.println("Test 3");
       System.out.println("before reverse word: " + beforeRev);
       System.out.println("expected: " + afterRev);
       
       System.out.println("The reverse would be: "+ reverse);
     
       if(afterRev.equals(reverse)) {
           System.out.println("Test passed.");
       }
       else {
           System.out.println("Test failed.");
       }
       System.out.println();
       
       beforeRev = "University of Wisconsin - Madison";
       
       afterRev = "Nosidam - nisnOcsiw fo ytiSrevinu";
      
      revWord = new String[2];
      
      reverse = "";
      
      reverse = TextManipulator.reverse(beforeRev);
      
      System.out.println("Test 4");
      System.out.println("before reverse word: " + beforeRev);
      System.out.println("expected: " + afterRev);
      
      System.out.println("The reverse would be: "+ reverse);
    
      if(afterRev.equals(reverse)) {
          System.out.println("Test passed.");
      }
      else {
          System.out.println("Test failed.");
      }
      System.out.println();
    }
   
    private static void testpigLatin() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("                                      PIGLATIN TEST                                        ");
        System.out.println("-------------------------------------------------------------------------------------------");
        String str = "Hamburger";
        String expectedStr = "Amburgerhay";
     
        System.out.println("Test 1");
       System.out.println("Original: " + str);
        System.out.println("expected: " + expectedStr);
        String pigLatinWord = TextManipulator.pigLatin(str);
        System.out.println("pigLatin: " + pigLatinWord);

        
        if(pigLatinWord.equals(expectedStr)) {
           
//            System.out.println("Before pig latin: " + str + "\nAfter pigLatin: " + pigLatinWord + "\nActual output: " + expectedStr);
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test Failed!");
        }
        
         str = "FoOd";
         expectedStr = "OoDfay";
         
         System.out.println("\nTest 2");
         System.out.println("Original: " + str);
         System.out.println("expected: " + expectedStr);
         
        pigLatinWord = TextManipulator.pigLatin(str);
        System.out.println("pigLatin: " + pigLatinWord);

        
        if(pigLatinWord.equals(expectedStr)) {
           
//            System.out.println("Before pig latin: " + str + "\nAfter pigLatin: " + pigLatinWord + "\nActual output: " + expectedStr);
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test Failed!");
        }
    
    
         str = "pilLOw";
         expectedStr = "illOWpay";
         
         System.out.println("\nTest 3");     
         System.out.println("Original: " + str);
         System.out.println("expected: " + expectedStr);
         
        pigLatinWord = TextManipulator.pigLatin(str);
        System.out.println("pigLatin: " + pigLatinWord);

        
        if(pigLatinWord.equals(expectedStr)) {
           
//            System.out.println("Before pig latin: " + str + "\nAfter pigLatin: " + pigLatinWord + "\nActual output: " + expectedStr);
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test Failed!");
        }
 
    
         str = "strAwBerRIEs";
         expectedStr = "errIeSstRAWbay";
     
         System.out.println("\nTest 4");
         System.out.println("Original: " + str);
         System.out.println("expected: " + expectedStr);
         
        pigLatinWord = TextManipulator.pigLatin(str);
        System.out.println("pigLatin: " + pigLatinWord);

        
        if(pigLatinWord.equals(expectedStr)) {
           
//            System.out.println("Before pig latin: " + str + "\nAfter pigLatin: " + pigLatinWord + "\nActual output: " + expectedStr);
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test Failed!");
        }
        
    }
    
    private static void reverseLine() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> newNames = new ArrayList<String>();
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("                                    REVERSE LINE TEST                                     ");
        System.out.println("------------------------------------------------------------------------------------------");
        
        names.add("Harry");
        names.add("Ron");
        names.add("Harmione");
        names.add("Fred");
        names.add("Dumbeldore");
        names.add("Snape");
        names.add("Voldemort");
        names.add("Kobe");
        
        ArrayList<String> expectedNames = new ArrayList<String>();
        expectedNames.add("Kobe");
        expectedNames.add("Voldemort");
        expectedNames.add("Snape");
        expectedNames.add("Dumbeldore");
        expectedNames.add("Fred");
        expectedNames.add("Harmione");
        expectedNames.add("Ron");
        expectedNames.add("Harry");

        System.out.println("\t\tTest 1");
        System.out.println("Before reversing arraylist: ");
        System.out.println(names);
        System.out.println();
        //System.out.println("Expected result: \n[Kobe, Voldemort, Snape, Dumberdore, Fred, Harmione, Ron, Harry]");
        System.out.println("Expected result: \n" + expectedNames);
        System.out.println();
        newNames = TextManipulator.reverse(names);
        System.out.println("After reversing arraylist:  ");
        System.out.println(newNames);
                
        
        System.out.println("---------------------------------------------------------------------------------------------");
        names.clear();
        
        names.add("How");
        names.add("are");
        names.add("you");
        names.add("doing");
        names.add("?");
        names.add("Where");
        names.add("are");
        names.add("you");

        System.out.println("\t\tTest 2");
        System.out.println("Before reversing arraylist: ");
        System.out.println(names);
        System.out.println();
        System.out.println("Expected result: \n[you, are, Where, ?, doing, you, are, How]");
        System.out.println();
        newNames = TextManipulator.reverse(names);
        System.out.println("After reversing arraylist:  ");
        System.out.println(newNames);
        
        System.out.println("---------------------------------------------------------------------------------------------");
        names.clear();
        
        names.add("This");
        names.add("is");
        names.add("the");
        names.add("Test");
        names.add("that");
        names.add("we");
        names.add("want");
        names.add("checked");

        System.out.println("\t\tTest 3");
        System.out.println("Before reversing arraylist: ");
        System.out.println(names);
        System.out.println();
        System.out.println("Expected result: \n[checked, want, we, that, Test, the, is, This]");
        System.out.println();
        newNames = TextManipulator.reverse(names);
        System.out.println("After reversing arraylist:  ");
        System.out.println(newNames);
        
        System.out.println("---------------------------------------------------------------------------------------------");
        names.clear();
        
        names.add("I");
        names.add("am");
        names.add("Sam");
        names.add("Sam");
        names.add("I");
        names.add("am");
        names.add("!");
        names.add("Do");
        names.add("you");
        names.add("like");
        names.add("green");
        names.add("eggs");
        names.add("and");
        names.add("ham");
        names.add("?");
        
        
        System.out.println("\t\tTest 4");
        System.out.println("Before reversing arraylist: ");
        System.out.println(names);
        System.out.println();
        System.out.println("Expected result: \n[?, ham, and, eggs, green, like, you, Do, !, am, I, Sam, Sam, am, I]");
        System.out.println();
        newNames = TextManipulator.reverse(names);
        System.out.println("After reversing arraylist:  ");
        System.out.println(newNames);
        }

     
    
   
}