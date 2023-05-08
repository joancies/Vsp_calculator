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
    private int[][] vrChosenArray;
    private int[][] v2ChosenArray;
    private int[] vFriChosenArray;
    private int degreeDifference;
    private double factorForWindCalculation;
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
        i= getI();
        j= getJ();
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
        i= getI();
        j= getJ();
    }
    public int getI(){
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
    public int getJ(){
        if(altitude<= 1_000)
            return 0;
        else if(altitude>1_000 && altitude<=3_000 )
            return 1;
        else if(altitude>3_000 && altitude<=5_000 )
            return 2;
        else if(altitude>5_000 && altitude<=7_000 )
            return 3;
        else if(altitude>7_000 && altitude<=9_000 )
            return 4;
        else
            return 5;
    }
    public double getV1() {
        v1 = getVrInitialValue();
        if (wetRunway) {
            if (isHeadWind())
                v1 = (v1 - (8 - 0.1 * getWindSpeedValue()));
            else
                v1 = (v1 - (8 + 0.3 * getWindSpeedValue()));
        }
        if (v1 < 97 && takeoffFlapsSettings == 5)
            v1 = 97;
        else if (v1 < 96 && (takeoffFlapsSettings == 10 || takeoffFlapsSettings == 15))
            v1 = 96;
        v1=Math.round(v1*100);
        v1=v1/100;
        return v1;
    }
    public int getVrInitialValue(){
        vrChosenArray = getVrForTemperatureAndFlapsSettings();
        return vrChosenArray[i][j];
    }
    public int[][] getVrForTemperatureAndFlapsSettings(){

        if(temperature > 20 && takeoffFlapsSettings == 5)
            return vrValuesForFlaps05TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 10)
            return vrValuesForFlaps10TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 15)
            return vrValuesForFlaps15TemperatureAbove20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 5)
            return vrValuesForFlaps05TemperatureBelow20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 10)
            return vrValuesForFlaps10TemperatureBelow20C;
        else
            return vrValuesForFlaps15TemperatureBelow20C;
    }
    public int getDegreeDifference(){

        if ((runwayDegree - windDegree) < 0)
            return runwayDegree - windDegree + 360;
        else
            return runwayDegree - windDegree;
    }
    public boolean isHeadWind(){
        degreeDifference = getDegreeDifference();

        if((degreeDifference >=0 && degreeDifference <=90)||(degreeDifference >=271 && degreeDifference <=360))
            return true;
        else
            return false;
    }
    public double getWindSpeedValue(){
        factorForWindCalculation = getFactorForWindCalculation();
        return factorForWindCalculation * windSpeed;
    }
    public double getFactorForWindCalculation(){
        if((degreeDifference >=0 && degreeDifference <=30)||(degreeDifference >=151 && degreeDifference <=210)||
                (degreeDifference >=331 && degreeDifference <=360))
            return  1;
        else if((degreeDifference >=31 && degreeDifference <=60)|| (degreeDifference >=211 && degreeDifference <=240)||
                (degreeDifference >=121 && degreeDifference <=150)||(degreeDifference >=301 && degreeDifference <=330))
            return 0.66;
        else
            return 0.33;
    }
    public double getVr() {
        vr = getVrInitialValue();
        if (vr < 108 && takeoffFlapsSettings == 5)
            return 108;
        else if (vr < 104 && takeoffFlapsSettings == 10)
            return 104;
        else if (vr < 100 && takeoffFlapsSettings == 15)
            return 100;
        else
            return vr;
    }
    public double getV2() {
        v2 = getV2InitialValue();
        vr = getVrInitialValue();

        if (vr > v2)
            return vr;
        else
            return v2;
    }
    public int getV2InitialValue(){
        v2ChosenArray = getV2ForTemperatureAndFlapsSettings();
        return v2ChosenArray[i][j];
    }
    public int[][] getV2ForTemperatureAndFlapsSettings(){
        if(temperature > 20 && takeoffFlapsSettings == 5)
            return v2ValuesForFlaps05TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 10)
            return v2ValuesForFlaps10TemperatureAbove20C;
        else if(temperature > 20 && takeoffFlapsSettings == 15)
            return v2ValuesForFlaps15TemperatureAbove20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 5)
            return v2ValuesForFlaps05TemperatureBelow20C;
        else if(temperature <= 20 && takeoffFlapsSettings == 10)
            return v2ValuesForFlaps10TemperatureBelow20C;
        else
            return v2ValuesForFlaps15TemperatureBelow20C;
    }
    public int getVfri(){
        vFriChosenArray = getVfriForFlapsSettings();
        return vFriChosenArray[i];
    }
    public int[] getVfriForFlapsSettings(){
        if(takeoffFlapsSettings == 5)
            return vfriValuesForFlaps05;
        else if(takeoffFlapsSettings == 10)
            return vfriValuesForFlaps10;
        else
            return vfriValuesForFlaps15;
    }
    public int getVclmb(){
        return vclmbValues[i];
    }
}
