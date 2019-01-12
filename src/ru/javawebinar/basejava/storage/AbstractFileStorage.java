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
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
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
        doDelete(file);
    }

    @Override
    protected Resume getFromStorage(File file) {
        Resume resume = null;
        try {
            resume = doRead(file);
        } catch (IOException e) {
            throw new StorageException(file.getName(), "IO Error", e);
        }
        return resume;
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
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> resumes = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                Resume resume = getFromStorage(file);
                resumes.add(resume);
            }
        }
        return resumes;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelete(file);
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

    private void doDelete(File file) {
        if (!file.delete()) {
            throw new SecurityException("can't delete: " + file.getName());
        }
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;
}
