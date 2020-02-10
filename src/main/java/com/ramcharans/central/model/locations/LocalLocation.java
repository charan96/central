package com.ramcharans.central.model.locations;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocalLocation implements Location {
    private String baseLocation;
    private String baseName;

    private String delimiter = "/";

    public LocalLocation(String location) {
        fromString(location);
    }


    @Override
    public String getBaseLocation() {
        return baseLocation;
    }

    @Override
    public String getBaseName() {
        return baseName;
    }

    @Override
    public String asString() {
        return Paths.get(baseLocation, baseName).toString();
    }

    @Override
    public void fromString(String location) {
        // todo: add check in controller to make sure the location is not empty or has only "/"
        Path path = Paths.get(location);

        baseName = path.getFileName().toString();

        try {
            baseLocation = path.subpath(0, path.getNameCount() - 1).toString();
        } catch (IllegalArgumentException e) {
            baseLocation = "/";
        }
    }

    @Override
    public List<String> getPathComponentsAsStringList() {
        List<String> dirs = new ArrayList<>();

        Path path = Paths.get(baseLocation);

        for (int i = 0; i < path.getNameCount(); i++)
            dirs.add(path.subpath(i, i + 1).toString());

        return dirs;
    }

    @Override
    public boolean isCategory() {
        return !baseName.contains(".");
    }
}
