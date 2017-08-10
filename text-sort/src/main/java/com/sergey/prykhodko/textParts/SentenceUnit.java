package com.sergey.prykhodko.textParts;

public interface SentenceUnit {
    String WORD_REG_EX = "[А-Яа-яA-Za-zієїІЇЄ]{1}([\\wА-Яа-я’ієї]+)";
    String PUNCTUATION_UNIT_REG_EX = "[,.-—:;!?\\)\\(]{1}";
}
