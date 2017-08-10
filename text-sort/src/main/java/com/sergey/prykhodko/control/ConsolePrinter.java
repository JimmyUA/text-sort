package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;
import com.sergey.prykhodko.textParts.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ConsolePrinter {


    /*******************************************************************************
     *************************** Task # 1 ******************************************
     *******************************************************************************/

    void showSentencesAmountWithEqulWords(int sentencesWithEqualWordsAmount) {
        System.out.println("There are " + sentencesWithEqualWordsAmount + " sentences with same words in current text");
    }

    /*******************************************************************************
     *************************** Task # 2 ******************************************
     *******************************************************************************/

    void showSentences(List<Sentence> sentences) {
        for (Sentence sentence : sentences
                ) {
            System.out.println("" + sentence + "\u001B[31m words amount: " +
                    sentence.getWordsAsList().size() + "\u001B[0m\n");
        }
    }

    /*******************************************************************************
     *************************** Task # 3 ******************************************
     *******************************************************************************/

    void showUniqWordFromFirstSentence(Word word) {
        System.out.println("Word - " + word + " present only in first sentence");
    }

    void notifyNoUniqWordsInFirstSentence() {
        System.out.println("All words in first sentence are present in other parts of the text");
    }

    /*******************************************************************************
     *************************** Task # 4 ******************************************
     *******************************************************************************/

    void showQuestionRegardingDesiredWordsLength() {
        System.out.println("Please enter desired words length to find in interrogative sentences");
    }

    void showWordsFromList(List<Word> wordsToShow, int desiredWordsLength) {
        System.out.println("Words from iterrogative sentences with " + desiredWordsLength + " letters are:");
        for (Word word : wordsToShow
                ) {
            System.out.println(word);
        }
    }

    void notifyNoWordsWithSuchLengthInIterrogativeSentences() {
        System.out.println("No words were found");
    }

    void notifyNoIterrogativeSentences() {
        System.out.println("There are no iterrogative sentences!");
    }

    /*******************************************************************************
     *************************** Task # 6 ******************************************
     *******************************************************************************/

    void showWordsInAlphabeticOrder(Set<Word> allWords) {
        List<Word> words = new ArrayList<>(allWords);
        System.out.println("    " + words.get(0));
        for (int i = 1; i < words.size(); i++) {
            String current = words.get(i).toString();
            String previous = words.get(i - 1).toString();
            if (current.charAt(0) != previous.charAt(0)) {
                System.out.println("    " + current);
            } else {
                System.out.println(current);
            }
        }
    }

    /*******************************************************************************
     *************************** Task # 7 ******************************************
     *******************************************************************************/

    void showWordSortedByVovelsAmount(List<Word> words) {
        for (Word word : words
                ) {
            Double ratio = word.vovelsAmount() / (word.charactersAmount() * 1.0);
            System.out.printf(word + "\u001B[31m Vovels ratio - %1.2f vovels amount: " + word.vovelsAmount() + "\u001B[0m\n", ratio);
        }
    }

    /*******************************************************************************
     *************************** Task # 8 ******************************************
     *******************************************************************************/

    void showWords(List<Word> words) {
        for (Word word : words
                ) {
            System.out.println(word);
        }
    }

    void notifyNoWordsStartsWithVovel() {
        System.out.println("No word starts with vovel");
    }

    /*******************************************************************************
     *************************** Task # 9 ******************************************
     *******************************************************************************/

    void askDesiredLetter() {
        System.out.println("Enter letter to sort words by it's amount:");
    }

    void notifyNoWordsContainsDesiredLetter() {
        System.out.println("No words contains desired letter");
    }

    /*******************************************************************************
     *************************** Task # 10 ******************************************
     *******************************************************************************/

    void showWordsSortedByAppearence(Map<Word, List<Integer>> wordsWithAppearenceInEachSentence) {
        for (Map.Entry<Word, List<Integer>> entry : wordsWithAppearenceInEachSentence.entrySet()
                ) {
            List<Integer> appearences = entry.getValue();
            int avarege = calculateAverage(appearences);
            System.out.println(entry.getKey() + " - total appearence: " + avarege);
            System.out.print("Each sentence appearence: ");
            for (int i = 0; i < appearences.size(); i++) {
                System.out.print((i + 1) + " : " + "\u001B[31m" + appearences.get(i) + "\u001B[0m" + "| ");
            }
            System.out.println("\n");
        }
    }

    private int calculateAverage(List<Integer> integers) {
        int avarege = 0;
        for (int entry : integers
                ) {
            avarege += entry;
        }
        return avarege;
    }

    /*******************************************************************************
     *************************** Task # 11 ******************************************
     *******************************************************************************/

    void askIntervalLetters() {
        System.out.println("Please enter limit-letters for interval to be deleted from each sentance(letter_letter):");
    }

    void showDeletedInterval(String deletedInterval) {
        System.out.println("Substring \u001B[31m\"" + deletedInterval + "\"\u001B[0m were deleted wrom sentence");
    }

    void showCuttedSentence(String cuttedSentence) {
        System.out.println("Now sentence is: \u001B[34m\"" + cuttedSentence + "\"\n\u001B[0m");
    }

    /*******************************************************************************
     *************************** Task # 12 ******************************************
     *******************************************************************************/

    void askWordLength() {
        System.out.println("Please enter words to be deleted length:");
    }

    void showSentenceBefore(Sentence sentence) {
        System.out.println("Sentence before:\u001B[31m\n" + sentence + "\u001B[0m");
    }

    void notifyNoWordsWithSuchLengthInSentences() {
        System.out.println("No words with that lenght found");
    }

    void showWordsWillBeDeleted(Set<Word> words) {
        System.out.print("Deleting words: ");
        for (Word word : words
                ) {
            System.out.print(word + ", ");
        }
        System.out.println("\b\b");
    }

    void showSentenceAfter(Sentence sentence) {
        System.out.println("Sentence after:\n\u001B[34m" + sentence + "\u001B[0m\n");
    }

    /*******************************************************************************
     *************************** Task # 14 ******************************************
     *******************************************************************************/

    void notifyNoPolindromes() {
        System.out.println("No Polindrome were found");
    }

    void showPolindrome(Word longestPolindrome) {
        System.out.println("The longest polindrome in this text is: " + "\u001B[35m" + longestPolindrome);
    }

    /*******************************************************************************
     *************************** Task # 15 ******************************************
     *******************************************************************************/

    void showWordBeforeDeletion(Word word) {
        System.out.print("\u001B[34m" + word + "\u001B[0m  - ");
    }

    void showWordAfterDeletion(Word word) {
        System.out.println("\u001B[31m" + word + "\u001B[0m");
    }

    /*******************************************************************************
     *************************** Task # 16 ******************************************
     *******************************************************************************/

    void askDesiredSentenceNumber() {
        System.out.println("Please enter sentence number were words should be replaced:");
    }

    void askSubstringForReplacing() {
        System.out.println("Please enter substring to replace words with in given sentence:");
    }

    void notifyThereAreLessSentenses(int size) {
        System.out.println("There are only " + size + "sentences");
    }

    /*******************************************************************************
     *************************** system methods*************************************
     *******************************************************************************/

    void printCommandVariants() {
        System.out.println("////////////////////////////////WELCOME TO TEXT PARSER////////////////////////////////////////////" +
                "\nenter number of the task you want to execute or 0 - to see all words, -1 - to exit");
    }

    void print(String string) {
        System.out.println(string);
    }


}
