package com.sergey.prykhodko.textParts;

public class PunctuationUnit implements SentenceUnit{
    private char unit;

    public PunctuationUnit(char unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "" + unit;
    }
}
