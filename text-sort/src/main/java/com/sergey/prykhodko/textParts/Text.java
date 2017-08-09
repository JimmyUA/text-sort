package com.sergey.prykhodko.textParts;

import java.util.List;

public class Text {
    private List<Sentence> sentences;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public List<Sentence> getSentencesAsList() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
