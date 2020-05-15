package com.digisystem.TestJavaDeveloper.domain;

import java.text.DecimalFormat;

public class RspChallenge01 {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private String total;

    public RspChallenge01(double value) {
        this.total = String.format("%.2f", value);
    }

    public String getTotal() {
        return total;
    }

}
