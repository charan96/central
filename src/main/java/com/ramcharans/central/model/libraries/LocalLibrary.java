package com.ramcharans.central.model.libraries;

import com.ramcharans.central.exceptions.library.*;
import com.ramcharans.central.exceptions.librarycoordinator.InvalidDataLocationException;
import com.ramcharans.central.model.documents.Document;
import com.ramcharans.central.model.documents.DocumentCreator;
import com.ramcharans.central.model.locations.Location;
import com.ramcharans.central.utils.JSONUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalLibrary implements Library {
    private String rootLocation;

    public LocalLibrary(String rootLocation) throws InvalidRootLocationForLocalLibraryException {
        if (!isLegalRootLocation(rootLocation)) {
            throw new InvalidRootLocationForLocalLibraryException("root location '" + rootLocation + "' is not a " +
                    "directory");
        }
        this.rootLocation = rootLocation;
    }

    private String convertVirtualAddressToAbsoluteAddress(String localAddress) {
        Path path = Paths.get(rootLocation, localAddress);
        return path.toString();
    }

    private Path convertVirtualAddressToAbsoluteAddressAsPath(String localAddress) {
        Path path = Paths.get(rootLocation, localAddress);
        return path;
    }

    public boolean isLegalRootLocation(String rootLocation) {
        Path path = Paths.get(rootLocation);
        return Files.isDirectory(path);
    }

    @Override
    public boolean isFileExists(Location loc) {
        Path path = convertVirtualAddressToAbsoluteAddressAsPath(loc.asString());
        return Files.isRegularFile(path);
    }

    @Override
    public boolean isFileLocationExists(Location loc) {
        Path path = convertVirtualAddressToAbsoluteAddressAsPath(loc.getBaseLocation());
        return Files.isDirectory(path);
    }

    @Override
    public void storeDocument(Document doc, Location loc) throws InvalidLocationException, FileHandlingException {
        if (!isFileLocationExists(loc))
            throw new InvalidLocationException("");

        String writeLocation = convertVirtualAddressToAbsoluteAddress(loc.asString());

        try {
            JSONUtils.writeJSONFile(doc.toMap(), writeLocation);
        } catch (IOException e) {
            throw new FileHandlingException("failed to write the Document JSON file at '" + loc.asString() + "'");
        }
    }

    @Override
    public Document retrieveDocument(Location loc) throws InvalidLocationException, FileHandlingException {
        if (!isFileExists(loc) || !isFileLocationExists(loc))
            throw new InvalidLocationException("File '" + loc.getBaseName() + "' does not exist at location '" + loc.getBaseLocation() + "'");

        String readLocation = convertVirtualAddressToAbsoluteAddress(loc.asString());

        try {
            return DocumentCreator.createNewDocument(JSONUtils.readJSONFile(readLocation));
        } catch (IOException e) {
            throw new FileHandlingException("failed to read Document from '" + loc.asString() + "'");
        }
    }

    @Override
    public void updateDocumentText(Location loc, String text) throws InvalidLocationException, FileHandlingException {
        if (!isFileExists(loc) || !isFileLocationExists(loc))
            throw new InvalidLocationException("File '" + loc.getBaseName() + "' does not exist at location '" + loc.getBaseLocation() + "'");

        String fileLocation = convertVirtualAddressToAbsoluteAddress(loc.asString());
        Document doc;

        try {
            doc = DocumentCreator.createNewDocument(JSONUtils.readJSONFile(fileLocation));
        } catch (IOException e) {
            throw new FileHandlingException("failed to read Document from '" + loc.asString() + "'");
        }

        try {
            doc.updateDocumentText(text);
            JSONUtils.writeJSONFile(doc.toMap(), fileLocation);
        } catch (IOException e) {
            throw new FileHandlingException("failed to write the Document JSON file at '" + loc.asString() + "'");
        }
    }

    @Override
    public void updateDocumentTimestamp(Location loc) throws InvalidLocationException, FileHandlingException {
        if (!isFileExists(loc) || !isFileLocationExists(loc))
            throw new InvalidLocationException("File '" + loc.getBaseName() + "' does not exist at location '" + loc.getBaseLocation() + "'");

        String fileLocation = convertVirtualAddressToAbsoluteAddress(loc.asString());
        Document doc;

        try {
            doc = DocumentCreator.createNewDocument(JSONUtils.readJSONFile(fileLocation));
        } catch (IOException e) {
            throw new FileHandlingException("failed to read Document from '" + loc.asString() + "'");
        }

        try {
            doc.setLastModified(LocalDateTime.now());
            JSONUtils.writeJSONFile(doc.toMap(), fileLocation);
        } catch (IOException e) {
            throw new FileHandlingException("failed to write the Document JSON file at '" + loc.asString() + "'");
        }
    }

    @Override
    public void deleteDocument(Location loc) throws InvalidLocationException, FileHandlingException {
        if (!isFileExists(loc) || !isFileLocationExists(loc))
            throw new InvalidLocationException("File '" + loc.getBaseName() + "' does not exist at location '" + loc.getBaseLocation() + "'");

        Path fileLocation = convertVirtualAddressToAbsoluteAddressAsPath(loc.asString());

        try {
            Files.delete(fileLocation);
        } catch (IOException e) {
            throw new FileHandlingException("failed to delete file at: '" + loc.asString() + "'");
        }
    }

    @Override
    public void changeDocumentName(Location loc, String name) throws InvalidLocationException, FileHandlingException {
        if (!isFileExists(loc) || !isFileLocationExists(loc))
            throw new InvalidLocationException("File '" + loc.getBaseName() + "' does not exist at location '" + loc.getBaseLocation() + "'");

        String fileLocation = convertVirtualAddressToAbsoluteAddress(loc.asString());
        Document doc;

        try {
            doc = DocumentCreator.createNewDocument(JSONUtils.readJSONFile(fileLocation));
        } catch (IOException e) {
            throw new FileHandlingException("failed to read Document from '" + loc.asString() + "'");
        }

        try {
            doc.renameDocument(name);
            JSONUtils.writeJSONFile(doc.toMap(), fileLocation);
        } catch (IOException e) {
            throw new FileHandlingException("failed to write the Document JSON file at '" + loc.asString() + "'");
        }
    }

    @Override
    public void moveDocument(Location oldLoc, Location newLoc) throws InvalidLocationException, FileHandlingException {
        if (!isFileExists(oldLoc) || !isFileLocationExists(oldLoc))
            throw new InvalidLocationException("File '" + oldLoc.getBaseName() + "' does not exist at location '" + oldLoc.getBaseLocation() + "'");

        if (!isFileLocationExists(newLoc))
            throw new InvalidLocationException("Invalid location at '" + newLoc.asString() + "'");

        String oldFileLocation = convertVirtualAddressToAbsoluteAddress(oldLoc.asString());
        String newFileLocation = convertVirtualAddressToAbsoluteAddress(newLoc.asString());
        Document doc;

        try {
            doc = DocumentCreator.createNewDocument(JSONUtils.readJSONFile(oldFileLocation));
        } catch (IOException e) {
            throw new FileHandlingException("failed to read Document from '" + oldLoc.asString() + "'");
        }

        try {
            JSONUtils.writeJSONFile(doc.toMap(), newFileLocation);
        } catch (IOException e) {
            throw new FileHandlingException("failed to write the Document JSON file at '" + newLoc.asString() + "'");
        }

        deleteDocument(oldLoc);
    }

    @Override
    public List<String> getFilesInCategory(Location loc) {
        Path path = convertVirtualAddressToAbsoluteAddressAsPath(loc.asString());

        try {
            Stream<Path> list = Files.list(path);
            return list.map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void createCategory(Location loc) throws InvalidLocationException, FailedToCreateCategoryException {
        // note: add doc about how a category name cannot contain a '.'
        if (!loc.isCategory())
            throw new InvalidLocationException("the category name cannot contain a '.'");

        Path path = convertVirtualAddressToAbsoluteAddressAsPath(loc.asString());

        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new FailedToCreateCategoryException(e.toString());
        }
    }

    @Override
    public void deleteCategory(Location loc) throws InvalidLocationException, FailedToDeleteCategoryAndItsContents {
        // note: add doc about deleting category recursively removes everything in it;
        if (!loc.isCategory())
            throw new InvalidLocationException(loc.asString() + " directory does not exist");

        try {
            Path path = convertVirtualAddressToAbsoluteAddressAsPath(loc.asString());

            Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            throw new FailedToDeleteCategoryAndItsContents(e.toString());
        }
    }

    // todo: implement this
//    @Override
//    public void renameCategory(Location oldLoc, Location newLoc) {
//         need to update the locations in library map
//    }

    // todo: add a moveCategory; keep all the files just move to different location
}
