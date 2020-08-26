package com.sienrgitec.painal.componente.recycler;

import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;

import java.util.Comparator;

public class ComparaEvaluacion implements Comparator<TtCtProveedor_> {

    @Override
    public int compare(TtCtProveedor_ o2, TtCtProveedor_ o1) {
        return new Double(o2.getDeEvaluacion()).compareTo(new Double(o1.getDeEvaluacion()));
    }
}

