package com.sienrgitec.painal.util;

import java.text.DecimalFormat;

public class Funcionalidades {

    public static String retornaDoubleEnMoneda(Double valor){
        return "$ " + round(valor,2);
    }

    public static Double round(Double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
