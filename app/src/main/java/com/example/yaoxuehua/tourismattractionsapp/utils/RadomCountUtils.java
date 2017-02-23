package com.example.yaoxuehua.tourismattractionsapp.utils;

import java.util.Random;

/**
 * Created by yaoxuehua on 16-12-2.
 */

public class RadomCountUtils {

    public static float getRadomCount() {

        float max = 1.00f;
        float min = -1.00f;
        Random random = new Random();

        float result = random.nextFloat();
        int justResult = random.nextInt(2) + 1;
        if (justResult == 1){

            result = 0f - result;
        }
        return result;
    }
}
