package by.bsuir.german.service;

import by.bsuir.german.entity.Storage;

import java.io.*;

public class Serialization {

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;

    public Serialization() {
    }

    public void serializeStorage(Storage storage, String filePath) throws IOException {
        fileOutputStream = new FileOutputStream(filePath);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(storage);
        objectOutputStream.flush();
    }

    public Storage desirealizeStorage (String filePath) throws IOException, ClassNotFoundException {
        fileInputStream = new FileInputStream(filePath);
        objectInputStream = new ObjectInputStream(fileInputStream);
        Storage storage = (Storage) objectInputStream.readObject();
        return storage;
    }
}
