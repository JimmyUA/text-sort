package com.sergey.prykhodko;

import com.sergey.prykhodko.control.MainController;
import com.sergey.prykhodko.control.TextLoader;
import com.sergey.prykhodko.textParts.Text;

import java.io.File;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Text textToWorkWith = new Text();
        
        MainController mainController = new MainController(textToWorkWith);
        Scanner scanner = new Scanner(System.in);
        int taksNumber = scanner.nextInt();
        switch (taksNumber){
            case 0:
                mainController.checkWords();                         //need to be deleted
            case 1:
                mainController.calculateAndShowAmountOfSentencesWithEqualWords();
                break;
            case 2:
                mainController.showSentenceInWordsAmountIncreasingOrder();
                break;
            case 3:
                mainController.findWordInFirstSentanceWichIsUnicForText();
                break;
            case 4:
                mainController.askUserDesiredWordsLength();
                int desiredWordsLength = scanner.nextInt();
                mainController.showAllWordsFromIterrogativeSentencesWithDesiredLength(desiredWordsLength);

            case 5:
                mainController.changeFirstAndLastWords();
                break;
            case 6:
                mainController.sortAllWordsByAlphabet();
                break;
            case 7:
                mainController.sortWordsByVovelsRatio();
                break;
            case 8:
                mainController.sortWordsStartsFromVovel();
                break;
            case 9:
                String desiredLetter = mainController.askAndReturnDesiredLetter(scanner);
                mainController.sortWordsByDesiredLetter(desiredLetter);
                break;
            case 10:
                File file = new File("D:/words_to_find_in_text.txt");
                mainController.countAmountWordsAppearenses(file);
                break;
            case 11:
                String[] desiredLetters = mainController.askDesiredLettersLimitsForInterval(scanner);
                mainController.deleteMaxIntervalFromEachSentence(desiredLetters);
                break;
            case 12:
                int wordLength = mainController.askWordLength(scanner);
                mainController.deleteWordthHasLengthAndStartsFromConsonant(wordLength);
                break;
            case 13:
                desiredLetter = mainController.askAndReturnDesiredLetter(scanner);
                mainController.sortWordsByDesiredLetterDecreasingOrder(desiredLetter);
                break;
            case 14:
                mainController.findMaxPolindrome();
                break;
            case 15:
                mainController.removeFirstAndLastLettersFromWords();

        }
    }
}
