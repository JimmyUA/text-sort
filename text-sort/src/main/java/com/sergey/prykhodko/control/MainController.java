package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;
import com.sergey.prykhodko.textParts.Text;
import com.sergey.prykhodko.textParts.Word;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    private List<Sentence> sentences;
    private ConsolePrinter consolePrinter;

    public MainController(Text text) {
        sentences = text.getSentencesAsList();
        consolePrinter = new ConsolePrinter();
    }

    /*******************************************************************************
     *************************** Task # 1 ******************************************
     *******************************************************************************/

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
                if (words.get(i).equals(words.get(j)) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    /*******************************************************************************
     *************************** Task # 2 ******************************************
     *******************************************************************************/

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

    /*******************************************************************************
     *************************** Task # 3 ******************************************
     *******************************************************************************/

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
                if (currentSentence.getWordsAsList().contains(word)) {
                    isUniq = false;
                    break;
                }
            }
            if (isUniq) {
                consolePrinter.showUniqWordFromFirstSentence(word);
                counter++;
            }
        }
        if (counter == 0) {
            consolePrinter.notifyNoUniqWordsInFirstSentence();
        }
    }

    /*******************************************************************************
     *************************** Task # 4 ******************************************
     *******************************************************************************/

    public boolean areIterrogativeSentencesPresent() {
        for (Sentence sentence : sentences
                ) {
            String sentenceString = sentence.toString();
            if (sentenceString.charAt(sentenceString.length() - 1) == '?') {
                return true;
            }
        }
        return false;
    }

    public void askUserDesiredWordsLength() {
        consolePrinter.showQuestionRegardingDesiredWordsLength();
    }

    public void showAllWordsFromIterrogativeSentencesWithDesiredLength(int desiredWordsLength) {
        List<Word> wordsToShow;

        for (Sentence sentence : sentences
                ) {
            if (sentence.isIterrogative()) {
                wordsToShow = addAllWordsWithRequiredLength(desiredWordsLength, sentence);
                if (!wordsToShow.isEmpty()) {
                    consolePrinter.showWordsFromList(wordsToShow, desiredWordsLength);
                } else {
                    consolePrinter.notifyNoWordsWithSuchLengthInIterrogativeSentences();
                }
            }
        }
    }

    public void printNoIterrogativeSentences() {
        consolePrinter.notifyNoIterrogativeSentences();
    }

    /*******************************************************************************
     *************************** Task # 5 ******************************************
     *******************************************************************************/

    public void changeFirstAndLastWords() {
        String sentenceString;
        List<Word> words;
        for (Sentence sentence : sentences
                ) {
            sentenceString = sentence.toString();
            words = sentence.getWordsAsList();
            sentenceString = changeFirstAndLastWordsInOneSentence(sentenceString, words);
            consolePrinter.print(sentenceString);
        }

    }

    private String changeFirstAndLastWordsInOneSentence(String sentence, List<Word> words) {
        String firstWord = words.get(0).toString();
        String lastWord = words.get(words.size() - 1).toString();

        sentence = sentence.replace(lastWord, firstWord);

        String cuttedSentence = sentence.substring(firstWord.length());

        sentence = lastWord + cuttedSentence;

        return sentence;
    }


    /*******************************************************************************
     *************************** Task # 6 ******************************************
     *******************************************************************************/

    public void sortAllWordsByAlphabet() {
        List<Word> allWords = getAllTextWords();

        Collections.sort(allWords);
        Set<Word> allUniqWords = new LinkedHashSet<>(allWords);
        consolePrinter.showWordsInAlphabeticOrder(allUniqWords);
    }

    /*******************************************************************************
     *************************** Task # 7 ******************************************
     *******************************************************************************/

    public void sortWordsByVovelsRatio() {
        List<Word> allWords = getAllTextWords();
        Collections.sort(allWords, comparatorByVovelsAmout());
        consolePrinter.showWordSortedByVovelsAmount(allWords);
    }

    private Comparator<? super Word> comparatorByVovelsAmout() {
        return new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                Double o1Ratio = o1.vovelsAmount() / (o1.charactersAmount() * 1.0);
                Double o2Ratio = o2.vovelsAmount() * 1.0 / (o2.charactersAmount() * 1.0);
                return o1Ratio.compareTo(o2Ratio);
            }
        };
    }

    /*******************************************************************************
     *************************** Task # 8 ******************************************
     *******************************************************************************/

    public void sortWordsStartsFromVovel() {
        List<Word> allWords = getAllTextWords();
        Set<Word> startsWithVovelSet = new HashSet<>();
        List<Character> wordCharacters;

        for (Word word : allWords
                ) {
            wordCharacters = word.getWordCharactersAsList();
            if (Word.isVovel(wordCharacters.get(0))) {
                startsWithVovelSet.add(word);
            }
        }
        if (startsWithVovelSet.isEmpty()) {
            consolePrinter.notifyNoWordsStartsWithVovel();
        }

        List<Word> startsWithVovel = new ArrayList<>(startsWithVovelSet);
        Collections.sort(startsWithVovel, comparatorByFirstNotVovel());
        consolePrinter.showWords(startsWithVovel);
    }

    private Comparator<? super Word> comparatorByFirstNotVovel() {
        return new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                List<Character> o1Characters = o1.getWordCharactersAsList();
//                if (o1Characters.size() == 0){
//                    return -1;
//                }
                while (Word.isVovel(o1Characters.get(0))) {
                    o1Characters.remove(0);
                    if (o1Characters.size() == 0) {
                        o1Characters.add('z');
                        break;
                    }
                }
                List<Character> o2Characters = o2.getWordCharactersAsList();
//                if (o2Characters.size() == 0){
//                    return -1;
//                }
                while (Word.isVovel(o2Characters.get(0))) {
                    o2Characters.remove(0);
                    if (o2Characters.size() == 0) {
                        o2Characters.add('z');
                        break;
                    }
                }
                String o1ToCompare = o1Characters.get(0).toString();
                String o2ToCompare = o2Characters.get(0).toString();
                return o1ToCompare.compareTo(o2ToCompare);
            }
        };
    }

    private List<Word> addAllWordsWithRequiredLength(int desiredWordsLength, Sentence sentence) {
        List<Word> requiredWords = new ArrayList<>();
        for (Word word : sentence.getWordsAsList()
                ) {
            if (word.length() == desiredWordsLength) {
                requiredWords.add(word);
            }
        }
        return requiredWords;
    }

    /*******************************************************************************
     *************************** Task # 9 ******************************************
     *******************************************************************************/

    public String askAndReturnDesiredLetter(Scanner scanner) {
        consolePrinter.askDesiredLetter();
        return scanner.next();
    }

    public void sortWordsByDesiredLetter(String desiredLetter) {
        List<Word> words = getAllTextWords();
        Set<Word> wordSet = new HashSet<>(words);
        words = new ArrayList<>(wordSet);
        String withoutDesiredLetter;
        for (int i = 1; i < words.size(); i++) {
            withoutDesiredLetter = words.get(i).toString();
            if (!withoutDesiredLetter.contains(desiredLetter)) {
                words.remove(i--);
            }
        }
        if (!words.get(0).toString().contains(desiredLetter)) {
            words.remove(0);
        }
        Collections.sort(words, comparatorByDesiredLetterAmount(desiredLetter));
        if (words.isEmpty()) {
            consolePrinter.notifyNoWordsContainsDesiredLetter();
        }
        consolePrinter.showWords(words);
    }

    private Comparator<? super Word> comparatorByDesiredLetterAmount(final String desiredLetter) {

        return new Comparator<Word>() {
            char requiredChar = desiredLetter.trim().charAt(0);

            @Override
            public int compare(Word o1, Word o2) {
                int o1Amount = getSameCharactersAmount(o1, requiredChar);
                int o2Amount = getSameCharactersAmount(o2, requiredChar);
                if (o1Amount == o2Amount) {
                    return o1.toString().compareTo(o2.toString());
                }

                return o1Amount - o2Amount;
            }

            private int getSameCharactersAmount(Word word, char requiredChar) {
                int amount = 0;
                List<Character> characters = word.getWordCharactersAsList();
                for (char character : characters
                        ) {
                    if (character == requiredChar) {
                        amount++;
                    }
                }
                return amount;
            }
        };
    }

    /*******************************************************************************
     *************************** Task # 10 ******************************************
     *******************************************************************************/

    public void countAmountWordsAppearenses(File file) {
        Text text = new Text();
        text.setSentences(TextLoader.getSentencesFromFile(file));
        List<Word> wordsToFindInText = getAllTextWords(text);
        Map<Word, List<Integer>> wordsWithAppearenceInEachSentence = new TreeMap<>(comparatorByAvaredgeAppearence());
        for (Word word : wordsToFindInText
                ) {
            List<Integer> appearences = getAppearencesList(word);
            wordsWithAppearenceInEachSentence.put(word, appearences);
        }
        consolePrinter.showWordsSortedByAppearence(wordsWithAppearenceInEachSentence);
    }

    private Comparator<? super Word> comparatorByAvaredgeAppearence() {
        return new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int o1Avarege = calculateAvarege(o1);
                int o2Avarege = calculateAvarege(o2);
                List<Integer> o2Appearence = getAppearencesList(o2);
                return o2Avarege - o1Avarege;
            }

            private int calculateAvarege(Word word) {
                List<Integer> appearences = getAppearencesList(word);
                int avarege = 0;
                for (int appearence : appearences
                        ) {
                    avarege += appearence;
                }
                return avarege;
            }
        };
    }

    private List<Integer> getAppearencesList(Word word) {
        List<Integer> appearences = new ArrayList<>();
        for (Sentence sentence : sentences
                ) {
            int appearenseInSentence = 0;
            for (Word entry : sentence.getWordsAsList()
                    ) {
                if (entry.equals(word)) {
                    appearenseInSentence++;
                }
            }
            appearences.add(appearenseInSentence);
        }
        return appearences;
    }

    /*******************************************************************************
     *************************** Task # 11 ******************************************
     *******************************************************************************/

    public String[] askDesiredLettersLimitsForInterval(Scanner scanner) {
        consolePrinter.askIntervalLetters();
        scanner.nextLine();

        return scanner.nextLine().split(" ");
    }

    public void deleteMaxIntervalFromEachSentence(String[] desiredLetters) {
        List<Sentence> sentencesCopy = new ArrayList<>(sentences);
        for (Sentence sentence : sentencesCopy
                ) {
            String deletedInterval = deleteMaxIntervalFromSentance(sentence, desiredLetters);
            consolePrinter.showDeletedInterval(deletedInterval);
            String cuttedSentence = sentence.toString().replace(deletedInterval, "");
            consolePrinter.showCuttedSentence(cuttedSentence);
        }
    }

    private String deleteMaxIntervalFromSentance(Sentence sentence, String[] desiredLetters) {
        String sentenceString = sentence.toString();

        List<String> intervals = new ArrayList<>();

        Pattern intervalPattern = Pattern.compile("(" + desiredLetters[0] + ")(.*)(" + desiredLetters[1] + ")", Pattern.DOTALL);
        Matcher intervalMatcher = intervalPattern.matcher(sentenceString);

        while (intervalMatcher.find()) {
            intervals.add(intervalMatcher.group());
        }
        Collections.sort(intervals, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        if (intervals.size() == 0) {
            return "";
        }
        return intervals.get(0);
    }

    /*******************************************************************************
     *************************** Task # 12 ******************************************
     *******************************************************************************/

    public int askWordLength(Scanner scanner) {
        consolePrinter.askWordLength();
        return scanner.nextInt();
    }

    public void deleteWordsHasLengthAndStartsFromConsonant(int wordLength) {
        Set<Word> wordsToDelete;
        List<Word> allWords;

        for (Sentence sentence : sentences
                ) {
            consolePrinter.showSentenceBefore(sentence);

            wordsToDelete = new HashSet<>();
            allWords = sentence.getWordsAsList();
            for (Word word : allWords
                    ) {
                String wordString = word.toString();
                if (!Word.isVovel(wordString.charAt(0)) && wordString.length() == wordLength) {
                    wordsToDelete.add(word);
                }
            }

            if (wordsToDelete.isEmpty()) {
                consolePrinter.notifyNoWordsWithSuchLengthInSentences();
            } else {
                consolePrinter.showWordsWillBeDeleted(wordsToDelete);
            }

            for (Word word : wordsToDelete
                    ) {
                sentence = deleteWordFromSentence(sentence, word);
            }
            consolePrinter.showSentenceAfter(sentence);
        }

    }

    private Sentence deleteWordFromSentence(Sentence sentence, Word word) {
        String sentenceString = sentence.toString();
        return new Sentence(sentenceString.replace(word.toString(), ""));
    }

    /*******************************************************************************
     *************************** Task # 13 ******************************************
     *******************************************************************************/

    public void sortWordsByDesiredLetterDecreasingOrder(String desiredLetter) {
        List<Word> words = getAllTextWords();
        Set<Word> wordSet = new HashSet<>(words);
        words = new ArrayList<>(wordSet);
        String withoutDesiredLetter;
        for (int i = 1; i < words.size(); i++) {
            withoutDesiredLetter = words.get(i).toString();
            if (!withoutDesiredLetter.contains(desiredLetter)) {
                words.remove(i--);
            }
        }
        if (!words.get(0).toString().contains(desiredLetter)) {
            words.remove(0);
        }
        Collections.sort(words, comparatorByDesiredLetterAmountDecreasingOrder(desiredLetter));
        if (words.isEmpty()) {
            consolePrinter.notifyNoWordsContainsDesiredLetter();
        }
        consolePrinter.showWords(words);
    }

    private Comparator<? super Word> comparatorByDesiredLetterAmountDecreasingOrder(final String desiredLetter) {

        return new Comparator<Word>() {
            char requiredChar = desiredLetter.trim().charAt(0);

            @Override
            public int compare(Word o1, Word o2) {
                int o1Amount = getSameCharactersAmount(o1, requiredChar);
                int o2Amount = getSameCharactersAmount(o2, requiredChar);
                if (o1Amount == o2Amount) {
                    return o1.toString().compareTo(o2.toString());
                }

                return o2Amount - o1Amount;
            }

            private int getSameCharactersAmount(Word word, char requiredChar) {
                int amount = 0;
                List<Character> characters = word.getWordCharactersAsList();
                for (char character : characters
                        ) {
                    if (character == requiredChar) {
                        amount++;
                    }
                }
                return amount;
            }
        };
    }

    /*******************************************************************************
     *************************** Task # 14 ******************************************
     *******************************************************************************/

    public void findMaxPolindrome() {
        List<Word> allWords = getAllTextWords();
        StringBuilder builder = new StringBuilder();

        for (Word word : allWords
                ) {
            builder.append(word.toString());
        }

        Word oneBigWord = new Word(builder.toString());

        findMaxPolindromeFromWord(oneBigWord);

    }

    private void findMaxPolindromeFromWord(Word word) {
        int stringLength = word.length();
        String wordString = word.toString();
        String longestPolindrome = wordString.substring(0, 1);
        for (int i = 0; i < stringLength - 1; i++) {
            String first = expandSides(wordString, i, i);
            if (first.length() > longestPolindrome.length()) {
                longestPolindrome = first;
            }

            String second = expandSides(wordString, i, i + 1);
            if (second.length() > longestPolindrome.length()) {
                longestPolindrome = first;
            }
        }

        if (longestPolindrome.equals(wordString.substring(0, 1))) {
            consolePrinter.notifyNoPolindromes();
        } else {
            consolePrinter.showPolindrome(new Word(longestPolindrome));
        }
    }

    private String expandSides(String word, int leftSide, int rightSide) {         //  asdfghgfdsa
        int length = word.length();
        while (leftSide >= 0 && rightSide < length && word.charAt(leftSide) == word.charAt(rightSide)) {
            leftSide--;
            rightSide++;
        }
        int start = leftSide + 1;
        int end = rightSide - 1;
        if (end < start) {
            return "";
        } else {
            return word.substring(leftSide + 1, rightSide);
        }
    }

    /*******************************************************************************
     *************************** Task # 15 ******************************************
     *******************************************************************************/

    public void removeFirstAndLastLettersFromWords() {
        List<Word> allWords = getAllTextWords();

        for (Word word : allWords
                ) {
            consolePrinter.showWordBeforeDeletion(word);
            word = deleteLastAndFirstLettersFromWord(word);
            consolePrinter.showWordAfterDeletion(word);
        }

    }

    private Word deleteLastAndFirstLettersFromWord(Word word) {
        if (word.toString().length() > 3) {
            List<Character> allLetters = word.getWordCharactersAsList();
            Character first = allLetters.get(0);
            Character last = allLetters.get(allLetters.size() - 1);
            String wordString = word.toString();
            String wordWithNoFirstAndLastLetter = wordString.substring(1, wordString.length() - 1);
            wordWithNoFirstAndLastLetter = wordWithNoFirstAndLastLetter.replace(first.toString().toLowerCase(), "").
                    replace(last.toString().toLowerCase(), "");

            String result = first.toString() + wordWithNoFirstAndLastLetter + last.toString();
            return new Word(result);
        } else {
            return word;
        }

    }

    /*******************************************************************************
     *************************** Task # 16 ******************************************
     *******************************************************************************/

    public int askAndReturnDesiredSentenceNumber(Scanner scanner) {
        consolePrinter.askDesiredSentenceNumber();
        return scanner.nextInt();
    }

    public String askAndReturnDesiredSubstring(Scanner scanner) {
        consolePrinter.askSubstringForReplacing();
        return scanner.next();
    }

    public void showSentenceWithGivenSubstringInsteadOfWordsWithGivenLength(
            int desiredSentenceNumber, int goalWordsLength, String substringForReplacing) {

        if (desiredSentenceNumber - 1 > sentences.size()) {
            consolePrinter.notifyThereAreLessSentenses(sentences.size() + 1);
            return;
        }
        Sentence desiredSentence = sentences.get(desiredSentenceNumber - 1);
        List<Word> words = desiredSentence.getWordsAsList();

        String sentence = desiredSentence.toString();

        consolePrinter.showSentenceBefore(desiredSentence);

        for (Word word : words
                ) {
            String wordString = word.toString();
            if (wordString.length() == goalWordsLength) {
                sentence = sentence.replace(wordString, substringForReplacing);
            }
        }
        consolePrinter.showSentenceAfter(new Sentence(sentence));

    }

    /*******************************************************************************
     *************************** system methods*************************************
     *******************************************************************************/

    public void showCommandVariants() {
        consolePrinter.printCommandVariants();
    }

    private List<Word> getAllTextWords() {
        List<Word> allWords = new ArrayList<>();
        for (Sentence sentence : sentences
                ) {
            allWords.addAll(sentence.getWordsAsList());
        }
        return allWords;
    }

    private List<Word> getAllTextWords(Text text) {
        List<Sentence> sentencesList = text.getSentencesAsList();
        List<Word> allWords = new ArrayList<>();
        for (Sentence sentence : sentencesList
                ) {
            allWords.addAll(sentence.getWordsAsList());
        }
        return allWords;
    }

    public void checkWords() {
        List<Word> words = getAllTextWords();
        int i = 1;
        for (Word word : words
                ) {
            System.out.println("" + i++ + " " + word);
        }
    }
}
