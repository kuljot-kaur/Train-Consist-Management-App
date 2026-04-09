package main;

import java.util.List;

public class UseCase10TrainConsistMgmt {

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
     * Calculates total seating capacity of all bogies by summing capacities using reduce().
     * @param bogies List of bogies
     * @return total seating capacity
     */
    public int calculateTotalSeatingCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }
}