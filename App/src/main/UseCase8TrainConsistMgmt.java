package main;

import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmt {

    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return "Bogie{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }

    /**
     * Filters bogies whose seating capacity is greater than the given threshold.
     * @param bogies list of bogies to filter
     * @param capacityThreshold capacity threshold for filtering (exclusive)
     * @return filtered list of bogies
     */
    public List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int capacityThreshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > capacityThreshold)
                .collect(Collectors.toList());
    }
}