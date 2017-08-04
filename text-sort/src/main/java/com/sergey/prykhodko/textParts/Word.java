package com.sergey.prykhodko.textParts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Word implements SentenceUnit, Comparable<Word>{
    private String word;
    private List<Character> characters;
    private static final char[] VOVELS = {'a', 'o', 'e', 'u', 'i', 'y'};

    public Word(String word) {
        this.word = word;
        characters = getAllCharacters();
    }

    private List<Character> getAllCharacters() {
        char[] chars = word.toCharArray();
        List<Character> allCharacters = new ArrayList<>();
        for (char entry : chars
              ) {
            allCharacters.add(entry);
        }
        return allCharacters;

    }

    public int length(){
        return word.length();

    }

    public int vovelsAmount(){
        int amount = 0;
        for (char character : characters
             ) {
            if (isVovel(character)){
                amount++;
            }
        }
        return amount;
    }

    public static boolean isVovel(char character) {
        for (char vovel : VOVELS
             ) {
            if (character == vovel){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word that = (Word) o;

        return word.equalsIgnoreCase(that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareTo(o.word);
    }

    public List<Character> getWordCharactersAsList() {
        return characters;
    }
}
