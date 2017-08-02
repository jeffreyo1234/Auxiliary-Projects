/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caplinexercise1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeffr
 */
public class CountWords {
    private static int numberOfWords=0;
    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<String> list;
        try (
                Scanner s = new Scanner(new File("C:\\Users\\jeffr\\Documents\\CAPLIN\\The Agile approach.dat"))) {
            list = new ArrayList<>();
            while (s.hasNext()) {
                String eachLine=s.nextLine();
                if(!eachLine.equals("")){
                    list.add(eachLine);
                }
            }
        }
        CountWords ce =new CountWords();
        int numberOfScount=ce.countWordsWithS(list);
        double percentageNumber = (double)numberOfScount/numberOfWords;
        
        System.out.println("Number of S in document: " + numberOfScount);
        System.out.println("Percentage of all the words in the file begin with the letter 's': " + percentageNumber*100 + "%");
    }
    
    public int countWordsWithS(ArrayList<String> list){
        int count=0;
        
        String wordLine= new String();
        //iterate through list get each line
        for(int x=0;x<list.size();x++){
            wordLine=list.get(x).toLowerCase();
            String[] wordArray= wordLine.split(" ");
            numberOfWords+=wordArray.length;
            //get each word
            for (String wordArray1 : wordArray) {
                if (wordArray1.charAt(0) == 's') {
                    count++;    
                }
            }
            
        }    
    
    return count;    
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(int numberOfWords) {
        CountWords.numberOfWords = numberOfWords;
    }
    
    
    
}
