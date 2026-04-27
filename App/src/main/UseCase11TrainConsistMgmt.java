package main;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UseCase11TrainConsistMgmt {

    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    private final Pattern trainIdPattern;
    private final Pattern cargoCodePattern;

    public UseCase11TrainConsistMgmt() {
        trainIdPattern = Pattern.compile(TRAIN_ID_REGEX);
        cargoCodePattern = Pattern.compile(CARGO_CODE_REGEX);
    }

    /**
     * Validates Train ID format (e.g., TRN-1234).
     * @param trainId Train ID input string
     * @return true if valid, false otherwise
     */
    public boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = trainIdPattern.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates Cargo Code format (e.g., PET-AB).
     * @param cargoCode Cargo Code input string
     * @return true if valid, false otherwise
     */
    public boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = cargoCodePattern.matcher(cargoCode);
        return matcher.matches();
    }
}