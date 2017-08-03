package com.sergey.prykhodko.textParts;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sentence {
    private String sentence;
    private Queue<SentenceUnit> sentenceInUnitRepresentation;

    public Sentence(String sentence) {
        this.sentence = sentence;
        sentenceInUnitRepresentation = new ArrayDeque<>();
    }
}
