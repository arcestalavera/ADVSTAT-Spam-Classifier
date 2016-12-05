/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Arces
 */
public class Email {

    private ArrayList<Word> wordList;
    private boolean isSpam;

    public Email() {
        this.wordList = new ArrayList<>();
    }

    /**
     * @return the wordList
     */
    public ArrayList<Word> getWordList() {
        return wordList;
    }

    /**
     * @param wordList the wordList to set
     */
    public void setWordList(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }

    /**
     * @param isSpam the isSpam to set
     */
    public void setIsSpam(boolean isSpam) {
        this.isSpam = isSpam;
    }

    public boolean getIsSpam() {
        return isSpam;
    }

    public Word getEmailWord(String word) {
        Word w = null;
        boolean doesContain = false;
        for (int i = 0; i < wordList.size() && !doesContain; i++) {
            if (wordList.get(i).getWord().equals(word)) {
                w = wordList.get(i);
                doesContain = true;
            }
        }
        return w;
    }
}
