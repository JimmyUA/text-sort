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
        textToWorkWith.setText(TextLoader.getTextFromFile(new File("D:/test.txt")));

        MainController mainController = new MainController(textToWorkWith);
        Scanner scanner = new Scanner(System.in);
        int taksNumber = scanner.nextInt();
        switch (taksNumber){
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
        }
    }
}
