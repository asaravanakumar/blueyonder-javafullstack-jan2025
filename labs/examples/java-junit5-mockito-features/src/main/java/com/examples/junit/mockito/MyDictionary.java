package com.examples.junit.mockito;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary {
    protected Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<>();
    }

    public MyDictionary(Map<String, String> wordMap) {
       this.wordMap = wordMap;
    }

    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }
    public String getMeaning(final String word) {
        return wordMap.get(word);
    }

    private String getName() {
        return "Testing Dictionary";
    }

    public final int count() {
        return wordMap.size();
    }

    public static String getDictionaryName() {
        return "Training Dictionary";
    }

    public static class DictionaryUtils {
        public static String getDisplayName() {
            return MyDictionary.getDictionaryName();
        }
    }
}
