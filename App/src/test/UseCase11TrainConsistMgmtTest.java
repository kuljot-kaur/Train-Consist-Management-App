import main.UseCase11TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    private final UseCase11TrainConsistMgmt validator = new UseCase11TrainConsistMgmt();

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(validator.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(validator.validateTrainId("TRAIN12"));
        assertFalse(validator.validateTrainId("TRN12A"));
        assertFalse(validator.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(validator.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validator.validateCargoCode("PET-ab"));
        assertFalse(validator.validateCargoCode("PET123"));
        assertFalse(validator.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validator.validateTrainId("TRN-123"));
        assertFalse(validator.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validator.validateCargoCode("PET-Ab"));
        assertFalse(validator.validateCargoCode("PET-aB"));
        assertFalse(validator.validateCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(validator.validateTrainId(""));
        assertFalse(validator.validateCargoCode(""));
        assertFalse(validator.validateTrainId(null));
        assertFalse(validator.validateCargoCode(null));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(validator.validateTrainId("TRN-1234X")); // extra char
        assertFalse(validator.validateCargoCode("PET-ABCD")); // too many chars
        assertFalse(validator.validateTrainId("XTRN-1234")); // extra char at start
        assertFalse(validator.validateCargoCode("XPET-AB")); // extra char at start
    }
}