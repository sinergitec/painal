package com.sienrgitec.painal.constante;

import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;

import java.util.ArrayList;

public class Constantes {
    //public static final String URL_BASE_WS = "http://escuela181945.herokuapp.com/api/";
    public static final String URL_BASE_WS_SINERGITEC = "http://sinergitecdemo.ddns.net:8083/painal/rest/painalService/";
    //public static final String URL_BASE_WS_SINERGITEC = "http://192.168.1.102:8083/painal/rest/painalService/";
    public static final String[] ARRAY_COLORS = {"#DCD3C1", "#F9FA81", "#FEC298", "#B9F6F9", "#96ABFE", "#BAFCBE", "#F4C9FD", "#FEACB6", "#F9D795"};


    public static final Integer CANTIDAD_MAX_PROVEEDORES = 3;
    public static String vcCuenta = "";
    public static String vcMatchArt = "";
    public static Double vdeSaldo = 0.00;


    public static ArrayList<TtCtProveedor_> ctProvList      = new ArrayList<>();

}
