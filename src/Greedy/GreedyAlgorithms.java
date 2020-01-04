package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithms {
    public static void main(String[] args){
        HashSet<String> set1=new HashSet<String>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        HashSet<String> set2=new HashSet<String>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        HashSet<String> set3=new HashSet<String>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        HashSet<String> set4=new HashSet<String>();
        set4.add("上海");
        set4.add("天津");
        HashSet<String> set5=new HashSet<String>();
        set5.add("杭州");
        set5.add("大连");
        HashMap<String,HashSet<String>> broadcasts=new HashMap<String, HashSet<String>>();
        broadcasts.put("K1",set1);
        broadcasts.put("K2",set2);
        broadcasts.put("K3",set3);
        broadcasts.put("K4",set4);
        broadcasts.put("K5",set5);
        HashSet<String> allAreas=new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        ArrayList<String> selects=new ArrayList<>();
        HashSet<String> tempSet=new HashSet<>();
        String maxKey=null;
        while(allAreas.size()!=0) {
            maxKey=null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas=broadcasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if(tempSet.size()>0&&(maxKey==null||broadcasts.get(maxKey).size()<tempSet.size())){
                    maxKey=key;
                }
                if(maxKey!=null){
                    selects.add(maxKey);
                    allAreas.removeAll(broadcasts.get(maxKey));
                }
            }
            System.out.println(selects);
        }
    }
}
