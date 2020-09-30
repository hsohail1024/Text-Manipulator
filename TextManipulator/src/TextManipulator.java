// FIXME file header comment

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// FIXME class header comment

public class TextManipulator {

    /**
     * Matches the case of the original string to that of the template as follows.
     *
     * 1) If the length of template is the same or longer than the length of the original, the
     * returned string will match the case of the prefix of the template up to the length of the
     * original string. For example: template: XXxxxXxX original: azertYU returns: AZertYu
     *
     * 2) If the length of the template is shorter than the length of the original, the prefix of
     * the returned string up to the length of the template will match the case of the template. The
     * remaining characters should all be lower case. For example: template: WxCv original: azertYU
     * returns: AzErtyu
     *
     * @param template Template of which characters should be which case.
     * @param original String to change the case of, based on the template.
     * @return A string containing the characters of original with the case matching that of
     *         template.
     */
    public static String matchCase(String template, String original) {



        int templateLength =  template.length();
        int originalLength = original.length();
        char changeChar;

        StringBuilder finalOriginalWord = new StringBuilder();
        for(int i = 0; i < templateLength &&  i < originalLength; i++)
        {
            if(Character.isUpperCase(template.charAt(i)))
            {
                changeChar =  Character.toUpperCase(original.charAt(i));

                finalOriginalWord.append(changeChar);
            }
            else if(Character.isLowerCase(template.charAt(i)))
            {
                changeChar = Character.toLowerCase(original.charAt(i));

                finalOriginalWord.append(changeChar);
            }

            else {
                finalOriginalWord.append(original.charAt(i));
            }


        }
        for(int i = template.length(); i < original.length(); i++ ){


            changeChar = Character.toLowerCase(original.charAt(i));
            finalOriginalWord.append(changeChar);

        }

        // FIXME
        return finalOriginalWord.toString();
    }

    /**
     * Translates a word according to the data in wordList then matches the case. The parameter
     * wordList contains the mappings for the translation. The data is organized in an ArrayList
     * containing String arrays of length 2. The first cell (index 0) contains the word in the
     * original language, called the key, and the second cell (index 1) contains the translation.
     *
     * It is assumed that the items in the wordList are sorted in ascending order according to the
     * keys in the first cell.
     *
     * @param word The word to translate.
     * @param wordList An ArrayList containing the translation mappings.
     * @return The mapping in the wordList with the same case as the original. If no match is found
     *         in wordList, it returns a string of Config.LINE_CHAR of the same length as word.
     */
    public static String translate(String word, ArrayList<String[]> wordList) {

        int numberOfKeys = wordList.size();
        int wordLength = word.length();
        String engWord = word;
        String fraWord = "";
        boolean hasTranslation = false;


        for (int i = 0; i < numberOfKeys; i++) {

            String wordKey = wordList.get(i)[0];
            if (engWord.equalsIgnoreCase(wordKey)) {
                hasTranslation = true;
                fraWord = wordList.get(i)[1];

                fraWord = matchCase(engWord, fraWord);
                break;

            }

        }
        if (!hasTranslation) {

            for (int l = 0; l < wordLength; l++) {
                fraWord += Config.LINE_CHAR;
            }
        }

        boolean lett = Character.isLetter(engWord.charAt(0));
        if (!lett) {
            fraWord = engWord;
        }

        return fraWord;
    }

