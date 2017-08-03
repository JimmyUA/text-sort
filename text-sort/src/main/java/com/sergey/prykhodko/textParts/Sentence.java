package com.sergey.prykhodko.textParts;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private String sentence;
    private Queue<SentenceUnit> sentenceInUnitRepresentation;
    private List<Word> words;
    private List<PunctuationUnit> punctuationUnits;

    public Sentence(String sentence) {
        this.sentence = sentence;
        sentenceInUnitRepresentation = new ArrayDeque<>();
        words = new ArrayList<>();
        punctuationUnits = new ArrayList<>();

        getAllWords();
        getAllPunctuatioUnits();
    }

    private void getAllPunctuatioUnits() {
        Pattern punctuationUnitPattern = Pattern.compile(SentenceUnit.PUNCTUATION_UNIT_REG_EX);
        Matcher punctuationUnitMatcher = punctuationUnitPattern.matcher(sentence);

        while (punctuationUnitMatcher.find()){
            punctuationUnits.add(new PunctuationUnit(punctuationUnitMatcher.group().charAt(0)));
        }
    }

    private void getAllWords(){
        Pattern wordPattern = Pattern.compile(SentenceUnit.WORD_REG_EX);
        Matcher wordMatcher = wordPattern.matcher(sentence);

        while (wordMatcher.find()){
            words.add(new Word(wordMatcher.group().toLowerCase()));
        }
    }

    public boolean isIterrogative(){
        return punctuationUnits.contains(new PunctuationUnit('?'));
    }

    public List<Word> getWordsAsList() {
        return words;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
