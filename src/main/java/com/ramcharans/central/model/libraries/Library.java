package com.ramcharans.central.model.libraries;

import com.ramcharans.central.exceptions.library.*;
import com.ramcharans.central.exceptions.librarycoordinator.InvalidDataLocationException;
import com.ramcharans.central.model.documents.Document;
import com.ramcharans.central.model.locations.Location;

import java.util.List;

public interface Library {
    /* LOCATION VALIDATING METHODS */
    public boolean isFileExists(Location loc);

    public boolean isFileLocationExists(Location loc);

    public void storeDocument(Document doc, Location loc) throws InvalidLocationException, FileHandlingException;

    public Document retrieveDocument(Location loc) throws InvalidLocationException, FileHandlingException;

    public void updateDocumentText(Location loc, String text) throws InvalidLocationException, FileHandlingException;

    public void updateDocumentTimestamp(Location loc) throws InvalidLocationException, FileHandlingException;

    public void deleteDocument(Location loc) throws InvalidLocationException, FileHandlingException;

    public void changeDocumentName(Location loc, String name) throws InvalidLocationException, FileHandlingException;

    public void moveDocument(Location oldLoc, Location newLoc) throws InvalidLocationException, FileHandlingException;

    public List<String> getFilesInCategory(Location loc);

    public void createCategory(Location loc) throws InvalidLocationException, FailedToCreateCategoryException;

    public void deleteCategory(Location loc) throws InvalidLocationException, FailedToDeleteCategoryAndItsContents;

    // todo: need to implement this later
    // public void renameCategory(Location oldLoc, Location newLoc);
}
