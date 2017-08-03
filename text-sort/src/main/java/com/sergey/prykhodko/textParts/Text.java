package com.sergey.prykhodko.textParts;

import java.util.List;

public class Text {
    private List<Sentence> text;

    public List<Sentence> getSentencesAsList() {
        return text;
    }

    public void setText(List<Sentence> text) {
        this.text = text;
    }
}
