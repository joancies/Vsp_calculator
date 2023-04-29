import joancies.vsp_calc_2.vsp_calc_2.LandingSpeedsCalculation;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LandingSpeedsCalculationTest {

    private final LandingSpeedsCalculation landingSpeedsCalculation_1 = new LandingSpeedsCalculation(5,8000,10000);
    @Test
    void landingweight_test_zerofuel_10000_landingfuel_800(){
        assertEquals(18000, landingSpeedsCalculation_1.getLandingWeight());
    }
    @Test
    void vapp_test_weight_18000_flaps_5(){
        assertEquals(115, landingSpeedsCalculation_1.getVapp());
    }
    @Test
    void vref_test_weight_18000_flaps_5(){
        assertEquals(115, landingSpeedsCalculation_1.getVref());
    }
    @Test
    void vga_test_weight_18000_flaps_5(){
        assertEquals(109, landingSpeedsCalculation_1.getVga());
    }
    @Test
    void i_test_weight_18000(){
        assertEquals(0, landingSpeedsCalculation_1.getI());
    }

    private final LandingSpeedsCalculation landingSpeedsCalculation_2 = new LandingSpeedsCalculation(10,10000,10000);

    @Test
    void vapp_test_weight_20000_flaps_10(){
        assertEquals(112, landingSpeedsCalculation_2.getVapp());
    }
    @Test
    void vref_test_weight_20000_flaps_10(){
        assertEquals(112, landingSpeedsCalculation_2.getVref());
    }
    @Test
    void vga_test_weight_20000_flaps_10(){
        assertEquals(108, landingSpeedsCalculation_2.getVga());
    }
    @Test
    void i_test_weight_20000(){
        assertEquals(1, landingSpeedsCalculation_2.getI());
    }

    private final LandingSpeedsCalculation landingSpeedsCalculation_3 = new LandingSpeedsCalculation(15,2000,20000);

    @Test
    void vapp_test_weight_22000_flaps_15(){
        assertEquals(112, landingSpeedsCalculation_3.getVapp());
    }
    @Test
    void vref_test_weight_22000_flaps_15(){
        assertEquals(112, landingSpeedsCalculation_3.getVref());
    }
    @Test
    void vga_test_weight_22000_flaps_15(){
        assertEquals(105, landingSpeedsCalculation_3.getVga());
    }
    @Test
    void i_test_weight_22000(){
        assertEquals(2, landingSpeedsCalculation_3.getI());
    }

    private final LandingSpeedsCalculation landingSpeedsCalculation_4 = new LandingSpeedsCalculation(35,4000,20000);

    @Test
    void vapp_test_weight_24000_flaps_35(){
        assertEquals(112, landingSpeedsCalculation_4.getVapp());
    }
    @Test
    void vref_test_weight_24000_flaps_35(){
        assertEquals(112, landingSpeedsCalculation_4.getVref());
    }
    @Test
    void vga_test_weight_24000_flaps_35(){
        assertEquals(112, landingSpeedsCalculation_4.getVga());
    }
    @Test
    void i_test_weight_24000(){
        assertEquals(3, landingSpeedsCalculation_4.getI());
    }

    private final LandingSpeedsCalculation landingSpeedsCalculation_5 = new LandingSpeedsCalculation(5,6000,20000);

    @Test
    void vapp_test_weight_26000_flaps_5(){
        assertEquals(137, landingSpeedsCalculation_5.getVapp());
    }
    @Test
    void vref_test_weight_26000_flaps_5(){
        assertEquals(137, landingSpeedsCalculation_5.getVref());
    }
    @Test
    void vga_test_weight_26000_flaps_5(){
        assertEquals(125, landingSpeedsCalculation_5.getVga());
    }
    @Test
    void i_test_weight_26000(){
        assertEquals(4, landingSpeedsCalculation_5.getI());
    }

    private final LandingSpeedsCalculation landingSpeedsCalculation_6 = new LandingSpeedsCalculation(10,8000,20000);

    @Test
    void vapp_test_weight_28000_flaps_10(){
        assertEquals(132, landingSpeedsCalculation_6.getVapp());
    }
    @Test
    void vref_test_weight_28000_flaps_10(){
        assertEquals(132, landingSpeedsCalculation_6.getVref());
    }
    @Test
    void vga_test_weight_28000_flaps_10(){
        assertEquals(122, landingSpeedsCalculation_6.getVga());
    }
    @Test
    void i_test_weight_28000(){
        assertEquals(5, landingSpeedsCalculation_6.getI());
    }

    private final LandingSpeedsCalculation landingSpeedsCalculation_7 = new LandingSpeedsCalculation(35,8001,20000);

    @Test
    void vapp_test_weight_28001_flaps_35(){
        assertEquals(123, landingSpeedsCalculation_7.getVapp());
    }
    @Test
    void vref_test_weight_28001_flaps_35(){
        assertEquals(123, landingSpeedsCalculation_7.getVref());
    }
    @Test
    void vga_test_weight_28001_flaps_35(){
        assertEquals(123, landingSpeedsCalculation_7.getVga());
    }
    @Test
    void i_test_weight_28001(){
        assertEquals(6, landingSpeedsCalculation_7.getI());
    }


}