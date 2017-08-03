package com.sergey.prykhodko.textParts;

public class Word implements SentenceUnit{
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public int length(){
        return word.length();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word that = (Word) o;

        return word.equalsIgnoreCase(that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
