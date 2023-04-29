package joancies.vsp_calc_2.vsp_calc_2;

public class TakeoffSpeedsCalculation {

    private boolean wetRunway;
    private int takeoffFlapsSettings;
    private int temperature;
    private int weight;
    
    private int altitude;
    private int windDegree;
    private int runwayDegree;
    private int windSpeed;

    private int vr;
    private int v2;

    private double v1;

    private  int i;
    private int j;

    private int[][] vrArray;
    private int[][] v2Array;
    private int[] vFri;


    private double windSpeedValue;
    private boolean headWind;
    private int degreeDifference;





    private int[][] vrValuesForFlaps05TemperatureBelow20C = {
            {102, 102, 102, 102, 102, 103},
            {105, 106, 107, 107, 108, 110},
            {112, 113, 113, 114, 115, 116},
            {118, 119, 120, 120, 121, 122},
            {124, 125, 126, 126, 127, 128},
            {130, 131, 131, 132, 133, 134},
            {133, 134, 135, 136, 137, 138}
    };
    private int[][] vrValuesForFlaps05TemperatureAbove20C = {
            {102, 102, 102, 103, 103, 105},
            {107, 108, 108, 110, 110, 112},
            {113, 114, 115, 116, 117, 118},
            {120, 120, 121, 122, 123, 124},
            {126, 126, 127, 128, 129, 130},
            {131, 132, 133, 134, 135, 136},
            {135, 136, 137, 138, 138, 140}
    };

    private int[][] v2ValuesForFlaps05TemperatureBelow20C = {
            {116, 115, 114, 113, 112, 111},
            {115, 114, 113, 112, 112, 111},
            {117, 117, 117, 117, 117, 117},
            {122, 122, 122, 122, 122, 122},
            {127, 127, 127, 127, 127, 127},
            {132, 132, 132, 132, 132, 132},
            {135, 135, 135, 135, 135, 135}
    };
    private int[][] v2ValuesForFlaps05TemperatureAbove20C = {
            {114, 113, 112, 111, 110, 109},
            {113, 112, 112, 111, 111, 111},
            {117, 117, 117, 117, 117, 117},
            {122, 122, 122, 122, 122, 122},
            {127, 127, 127, 127, 127, 127},
            {132, 132, 132, 132, 132, 132},
            {135, 135, 135, 135, 135, 135}
    };
    private int[][] vrValuesForFlaps10TemperatureBelow20C = {
            {100, 100, 100, 100, 100, 100},
            {100, 100, 100, 100, 100, 101},
            {103, 105, 105, 105, 106, 108},
            {109, 110, 111, 111, 112, 113},
            {115, 116, 116, 117, 118, 119},
            {120, 121, 122, 122, 123, 124},
            {124, 125, 125, 126, 127, 128}
    };


