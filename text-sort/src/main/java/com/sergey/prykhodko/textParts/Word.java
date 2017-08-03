package com.sergey.prykhodko.textParts;

public class Word implements SentenceUnit{
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
