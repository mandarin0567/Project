package com.example.lifemedicalinfo.domain.repository;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;

public class AEDInfoXmlParser {

    public AEDInfoXmlParser() { }

    public ArrayList<AED> getXmlData(InputStream input) throws Exception {
        ArrayList<AED> arrayList = new ArrayList<>();

        XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = parserCreator.newPullParser();

        xpp.setInput(input, "UTF-8");

        AED data = new AED();
        String tag;

        int eventType = xpp.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;

                case XmlPullParser.START_TAG:
                    tag = xpp.getName();

                    if (tag.equals("item")) {
                        System.out.println(tag.equals("item"));
                    } else if (tag.equals("buildAddress")) {
                        xpp.next();
                        data.setBuildAddress(xpp.getText());
                    } else if (tag.equals("buildPlace")) {
                        xpp.next();
                        data.setBuildPlace(xpp.getText());
                    } else if (tag.equals("clerkTel")) {
                        xpp.next();
                        data.setClerkTel(xpp.getText());
                    } else if (tag.equals("distance")) {
                        xpp.next();
                        data.setDistance(xpp.getText());
                    } else if (tag.equals("manager")) {
                        xpp.next();
                        data.setManager(xpp.getText());
                    } else if (tag.equals("managerTel")) {
                        xpp.next();
                        data.setManagerTel(xpp.getText());
                    } else if (tag.equals("mfg")) {
                        xpp.next();
                        data.setMfg(xpp.getText());
                    } else if (tag.equals("rnum")) {
                        xpp.next();
                        data.setRnum(xpp.getText());
                    } else if (tag.equals("wgs84Lat")) {
                        xpp.next();
                        data.setWgs84Lat(xpp.getText());
                    } else if (tag.equals("wgs84Lon")) {
                        xpp.next();
                        data.setWgs84Lon(xpp.getText());
                    } else if (tag.equals("zipcode1")) {
                        xpp.next();
                        data.setZipcode1(xpp.getText());
                    } else if (tag.equals("zipcode2")) {
                        xpp.next();
                        data.setZipcode2(xpp.getText());
                    } else if (tag.equals("model")) {
                        xpp.next();
                        data.model = xpp.getText();
                    }

                    break;

                case XmlPullParser.TEXT:
                    break;

                case XmlPullParser.END_TAG:
                    tag = xpp.getName(); //테그 이름 얻어오기

                    if (tag.equals("item")) {
                        arrayList.add(data);
                        data = new AED();
                    }
                    break;
            }

            eventType = xpp.next();
        }

        return arrayList;
    }
}
