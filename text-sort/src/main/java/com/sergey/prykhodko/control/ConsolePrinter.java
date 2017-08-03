package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;
import com.sergey.prykhodko.textParts.Word;

import java.util.List;

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
}
