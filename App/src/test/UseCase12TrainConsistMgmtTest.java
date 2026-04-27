import main.UseCase12TrainConsistMgmt;
import main.UseCase12TrainConsistMgmt.GoodsBogie;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    private final UseCase12TrainConsistMgmt uc12 = new UseCase12TrainConsistMgmt();

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain")
        );
        assertTrue(uc12.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertFalse(uc12.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain")
        );
        assertTrue(uc12.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Open", "Grain")
        );
        assertFalse(uc12.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(uc12.isTrainSafetyCompliant(bogies));
    }
}