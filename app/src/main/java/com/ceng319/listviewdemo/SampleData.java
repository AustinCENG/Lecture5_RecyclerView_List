package com.ceng319.listviewdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static List<DataItem> dataItemList;

    static {
        dataItemList = new ArrayList<>();
        dataItemList.add(new DataItem(1	, "Anguilla	", "North_America/North_America-Anguilla.png"));
        dataItemList.add(new DataItem(2	, "Antigua_and_Barbuda"	, "North_America/North_America-Antigua_and_Barbuda.png"));
        dataItemList.add(new DataItem(3	, "Aruba"	, "North_America/North_America-Aruba.png"));
        dataItemList.add(new DataItem(4	, "Bahamas"	, "North_America/North_America-Bahamas.png"));
        dataItemList.add(new DataItem(5	, "Barbados"	, "North_America/North_America-Barbados.png"));
        dataItemList.add(new DataItem(6	, "Belize"	, "North_America/North_America-Belize.png"));
        dataItemList.add(new DataItem(7	, "Bermuda"	, "North_America/North_America-Bermuda.png"));
        dataItemList.add(new DataItem(8	, "British_Virgin_Islands"	, "North_America/North_America-British_Virgin_Islands.png"));
        dataItemList.add(new DataItem(9	, "Canada"	, "North_America/North_America-Canada.png"));
        dataItemList.add(new DataItem(10	, "Cayman_Islands"	, "North_America/North_America-Cayman_Islands.png"));
        dataItemList.add(new DataItem(11	, "Costa_Rica"	, "North_America/North_America-Costa_Rica.png"));
        dataItemList.add(new DataItem(12	, "Cuba"	, "North_America/North_America-Cuba.png"));
        dataItemList.add(new DataItem(13	, "Dominica"	, "North_America/North_America-Dominica.png"));
        dataItemList.add(new DataItem(14	, "Dominican_Republic"	, "North_America/North_America-Dominican_Republic.png"));
        dataItemList.add(new DataItem(15	, "El_Salvador"	, "North_America/North_America-El_Salvador.png"));
        dataItemList.add(new DataItem(16	, "Grenada"	, "North_America/North_America-Grenada.png"));
        dataItemList.add(new DataItem(17	, "Guatemala"	, "North_America/North_America-Guatemala.png"));
        dataItemList.add(new DataItem(18	, "Haiti"	, "North_America/North_America-Haiti.png"));
        dataItemList.add(new DataItem(19	, "Honduras"	, "North_America/North_America-Honduras.png"));
        dataItemList.add(new DataItem(20	, "Jamaica"	, "North_America/North_America-Jamaica.png"));
        dataItemList.add(new DataItem(21	, "Martinique"	, "North_America/North_America-Martinique.png"));
        dataItemList.add(new DataItem(22	, "Mexico"	, "North_America/North_America-Mexico.png"));
        dataItemList.add(new DataItem(23	, "Montserrat"	, "North_America/North_America-Montserrat.png"));
        dataItemList.add(new DataItem(24	, "Nicaragua"	, "North_America/North_America-Nicaragua.png"));
        dataItemList.add(new DataItem(25	, "Panama"	, "North_America/North_America-Panama.png"));
        dataItemList.add(new DataItem(26	, "Puerto_Rico"	, "North_America/North_America-Puerto_Rico.png"));
        dataItemList.add(new DataItem(27	, "Saint_Kitts_and_Nevis"	, "North_America/North_America-Saint_Kitts_and_Nevis.png"));
        dataItemList.add(new DataItem(28	, "Saint_Lucia"	, "North_America/North_America-Saint_Lucia.png"));
        dataItemList.add(new DataItem(29	, "Saint_Pierre"	, "North_America/North_America-Saint_Pierre.png"));
        dataItemList.add(new DataItem(30	, "St._Vicent_and_Grenadines"	, "North_America/North_America-St._Vicent_and_Grenadines.png"));
        dataItemList.add(new DataItem(31	, "Turks_and_Caicos_Islands"	, "North_America/North_America-Turks_and_Caicos_Islands.png"));
        dataItemList.add(new DataItem(32	, "United_States_of_America"	, "North_America/North_America-United_States_of_America.png"));
        dataItemList.add(new DataItem(33	, "US_Virgin_Islands"	, "North_America/North_America-US_Virgin_Islands.png"));

    }

    private void generateList(){
        File folder = new File("your/path");

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
}
