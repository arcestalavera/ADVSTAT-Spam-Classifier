/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Arces
 */
public class ConfusionMatrix {
    private int trueSpam, trueNonSpam, falseSpam, falseNonSpam;
    
    /**
     * @return the trueSpam
     */
    public int getTrueSpam() {
        return trueSpam;
    }

    /**
     * @param trueSpam the trueSpam to set
     */
    public void setTrueSpam(int trueSpam) {
        this.trueSpam = trueSpam;
    }

    /**
     * @return the trueNonSpam
     */
    public int getTrueNonSpam() {
        return trueNonSpam;
    }

    /**
     * @param trueNonSpam the trueNonSpam to set
     */
    public void setTrueNonSpam(int trueNonSpam) {
        this.trueNonSpam = trueNonSpam;
    }

    /**
     * @return the falseSpam
     */
    public int getFalseSpam() {
        return falseSpam;
    }

    /**
     * @param falseSpam the falseSpam to set
     */
    public void setFalseSpam(int falseSpam) {
        this.falseSpam = falseSpam;
    }

    /**
     * @return the falseNonSpam
     */
    public int getFalseNonSpam() {
        return falseNonSpam;
    }

    /**
     * @param falseNonSpam the falseNonSpam to set
     */
    public void setFalseNonSpam(int falseNonSpam) {
        this.falseNonSpam = falseNonSpam;
    }
    
    public float computeAccuracy(){
        return (float)(trueSpam + trueNonSpam) / 
                (trueSpam + trueNonSpam + falseSpam + falseNonSpam) * 100; 
    }
    
    public float computePrecision(){
        return (float) trueSpam / 
                (trueSpam + falseNonSpam) * 100; 
    }
    
    public float computeRecall(){
        return (float) trueSpam / 
                (trueSpam + falseSpam) * 100; 
    }
}