    private int[][] vrValuesForFlaps10TemperatureAbove20C = {
            {100, 100, 100, 100, 106, 105},
            {100, 100, 100, 100, 105, 105},
            {104, 106, 106, 106, 108, 108},
            {110, 111, 112, 112, 113, 113},
            {116, 117, 117, 118, 118, 118},
            {121, 122, 123, 123, 122, 122},
            {125, 125, 126, 127, 125, 125}
    };
    private int[][] v2ValuesForFlaps10TemperatureBelow20C = {
            {111, 110, 110, 109, 108, 107},
            {110, 109, 109, 108, 107, 106},
            {109, 109, 108, 108, 108, 108},
            {113, 113, 113, 113, 113, 113},
            {118, 118, 118, 118, 118, 118},
            {122, 122, 122, 122, 122, 122},
            {125, 125, 125, 125, 125, 125}
    };
    private int[][] v2ValuesForFlaps10TemperatureAbove20C = {
            {109, 109, 109, 107, 106, 105},
            {108, 108, 107, 106, 105, 105},
            {108, 108, 108, 108, 108, 108},
            {113, 113, 113, 113, 113, 113},
            {118, 118, 118, 118, 118, 118},
            {122, 122, 122, 122, 122, 122},
            {125, 125, 125, 125, 125, 125}
    };
    private int[][] vrValuesForFlaps15TemperatureBelow20C = {
            {98, 98, 98, 98, 98, 98},
            {98, 98, 98, 98, 98, 98},
            {100, 101, 101, 102, 103, 104},
            {106, 106, 107, 108, 108, 109},
            {111, 112, 112, 113, 114, 114},
            {116, 117, 117, 118, 118, 119},
            {119, 120, 120, 121, 122, 122}
    };
    private int[][] vrValuesForFlaps15TemperatureAbove20C = {
            {98, 98, 98, 98, 98, 98},
            {98, 98, 98, 98, 99, 99},
            {101, 102, 103, 104, 104, 104},
            {107, 108, 108, 109, 110, 110},
            {112, 113, 114, 114, 115, 115},
            {117, 118, 119, 119, 120, 120},
            {120, 121, 121, 122, 123, 123}
    };
    private int[][] v2ValuesForFlaps15TemperatureBelow20C = {
            {106, 106, 105, 104, 103, 102},
            {105, 105, 104, 103, 102, 102},
            {104, 104, 104, 104, 104, 104},
            {109, 109, 109, 109, 109, 109},
            {113, 113, 113, 113, 113, 113},
            {118, 118, 118, 118, 118, 118},
            {120, 120, 120, 120, 120, 120}
    };
    private int[][] v2ValuesForFlaps15TemperatureAbove20C = {
            {105, 104, 103, 102, 102, 102},
            {103, 103, 102, 102, 102, 102},
            {104, 104, 104, 104, 104, 104},
            {109, 109, 109, 109, 109, 109},
            {113, 113, 113, 113, 113, 113},
            {118, 118, 118, 118, 118, 118},
            {120, 120, 120, 120, 120, 120}
    };


    private int[] vfriValuesForFlaps05 = {116, 120, 126, 132, 137, 142, 146};
    private int[] vfriValuesForFlaps10 = {110, 112, 118, 123, 128, 134, 137};
    private int[] vfriValuesForFlaps15 = {107, 109, 115, 120, 125, 130, 133};
    private int[] vclmbValues = {130, 131, 137, 143, 148, 154, 158};



    public TakeoffSpeedsCalculation(int takeoffFlapsSettings, int temperature, int weight, int altitude) {
        wetRunway = false;
        this.takeoffFlapsSettings = takeoffFlapsSettings;
        this.temperature = temperature;
        this.weight = weight;
        this.altitude = altitude;
        getSpeeds();
    }

    public TakeoffSpeedsCalculation(int takeoffFlapsSettings, int temperature, int weight, int altitude, int windDegree, int runwayDegree, int windSpeed) {
        wetRunway = true;
        this.takeoffFlapsSettings = takeoffFlapsSettings;
        this.temperature = temperature;
        this.weight = weight;
        this.altitude = altitude;
        this.windDegree = windDegree;
        this.runwayDegree = runwayDegree;
        this.windSpeed = windSpeed;
        getSpeeds();
        getWindSpeedValue();

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
        else
            i=6;

        return i;
    }
    public int getJ(){
        if(altitude<= 1_000)
            j=0;
        else if(altitude>1_000 && altitude<=3_000 )
            j=1;
        else if(altitude>3_000 && altitude<=5_000 )
            j=2;
        else if(altitude>5_000 && altitude<=7_000 )
            j=3;
        else if(altitude>7_000 && altitude<=9_000 )
            j=4;
        else
            j=5;

        return j;

    }

