package com.ramcharans.central.model.documents;

import com.ramcharans.central.model.locations.LocalLocation;
import com.ramcharans.central.model.locations.Location;
import com.ramcharans.central.model.locations.LocationFactory;

import java.time.LocalDateTime;
import java.util.Map;

public class DocumentCreator {
    public static Document createNewDocument(String id, String name, String text) {
        Document doc = new Document(id, name, text);
        doc.setLastModified(LocalDateTime.now());

        return doc;
    }

    public static Document createNewDocument(String id, Document doc) {
        Document newDoc = new Document(id, doc.getName(), doc.getText());
        doc.setLastModified(LocalDateTime.now());

        return newDoc;
    }

    public static Document createNewDocument(Map docMap) {
        Document doc = new Document(docMap.get("id").toString(),
                docMap.get("name").toString(),
                docMap.get("text").toString());
        doc.setLastModified(LocalDateTime.now());

        return doc;
    }
}
