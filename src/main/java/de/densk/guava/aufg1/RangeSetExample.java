package de.densk.guava.aufg1;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetExample {
    public static void run() {
        System.out.println("RangeSet Example");
        final RangeSet<Integer> rangeSet = TreeRangeSet.create();

        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        System.out.println(rangeSet);

/*        rangeSet.add(Range.open(1, 10)); // {[1, 10]}
        System.out.println(rangeSet);*/

        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        System.out.println(rangeSet);

        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        System.out.println(rangeSet);

        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        System.out.println(rangeSet);

        rangeSet.remove(Range.open(5, 10)); // splits [[1..5], [10..10], [11..20)]
        System.out.println(rangeSet);
        System.out.println();
    }
}