    /**
     * Converts a string to simplified Pig Latin then matching the case. The rules for simplified
     * Pig Latin are as follows: 1) If the word begins with a vowel (a, e, i, o, u, or y), then the
     * string "way" is appended. 2) If the word begins with a consonant (any letter that is not a
     * vowel as defined above), then the group of consonants at the beginning of the word are moved
     * to the end of the string, and then the string "ay" is appended. 3) If the word begins with
     * any other character, the original string is returned. Note 1: 'y' is always considered a
     * vowel. Note 2: An apostrophe that is not the first character of a word is treated as a
     * consonant.
     *
     * Some examples: Pig -> Igpay Latin -> Atinlay Scram -> Amscray I'd -> I'dway you -> youway
     * crypt -> yptcray
     *
     * @param word The word to covert to simplified Pig Latin.
     * @return The simplified Pig Latin of the parameter word with matching case.
     */
    public static String pigLatin(String word) {
        String changingWord = word;
        String pigLatinString = "";
        char v = word.charAt(0);
        char[] vowels = {'a','e','i','o','u'};
        
        if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'y' ||
            v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U' || v == 'Y'){ //Instead of having it so long, maybe think about doing toLowerCase 
                                                                                   //and then call matchCase.
            pigLatinString = changingWord + "way";
           
        }
        else
        {
            outerloop:
            for (int i = 0; i < changingWord.length(); i++) 
            {
                for (int j = 0; j < vowels.length; j++) 
                {
                    if (changingWord.charAt(i) == vowels[j]) 
                    {
                        pigLatinString = changingWord.substring(i) + changingWord.substring(0, i) + "ay";
                        //System.out.println("Before matchCase: " + pigLatinString); DELETE
                        pigLatinString = matchCase(word, pigLatinString );
                        //System.out.println("After matchCase: " + pigLatinString); DELETE
                        break outerloop;
                    }
                    else {
                        pigLatinString = changingWord;
                    }
                }
            }
           
        }
        return pigLatinString;
    }

    /**
     * Reverses a String, then matches the case. For example: aZErty returns yTReza
     *
     * @param word The String to reverse.
     * @return The reverse of word with matching case.
     */
    public static String reverse(String word) {
        String beforeRev = word;
        String reverse = "";
        
        int beforeRevLength = beforeRev.length();
        
        for(int i = beforeRevLength - 1; i >= 0; --i){
            
            reverse = reverse + beforeRev.charAt(i);
            reverse = matchCase(word, reverse );
            
        }
        
        return reverse;
    }

    /**
     * Builds a new ArrayList of Strings that contains the items of the ArrayList passed in, arrL,
     * but in reverse order.
     *
     * @param arrL The ArrayList of Strings to reverse.
     * @return A new ArraList of Strings that is the reverse of arrL.
     */
    public static ArrayList<String> reverse(ArrayList<String> arrL) {
        
        ArrayList<String> reverseString = new ArrayList<String>();
        int arrLSize = arrL.size();
        reverseString = arrL;
        
       
        for (int i = 0; i < arrLSize / 2; i++) { 
            final String firstString = reverseString.get(i); 
            reverseString.set(i, reverseString.get(arrLSize - i - 1)); 
            reverseString.set(arrLSize - i - 1, firstString); 
            }
        
        return reverseString;
    }

    /**
     * The method that displays the main program menu and reads the user's menu choice. The full
     * menu has the following format where the (assuming that Config.MISSING_CHAR is '-'):
     * 
     * -------------------------------------------------------------------------------- 
     * Text Manipulator Program
     * -------------------------------------------------------------------------------- Current
     * input file: --- Current output file: --- Current dictionary: --- Current mode: Interleaved
     * Current mods: TPWL
     * -------------------------------------------------------------------------------- 
     * Main menu:
     * 1) Display Output 
     * 2) Save Output 
     * Manipulations: 
     *         T)ranslate 
     *         P)ig latin 
     *         W)ord reverse 
     *         L)ine reverse
     * Configuration: 
     *         I)nput file. 
     *         O)utput file. 
     *         D)ictionary file. 
     *         M)ode Toggle. 
     *         H)ide/show Menu. 
     *         Q)uit Enter action:
     *
     * Notes: - The lines consist of 80 Config.LINE_CHAR characters. - The input file, output file
     * and dictionary names are 3 Config.LINE_CHAR characters if appropriate value in files is null,
     * otherwise display the appropriate value in files. - The Current mode displays "Interleaved"
     * when modeBoth is true and "Modified" when false. - The Current mods displays (in the
     * following order) 'T' if translate is toggled, 'P' if Pig Latin is toggled, 'W' if word
     * reverse is toggled, and 'L' if line reverse is toggled. - The manipulation and configuration
     * options are preceded by a single tab. - There is no new line following the final "Enter
     * action: " prompt.
     *
     * @param sc The reference to the Scanner object for reading input from the user.
     * @param files A string array containing the input file name, the output file name, and the
     *        dictionary file name in that exact order. The entries may be null. The length of the
     *        array is Config.NUM_FILES. The input file name is at index Config.FILE_IN, the output
     *        file name is at index Config.FILE_OUT, and the dictionary file name is at index
     *        Config.FILE_DICT.
     * @param modFlags A boolean array where the values are true if the given modification is set to
     *        be applied.
     * @param modeBoth True if the display command will alternate lines from the modified text and
     *        the original text.
     * @param showMenu If true the entire menu is shown, otherwise only the "Enter Action: " line is
     *        shown.
     * @return The first character of the line inputed by the user.
     */
    public static char promptMenu(Scanner sc, String[] files, boolean[] modFlags, boolean modeBoth,
        boolean showMenu) {
        int lineCapacity = 80;


        char lineBorder = Config.LINE_CHAR * 80;



        if (showMenu) {
            if (lineCapacity >= 80) {
                for (int i = 1; i <= lineCapacity; i++) {
                    System.out.print(Config.LINE_CHAR);
                }

                System.out.println();
            }
            System.out.println("Text Manipulator Program");
            if (lineCapacity >= 80) {
                for (int i = 1; i <= lineCapacity; i++) {
                    System.out.print(Config.LINE_CHAR);
                }

                System.out.println();
            }
            String inputFile = files[Config.FILE_IN];
            String outputFile = files[Config.FILE_OUT];
            String dictionFile = files[Config.FILE_DICT];

            System.out.print("Current input file: ");

            if (inputFile == null) {
                System.out.println("" + Config.LINE_CHAR + Config.LINE_CHAR + Config.LINE_CHAR);
            } else {
                System.out.println(inputFile);
            }
            System.out.print("Current output file: ");
            if (outputFile == null) {
                System.out.println("" + Config.LINE_CHAR + Config.LINE_CHAR + Config.LINE_CHAR);
            } else {
                System.out.println(outputFile);
            }
            System.out.print("Current dictionary: ");
            if (dictionFile == null) {
                System.out.println("" + Config.LINE_CHAR + Config.LINE_CHAR + Config.LINE_CHAR);
            } else {
                System.out.println(dictionFile);
            }


            System.out.print("Current mode: ");

            if (modeBoth) {
                System.out.println("Interleaved");
            } else {
                System.out.println("Modified");
            }
            System.out.print("Current mods: ");

            if (modFlags[Config.MOD_TRANS]) {
                System.out.print('T');

            }
            if (modFlags[Config.MOD_PIG]) {
                System.out.print('P');

            }
            if (modFlags[Config.MOD_REV_WORD]) {
                System.out.print('W');

            }
            if (modFlags[Config.MOD_REV_LINE]) {
                System.out.print('L');
            }

            System.out.println();
            if (lineCapacity >= 80) {
                for (int i = 1; i <= lineCapacity; i++) {
                    System.out.print(Config.LINE_CHAR);
                }

                System.out.println();
            }
            System.out.println("Main menu:");
            System.out.println("1) Display Output");
            System.out.println("2) Save Output");

            System.out.println("Manipulations:");
            System.out.println("\tT)ranslate");
            System.out.println("\tP)ig latin");
            System.out.println("\tW)ord reverse");
            System.out.println("\tL)ine reverse");

            System.out.println("Configuration:");
            System.out.println("\tI)nput file.");
            System.out.println("\tO)utput file.");
            System.out.println("\tD)ictionary file.");
            System.out.println("\tM)ode Toggle.");
            System.out.println("\tH)ide/show Menu.");
            System.out.println("Q)uit");
            System.out.print("Enter action: ");
        }


        else {
            System.out.print("Enter action: ");
        }



        String letter = sc.nextLine();
        char letterRet = letter.charAt(0);


        return letterRet;
    }


    /**
     * Prompts the user for a new file name. The prompt should be: "Enter file name [curFileName]:
     * ", where curFileName is the value from the parameter of the same name. There should not be a
     * new line following the prompt.
     *
     * @param sc The reference to the Scanner object for reading input from the user.
     * @param curFileName The current file name.
     * @return The value input by the user excluding any leading or trailing white space. If the
     *         input is an empty string, then curFileName is returned.
     */
    public static String updateFileName(Scanner sc, String curFileName) {

        System.out.print("Enter file name " + "[" + curFileName + "]" + ": ");

        String newFileName = sc.nextLine();
        newFileName = newFileName.trim();

        if (newFileName.isEmpty()) {

            newFileName = null;
        }

        return newFileName;
    }

    /**
     * Opens and reads the contents of the dictionary file specified in fileName. The file is
     * assumed to be a text file encoded in UTF-8. It is assumed that there is one translation
     * mapping per line. Each line contains a key and its translation separated by a tab. Note: The
     * dictionary file is assumed to be sorted by the keys in ascending order.
     *
     * For each line in the dictionary file, an entry is added into wordList. The entry is a String
     * array of length 2, where the value of index 0 is the key and the value of index 1 is the
     * translation.
     *
     * When opening the file, any FileNotFoundException is caught and the error message "Exception:
     * File 'fileName' not found." followed by a new line is output, where fileName is the name of
     * the file that the method attempted to open.
     *
     * @param fileName
     * @param wordList Reference to ArrayList to contain the translation mappings.
     * @throws IOException if an I/O error occurs when closing the file. FileNotFoundException is
     *         caught when opening the file.
     */
    public static void readDictFile(String fileName, ArrayList<String[]> wordList)
        throws IOException {

        wordList.clear(); //= new ArrayList<String[]>();

        try
        {
            FileInputStream dictFileReader = new FileInputStream(fileName);
            Scanner read = new Scanner(dictFileReader);

            while(read.hasNextLine())
            {
                String[] readDictLines = new String[2];
                String line = read.nextLine();
                readDictLines = line.split("\t");

                wordList.add(readDictLines);

               

            }
            read.close();
        } catch (FileNotFoundException e) {

            System.out.println("Exception: File '" + fileName + "' not found.");
        }

        // FIXME
    } 

    /**
     * Opens and reads the contents of the input file specified in fileName. The input file is read
     * line by line. Each line is split into words and punctuation (excluding the apostrophe) and
     * stored in an ArrayList of Strings. These ArrayLists representing the line are stored in an
     * ArrayList of ArrayLists of Strings. Specifically, they are put in the ArrayList fileByLine
     * that is passed in as a parameter.
     *
     * For example, a file containing the following: Lorem ipsum dolor sit amet, consectetur
     * adipiscing elit. Don'ec elementum tortor in mauris consequat vulputate.
     *
     * Would produce an ArrayList of ArrayLists containing 2 ArrayLists of Strings. The first
     * ArrayList would contain: "Lorem", "ipsum", "dolor", "sit", "amet", ",", "consectetur",
     * "adipiscing", "elit", ".", "Don'ec", "elementum", "tortor", "in", "mauris" The second
     * Arraylist would contain: "consequat", "vulputate", "."
     *
     * Note 1: The text file is assumed to be UTF-8. Note 2: There are no assumption about the
     * length of the file or the length of the lines. Note 3: All single quotes (') are assumed to
     * be apostrophes.
     *
     * When opening the file, any FileNotFoundException is caught and the error message "Exception:
     * File 'fileName' not found." followed by a new line is output, where fileName is the name of
     * the file that the method attempted to open.
     *
     * @param fileName The name of the input text file to parse.
     * @param fileByLine Reference to ArrayList to contain the contents of the file line by line,
     *        where each line is an ArrayList of Strings.
     * @throws IOException if an I/O error occurs when closing the file. FileNotFoundException is
     *         caught when opening the file.
     */
    public static void readInputFile(String fileName, ArrayList<ArrayList<String>> fileByLine)
        throws IOException {



        try {
            // Scanner scnr = null;
            FileInputStream fileStringStream = new FileInputStream(fileName);
            Scanner scnr = new Scanner(fileStringStream);

            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] splitLines = line.split(" ");
                ArrayList<String> secondArrayList = new ArrayList<>();
                char punc;

                for (int i = 0; i < splitLines.length; i++) {
                    punc = splitLines[i].charAt(splitLines[i].length() - 1); // looks at the last
                    // character of the
                    // word
                    if (punc == '.' || punc == ',' || punc == ';' || punc == ':' || punc == '?'
                        || punc == '!') {
                        splitLines[i] = splitLines[i].substring(0, splitLines[i].length() - 1);

                        secondArrayList.add(splitLines[i]);
                        String corrPunc = Character.toString(punc);
                        secondArrayList.add(corrPunc);
                    } else {
                        secondArrayList.add(splitLines[i]);
                    }
                }
                fileByLine.add(secondArrayList);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Exception: File" + " '" + fileName + "' " + "not found.");
        } catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }



    /**
     * Opens and writes (overwrites if the file already exits) the modified contents of the input 
     * file specified contained in modFileByLine to a file called filename. modFileByLine is an 
     * ArrayList containing one ArrayList of String for each output line. 
     *
     * When producing the output file, each word (non-punctuation) should be separated by a space
     * and each line should be terminated by a new line.
     * The spacing around the punctuation should be as follows:
     * - Excluding, double quotes ("), no space between the preceding string and the punctuation, but
     *   a space following the punctuation.
     * - Double quotes (") will be treated as pairs:
     *    - the first double quote will be preceded by a space and will not have a space following.
     *    - the next double quote will not be preceded by space and will have a space following.  
     *
     * If modFileByLine is an ArrayList of ArrayLists containt 2 ArrayLists of Strings, such that:
     * - The first ArrayList contains:
     *   "Lorem", "ipsum", "\"", "dolor", "sit", "\"", "amet", ",", "consectetur", "adipiscing", 
     *   "elit", ".", "Don'ec", "elementum", "tortor", "in", "mauris"
     * - The second Arraylist contains:
     *   "consequat", "vulputate", "."
     *
     * The output to the file would be:
     * Lorem ipsum "dolor sit" amet, consectetur adipiscing elit. Don'ec elementum tortor in mauris
     * consequat vulputate.
     *
     * Note 1: The output to the file is UTF-8.
     *
     * When opening the file, any FileNotFoundException is caught and the error message 
     * "Exception: File 'fileName' not found." followed by a new line is output,
     * where fileName is the name of the file that the method attempted to open.
     *
     * @param fileName The name of the output file.
     * @param modFileByLine Reference to ArrayList to contain the modified contents of the file line
     *                      by line, where each line is an ArrayList of Strings.
     * @throws IOException if an I/O error occurs when closing the file. FileNotFoundException is
     *                     caught when opening the file.
     */
    public static void saveToFile(String fileName, ArrayList<ArrayList<String>> modFileByLine)
        throws IOException {
        
        FileWriter  fileWriter = null;
        PrintWriter outFs = null;
        
//        fileWriter = new FileWriter(fileName);
//        outFs = new PrintWriter(fileWriter);
//        File newFile = new File(fileName);
        boolean flag = true;
        int punctCounter = 0;
        
        try {
            fileWriter = new FileWriter(fileName);
            outFs = new PrintWriter(fileWriter);
            File newFile = new File(fileName);
            
            for(int i = 0; i < modFileByLine.size(); i++) {
                for(int j = 0; j < modFileByLine.get(i).size(); j++) {
                    String tempWord = modFileByLine.get(i).get(j);
                    
                    if(tempWord == "\"") {
                        punctCounter++;
                    }
                    
                    if(!(Character.isLetter(tempWord.charAt(0))) && tempWord.indexOf('\"') == -1) {
                        outFs.print(tempWord);
                    }else if ((Character.isLetter(tempWord.charAt(0))) && j != 0) { //prints out the remaining words
                        if(flag) {
                            outFs.print(" " + tempWord);
                            //System.out.println(tempWord);
                            flag = true;
                            }else {
                                outFs.print(tempWord);
                                flag = true;
                            }
                    }else if(punctCounter % 2 == 1) { //(tempWord.indexOf('\"') != -1 && firstQuote) { //first quote
                        outFs.print(" " + tempWord);
                        //System.out.println(tempWord);
                        //secondQuote = false;
                        flag = false;
                    }else if(punctCounter % 2 == 0) {
                        outFs.print(tempWord);
                        flag = true;
                    } //else if(tempWord.indexOf('\"')  != -1 && secondQuote) { //second quote
                        //outFs.print(tempWord);
                    
                    else if ((Character.isLetter(tempWord.charAt(0))) && j == 0) { //prints out the first word of the arrayList
                        outFs.print(tempWord);
                        //System.out.println(tempWord);
                       
                        
                    }
                }
                outFs.println();
                //System.out.println();
            }
            outFs.flush();
            outFs.close();
            
           
        } catch (FileNotFoundException e) { //CHECK THIS WITH TA AND MAKE SURE YOU CAN USE EXCEPTION
            System.out.println("Exception: '" + fileName + "' not found.");
        }finally {
//            outFs.flush();
//            outFs.close();
        }
            }
        

        
