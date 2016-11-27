/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Driver;

import Model.Word;
import Processor.WordCounter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Arces
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter File Name: ");
        String filename = sc.nextLine();
        ArrayList<Word> wordList = wc.countWords("email/" + filename);//count words on email
        
        System.out.println("WORD FREQUENCY: ");
        for(Word word: wordList){
            System.out.println("\t" + word.getWord() + ": " + word.getCount());
        }
    }
    
}
