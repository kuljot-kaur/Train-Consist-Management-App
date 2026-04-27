package main;

public class UseCase15SafeCargoAssignment {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie
    static class GoodsBogie {
        private String shape;
        private String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public String getShape() {
            return shape;
        }

        public String getCargo() {
            return cargo;
        }

        // Cargo assignment with try-catch-finally
        public void assignCargo(String cargoType) {

            try {
                // Unsafe condition
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargoType.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe: Petroleum cannot be loaded in Rectangular bogie"
                    );
                }

                // Safe assignment
                this.cargo = cargoType;
                System.out.println("Cargo assigned: " + cargoType);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo assignment attempt completed.");
            }
        }
    }

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe case
        b1.assignCargo("Petroleum");

        // Unsafe case (handled)
        b2.assignCargo("Petroleum");

        // Program continues
        b2.assignCargo("Grain");

        System.out.println("Program continues safely...");
    }
}