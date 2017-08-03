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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PunctuationUnit that = (PunctuationUnit) o;

        return unit == that.unit;
    }

    @Override
    public int hashCode() {
        return (int) unit;
    }
}
