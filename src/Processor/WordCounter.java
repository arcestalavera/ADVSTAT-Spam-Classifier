package Processor;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private BufferedReader br;

    public ArrayList<Word> countWords(String filename) {
        ArrayList<Word> wordList = new ArrayList<>(); //contains the word and the count
        ArrayList<String> words;
        Set<String> wordSet;
                
        try {
            br = new BufferedReader(new FileReader(new File(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Build the string
        String content = "", s;
        try {
            while ((s = br.readLine()) != null) {
                content += s;
            }
            //Clean and organize content
            //convert to lower case
            content = content.toLowerCase();

            //remove all punctuation marks
            content = content.replaceAll("\\p{P}", "");

            //remove greater than less than sign
            content = content.replaceAll("<", "").replaceAll(">", "");

            //remove all digits
            content = content.replaceAll("\\d", "");

            //make spaces only one
            content = content.replaceAll("\\s+", " ");

            //split the content then make it an arraylist
            words = new ArrayList<>(Arrays.asList(content.split(" ")));

            //use hashset to get the frequency of words
            wordSet = new HashSet<>(words);

            for (String key : wordSet) {
                Word word = new Word();
                word.setWord(key);
                word.setCount(Collections.frequency(words, key));
                wordList.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
