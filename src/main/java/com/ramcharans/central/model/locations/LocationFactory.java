package com.ramcharans.central.model.locations;

public class LocationFactory {
    public static Location createLocation(String location, String type) {
        if (type.equals("local")) {
            return new LocalLocation(location);
        } else {
            return null;
        }
    }
}