    public int getVr(){

        if(temperature > 20 && takeoffFlapsSettings == 5)
            vrArray = vrValuesForFlaps05TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 10)
            vrArray = vrValuesForFlaps10TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 15)
            vrArray = vrValuesForFlaps15TemperatureAbove20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 5)
            vrArray = vrValuesForFlaps05TemperatureBelow20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 10)
            vrArray = vrValuesForFlaps10TemperatureBelow20C;
        else if (temperature <= 20 && takeoffFlapsSettings == 15)
            vrArray = vrValuesForFlaps15TemperatureBelow20C;

        return vrArray[i][j];
    }
    public int getV2(){
        if(temperature > 20 && takeoffFlapsSettings == 5)
            v2Array = v2ValuesForFlaps05TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 10)
            v2Array = v2ValuesForFlaps10TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 15)
            v2Array = v2ValuesForFlaps15TemperatureAbove20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 5)
            v2Array = v2ValuesForFlaps05TemperatureBelow20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 10)
            v2Array = v2ValuesForFlaps10TemperatureBelow20C;
        else if (temperature <= 20 && takeoffFlapsSettings == 15)
            v2Array = v2ValuesForFlaps15TemperatureBelow20C;

        return v2Array[i][j];
    }

    public int getVfri(){
        if(takeoffFlapsSettings == 5)
            vFri = vfriValuesForFlaps05;
        else if(takeoffFlapsSettings == 10)
            vFri = vfriValuesForFlaps10;
        else if(takeoffFlapsSettings == 15)
            vFri = vfriValuesForFlaps15;

        return vFri[i];
    }

    public int getVclmb(){

        return vclmbValues[i];
    }


    public void getSpeeds(){
        i= getI();
        j= getJ();
        vr = getVr();
        v2 = getV2();
        v1 = getVr();

    }


    public double getWindSpeedValue(){

        degreeDifference = runwayDegree - windDegree;

        if (degreeDifference < 0) {
            degreeDifference = degreeDifference + 360;
        }

        if((degreeDifference >=0 && degreeDifference <=30)||(degreeDifference >=331 && degreeDifference <=359)){
            headWind = true;
            windSpeedValue = windSpeed;
        }
        else if(degreeDifference >=151 && degreeDifference <=210){
            headWind = false;
            windSpeedValue = windSpeed;
        }
        else if((degreeDifference >=31 && degreeDifference <=60)||(degreeDifference >=301 && degreeDifference <=330)){
            headWind = true;
            windSpeedValue = 0.66*windSpeed;
        }
        else if((degreeDifference >=211 && degreeDifference <=240)||(degreeDifference >=121 && degreeDifference <=150)){
            headWind = false;
            windSpeedValue = 0.66*windSpeed;
        }
        else if((degreeDifference >=61 && degreeDifference <=90)||(degreeDifference >=271 && degreeDifference <=300)){
            headWind = true;
            windSpeedValue = 0.33*windSpeed;
        }
        else if((degreeDifference >=91 && degreeDifference <=120)||(degreeDifference >=241 && degreeDifference <=270)){
            headWind = false;
            windSpeedValue = 0.33*windSpeed;
        }

        return windSpeedValue;
    }


    public double calculateV1() {

        if (wetRunway) {
            if (headWind)
                v1 = (v1 - (8 - 0.1 * windSpeedValue));
            else
                v1 = (v1 - (8 + 0.3 * windSpeedValue));
        }

        if (v1 < 97 && takeoffFlapsSettings == 5)
            v1 = 97;
        if (v1 < 96 && (takeoffFlapsSettings == 10 || takeoffFlapsSettings == 15))
            v1 = 96;
        v1=Math.round(v1*100);
        v1=v1/100;
        return v1;
    }

    public double calculateVr() {

        if (vr < 108 && takeoffFlapsSettings == 5)
            vr = 108;
        if (vr < 104 && takeoffFlapsSettings == 10)
            vr = 104;
        if (vr < 100 && takeoffFlapsSettings == 15)
            vr = 100;
        return vr;
    }
    public double calculateV2() {
        if (vr > v2)
            v2 = vr;
        return v2;
    }

}
