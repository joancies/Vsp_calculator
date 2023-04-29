package joancies.vsp_calc_2.vsp_calc_2;

public class LandingSpeedsCalculation {

    int landingFlapsSettings;
    int weight;
    int landingFuel;
    int zeroFuelWeight;




    int i;

    int[] vapp;
    int[] vref;
    int[] vga;



    final int[] vappValuesForFlaps05 = {115, 120, 126, 131, 137, 142, 146};
    final int[] vgaValuesForFlaps05 = {109, 110, 115, 120, 125, 130, 134};

    final int[] vappValuesForFlaps10 = {109, 112, 117, 122, 127, 132, 136};
    final int[] vrefValuesForFlaps10 = {108, 112, 117, 122, 127, 132, 136};
    final int[] vgaValuesForFlaps10 = {108, 108, 108, 112, 117, 122, 125};

    final int[] vappValuesForFlaps15 = {106, 106, 112, 117, 122, 126, 129};
    final int[] vrefValuesForFlaps15 = {105, 117, 112, 117, 121, 126, 129};
    final int[] vgaValuesForFlaps15 = {105, 105, 105, 107, 111, 116, 119};

    final int[] vrefValuesForFlaps35 = {101, 102, 107, 112, 116, 120, 123};

    public LandingSpeedsCalculation(int landingFlapsSettings, int landingFuel, int zeroFuelWeight) {

        this.landingFlapsSettings = landingFlapsSettings;
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

        if(landingFlapsSettings == 5)
            vapp = vappValuesForFlaps05;
        else if(landingFlapsSettings == 10)
            vapp = vappValuesForFlaps10;
        else if(landingFlapsSettings == 15)
            vapp = vappValuesForFlaps15;
        else
            vapp = vrefValuesForFlaps35;

        return vapp[i];
    }

    public int getVref(){

        if(landingFlapsSettings == 5)
            vref = vappValuesForFlaps05;
        else if(landingFlapsSettings == 10)
            vref = vrefValuesForFlaps10;
        else if(landingFlapsSettings == 15)
            vref = vrefValuesForFlaps15;
        else
            vref = vrefValuesForFlaps35;

        return vref[i];
    }

    public int getVga(){

        if(landingFlapsSettings == 5)
            vga = vgaValuesForFlaps05;
        else if(landingFlapsSettings == 10)
            vga = vgaValuesForFlaps10;
        else if(landingFlapsSettings == 15)
            vga = vgaValuesForFlaps15;
        else
            vga = vrefValuesForFlaps35;

        return vga[i];
    }


}