//        FileWriter fileWriter = null;
//        PrintWriter printWriter = null;
//        //FileWriter  fileStringStream = null;
//        String output = "";
//        int symPuncCounter = 0;
//        boolean flag = true;
//        
//        try {
//            fileWriter = new FileWriter(fileName);
//            printWriter = new PrintWriter(fileWriter);
//            
//            //DELETEfileStringStream = new FileWriter(fileName);
//            for(ArrayList<String> wordLine : modFileByLine) {
//                for(String word : wordLine) {
//                    if(word == "\"" || word == "," || word == ".") {
//                       
//                        symPuncCounter++;
//                    }
//                    if(symPuncCounter % 2 == 0 && symPuncCounter != 0) {
//                        output = output + word + " ";
//                    }
//                    else if(symPuncCounter % 2 == 1) {
//                        
//                        output = output + word;
//                        
//                    }
//                    else {
//                        output = output + word + " ";
//                    }
//                        
//                }
//                printWriter.print(output);
//            }
//            
//  
//        }catch(FileNotFoundException e) {
//            System.out.println("Exception: File '" + fileName + "' not found.");
//        }finally {
//            if(fileName != null) {
//                printWriter.close();
//            }
//        }    
    
    

    /**
     * Prints out the modified file (and possibly interleaved with the original file) to the screen.
     *
     * If modeBoth is false, then the contents of modFileByLine is output line by line. Each word is
     * output followed by a space except for the last word. Each line is terminated with a new line
     * character.
     *
     * For the non-interleaved mode, consider the following example: modFileByLine contains 2
     * ArrayList of Strings: 
     * 1: "Où", "est", "la", "bibliothèque", "?" 
     * 2: "Aucune", "idée", "."
     *
     * The output would be: 
     * Où est la bibliothèque ? 
     * Aucune idée .
     *
     * Otherwise, modeBoth is true, then the contents of modFileByLine is interleaved with
     * fileByline. Lines are printed out in order. First, a line from modFileByLine is output
     * followed by a new line character followed by the corresponding line in fileByLine. In order
     * to better match up the corresponding words in the corresponding lines, the short word is
     * appended with spaces to the length of the longer word. Between each word adjusted for length
     * is an additional space.
     *
     * For the interleaved mode, consider the following example:
     * 
     * modFileByLine contains 2 ArrayList of Strings: 
     * 1: "Où", "est", "la", "bibliothèque", "?" 
     * 2: "Aucune", "idée", "." 
     * fileByLine contains 1 ArrayList of Strings: 
     * 1: "Where", "is", "the", "library", "?" 
     * 2: "No", "idea", "."
     *
     * The output would be: 
     * Où    est la  bibliothèque ? 
     * Where is  the library      ? 
     * Aucune idée . 
     * No     idea .
     * 
     * @param fileByLine An ArrayList of ArrayList of Strings containing the original content.
     * @param modFileByLine An ArrayList of ArrayList of Strings containing the modified content.
     * @param modeBoth Flag to indicate if the original file should be interleaved.
     * @throws Exception Throws an Exception with the message "Number of lines in modified version
     *         differs from original." if the size of fileByLine differes from modFileByLine.
     * @throws Exception Throws an Exception with the message "Number of words on line i in modified
     *         version differs from original.", where i should be the 0-based line index where the
     *         size of the ArrayList at index i in fileByLine differes from the ArrayList at index i
     *         in modFileByLine.
     */
    public static void display(ArrayList<ArrayList<String>> fileByLine,
        ArrayList<ArrayList<String>> modFileByLine, boolean modeBoth) throws Exception {

        ArrayList<String> eng = new ArrayList<String>();
        ArrayList<String> french = new ArrayList<String>();
        String frenchWord = "";
        String engWord = "";
        ArrayList<ArrayList<String>> engFile = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> frenchFile = new ArrayList<ArrayList<String>>();

        try {
            if(modeBoth) {

                for (int c = 0; c < 80; c++) {
                    System.out.print(Config.LINE_CHAR);
                }
                System.out.println();

                //System.out.println(modFileByLine);//DELETE
                //System.out.println(fileByLine);//DELETE
                for(int i = 0; i < fileByLine.size(); i++) {

                    for(int j = 0; j < fileByLine.get(i).size(); j++) {

                        if(fileByLine.size() == modFileByLine.size()) {


                            if(fileByLine.get(i).size() == modFileByLine.get(i).size()) {

                                frenchWord = modFileByLine.get(i).get(j);
                                engWord = fileByLine.get(i).get(j);
                                int lastFrenchWord = modFileByLine.get(i).size();
                                int lastEngWord = fileByLine.get(i).size();
                   
                                int engWordLength = fileByLine.get(i).get(j).length();
                                int frenchWordLength = modFileByLine.get(i).get(j).length();

                                int diff = engWordLength - frenchWordLength;

                               
                                if (diff > 0) 
                                {
                                    eng.add(engWord);
                                    for (int h = 0; h < diff; h++) {
                                        if(lastEngWord != 1) {
                                            frenchWord = frenchWord + " ";
                                        }
                                        else {
                                            frenchWord = frenchWord;
                                        }
                                    }
                                    french.add(frenchWord);
                                } 
                                else 
                                {
                                    french.add(frenchWord);
                                    for (int h = 0; h < Math.abs(diff); h++) {
                                        if(lastFrenchWord != 1) {
                                            engWord = engWord + " ";
                                        }
                                        else {
                                            engWord = engWord;
                                        }
                                    }
                                    eng.add(engWord);
                                }

                            }

                            else {
                                throw new Exception("Number of words on line " + i + " in modified version differs from original.");
                            }
                        }

                        else {
                            throw new Exception("Number of lines in modified version differs from original");
                        }
                    }

                    System.out.print(french.get(0));
                    for(int h = 1; h < french.size(); h++)
                    {
                            //ADD French size as if else down below
                        System.out.print(" " + french.get(h));
                    }
                    System.out.println();

                    System.out.print(eng.get(0));
                    for(int s = 1; s < eng.size(); s++)

                    {   
                        if(s == eng.size() - 1)
                        {
                            System.out.print(" " + eng.get(s).trim());
                        }
                        else
                        {
                            System.out.print(" " + eng.get(s));
                        }

                    }
                    System.out.println("\n");

                    eng.clear();
                    french.clear();

                }

                for (int c = 0; c < 80; c++) {
                    System.out.print(Config.LINE_CHAR);
                }
                System.out.println();
            }


            else {

                for (int i = 0; i < 80; i++) {
                    System.out.print(Config.LINE_CHAR);
                }
                System.out.println();

                for(int i = 0; i < modFileByLine.size(); i++)
                {
                    System.out.print(modFileByLine.get(i).get(0));
                    for(int j = 1; j < modFileByLine.get(i).size(); j++)
                    {
                        System.out.print(" " + modFileByLine.get(i).get(j));
                    }
                    System.out.println();
                }

                for (int i = 0; i < 80; i++) 
                {
                    System.out.print(Config.LINE_CHAR);
                }
                System.out.println();

            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Performs the actions specified by the modFlags to the input file stored in the ArrayList of
     * ArrayLists of Strings fileByLine. This method stores the modified string in a new ArrayList
     * of ArrayLists of Strings which it returns.
     *
     * There are 4 modifications that may be performed. They are to be process in the following 
     * order if indicated in modFlags:
     *   1 - Translation
     *   2 - To Pig Latin
     *   3 - Reverse the letters in each word
     *   4 - Reverse the words in each line
     *
     * @param fileByLine The original file stored as an ArrayList of ArrayLists of Strings.
     * @param dict An ArrayList of String arrays of length two. The ArrayList is assumed to be
     *             sorted in ascending order accordings to the strings at index 0. This will be the
     *             second argument for the translate method.
     * @param modFlags A boolean area of length Config.NUM_MODS that indicates which translation 
     *                 to perform by having a value of true in the appropriate cell as follows:
     *                 Index                  Modification
     *                 -------------------    --------------------------------
     *                 Config.MOD_TRANS       Translation
     *                 Config.MOD_PIG         To Pig Latin
     *                 Config.MOD_REV_WORD    Reverse the letters in each word
     *                 Config.MOD_REv_LINE    Reverse the words in each line
     *@return An ArrayList of ArrayLists of Strings, where each internal ArrayList is a line 
     *        which corresponds to the data in fileByLine but with the transformations applied in 
     *        the order specified above.
     */
    public static ArrayList<ArrayList<String>> manipulate(ArrayList<ArrayList<String>> fileByLine,
        ArrayList<String[]> dict, boolean[] modFlags) {

        
       // System.out.println("Before any manipulations:" + Arrays.toString(fileByLine.toArray()));

        if(modFlags[Config.MOD_TRANS])
        {
            ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
            for(int i = 0; i < fileByLine.size(); i++)
            {
                ArrayList<String> newArrList = new ArrayList<String>();
                for(int j = 0; j < fileByLine.get(i).size(); j++)
                {
                    String word = fileByLine.get(i).get(j);
                   // System.out.println(word); DELETE
                    String translatedWord = translate(word, dict);
                    newArrList.add(translatedWord);
    
                }
                arrayList.add(newArrList);

            }
            fileByLine = arrayList;

        }
        
        if(modFlags[Config.MOD_PIG])
        {
            ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
            for(int i = 0; i < fileByLine.size(); i++)
            {
                ArrayList<String> innerArrayList = new ArrayList<String>();
                for(int j = 0; j < fileByLine.get(i).size(); j++)
                {
                    String word = fileByLine.get(i).get(j);
                    //System.out.println(word); DELETE
                    String pigLatinWord = pigLatin(word);
                    //System.out.println("After pigLatin method: " + pigLatinWord); DELETE
                    innerArrayList.add(pigLatinWord);
                }
                arrayList.add(innerArrayList);
            }
            fileByLine = arrayList;
            //System.out.println("Pig Latin output is: " + fileByLine); DELETE
        }
        
        if(modFlags[Config.MOD_REV_WORD])
        {
            ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
            for(int i = 0; i < fileByLine.size(); i++)
            {
                ArrayList<String> innerArrayList = new ArrayList<String>();
                for(int j = 0; j < fileByLine.get(i).size(); j++)
                {
                    String word = fileByLine.get(i).get(j);
//                    System.out.println(word); DELETE
                    String reversedWord = reverse(word);
                    innerArrayList.add(reversedWord);
                }
                arrayList.add(innerArrayList);
            }
            fileByLine = arrayList;
        }
        if(modFlags[Config.MOD_REV_LINE])
        {
            ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
            for(int i = 0; i < fileByLine.size(); i++)
            {
                ArrayList<String> line = fileByLine.get(i);
//                System.out.println(line); DELETE
                ArrayList<String> reversedLine = reverse(line);
                arrayList.add(reversedLine);
            }
            fileByLine = arrayList;
//            System.out.println("Reverse line output is: " + fileByLine); DELETE
            
        }

        return fileByLine;

        // For Milestone 2, you will need to build a new ArrayList<ArrayList<String>> that will be
        // returned. Go through the each string in fileByLine and, if the boolean at
        // Config.MOD_TRANS in modFlags is true, then call the translate method, storing the
        // modified strings (otherwise store the original string) line by line as they are organized in
        // fileByLine.

        // For Milestone 3, you will need to build a new ArrayList<ArrayList<String>> that will be
        // returned. For each string in fileByLine, you will need to check the booleans at
        // Config.MOD_TRANS, Config.MOD_PIG, and Config.MOD_REV_WORD in modFlags in that order. For
        // each one that is true, apply the appropriate transformation, storing them as in
        // Milestone 2. After having processed each string, if the boolean at Config.MOD_REV_LINE
        // in modFlags is true, reverse each line in the returning ArrayList<ArrayList<String>>.
    }


    /**
     * This is the main method for the TextManipulator program. This method contains the loop that
     * runs the prompt. It handles the user response and calls the methods that are necessary in
     * order to perform the actions requested by the user.
     *
     * The initial default behavior of the program is to show the full menu, to be in the "Modified"
     * mode, to have no modifications selected, and to have no values for the various file names.
     *
     * @param args (unused)
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        boolean flag = false; // runs loop in main
        Scanner scnr = new Scanner(System.in); // Scanner object
        String curFileName = null;
        String newCurFileName = null;
        String curDictFileName = null;
        String curOutputFileName = null;
        String outputFile = null;
        // char userCommand = 'x'; //user input from promptMenu
        String[] files = new String[Config.NUM_FILES];
        boolean[] mods = new boolean[Config.NUM_MODS]; //modFlags
        boolean modeBoth = false; // to see if display will print interleaved or not
        boolean showMenu = true; // shows menu of promptMenu or not

        ArrayList<ArrayList<String>> modFileByLine = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> fileByLine = new ArrayList<ArrayList<String>>();
        ArrayList<String[]> wordList = new ArrayList<String[]>();



        while (!flag) {
            char userCommand = promptMenu(scnr, files, mods, modeBoth, showMenu);

            if (userCommand == 'T' || userCommand == 't') {
                mods[Config.MOD_TRANS] = !mods[Config.MOD_TRANS];
                //modFileByLine = manipulate(fileByLine, wordList, mods);

            } else if (userCommand == 'P' || userCommand == 'p') {
                mods[Config.MOD_PIG] = !mods[Config.MOD_PIG];

                //modFileByLine = manipulate(fileByLine, wordList, mods);

                // mods[1] = !mods[1];
            } else if (userCommand == 'W' || userCommand == 'w') {
                mods[Config.MOD_REV_WORD] = !mods[Config.MOD_REV_WORD];
                //modFileByLine = manipulate(fileByLine, wordList, mods);
                // mods[2] = !mods[2];

            } else if (userCommand == 'L' || userCommand == 'l') {
                mods[Config.MOD_REV_LINE] = !mods[Config.MOD_REV_LINE];

               // modFileByLine = manipulate(fileByLine, wordList, mods);

            } else if (userCommand == 'D' || userCommand == 'd') {

                String dictFileName = updateFileName(scnr, curDictFileName);
                if (dictFileName == null) {
                    dictFileName = "null";
                    continue;
                }
                files[Config.FILE_DICT] = dictFileName;
                if (!(dictFileName.equals(curDictFileName))) {

                    try {
                        readDictFile(dictFileName, wordList);

                    } catch (IOException e) {
                        e.getMessage();
                    } catch (Exception e) {
                        e.getMessage();
                    }

                }

            } else if (userCommand == 'O' || userCommand == 'o') {

                outputFile = updateFileName(scnr, curOutputFileName);
                if (outputFile == null) {
                    outputFile = "null";
                    continue;
                }
                files[Config.FILE_OUT] = outputFile;
                if (!(outputFile.equals(curOutputFileName))) {
                    try {
                        saveToFile(outputFile, modFileByLine);
                    } catch (IOException e) {
                        e.getMessage();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }

            else if (userCommand == 'i' || userCommand == 'I') {
                // showMenu = true;
                newCurFileName = updateFileName(scnr, curFileName);
                if (newCurFileName == null) {
                    newCurFileName = "null";
                    continue;
                }
                files[Config.FILE_IN] = newCurFileName;
                if (!(newCurFileName.equals(curFileName))) {
                    try {
                        readInputFile(newCurFileName, fileByLine);
                    } catch (IOException e) {
                        e.getMessage();

                    }
                }

            } else if (userCommand == 'm' || userCommand == 'M') {
                modeBoth = !modeBoth;
            }

            else if (userCommand == 'h' || userCommand == 'H') {
                showMenu = !showMenu;
            } else if (userCommand == '1') {
                try {
                    modFileByLine = manipulate(fileByLine, wordList, mods);
                    display(fileByLine, modFileByLine, modeBoth);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (userCommand == '2') {

                modFileByLine = manipulate(fileByLine, wordList, mods);

                try {
                    saveToFile(outputFile, modFileByLine);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                // generates the modified file by calling manipulate method and saves modified file
                // by calling saveToFile method

            }

            else if (userCommand == 'Q' || userCommand == 'q') {
                flag = true;
                break;
            } else {
                System.out.println("Unknown option.");
                // continue;
            }

        }
    }

}

