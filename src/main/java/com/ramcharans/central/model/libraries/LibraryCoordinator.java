package com.ramcharans.central.model.libraries;

import com.ramcharans.central.exceptions.library.*;
import com.ramcharans.central.exceptions.librarymap.*;
import com.ramcharans.central.exceptions.librarycoordinator.*;
import com.ramcharans.central.model.documents.Document;
import com.ramcharans.central.model.internal.InternalDataManager;
import com.ramcharans.central.model.locations.Location;

public class LibraryCoordinator {
    private Library library;
    private LibraryMap libraryMap;
    private InternalDataManager idm;

    public LibraryCoordinator(LibraryMap libraryMap, InternalDataManager idm, Library library) {
        this.library = library;
        this.libraryMap = libraryMap;
        this.idm = idm;
    }

    public Document retrieveDocument(String id) throws InvalidDataLocationException, NoLocationFoundForIdException {
        try {
            Location loc = this.libraryMap.getLocation(id);
            Document doc = this.library.retrieveDocument(loc);

            return doc;
        } catch (InvalidLocationException | FileHandlingException e) {
            throw new InvalidDataLocationException(e.toString());
        } catch (IdDoesNotExistInLibraryMapException e) {
            throw new NoLocationFoundForIdException(e.toString());
        }
    }

    //    public void saveDocument(Document doc) throws InvalidDataLocationException {
//        try {
//            this.libraryMap.addEntry(doc.getId(), doc.getLocation());
//            this.library.storeDocument(doc);
//        } catch (Exception e) {
//            throw new InvalidDataLocationException(e.toString());
//        }
//    }
    public void saveDocument(Document doc, Location loc) throws InvalidDataLocationException {
        try {
            this.libraryMap.addEntry(doc.getId(), loc);
            this.library.storeDocument(doc, loc);
        } catch (Exception e) {
            throw new InvalidDataLocationException(e.toString());
        }
    }

    public void updateDocument(String id, String text) throws InvalidDataLocationException, InvalidDocumentIdException {
        try {
            Location loc = this.libraryMap.getLocation(id);
            this.library.updateDocumentText(loc, text);
        } catch (IdDoesNotExistInLibraryMapException e) {
            throw new InvalidDocumentIdException(e.toString());
        } catch (InvalidLocationException | FileHandlingException e) {
            throw new InvalidDataLocationException(e.toString());
        }
    }

    public void changeDocumentName(String id, String name) throws InvalidDataLocationException,
            InvalidDocumentIdException {
        try {
            Location loc = this.libraryMap.getLocation(id);
            this.library.changeDocumentName(loc, name);
        } catch (IdDoesNotExistInLibraryMapException e) {
            throw new InvalidDocumentIdException(e.toString());
        } catch (InvalidLocationException | FileHandlingException e) {
            throw new InvalidDataLocationException(e.toString());
        }
    }

    public void moveDocument(String id, Location newLoc) throws InvalidDataLocationException,
            InvalidDocumentIdException {
        try {
            Location oldLoc = this.libraryMap.getLocation(id);
            this.library.moveDocument(oldLoc, newLoc);

            this.libraryMap.updateEntry(id, newLoc);
        } catch (IdDoesNotExistInLibraryMapException e) {
            throw new InvalidDocumentIdException(e.toString());
        } catch (InvalidLocationException | FileHandlingException e) {
            throw new InvalidDataLocationException(e.toString());
        }
    }

    public void deleteDocument(String id) throws InvalidDataLocationException,
            InvalidDocumentIdException {
        try {
            Location loc = this.libraryMap.getLocation(id);
            this.library.deleteDocument(loc);

            this.libraryMap.removeEntry(id);
        } catch (IdDoesNotExistInLibraryMapException e) {
            throw new InvalidDocumentIdException(e.toString());
        } catch (InvalidLocationException | FileHandlingException e) {
            throw new InvalidDataLocationException(e.toString());
        }
    }

    public void createCategory(Location loc) {

    }

    public void deleteCategory(Location loc) {

    }

    public void renameCategory(Location old, Location newLoc) {

    }
}
