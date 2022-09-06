package de.densk.guava.aufg1;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;

import java.util.List;
import java.util.stream.Collectors;

public class MultimapExamples {
    private static void treeListMultimap() { // keys werden sortiert, werte nicht, duplikate erlaubt
        final ListMultimap<String, Integer> treeListMultimap =
                MultimapBuilder.treeKeys().arrayListValues().build();

        treeListMultimap.put("k1", 1);
        treeListMultimap.put("k2", 2);
        treeListMultimap.put("k1", 3);
        treeListMultimap.put("k1", 1);
        treeListMultimap.put("k6", 4);
        treeListMultimap.put("k6", 4);
        treeListMultimap.put("k5", 5);

        System.out.println(treeListMultimap);
    }

    private static void hashListMultimap() { // keys werden sortiert, werte nicht, duplikate erlaubt
        final ListMultimap<String, Integer> hashListMultimap =
                MultimapBuilder.hashKeys().arrayListValues().build();

        hashListMultimap.put("k1", 1);
        hashListMultimap.put("k2", 2);
        hashListMultimap.put("k1", 3);
        hashListMultimap.put("k1", 1);
        hashListMultimap.put("k6", 4);
        hashListMultimap.put("k6", 4);
        hashListMultimap.put("k5", 5);

        System.out.println(hashListMultimap);

        List<Integer> k1 = hashListMultimap.get("k1");
        System.out.println(k1.stream().map(v -> v + "").collect(Collectors.joining(", ")));
    }

    private static void treeSetMultimap() { // keys werden sortiert, werte nicht, duplikate erlaubt
        final SortedSetMultimap<String, Integer> treeSetMultimap =
                MultimapBuilder.treeKeys().treeSetValues().build();

        treeSetMultimap.put("k1", 3);
        treeSetMultimap.put("k2", 2);
        treeSetMultimap.put("k1", 1);
        treeSetMultimap.put("k1", 1);
        treeSetMultimap.put("k6", 4);
        treeSetMultimap.put("k6", 4);
        treeSetMultimap.put("k5", 5);

        System.out.println(treeSetMultimap);
    }

    private static void hashSetEnumMultimap() { // keys werden sortiert, werte auch (keine garantie), keine duplikate
        SetMultimap<String, MyEnum> hashSetEnumMultimap =
                MultimapBuilder.hashKeys().enumSetValues(MyEnum.class).build();

        hashSetEnumMultimap.put("k1", MyEnum.ENUM_HELLO);
        hashSetEnumMultimap.put("k2", MyEnum.ENUM_WORLD);
        hashSetEnumMultimap.put("k1", MyEnum.ENUM_HELLO);
        hashSetEnumMultimap.put("k6", MyEnum.ENUM_WORLD);
        hashSetEnumMultimap.put("k6", MyEnum.ENUM_HELLO);
        hashSetEnumMultimap.put("k5", MyEnum.ENUM_WORLD);

        System.out.println(hashSetEnumMultimap);
    }

    public static void run() {
        System.out.println("Multimap Examples:");
        treeListMultimap();
        System.out.println();
        hashListMultimap();
        System.out.println();
        treeSetMultimap();
        System.out.println();
        hashSetEnumMultimap();
        System.out.println();
    }
}
