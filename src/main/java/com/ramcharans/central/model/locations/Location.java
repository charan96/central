package com.ramcharans.central.model.locations;

import java.util.List;

public interface Location {
    public String getBaseLocation();

    public String getBaseName();

    public String asString();

    public void fromString(String location);

    public List<String> getPathComponentsAsStringList();

    public boolean isCategory();
}
