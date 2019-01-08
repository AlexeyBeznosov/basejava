package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not dorectory");
        }
        this.directory = directory;
    }

    @Override
    protected void updateStorage(File file, Resume resume) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException(resume.getUuid(), "IO Error", e);
        }
    }

    @Override
    protected void deleteFromStorage(File file) {
        file.delete();
    }

    @Override
    protected Resume getValueStorage(File file) {
        return doRead(file);
    }

    @Override
    protected void addToStorage(Resume resume, File file) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException(resume.getUuid(), "IO Error", e);
        }
    }

    @Override
    protected File findIndexOfResume(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean checkIndexExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> resumes = new ArrayList<>();
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            resumes.add(doRead(files[i]));
        }
        return resumes;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
        }
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        if (files != null) {
            return files.length;
        }
        return 0;
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    protected abstract Resume doRead(File file);
}
