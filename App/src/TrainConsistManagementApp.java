package main;

import java.util.List;

public class UseCase12TrainConsistMgmt {

    public static class GoodsBogie {
        private final String type;
        private final String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }
    }

    /**
     * Checks if all goods bogies comply with safety rules:
     * Cylindrical bogies can only carry "Petroleum".
     * Other bogie types have no cargo restriction.
     * @param bogies list of goods bogies
     * @return true if safe, false otherwise
     */
    public boolean isTrainSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(bogie -> {
                    if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                        return "Petroleum".equalsIgnoreCase(bogie.getCargo());
                    }
                    return true; // no restriction for other types
                });
    }
}