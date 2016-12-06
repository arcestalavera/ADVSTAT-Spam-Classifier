/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.Email;
import Model.TrainedSet;
import Model.Word;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Arces
 */
public class DatasetTrainer {

    public TrainedSet trainDataset(ArrayList<Email> emailList) {
        TrainedSet ts = new TrainedSet();
        float[] priorProbability = new float[2];
        ArrayList<Email> spamList = new ArrayList<>();
        ArrayList<Email> nonSpamList = new ArrayList<>();
        ArrayList<String> wordList = getEmailWords(emailList);
        ArrayList<Word> spamWords = new ArrayList<>();
        ArrayList<Word> nonSpamWords = new ArrayList<>();
        Word word, emailWord;
        
        System.out.println("Separating spam to non-spam. . .");
        //separate spam and non spam in training data
        for (Email email : emailList) {
            if (email.getIsSpam()) {
                spamList.add(email);
            } else {
                nonSpamList.add(email);
            }
        }

        System.out.println("Computing Prior Probability. . .");
        //prior probability for spam mails[0] and non spam mails[1]
        priorProbability[0] = (float) spamList.size() / emailList.size();
        priorProbability[1] = (float) nonSpamList.size() / emailList.size();

        int spamWordCount = 0;
        int nonSpamWordCount = 0;
        int wordCount;
        
        
        System.out.println("Computing Total Number of Words in Spam Mails. . .");
        //get total number of words in spam mails
        for(Email email: spamList){
            for(Word w: email.getWordList()){
                spamWordCount += w.getCount();
            }
        }
        
        System.out.println("Computing Total Number of Words in Non-Spam Mails. . .");
        //get total number of words in non-spam mails
        for(Email email: nonSpamList){
            for(Word w: email.getWordList()){
                nonSpamWordCount += w.getCount();
            }
        }
        
        System.out.println("Computing Likelihood of Words in Spam Mails. . .");
        //likelihood of words for spam email
        for (String w : wordList) {
            word = new Word();
            word.setWord(w);
            wordCount = 0;
            
            for (Email email : spamList) {
                //get word in email
                emailWord = email.getEmailWord(w);

                if (emailWord != null) {
                    wordCount += emailWord.getCount();
                }
                wordCount++;
            }
            word.setProbability((float) wordCount / (spamWordCount + emailList.size()));
            spamWords.add(word);
        }
        
        System.out.println("Computing Likelihood of Words in Non-Spam Mails. . .");
        //likelihood of words for non-spam email
        for (String w : wordList) {
            word = new Word();
            word.setWord(w);
            wordCount = 0;

            for (Email email : nonSpamList) {
                //get word in email
                emailWord = email.getEmailWord(w);

                if (emailWord != null) {
                    wordCount += emailWord.getCount();
                }
                wordCount++;
            }
            word.setProbability((float) wordCount / (nonSpamWordCount + emailList.size()));
            nonSpamWords.add(word);
        }
        
        //Set the trained data to the trained dataset
        ts.setPriorProbability(priorProbability);
        ts.setNonSpamWords(nonSpamWords);
        ts.setSpamWords(spamWords);
        
        return ts;
    }

    public ArrayList<String> getEmailWords(ArrayList<Email> emailList) {
        Set<String> emailWords = new HashSet<>();

        //add words of email to list 
        for (Email email : emailList) {
            for (Word word : email.getWordList()) {
                emailWords.add(word.getWord());
            }
        }

        return new ArrayList<>(emailWords);
    }
}
