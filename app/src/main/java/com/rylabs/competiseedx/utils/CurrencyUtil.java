package com.rylabs.competiseedx.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CurrencyUtil {

    public CurrencyUtil() {}

    public static String format(int price) {
        return new CurrencyUtil().buildCurrency(price, true);
    }

    private String buildCurrency(int price, boolean currSymbol) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        if (currSymbol) formatRp.setCurrencySymbol("Rp ");
        else formatRp.setCurrencySymbol("");

        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        kursIndonesia.setMaximumFractionDigits(0);
        return kursIndonesia.format(price);
    }
}