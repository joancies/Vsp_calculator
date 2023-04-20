import joancies.vsp_calc_2.vsp_calc_2.SpeedCalculationTO;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SpeedCalculationTOTest {

    private final SpeedCalculationTO speedCalculationTO_1 = new SpeedCalculationTO(5,20,18000,1000);

    @Test
    void i_test_weight_18000(){
        assertEquals(0, speedCalculationTO_1.getI());
    }
    @Test
    void j_test_alt_1000(){
        assertEquals(0, speedCalculationTO_1.getJ());
    }
    @Test
    void vfri_test_weight_18000_flaps_5(){
        assertEquals(116, speedCalculationTO_1.getVfri());
    }
    @Test
    void vclmb_test_weight_18000(){
        assertEquals(130, speedCalculationTO_1.getVclmb());
    }
    @Test
    void v1_speed_test_weight_18000_temp_20_alt_1000_flaps_5(){
        assertEquals(102, speedCalculationTO_1.calculateV1());
    }
    @Test
    void v2_speed_test_weight_18000_temp_20_alt_1000_flaps_5(){
        assertEquals(116, speedCalculationTO_1.calculateV2());
    }
    @Test
    void vr_speed_test_weight_18000_temp_20_alt_1000_flaps_5(){assertEquals(108, speedCalculationTO_1.calculateVr());}



    private final SpeedCalculationTO speedCalculationTO_2 = new SpeedCalculationTO(5,21,20000,3000);

    @Test
    void i_test_weight_20000(){
        assertEquals(1, speedCalculationTO_2.getI());
    }
    @Test
    void j_test_alt_3000(){
        assertEquals(1, speedCalculationTO_2.getJ());
    }
    @Test
    void vfri_test_weight_20000_flaps_5(){
        assertEquals(120, speedCalculationTO_2.getVfri());
    }
    @Test
    void vclmb_test_weight_20000(){
        assertEquals(131, speedCalculationTO_2.getVclmb());
    }

    @Test
    void v1_speed_test_weight_20000_temp_21_alt_3000_flaps_5(){
        assertEquals(108, speedCalculationTO_2.calculateV1());
    }
    @Test
    void v2_speed_test_weight_20000_temp_21_alt_3000_flaps_5(){
        assertEquals(112, speedCalculationTO_2.calculateV2());
    }
    @Test
    void vr_speed_test_weight_20000_temp_21_alt_3000_flaps_5(){assertEquals(108, speedCalculationTO_2.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_3 = new SpeedCalculationTO(10,20,22000,5000,60,90,10);

    @Test
    void i_test_weight_22000(){
        assertEquals(2, speedCalculationTO_3.getI());
    }
    @Test
    void j_test_alt_5000(){
        assertEquals(2, speedCalculationTO_3.getJ());
    }
    @Test
    void vfri_test_weight_22000_flaps_10(){
        assertEquals(118, speedCalculationTO_3.getVfri());
    }
    @Test
    void vclmb_test_weight_22000(){
        assertEquals(137, speedCalculationTO_3.getVclmb());
    }

    @Test
    void v1_speed_test_weight_22000_temp_20_alt_5000_flaps_10_wetrunway(){
        assertEquals(98, speedCalculationTO_3.calculateV1());
    }
    @Test
    void v2_speed_test_weight_22000_temp_20_alt_5000_flaps_10_wetrunway(){
        assertEquals(108, speedCalculationTO_3.calculateV2());
    }
    @Test
    void vr_speed_test_weight_22000_temp_20_alt_5000_flaps_10_wetrunway(){assertEquals(105, speedCalculationTO_3.calculateVr());}


    private final SpeedCalculationTO speedCalculationTO_4 = new SpeedCalculationTO(10,21,24000,7000,180,40,3);

    @Test
    void i_test_weight_25000(){
        assertEquals(3, speedCalculationTO_4.getI());
    }
    @Test
    void j_test_alt_7000(){
        assertEquals(3, speedCalculationTO_4.getJ());
    }
    @Test
    void vfri_test_weight_24000_flaps_10(){
        assertEquals(123, speedCalculationTO_4.getVfri());
    }
    @Test
    void vclmb_test_weight_24000(){
        assertEquals(143, speedCalculationTO_4.getVclmb());
    }

    @Test
    void v1_speed_test_weight_24000_temp_21_alt_7000_flaps_10_wetrunway(){
        assertEquals(103.41, speedCalculationTO_4.calculateV1());
    }
    @Test
    void v2_speed_test_weight_24000_temp_21_alt_7000_flaps_10_wetrunway(){
        assertEquals(113, speedCalculationTO_4.calculateV2());
    }
    @Test
    void vr_speed_test_weight_24000_temp_21_alt_7000_flaps_10_wetrunway(){assertEquals(112, speedCalculationTO_4.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_5 = new SpeedCalculationTO(15,20,26000,9000,300,10,6);

    @Test
    void i_test_weight_26000(){
        assertEquals(4, speedCalculationTO_5.getI());
    }
    @Test
    void j_test_alt_9000(){
        assertEquals(4, speedCalculationTO_5.getJ());
    }
    @Test
    void vfri_test_weight_26000_flaps_15(){
        assertEquals(125, speedCalculationTO_5.getVfri());
    }
    @Test
    void vclmb_test_weight_26000(){
        assertEquals(148, speedCalculationTO_5.getVclmb());
    }

    @Test
    void v1_speed_test_weight_26000_temp_20_alt_9000_flaps_15_wetrunway(){
        assertEquals(106.20, speedCalculationTO_5.calculateV1());
    }
    @Test
    void v2_speed_test_weight_26000_temp_20_alt_9000_flaps_15_wetrunway(){
        assertEquals(114, speedCalculationTO_5.calculateV2());
    }
    @Test
    void vr_speed_test_weight_26000_temp_20_alt_9000_flaps_15_wetrunway(){assertEquals(114, speedCalculationTO_5.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_6 = new SpeedCalculationTO(15,21,28000,9001,10,250,3);

    @Test
    void i_test_weight_28000(){
        assertEquals(5, speedCalculationTO_6.getI());
    }
    @Test
    void j_test_alt_9001(){
        assertEquals(5, speedCalculationTO_6.getJ());
    }
    @Test
    void vfri_test_weight_28000_flaps_15(){
        assertEquals(130, speedCalculationTO_6.getVfri());
    }
    @Test
    void vclmb_test_weight_28000(){
        assertEquals(154, speedCalculationTO_6.getVclmb());
    }

    @Test
    void v1_speed_test_weight_28000_temp_21_alt_9001_flaps_15_wetrunway(){
        assertEquals(111.41, speedCalculationTO_6.calculateV1());
    }
    @Test
    void v2_speed_test_weight_28000_temp_21_alt_9001_flaps_15_wetrunway(){
        assertEquals(120, speedCalculationTO_6.calculateV2());
    }
    @Test
    void vr_speed_test_weight_28000_temp_21_alt_9001_flaps_15_wetrunway(){assertEquals(120, speedCalculationTO_6.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_7 = new SpeedCalculationTO(5,20,28001,0,10,161,10);

    @Test
    void i_test_weight_28001(){
        assertEquals(6, speedCalculationTO_7.getI());
    }
    @Test
    void j_test_alt_0(){
        assertEquals(0, speedCalculationTO_7.getJ());
    }
    @Test
    void vfri_test_weight_28001_flaps_5(){
        assertEquals(146, speedCalculationTO_7.getVfri());
    }
    @Test
    void vclmb_test_weight_28001(){
        assertEquals(158, speedCalculationTO_7.getVclmb());
    }

    @Test
    void v1_speed_test_weight_28001_temp_20_alt_0_flaps_5_wetrunway(){
        assertEquals(122, speedCalculationTO_7.calculateV1());
    }
    @Test
    void v2_speed_test_weight_28001_temp_20_alt_0_flaps_5_wetrunway(){
        assertEquals(135, speedCalculationTO_7.calculateV2());
    }
    @Test
    void vr_speed_test_weight_28001_temp_20_alt_0_flaps_5_wetrunway(){assertEquals(133, speedCalculationTO_7.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_8 = new SpeedCalculationTO(10,21,18000,0);

    @Test
    void vr_speed_test_weight_18000_temp_21_alt_0_flaps_10(){assertEquals(104, speedCalculationTO_8.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_9 = new SpeedCalculationTO(15,21,18000,0);

    @Test
    void vr_speed_test_weight_18000_temp_21_alt_0_flaps_15(){assertEquals(100, speedCalculationTO_9.calculateVr());}

    private final SpeedCalculationTO speedCalculationTO_10 = new SpeedCalculationTO(10,21,18000,0,29,330,1);

    @Test
    void v1_speed_test_weight_18000_temp_21_alt_0_flaps_10_wetruway(){assertEquals(96, speedCalculationTO_10.calculateV1());}

    private final SpeedCalculationTO speedCalculationTO_11 = new SpeedCalculationTO(5,21,18000,0,29,120,1);

    @Test
    void v1_speed_test_weight_18000_temp_21_alt_0_flaps_5_wetruway(){assertEquals(97, speedCalculationTO_11.calculateV1());}

}