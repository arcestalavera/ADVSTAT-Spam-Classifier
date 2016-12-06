package Processor;

import Model.Email;
import Model.Word;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arces
 */
public class WordCounter {
    public ArrayList<Word> countWords(String body) {
        ArrayList<Word> wordList = new ArrayList<>(); //contains the word and the count
        ArrayList<String> words;
        Set<String> wordSet;

        //Clean and organize content
        //convert to lower case
        body = body.toLowerCase();
        
        //remove all digits, special characters, and extra spaces 
        body = body.replaceAll("\\d", "").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s+", " ");

        //split the content then make it an arraylist
        words = new ArrayList<>(Arrays.asList(body.split(" ")));

        //use hashset to get the frequency of words
        wordSet = new HashSet<>(words);

        for (String key : wordSet) {
            Word word = new Word();
            word.setWord(key);
            word.setCount(Collections.frequency(words, key));
            wordList.add(word);
        }

        return wordList;
    }
    
    public void computeWordsProbability(Email email){
        float totalWords = 0;
        
        //get total number of words in email
        for(Word word: email.getWordList()){
            totalWords += word.getCount();
        }
        
        //get probability of word in email
        for(Word word: email.getWordList()){
            word.setProbability(word.getCount() / totalWords);
        }
    }
}
