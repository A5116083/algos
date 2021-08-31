package com.company.dynamic;

import java.util.*;
import java.util.stream.Collectors;

public class NumOfReportesOfManager {

    public static void main(String[] args) {

        String[][] empRelationShip = new String[][]
                {
                        { "A", "C" },
                        { "B", "C" },
                        { "C", "F" },
                        { "D", "E" },
                        { "E", "F" },
                        { "F", "F" }
                };

        Map<String, String> empManagerMap= buildMap(empRelationShip);
        Map<String, Integer> result = computeManager(empManagerMap);
        for(Map.Entry<String,Integer> kvp : result.entrySet()){

            System.out.println(kvp.getKey() + " :" + kvp.getValue());
        }


    }

    private static class Pair{
        private String key;
        private String value;

        private Pair(String key, String val){
            this.key = key;
            this.value= val;
        }
        private String getKey(){
            return this.key;
        }
        private String getValue(){
            return this.value;
        }
    }
    private static Map<String,String> buildMap(String[][] empRelArray){

        return Arrays.stream(empRelArray)
                .map(item-> new Pair(item[0], item[1]))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (newVal, oldVal)-> newVal));

    }

    private static Map<String, Integer> computeManager(Map<String,String> empMgrMap){
        Map<String, Integer> result= new HashMap<>();
        Map<String, List<String>> mgrEmpMap=  empMgrMap.entrySet().stream()
                .map(kvp-> new Pair(kvp.getValue(), kvp.getKey()))
                .filter(pair -> !pair.getKey().equals(pair.getValue()))
                .collect(Collectors.toMap(k-> k.getKey(), v-> Arrays.asList((String)v.getValue()),
                        (oldList,newList )->{
                    List<String> mergedList = new ArrayList();
                    mergedList.addAll(oldList);
                    mergedList.addAll(newList);
                    return mergedList;
                } ));

        for(Map.Entry<String,String> kvp:empMgrMap.entrySet()){

            String key= kvp.getKey();

            if(!mgrEmpMap.containsKey(key)){
                result.put(key, 0);
            }else{

                int count =mgrEmpMap.get(key).size();
                for(String emp:mgrEmpMap.get(key)){
                    if(mgrEmpMap.containsKey(emp)&& !emp.equals(key))
                        count+= mgrEmpMap.get(emp).size();
                }
                result.put(key, count);

            }
        }
        return result;
    }







}
