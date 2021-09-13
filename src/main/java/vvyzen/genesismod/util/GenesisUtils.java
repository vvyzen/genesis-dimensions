package vvyzen.genesismod.util;

import java.util.Random;

public class GenesisUtils {

    // * BlackbodyRGBGenerator generates color roughly based on blackbody radiation
    //saturation for how much the color is darkened, so just saturation
    //greenExponent affects the cutoff of the green color, so a lower value means a smoother gradient from yellow/cyan to red/blue
    //greenOffset affects the cutoff offset, at 0 there will be barely any pure red/blue stars, recommended value is 0.6
    //temperatureOffset affects star color, turning this up may increase saturation and might break things, highly recommended to leave at 1
    //the way temperature works is negative values are red, positive are blue, 0 is white, values near 0 have high green, making cyan/yellow possible w/ greenExponent
    public static float[] BlackbodyRGBGenerator(Random rand, float temperatureOffset, float saturation, float greenExponent, float greenOffset){
        float[] colors;
        colors = new float[3];

        float temperature = ClinkerMathUtils.getRandomFloatBetween(rand, 0.0F-temperatureOffset, 0.0F+temperatureOffset);
        float tempGreen = Math.abs((float) Math.pow(Math.abs(temperature), greenExponent)+(greenOffset)*Math.abs(temperature));

        float redMultiplier = 1.0F + (temperature*saturation);
        float greenMultiplier = 1.0F - ((tempGreen)*saturation);
        float blueMultiplier = 1.0F - (temperature*saturation);

        colors[0] = (270*redMultiplier)/255;
        colors[1] = (270*greenMultiplier)/255;
        colors[2] = (270*blueMultiplier)/255;

        return colors;

    }
}