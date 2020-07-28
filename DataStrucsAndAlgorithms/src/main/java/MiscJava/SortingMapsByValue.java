package MiscJava;

import java.util.*;

public class SortingMapsByValue {

    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<String, Integer>();
        unsortedMap.put("LinkedLists", 10);
        unsortedMap.put("BST", 3);
        unsortedMap.put("Array", 90);

        Map<String, Integer> sortedCloud = sortMapByValue(unsortedMap, false);
        System.out.println(sortedCloud);

        sortedCloud = sortMapByValue(unsortedMap, true);
        System.out.println(sortedCloud);
    }

    public static Map<String, Integer> sortMapByValue(Map<String, Integer> map, boolean reversed) {

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        if (!reversed) {
            map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
            return sortedMap;
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;

    }
}