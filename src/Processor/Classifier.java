/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.ConfusionMatrix;
import Model.Email;
import Model.TrainedSet;
import Model.Word;
import java.util.ArrayList;

/**
 *
 * @author Arces
 */
public class Classifier {

    public ConfusionMatrix classifyTestSet(TrainedSet trainedSet, ArrayList<Email> testSet) {
        ArrayList<Word> wordList;
        double spamProb, nonSpamProb;
        ConfusionMatrix cm = new ConfusionMatrix();
        int tS = 0, fS = 0, tNS = 0, fNS = 0;
        //tS = true spam; fS = false spam; tNS = true non-spam; fNS = false non-spam 

        System.out.println("Classifying Email. . .");
        int i = 1;
        for (Email email : testSet) {
            System.out.println("Email # " + i + " / " + testSet.size());
            i++;
            
            spamProb = Math.log(trainedSet.getPriorProbability()[0]);
            nonSpamProb = Math.log(trainedSet.getPriorProbability()[1]);
            //get words of email in test set
            wordList = email.getWordList();
            //for every word in the email, multiply their probability
            for (Word word : wordList) {
                //P(spam|d)
                spamProb += Math.log(trainedSet.getSpamWordProbability(word.getWord()));

                //P(not spam|d)
                nonSpamProb += Math.log(trainedSet.getNonSpamWordProbability(word.getWord()));
            }

            if (spamProb > nonSpamProb) { // if output prediction is spam
                if (email.getIsSpam()) {
                    tS++; //if prediction is correct, add to true spam 
                } else {
                    fS++; //else add to false spam
                }
            } else { // if output prediction is non-spam
                if (!email.getIsSpam()) {
                    tNS++; //if prediction is correct, add to true non-spam 
                } else {
                    fNS++; //else add to false non-spam
                }
            }
        }

        cm.setTrueSpam(tS);
        cm.setTrueNonSpam(tNS);
        cm.setFalseSpam(fS);
        cm.setFalseNonSpam(fNS);
        return cm;
    }
}
