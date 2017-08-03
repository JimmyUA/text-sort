package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;

import java.util.List;

public class ConsolePrinter {

    public void showSentences(List<Sentence> sentences) {
        for (Sentence sentence : sentences
             ) {
            System.out.println("" + sentence + "\u001B[31m words amount: " + sentence.getWordsAsList().size() + "\u001B[0m");
        }
    }
}
