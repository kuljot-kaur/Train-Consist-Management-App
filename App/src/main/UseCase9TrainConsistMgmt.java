package main;

import java.util.*;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmt {

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
    }

    // UC9 logic: group bogies by type (name)
    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogieList) {
        return bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }
}