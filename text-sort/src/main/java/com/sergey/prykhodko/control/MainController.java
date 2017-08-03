package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;
import com.sergey.prykhodko.textParts.Text;
import com.sergey.prykhodko.textParts.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainController {

    private List<Sentence> sentences;
    private ConsolePrinter consolePrinter;

    public MainController(Text text) {
        sentences = text.getSentencesAsList();
        consolePrinter = new ConsolePrinter();
    }

    public void calculateAndShowAmountOfSentencesWithEqualWords() {
        int sentencesWithEqualWordsAmount = 0;
        for (Sentence sentence : sentences
             ) {
            if (containsEqualWords(sentence)) {
                sentencesWithEqualWordsAmount++;
            }
        }

        consolePrinter.showSentencesAmountWithEqulWords(sentencesWithEqualWordsAmount);
    }

    private boolean containsEqualWords(Sentence sentence) {
        List<Word> words = sentence.getWordsAsList();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j)) && i != j){
                    return true;
                }
            }
        }
        return false;
    }

    public void showSentenceInWordsAmountIncreasingOrder() {
        List<Sentence> sortedSentences = new ArrayList<>(sentences);
        Comparator<Sentence> wordsAmountIncreasingOrderComparator = new Comparator<Sentence>() {
            @Override
            public int compare(Sentence o1, Sentence o2) {
                return o1.getWordsAsList().size() - o2.getWordsAsList().size();
            }
        };

        Collections.sort(sortedSentences, wordsAmountIncreasingOrderComparator);

        consolePrinter.showSentences(sortedSentences);
    }

    public void findWordInFirstSentanceWichIsUnicForText() {
        Sentence firstSentence = sentences.get(0);
        int counter = 0;
        Sentence currentSentence;
        boolean isUniq;
        for (Word word : firstSentence.getWordsAsList()
             ) {
            isUniq = true;
            for (int i = 1; i < sentences.size(); i++) {
                currentSentence = sentences.get(i);
                if (currentSentence.getWordsAsList().contains(word)){
                    isUniq = false;
                    break;
                }
            }
            if(isUniq) {
                consolePrinter.showUniqWordFromFirstSentence(word);
                counter++;
            }
        }
        if (counter == 0){
            consolePrinter.notifyNoUniqWordsInFirstSentence();
        }
    }


    public void askUserDesiredWordsLength() {
        consolePrinter.showQuestionRegardingDesiredWordsLength();
    }

    public void showAllWordsFromIterrogativeSentencesWithDesiredLength(int desiredWordsLength) {
        for (Sentence sentence : sentences
             ) {
            if (sentence.isIterrogative()){
                List<Word> wordsToShow = addAllWordsWithRequiredLength(desiredWordsLength, sentence);
                if (!wordsToShow.isEmpty()){
                consolePrinter.showWordsFromList(wordsToShow, desiredWordsLength);
                }
                else {
                    consolePrinter.notifyNoWordsWithSuchLengthInIterrogativeSentences();
                }
            }
        }
    }

    private List<Word> addAllWordsWithRequiredLength(int desiredWordsLength, Sentence sentence) {
        List<Word> requiredWords = new ArrayList<>();
        for (Word word : sentence.getWordsAsList()
             ) {
            if (word.length() == desiredWordsLength){
                requiredWords.add(word);
            }
        }
        return requiredWords;
    }
}
