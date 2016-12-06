/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.Email;
import Model.TrainedSet;
import Model.Word;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Arces
 */
public class CSVReader {

    private BufferedReader br;

    public ArrayList<Email> readEmail(File inputFile) {
        ArrayList<Email> emailList = new ArrayList<>();
        ArrayList<Word> wordList;
        String content;
        String[] features, values;
        Email email;
        Word word;
        try {
            br = new BufferedReader(new FileReader(inputFile));

            //read header first [features] then store them; remove last element because it's not a feature
            features = br.readLine().split(",");
            features = Arrays.copyOf(features, features.length - 1);
            int k = 1;
            //store words to emails
            while ((content = br.readLine()) != null) {
                System.out.println(k);
                k++;
                email = new Email();
                wordList = new ArrayList<>();

                //set value and string of word and add to wordList
                values = content.split(",");
                for (int i = 0; i < features.length; i++) {
                    if (!values[i].equals("0")) {
                        word = new Word();
                        word.setWord(features[i]);
                        word.setCount(Integer.parseInt(values[i]));

                        wordList.add(word);
                    }
                }

                //set wordlist of email and type
                if (values[values.length - 1].equals("Spam")) {
                    email.setIsSpam(true);
                } else {
                    email.setIsSpam(false);
                }

                email.setWordList(wordList);
                emailList.add(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailList;
    }

    public TrainedSet readTrainedSet(File inputFile) {
        TrainedSet ts = new TrainedSet();
        float[] priorProbability = new float[2];
        ArrayList<Word> spamWords = new ArrayList<>();
        ArrayList<Word> nonSpamWords = new ArrayList<>();
        Word spamWord, nonSpamWord;
        String content;
        String[] values;

        try {
            br = new BufferedReader(new FileReader(inputFile));

            //skip header
            br.readLine();

            //read values
            while ((content = br.readLine()) != null) {
                values = content.split(",");

                if (!values[0].equals("PriorProb")) {
                    //set string of word
                    spamWord = new Word();
                    spamWord.setWord(values[0]);
                    nonSpamWord = new Word();
                    nonSpamWord.setWord(values[0]);
                    
                    //set probability of word in spam [1] and non-spam [2]
                    spamWord.setProbability(Float.parseFloat(values[1]));
                    nonSpamWord.setProbability(Float.parseFloat(values[2]));
                    
                    //add words with probability to list
                    spamWords.add(spamWord);
                    nonSpamWords.add(nonSpamWord);
                } else{
                    //If value[0] is PriorProb -> store it to the prior probability
                    priorProbability[0] = Float.parseFloat(values[1]);
                    priorProbability[1] = Float.parseFloat(values[2]);
                }
            }
            
            ts.setNonSpamWords(nonSpamWords);
            ts.setSpamWords(spamWords);
            ts.setPriorProbability(priorProbability);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ts;
    }
}
