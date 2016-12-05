/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.Email;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Arces
 */
public class FeatureMapConstructor {

    private BufferedReader br;
    private WordCounter wc;

    public FeatureMapConstructor() {
        this.wc = new WordCounter();
    }

    public ArrayList<Email> constructFeatureMap(File inputFile) {
        ArrayList<Email> emailList = new ArrayList<>();
        String content, body = "";
        Email email = null;
        try {
            br = new BufferedReader(new FileReader(inputFile));
            while ((content = br.readLine()) != null) {
                if (!content.equals("")) {
                    if (content.contains(".txt")) { //if the file name is read, it is a new e-mail
                        email = new Email();
                        body = "";

                        //Get Label of Email
                        if (content.contains("spm")) { //if file name contains "spm", it means that it is a spam mail
                            email.setIsSpam(true);
                        } else {
                            email.setIsSpam(false);
                        }

                        emailList.add(email);
                    } else {
                        //Get Content [words] of Email
                        body += content;
                        
                        //count the words in the email
                        email.setWordList(wc.countWords(body));
                        
                        //get the probability of the words in the email
                        wc.computeWordsProbability(email);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return emailList;
    }
}
