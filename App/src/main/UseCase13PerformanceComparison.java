package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13PerformanceComparison {

    // Bogie class
    static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Large dataset
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Bogie-" + i, i % 100));
        }

        // Loop timing
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long loopEnd = System.nanoTime();

        // Stream timing
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long streamEnd = System.nanoTime();

        // Output
        System.out.println("Loop Count   : " + loopResult.size());
        System.out.println("Stream Count : " + streamResult.size());

        System.out.println("Loop Time (ns)   : " + (loopEnd - loopStart));
        System.out.println("Stream Time (ns) : " + (streamEnd - streamStart));

        System.out.println("Results Match: " + (loopResult.size() == streamResult.size()));
    }
}