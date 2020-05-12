package com.sienrgitec.painal.util;

public class Funcionalidades {

    public static String retornaDoubleEnMoneda(Double valor){
        if(valor == null || valor.equals(""))
            return "$0.00";
        return "$ " + round(valor,2);
    }

    public static Double round(Double value, int places) {
        if(value == null)
            return 0.00;
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
