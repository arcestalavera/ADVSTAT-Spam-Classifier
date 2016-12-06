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
    private StringBuilder sb;

    public CSVWriter(){
        this.sb = new StringBuilder();
    }
    
    public void exportFeatureMap(String fileName, ArrayList<Email> emailList) {
        Set<String> wordSet = new HashSet<>();
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
                        sb.append(emailWord.getCount());
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

            sb.setLength(0);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void exportTrainedDataset(String fileName, TrainedSet ts){
        ArrayList<Word> spamWords = ts.getSpamWords();
        ArrayList<Word> nonSpamWords = ts.getNonSpamWords();
                
        try{
            fw = new FileWriter(fileName);
            
            //create header
            sb.append("Word, Spam, Not Spam");
            fw.append(sb.toString() + "\n");
            
            for(int i = 0; i < spamWords.size(); i++){
                sb.setLength(0);
                sb.append(spamWords.get(i).getWord()).append(",");
                sb.append(spamWords.get(i).getProbability()).append(",").append(nonSpamWords.get(i).getProbability());
                
                fw.append(sb.toString() + "\n");
            }
            
            sb.setLength(0);
            sb.append("PriorProb,");
            sb.append(ts.getPriorProbability()[0]);
            sb.append(",");
            sb.append(ts.getPriorProbability()[1]);
            fw.append(sb.toString());
            
            sb.setLength(0);
            fw.flush();
            fw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void exportConfusionMatrix(String fileName, ConfusionMatrix cm){
        try{
            fw = new FileWriter(fileName);
            
            sb.append(",Spam, Not Spam\n");
            sb.append("Spam, ").append(cm.getTrueSpam()).append(", ").append(cm.getFalseSpam()).append("\n");
            sb.append("Not Spam, ").append(cm.getFalseNonSpam()).append(", ").append(cm.getTrueNonSpam()).append("\n");
            sb.append("Precision: ").append(cm.computePrecision()).append(" %\n");
            sb.append("Recall: ").append(cm.computeRecall()).append(" %\n");
            sb.append("Accuracy: ").append(cm.computeAccuracy()).append(" %");
            
            fw.write(sb.toString());
            
            sb.setLength(0);
            fw.flush();
            fw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
