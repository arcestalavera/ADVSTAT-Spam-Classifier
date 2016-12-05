/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.Email;
import Model.Word;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Arces
 */
public class CSVWriter {

    private FileWriter fw;

    public void exportFeatureMap(String fileName, ArrayList<Email> emailList) {
        Set<String> wordSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Word> wordList;
        Word emailWord;
        
        try {
            fw = new FileWriter(fileName);

            //create header of features
            //add words of emails to a set to have unique words
            for (Email email : emailList) {
                wordList = email.getWordList();
                for (Word word : wordList) {
                    wordSet.add(word.getWord());
                }
            }

            System.out.println("Number of words: " + wordSet.size());

            for (String word : wordSet) {
                sb.append(word);
                sb.append(",");
            }

            sb.append("LABEL");
            fw.append(sb.toString());

            //create and append rows per email
            for (Email email : emailList) {
                fw.append("\n");
                sb.setLength(0);
                
                //if the word in the whole set is not used in the email, set 0; else set its probability
                for (String word : wordSet) {
                    emailWord = email.getEmailWord(word);
                    if (emailWord != null) {
                        sb.append(emailWord.getProbability());
                    } else {
                        sb.append("0");
                    }
                    sb.append(",");
                }

                if (email.getIsSpam()) {
                    sb.append("Spam");
                } else {
                    sb.append("Not Spam");
                }
                fw.append(sb.toString());
            }

            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
