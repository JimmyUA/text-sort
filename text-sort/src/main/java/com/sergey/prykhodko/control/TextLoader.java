package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextLoader {

    private static final String SENTENCE_REG_EX = "(.*?)[.?!]([\\s\\n])";

    public static List<Sentence> getSentencesFromFile(File fileWithGoalText){
        List<Sentence> sentences = new ArrayList<>();

        try(Reader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileWithGoalText),
                "UTF-8"))){
            int i;
            int count = 0;
            int minLength = 2;

            StringBuilder builder = new StringBuilder();

            while ((i = in.read()) != -1){
                builder.append((char)i);

            }
            String text = builder.toString();

            Pattern sentencePattern = Pattern.compile(SENTENCE_REG_EX, Pattern.MULTILINE|Pattern.DOTALL);
            Matcher sentenceMatcer = sentencePattern.matcher(text);

            while (sentenceMatcer.find()){
                sentences.add(new Sentence(sentenceMatcer.group().replace("\n", "")));
            }
            if (sentences.isEmpty()){
                sentences.add(new Sentence(text));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }
}
