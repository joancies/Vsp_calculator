package joancies.vsp_calc_2.vsp_calc_2;

public class SpeedCalculationL {

    int flapsL;
    int weight;
    int landingFuel;
    int zeroFuelWeight;




    int i;

    int[] vapp;
    int[] vref;
    int[] vga;



    final int[] f05Vapp= {115, 120, 126, 131, 137, 142, 146};
    final int[] f05Vga= {109, 110, 115, 120, 125, 130, 134};

    final int[] f10Vapp= {109, 112, 117, 122, 127, 132, 136};
    final int[] f10Vref= {108, 112, 117, 122, 127, 132, 136};
    final int[] f10Vga= {108, 108, 108, 112, 117, 122, 125};

    final int[] f15Vapp= {106, 106, 112, 117, 122, 126, 129};
    final int[] f15Vref= {105, 117, 112, 117, 121, 126, 129};
    final int[] f15Vga= {105, 105, 105, 107, 111, 116, 119};

    final int[] f35Vref= {101, 102, 107, 112, 116, 120, 123};

    public SpeedCalculationL(int flapsL, int landingFuel, int zeroFuelWeight) {

        this.flapsL = flapsL;
        this.landingFuel = landingFuel;
        this.zeroFuelWeight = zeroFuelWeight;
        weight= getLandingWeight();
        getI();
    }
    int landingWeight;

    public int getLandingWeight() {
        landingWeight = zeroFuelWeight + landingFuel;
        return landingWeight;
    }

    public int getI(){
        if(weight<= 18_000)
            i=0;
        else if(weight>18_000 && weight<=20_000 )
            i=1;
        else if(weight>20_000 && weight<=22_000 )
            i=2;
        else if(weight>22_000 && weight<=24_000 )
            i=3;
        else if(weight>24_000 && weight<=26_000 )
            i=4;
        else if(weight>26_000 && weight<=28_000 )
            i=5;
        else if(weight>28_000 )
            i=6;

        return i;
    }


    public int getVapp(){

        if(flapsL == 5)
            vapp = f05Vapp;
        else if(flapsL == 10)
            vapp = f10Vapp;
        else if(flapsL == 15)
            vapp = f15Vapp;
        else
            vapp = f35Vref;

        return vapp[i];
    }

    public int getVref(){

        if(flapsL == 5)
            vref = f05Vapp;
        else if(flapsL == 10)
            vref = f10Vref;
        else if(flapsL == 15)
            vref = f15Vref;
        else
            vref = f35Vref;

        return vref[i];
    }

    public int getVga(){

        if(flapsL == 5)
            vga = f05Vga;
        else if(flapsL == 10)
            vga = f10Vga;
        else if(flapsL == 15)
            vga = f15Vga;
        else
            vga = f35Vref;

        return vga[i];
    }


}

