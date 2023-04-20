import joancies.vsp_calc_2.vsp_calc_2.SpeedCalculationL;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SpeedCalculationLTest {

    private final SpeedCalculationL speedCalculationL_1= new SpeedCalculationL(5,8000,10000);
    @Test
    void landingweight_test_zerofuel_10000_landingfuel_800(){
        assertEquals(18000, speedCalculationL_1.getLandingWeight());
    }
    @Test
    void vapp_test_weight_18000_flaps_5(){
        assertEquals(115, speedCalculationL_1.getVapp());
    }
    @Test
    void vref_test_weight_18000_flaps_5(){
        assertEquals(115, speedCalculationL_1.getVref());
    }
    @Test
    void vga_test_weight_18000_flaps_5(){
        assertEquals(109, speedCalculationL_1.getVga());
    }
    @Test
    void i_test_weight_18000(){
        assertEquals(0, speedCalculationL_1.getI());
    }

    private final SpeedCalculationL speedCalculationL_2= new SpeedCalculationL(10,10000,10000);

    @Test
    void vapp_test_weight_20000_flaps_10(){
        assertEquals(112, speedCalculationL_2.getVapp());
    }
    @Test
    void vref_test_weight_20000_flaps_10(){
        assertEquals(112, speedCalculationL_2.getVref());
    }
    @Test
    void vga_test_weight_20000_flaps_10(){
        assertEquals(108, speedCalculationL_2.getVga());
    }
    @Test
    void i_test_weight_20000(){
        assertEquals(1, speedCalculationL_2.getI());
    }

    private final SpeedCalculationL speedCalculationL_3= new SpeedCalculationL(15,2000,20000);

    @Test
    void vapp_test_weight_22000_flaps_15(){
        assertEquals(112, speedCalculationL_3.getVapp());
    }
    @Test
    void vref_test_weight_22000_flaps_15(){
        assertEquals(112, speedCalculationL_3.getVref());
    }
    @Test
    void vga_test_weight_22000_flaps_15(){
        assertEquals(105, speedCalculationL_3.getVga());
    }
    @Test
    void i_test_weight_22000(){
        assertEquals(2, speedCalculationL_3.getI());
    }

    private final SpeedCalculationL speedCalculationL_4= new SpeedCalculationL(35,4000,20000);

    @Test
    void vapp_test_weight_24000_flaps_35(){
        assertEquals(112, speedCalculationL_4.getVapp());
    }
    @Test
    void vref_test_weight_24000_flaps_35(){
        assertEquals(112, speedCalculationL_4.getVref());
    }
    @Test
    void vga_test_weight_24000_flaps_35(){
        assertEquals(112, speedCalculationL_4.getVga());
    }
    @Test
    void i_test_weight_24000(){
        assertEquals(3, speedCalculationL_4.getI());
    }

    private final SpeedCalculationL speedCalculationL_5= new SpeedCalculationL(5,6000,20000);

    @Test
    void vapp_test_weight_26000_flaps_5(){
        assertEquals(137, speedCalculationL_5.getVapp());
    }
    @Test
    void vref_test_weight_26000_flaps_5(){
        assertEquals(137, speedCalculationL_5.getVref());
    }
    @Test
    void vga_test_weight_26000_flaps_5(){
        assertEquals(125, speedCalculationL_5.getVga());
    }
    @Test
    void i_test_weight_26000(){
        assertEquals(4, speedCalculationL_5.getI());
    }

    private final SpeedCalculationL speedCalculationL_6= new SpeedCalculationL(10,8000,20000);

    @Test
    void vapp_test_weight_28000_flaps_10(){
        assertEquals(132, speedCalculationL_6.getVapp());
    }
    @Test
    void vref_test_weight_28000_flaps_10(){
        assertEquals(132, speedCalculationL_6.getVref());
    }
    @Test
    void vga_test_weight_28000_flaps_10(){
        assertEquals(122, speedCalculationL_6.getVga());
    }
    @Test
    void i_test_weight_28000(){
        assertEquals(5, speedCalculationL_6.getI());
    }

    private final SpeedCalculationL speedCalculationL_7= new SpeedCalculationL(35,8001,20000);

    @Test
    void vapp_test_weight_28001_flaps_35(){
        assertEquals(123, speedCalculationL_7.getVapp());
    }
    @Test
    void vref_test_weight_28001_flaps_35(){
        assertEquals(123, speedCalculationL_7.getVref());
    }
    @Test
    void vga_test_weight_28001_flaps_35(){
        assertEquals(123, speedCalculationL_7.getVga());
    }
    @Test
    void i_test_weight_28001(){
        assertEquals(6, speedCalculationL_7.getI());
    }


}