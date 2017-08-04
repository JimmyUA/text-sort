package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;
import com.sergey.prykhodko.textParts.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConsolePrinter {

    public void showSentences(List<Sentence> sentences) {
        for (Sentence sentence : sentences
             ) {
            System.out.println("" + sentence + "\u001B[31m words amount: " + sentence.getWordsAsList().size() + "\u001B[0m");
        }
    }


    public void showSentencesAmountWithEqulWords(int sentencesWithEqualWordsAmount) {
        System.out.println("There are " + sentencesWithEqualWordsAmount + " sentences with same words in current text");
    }

    public void showUniqWordFromFirstSentence(Word word) {
        System.out.println("Word - " + word + " present only in first sentence");
    }

    public void notifyNoUniqWordsInFirstSentence() {
        System.out.println("All words in first sentence are present in other parts of the text");
    }

    public void showQuestionRegardingDesiredWordsLength() {
        System.out.println("Please enter desired words length to find in interrogative sentences");
    }


    public void showWordsFromList(List<Word> wordsToShow, int desiredWordsLength) {
        System.out.println("Words from iterrogative sentences with " + desiredWordsLength + " letters are:");
        for (Word word : wordsToShow
             ) {
            System.out.println(word);
        }
    }

    public void notifyNoWordsWithSuchLengthInIterrogativeSentences() {
        System.out.println("No words were found");
    }

    public void showWordsInAlphabeticOrder(Set<Word> allWords) {
        List<Word> words = new ArrayList<>(allWords);
        System.out.println("    " + words.get(0));
        for (int i = 1; i < words.size(); i++) {
            String current = words.get(i).toString();
            String previous = words.get(i-1).toString();
            if (current.charAt(0) != previous.charAt(0)){
                System.out.println("    " + current);
            }
            else {
                System.out.println(current);
            }
        }
    }

    public void showWordSortedByVovelsAmount(List<Word> allWords) {
        for (Word word : allWords
                ) {
            Double ratio = word.vovelsAmount()/(word.charactersAmount() * 1.0);
            System.out.printf(word + "\u001B[31m Vovels ratio - %1.2f vovels amount: " + word.vovelsAmount() + "\u001B[0m\n", ratio);
        }
    }

    public void showWords(List<Word> words) {
        for (Word word : words
             ) {
            System.out.println(word);
        }
    }
}
