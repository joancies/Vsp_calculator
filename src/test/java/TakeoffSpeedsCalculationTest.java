import joancies.vsp_calc_2.vsp_calc_2.TakeoffSpeedsCalculation;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TakeoffSpeedsCalculationTest {

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_1 = new TakeoffSpeedsCalculation(5,20,18000,1000);

    @Test
    void i_test_weight_18000(){
        assertEquals(0, takeoffSpeedsCalculation_1.getI());
    }
    @Test
    void j_test_alt_1000(){
        assertEquals(0, takeoffSpeedsCalculation_1.getJ());
    }
    @Test
    void vfri_test_weight_18000_flaps_5(){
        assertEquals(116, takeoffSpeedsCalculation_1.getVfri());
    }
    @Test
    void vclmb_test_weight_18000(){
        assertEquals(130, takeoffSpeedsCalculation_1.getVclmb());
    }
    @Test
    void v1_speed_test_weight_18000_temp_20_alt_1000_flaps_5(){
        assertEquals(102, takeoffSpeedsCalculation_1.calculateV1());
    }
    @Test
    void v2_speed_test_weight_18000_temp_20_alt_1000_flaps_5(){
        assertEquals(116, takeoffSpeedsCalculation_1.calculateV2());
    }
    @Test
    void vr_speed_test_weight_18000_temp_20_alt_1000_flaps_5(){assertEquals(108, takeoffSpeedsCalculation_1.calculateVr());}



    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_2 = new TakeoffSpeedsCalculation(5,21,20000,3000);

    @Test
    void i_test_weight_20000(){
        assertEquals(1, takeoffSpeedsCalculation_2.getI());
    }
    @Test
    void j_test_alt_3000(){
        assertEquals(1, takeoffSpeedsCalculation_2.getJ());
    }
    @Test
    void vfri_test_weight_20000_flaps_5(){
        assertEquals(120, takeoffSpeedsCalculation_2.getVfri());
    }
    @Test
    void vclmb_test_weight_20000(){
        assertEquals(131, takeoffSpeedsCalculation_2.getVclmb());
    }

    @Test
    void v1_speed_test_weight_20000_temp_21_alt_3000_flaps_5(){
        assertEquals(108, takeoffSpeedsCalculation_2.calculateV1());
    }
    @Test
    void v2_speed_test_weight_20000_temp_21_alt_3000_flaps_5(){
        assertEquals(112, takeoffSpeedsCalculation_2.calculateV2());
    }
    @Test
    void vr_speed_test_weight_20000_temp_21_alt_3000_flaps_5(){assertEquals(108, takeoffSpeedsCalculation_2.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_3 = new TakeoffSpeedsCalculation(10,20,22000,5000,60,90,10);

    @Test
    void i_test_weight_22000(){
        assertEquals(2, takeoffSpeedsCalculation_3.getI());
    }
    @Test
    void j_test_alt_5000(){
        assertEquals(2, takeoffSpeedsCalculation_3.getJ());
    }
    @Test
    void vfri_test_weight_22000_flaps_10(){
        assertEquals(118, takeoffSpeedsCalculation_3.getVfri());
    }
    @Test
    void vclmb_test_weight_22000(){
        assertEquals(137, takeoffSpeedsCalculation_3.getVclmb());
    }

    @Test
    void v1_speed_test_weight_22000_temp_20_alt_5000_flaps_10_wetrunway(){
        assertEquals(98, takeoffSpeedsCalculation_3.calculateV1());
    }
    @Test
    void v2_speed_test_weight_22000_temp_20_alt_5000_flaps_10_wetrunway(){
        assertEquals(108, takeoffSpeedsCalculation_3.calculateV2());
    }
    @Test
    void vr_speed_test_weight_22000_temp_20_alt_5000_flaps_10_wetrunway(){assertEquals(105, takeoffSpeedsCalculation_3.calculateVr());}


    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_4 = new TakeoffSpeedsCalculation(10,21,24000,7000,180,40,3);

    @Test
    void i_test_weight_25000(){
        assertEquals(3, takeoffSpeedsCalculation_4.getI());
    }
    @Test
    void j_test_alt_7000(){
        assertEquals(3, takeoffSpeedsCalculation_4.getJ());
    }
    @Test
    void vfri_test_weight_24000_flaps_10(){
        assertEquals(123, takeoffSpeedsCalculation_4.getVfri());
    }
    @Test
    void vclmb_test_weight_24000(){
        assertEquals(143, takeoffSpeedsCalculation_4.getVclmb());
    }

    @Test
    void v1_speed_test_weight_24000_temp_21_alt_7000_flaps_10_wetrunway(){
        assertEquals(103.41, takeoffSpeedsCalculation_4.calculateV1());
    }
    @Test
    void v2_speed_test_weight_24000_temp_21_alt_7000_flaps_10_wetrunway(){
        assertEquals(113, takeoffSpeedsCalculation_4.calculateV2());
    }
    @Test
    void vr_speed_test_weight_24000_temp_21_alt_7000_flaps_10_wetrunway(){assertEquals(112, takeoffSpeedsCalculation_4.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_5 = new TakeoffSpeedsCalculation(15,20,26000,9000,300,10,6);

    @Test
    void i_test_weight_26000(){
        assertEquals(4, takeoffSpeedsCalculation_5.getI());
    }
    @Test
    void j_test_alt_9000(){
        assertEquals(4, takeoffSpeedsCalculation_5.getJ());
    }
    @Test
    void vfri_test_weight_26000_flaps_15(){
        assertEquals(125, takeoffSpeedsCalculation_5.getVfri());
    }
    @Test
    void vclmb_test_weight_26000(){
        assertEquals(148, takeoffSpeedsCalculation_5.getVclmb());
    }

    @Test
    void v1_speed_test_weight_26000_temp_20_alt_9000_flaps_15_wetrunway(){
        assertEquals(106.20, takeoffSpeedsCalculation_5.calculateV1());
    }
    @Test
    void v2_speed_test_weight_26000_temp_20_alt_9000_flaps_15_wetrunway(){
        assertEquals(114, takeoffSpeedsCalculation_5.calculateV2());
    }
    @Test
    void vr_speed_test_weight_26000_temp_20_alt_9000_flaps_15_wetrunway(){assertEquals(114, takeoffSpeedsCalculation_5.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_6 = new TakeoffSpeedsCalculation(15,21,28000,9001,10,250,3);

    @Test
    void i_test_weight_28000(){
        assertEquals(5, takeoffSpeedsCalculation_6.getI());
    }
    @Test
    void j_test_alt_9001(){
        assertEquals(5, takeoffSpeedsCalculation_6.getJ());
    }
    @Test
    void vfri_test_weight_28000_flaps_15(){
        assertEquals(130, takeoffSpeedsCalculation_6.getVfri());
    }
    @Test
    void vclmb_test_weight_28000(){
        assertEquals(154, takeoffSpeedsCalculation_6.getVclmb());
    }

    @Test
    void v1_speed_test_weight_28000_temp_21_alt_9001_flaps_15_wetrunway(){
        assertEquals(111.41, takeoffSpeedsCalculation_6.calculateV1());
    }
    @Test
    void v2_speed_test_weight_28000_temp_21_alt_9001_flaps_15_wetrunway(){
        assertEquals(120, takeoffSpeedsCalculation_6.calculateV2());
    }
    @Test
    void vr_speed_test_weight_28000_temp_21_alt_9001_flaps_15_wetrunway(){assertEquals(120, takeoffSpeedsCalculation_6.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_7 = new TakeoffSpeedsCalculation(5,20,28001,0,10,161,10);

    @Test
    void i_test_weight_28001(){
        assertEquals(6, takeoffSpeedsCalculation_7.getI());
    }
    @Test
    void j_test_alt_0(){
        assertEquals(0, takeoffSpeedsCalculation_7.getJ());
    }
    @Test
    void vfri_test_weight_28001_flaps_5(){
        assertEquals(146, takeoffSpeedsCalculation_7.getVfri());
    }
    @Test
    void vclmb_test_weight_28001(){
        assertEquals(158, takeoffSpeedsCalculation_7.getVclmb());
    }

    @Test
    void v1_speed_test_weight_28001_temp_20_alt_0_flaps_5_wetrunway(){
        assertEquals(122, takeoffSpeedsCalculation_7.calculateV1());
    }
    @Test
    void v2_speed_test_weight_28001_temp_20_alt_0_flaps_5_wetrunway(){
        assertEquals(135, takeoffSpeedsCalculation_7.calculateV2());
    }
    @Test
    void vr_speed_test_weight_28001_temp_20_alt_0_flaps_5_wetrunway(){assertEquals(133, takeoffSpeedsCalculation_7.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_8 = new TakeoffSpeedsCalculation(10,21,18000,0);

    @Test
    void vr_speed_test_weight_18000_temp_21_alt_0_flaps_10(){assertEquals(104, takeoffSpeedsCalculation_8.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_9 = new TakeoffSpeedsCalculation(15,21,18000,0);

    @Test
    void vr_speed_test_weight_18000_temp_21_alt_0_flaps_15(){assertEquals(100, takeoffSpeedsCalculation_9.calculateVr());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_10 = new TakeoffSpeedsCalculation(10,21,18000,0,29,330,1);

    @Test
    void v1_speed_test_weight_18000_temp_21_alt_0_flaps_10_wetruway(){assertEquals(96, takeoffSpeedsCalculation_10.calculateV1());}

    private final TakeoffSpeedsCalculation takeoffSpeedsCalculation_11 = new TakeoffSpeedsCalculation(5,21,18000,0,29,120,1);

    @Test
    void v1_speed_test_weight_18000_temp_21_alt_0_flaps_5_wetruway(){assertEquals(97, takeoffSpeedsCalculation_11.calculateV1());}

}