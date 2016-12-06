/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Arces
 */
public class TrainedSet {

    private ArrayList<Word> spamWords;
    private ArrayList<Word> nonSpamWords;
    private float[] priorProbability; //[0] for spam; [1]for non-spam

    public TrainedSet() {
        this.spamWords = new ArrayList<>();
        this.nonSpamWords = new ArrayList<>();
        this.priorProbability = new float[2];
    }

    /**
     * @return the spamWords
     */
    public ArrayList<Word> getSpamWords() {
        return spamWords;
    }

    /**
     * @param spamWords the spamWords to set
     */
    public void setSpamWords(ArrayList<Word> spamWords) {
        this.spamWords = spamWords;
    }

    /**
     * @return the nonSpamWords
     */
    public ArrayList<Word> getNonSpamWords() {
        return nonSpamWords;
    }

    /**
     * @param nonSpamWords the nonSpamWords to set
     */
    public void setNonSpamWords(ArrayList<Word> nonSpamWords) {
        this.nonSpamWords = nonSpamWords;
    }

    /**
     * @return the priorProbability
     */
    public float[] getPriorProbability() {
        return priorProbability;
    }

    /**
     * @param priorProbability the priorProbability to set
     */
    public void setPriorProbability(float[] priorProbability) {
        this.priorProbability = priorProbability;
    }

    public int getTotalWords() {
        Set<String> wordsList = new HashSet<>();

        for (Word word : spamWords) {
            wordsList.add(word.getWord());
        }

        for (Word word : nonSpamWords) {
            wordsList.add(word.getWord());
        }

        return wordsList.size();
    }

    public float getSpamWordProbability(String word) {
        boolean isFound = false;
        Word w;
        float probability = (float) 1 / (getTotalSpamCount() + getTotalWords());

        for (int i = 0; i < spamWords.size() && !isFound; i++) {
            w = spamWords.get(i);
            if (w.getWord().equals(word)) {
                probability = w.getProbability();
                isFound = true;
            }
        }
        
        return probability;
    }

    public float getNonSpamWordProbability(String word) {
        boolean isFound = false;
        Word w;
        float probability = (float) 1 / (getTotalNonSpamCount() + getTotalWords());

        for (int i = 0; i < nonSpamWords.size() && !isFound; i++) {
            w = nonSpamWords.get(i);
            if (w.getWord().equals(word)) {
                probability = w.getProbability();
                isFound = true;
            }
        }

        return probability;
    }
    
    public int getTotalSpamCount(){
        int total = 0;
        
        for(Word word: spamWords){
            total += word.getCount();
        }
        
        return total;
    }
    
    
    public int getTotalNonSpamCount(){
        int total = 0;
        
        for(Word word: nonSpamWords){
            total += word.getCount();
        }
        
        return total;
    }
}
