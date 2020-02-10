package com.ramcharans.central.model.documents;

import com.ramcharans.central.model.locations.Location;
import com.ramcharans.central.utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private LocalDateTime lastModified;
    private Location location;
    private String text;

    public Document(String id, String name, String text) {
        this.id = id;
        this.name = name;
        this.lastModified = LocalDateTime.now();
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public String getText() {
        return text;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public void updateDocumentText(String text) {
        this.text = text;
        setLastModified(LocalDateTime.now());
    }

    public void renameDocument(String name) {
        this.name = name;
        setLastModified(LocalDateTime.now());
    }

    public void updateDocumentLocation(Location location) {
        this.location = location;
        setLastModified(LocalDateTime.now());
    }

    public Map<String, String> toMap() {
        Map<String, String> docMap = new HashMap<>();

        docMap.put("id", id);
        docMap.put("name", name);
        docMap.put("last_modified", DateTimeUtils.convertLocalDateTimeToString(lastModified));
        docMap.put("text", text);

        return docMap;
    }
}
