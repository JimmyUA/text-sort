package com.sergey.prykhodko.control;

import com.sergey.prykhodko.textParts.Sentence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextLoader {

    public List<Sentence> getTextFromFile(File fileWithGoalText){
        List<Sentence> sentences = new ArrayList<>();

        try(InputStream in = new FileInputStream(fileWithGoalText)){
            int i;
            int count = 0;
            int minLength = 2;

            StringBuilder builder = new StringBuilder();

            while ((i = in.read()) != -1){
                builder.append((char)i);
                if (i == 46 && builder.length() > minLength){
                    sentences.add(new Sentence(builder.toString().trim()));
                    builder = new StringBuilder();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }
}
