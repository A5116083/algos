package com.company.NLP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class NGram {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        StringBuilder strBuffer = new StringBuilder();

        String input ="Mary had a little lamb its fleece was white as snow;\n" +
                "And everywhere that Mary went, the lamb was sure to go.\n" +
                "It followed her to school one day, which was against the rule;\n" +
                "It made the children laugh and play, to see a lamb at school.\n" +
                "And so the teacher turned it out, but still it lingered near,\n" +
                "And waited patiently about till Mary did appear.\n" +
                "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

        /*while ((line = in.readLine()) != null) {

            strBuffer.append(line);
            System.out.println(line);
        }*/
        line = removeStopWords(input);
        SortedSet<Map.Entry<String, Double>> nGramsFreq = nGrams(2," the ", line);

        /*gGramsFreq.stream()
                .forEach(kvp-> System.out.println(kvp.getKey() + ":" + kvp.getValue().toString()));*/
        printOutPut(nGramsFreq);

    }
    private static void printOutPut(SortedSet<Map.Entry<String, Double>> nGramsFreq){
        DecimalFormat df = new DecimalFormat("0.000");
        String output= nGramsFreq.stream()
                .map(kvp-> kvp.getKey()+","+df.format(kvp.getValue()))
                .collect(Collectors.joining(";"));
        System.out.println(output);
    }

    private static String removeStopWords(String input){

        return input.trim().replaceAll("[^a-zA-Z0-9-\\s]","").replace("\n"," ");
    }

    public static SortedSet<Map.Entry<String, Double>> nGrams(int n, String splitterStr,  String str) {
        String[] splittedLines = str.split(splitterStr);
        HashMap<String, Integer> wordMap = new HashMap<>();
        int splitLen = splitterStr.trim().split(" ").length;

        for (int count = 1; count < splittedLines.length; count++) {
            String[] splittedWords = splittedLines[count].split(" ");
            String nextWord=  concat(splittedWords, 0, n-splitLen);
            if(!nextWord.equals("")) {
                if (!wordMap.containsKey(nextWord))
                    wordMap.put(nextWord, 1);
                else {
                    wordMap.put(nextWord, wordMap.get(nextWord) + 1);
                }
            }
        }
        TreeMap<String, Double> tempMap  =  computeFreq(splittedLines.length-1, wordMap);
        return entriesSortedByValues(tempMap);
    }
    private static TreeMap<String, Double> computeFreq(int totalOccurance, HashMap<String, Integer> wordsFreq){

        return wordsFreq.entrySet().stream()
                .collect(Collectors.toMap(key-> key.getKey(), val->
                                Double.valueOf(val.getValue())/ Double.valueOf(totalOccurance)
                        ,(v1,v2)-> v1, TreeMap::new));
    }
    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
    private static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        if(end > words.length) return "";
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }
}
