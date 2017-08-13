package com.sergey.prykhodko.textParts;

public interface SentenceUnit {
    String WORD_REG_EX = "[A-Za-z]{1}(\\w+)";
    String PUNCTUATION_UNIT_REG_EX = "[,.-:;!?\\)\\(]{1}";
}
