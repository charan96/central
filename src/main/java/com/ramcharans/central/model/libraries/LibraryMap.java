package com.ramcharans.central.model.libraries;

import com.ramcharans.central.exceptions.librarymap.IdAlreadyExistsException;
import com.ramcharans.central.exceptions.librarymap.IdDoesNotExistInLibraryMapException;
import com.ramcharans.central.exceptions.librarymap.LocationAlreadyInUseException;
import com.ramcharans.central.model.locations.Location;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LibraryMap {
    private Map<String, Location> idLocationMap;
    private Set<Location> locationsInUseSet;

    public LibraryMap() {
        idLocationMap = new HashMap<>();
        locationsInUseSet = new HashSet<>();
    }

    public LibraryMap(Map<String, Location> idLocationMap, Set<Location> locationsInUseSet) {
        this.idLocationMap = idLocationMap;
        this.locationsInUseSet = locationsInUseSet;
    }

    public void addEntry(String id, Location loc) throws LocationAlreadyInUseException, IdAlreadyExistsException {
        if (isLocationInUse(loc)) {
            throw new LocationAlreadyInUseException("failed to add id-location pair to library map since location '" + loc.asString() + "' is already in use");
        } else if (isIdEntryExists(id)) {
            throw new IdAlreadyExistsException("failed to add id-location pair to library map since id '" + id + "' " +
                    "already exists");
        } else {
            idLocationMap.put(id, loc);
            locationsInUseSet.add(loc);
        }
    }

    public void removeEntry(String id) throws IdDoesNotExistInLibraryMapException {
        if (isIdEntryExists(id)) {
            Location loc = idLocationMap.get(id);
            locationsInUseSet.remove(loc);
            idLocationMap.remove(id);
        } else {
            throw new IdDoesNotExistInLibraryMapException("failed to remove id-location pair since '" + id + "' does " +
                    "not exist");
        }
    }

    public void updateEntry(String id, Location loc) throws IdDoesNotExistInLibraryMapException {
        if (isIdEntryExists(id)) {
            idLocationMap.replace(id, loc);
        } else {
            throw new IdDoesNotExistInLibraryMapException("cannot update library map since '" + id + "' does not " +
                    "exist " + "in the library map");
        }
    }

    private boolean isIdEntryExists(String id) {
        return idLocationMap.containsKey(id);
    }

    public Location getLocation(String id) throws IdDoesNotExistInLibraryMapException {
        if (isIdEntryExists(id)) {
            return idLocationMap.get(id);
        } else {
            throw new IdDoesNotExistInLibraryMapException("failed to get location for '" + id + "' since it does not " +
                    "exist");
        }
    }

    public Map<String, Location> getIdLocationMap() {
        return idLocationMap;
    }

    public Set<Location> getLocationsInUseSet() {
        return locationsInUseSet;
    }

    private boolean isLocationInUse(Location loc) {
        return locationsInUseSet.contains(loc);
    }
}
