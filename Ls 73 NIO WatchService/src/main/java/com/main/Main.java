package com.main;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import static java.nio.file.StandardWatchEventKinds.*;

/**
 * This class implements a directory watcher that recursively monitors a base directory
 * for creations, deletions, and modifications of files and subdirectories.
 * It specifically logs events related to files named 'index.html'.
 */
public class Main {

    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;
    private final Path basePath;

    /**
     * Creates a DirectoryWatcher and registers the given directory.
     * @param dir The directory to watch.
     * @throws IOException if an I/O error occurs.
     */
    public Main(Path dir) throws IOException {
        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException("The provided path is not a directory: " + dir);
        }
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<>();
        this.basePath = dir;

        System.out.printf("Starting to scan and register directories under '%s'%n", dir);
        registerAll(dir);
        System.out.println("Registration complete. Ready for changes.");
    }

    /**
     * Registers a single directory with the watch service.
     * @param dir The directory to register.
     * @throws IOException if an I/O error occurs.
     */
    private void register(Path dir) throws IOException {
        // We register for creation, deletion, and modification events.
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        keys.put(key, dir);
        System.out.printf("Registered directory: %s%n", dir);

        // Check for an existing index.html file upon registration
        Path indexPath = dir.resolve("index.html");
        if (Files.exists(indexPath)) {
            System.out.printf("-> Found existing 'index.html' in: %s%n", dir);
        }
    }

    /**
     * Registers the given directory and all of its sub-directories with the
     * watch service.
     * @param start The starting directory.
     * @throws IOException if an I/O error occurs.
     */
    private void registerAll(final Path start) throws IOException {
        // Walk the file tree and register every directory.
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Processes all events for keys queued to the watcher.
     */
    @SuppressWarnings("unchecked")
    void processEvents() {
        System.out.printf("%n--- Waiting for events ---%n");
        while (true) {
            WatchKey key;
            try {
                // Wait for a key to be available
                key = watcher.take();
            } catch (InterruptedException e) {
                System.err.println("Watch service interrupted. Exiting.");
                Thread.currentThread().interrupt();
                return;
            }

            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW) {
                    System.err.println("OVERFLOW: events may have been lost or discarded.");
                    continue;
                }

                // The filename is the context of the event.
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                Path child = dir.resolve(filename);

                System.out.printf("Event %s: %s%n", kind.name(), child);

                // If a new directory is created, register it and its sub-directories
                if (kind == ENTRY_CREATE) {
                    if (Files.isDirectory(child, LinkOption.NOFOLLOW_LINKS)) {
                        try {
                            registerAll(child);
                        } catch (IOException e) {
                            System.err.printf("Error registering new directory %s: %s%n", child, e.getMessage());
                        }
                    } else if (filename.toString().equals("index.html")) {
                        System.out.printf("--> ACTION: A new 'index.html' was created at: %s%n", dir);
                    }
                }
                // If a file is modified, check if it is our target file.
                else if (kind == ENTRY_MODIFY) {
                    if (filename.toString().equals("index.html")) {
                        System.out.printf("--> ACTION: 'index.html' was modified at: %s%n", dir);
                    }
                }
            }

            // Reset the key. If the directory is no longer accessible, the key
            // will be invalid. The directory is automatically unregistered.
            boolean valid = key.reset();
            if (!valid) {
                Path unregisteredDir = keys.remove(key);
                if (unregisteredDir != null) {
                    System.out.printf("Directory unregistered: %s (It was likely deleted)%n", unregisteredDir);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Create a temporary directory to act as the base path for demonstration.
        // In a real application, you would replace this with a specific path.
        Path tempDir = Files.createTempDirectory("MyWatchedFolder");
        tempDir.toFile().deleteOnExit(); // Clean up on JVM exit

        System.out.println("======================================================");
        System.out.printf("Java Directory Watch Service Demo%n");
        System.out.printf("Monitoring base path: %s%n", tempDir.toAbsolutePath());
        System.out.println("======================================================");
        System.out.println("Try the following actions in separate terminal windows:");
        System.out.printf("1. Create a new directory: mkdir %s/new_folder%n", tempDir.toAbsolutePath());
        System.out.printf("2. Create an index file: touch %s/index.html%n", tempDir.toAbsolutePath());
        System.out.printf("3. Modify the index file: echo 'hello' >> %s/index.html%n", tempDir.toAbsolutePath());
        System.out.printf("4. Create a nested directory: mkdir -p %s/new_folder/deep_folder%n", tempDir.toAbsolutePath());
        System.out.printf("5. Create an index file in a subfolder: touch %s/new_folder/index.html%n", tempDir.toAbsolutePath());
        System.out.printf("6. Delete a directory: rm -rf %s/new_folder%n", tempDir.toAbsolutePath());
        System.out.println("Press Ctrl+C to exit.");
        System.out.println("------------------------------------------------------");


        new Main(tempDir).processEvents();
    }
}


/*
OUTPUT Example

Starting to scan and register directories under 'C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634'
Registered directory: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634
Registration complete. Ready for changes.

--- Waiting for events ---
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\New folder
Registered directory: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\New folder
Event ENTRY_DELETE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\New folder
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC
Registered directory: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\New folder
Registered directory: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\New folder
Event ENTRY_MODIFY: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC
Event ENTRY_DELETE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\New folder
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234
Registered directory: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234
Event ENTRY_MODIFY: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234\New Text Document.txt
Event ENTRY_MODIFY: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234
Event ENTRY_DELETE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234\New Text Document.txt
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234\index.html
--> ACTION: A new 'index.html' was created at: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234
Event ENTRY_MODIFY: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234
Event ENTRY_MODIFY: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234\index.html
--> ACTION: 'index.html' was modified at: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\ABC\a1234
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\New Text Document.txt
Event ENTRY_DELETE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\New Text Document.txt
Event ENTRY_CREATE: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634\index.html
--> ACTION: A new 'index.html' was created at: C:\Users\LENOVO\AppData\Local\Temp\MyWatchedFolder11128316955163597634


 */