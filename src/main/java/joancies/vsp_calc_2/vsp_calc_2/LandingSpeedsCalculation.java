package joancies.vsp_calc_2.vsp_calc_2;

public class LandingSpeedsCalculation {

    int landingFlapsSettings;
    int weight;
    int landingFuel;
    int zeroFuelWeight;
    int i;
    int landingWeight;
    int[] vappChosenArray;
    int[] vrefChosenArray;
    int[] vgaChosenArray;

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
        i= getI();
    }
    public int getI(){
        weight = getLandingWeight();
        if(weight<= 18_000)
            return 0;
        else if(weight>18_000 && weight<=20_000 )
            return 1;
        else if(weight>20_000 && weight<=22_000 )
            return 2;
        else if(weight>22_000 && weight<=24_000 )
            return 3;
        else if(weight>24_000 && weight<=26_000 )
            return 4;
        else if(weight>26_000 && weight<=28_000 )
            return 5;
        else
            return 6;
    }
    public int getLandingWeight() {
        return zeroFuelWeight + landingFuel;
    }
    public int getVappChosenArray(){
        vappChosenArray = getVappValuesForFlapsSettings();
        return vappChosenArray[i];
    }
    public int[] getVappValuesForFlapsSettings(){
        if(landingFlapsSettings == 5)
            return vappValuesForFlaps05;
        else if(landingFlapsSettings == 10)
            return vappValuesForFlaps10;
        else if(landingFlapsSettings == 15)
            return vappValuesForFlaps15;
        else
            return vrefValuesForFlaps35;
    }
    public int getVrefChosenArray(){
        vrefChosenArray = getVrefValuesForFlapsSettings();
        return vrefChosenArray[i];
    }
    public int[] getVrefValuesForFlapsSettings(){

        if(landingFlapsSettings == 5)
            return vappValuesForFlaps05;
        else if(landingFlapsSettings == 10)
            return vrefValuesForFlaps10;
        else if(landingFlapsSettings == 15)
            return vrefValuesForFlaps15;
        else
            return vrefValuesForFlaps35;
    }

    public int getVgaChosenArray(){
        vgaChosenArray= getVgaValuesForFlapsSettings();
        return vgaChosenArray[i];
    }

    public int[] getVgaValuesForFlapsSettings(){
        if(landingFlapsSettings == 5)
            return vgaValuesForFlaps05;
        else if(landingFlapsSettings == 10)
            return vgaValuesForFlaps10;
        else if(landingFlapsSettings == 15)
            return vgaValuesForFlaps15;
        else
            return vrefValuesForFlaps35;
    }
}

