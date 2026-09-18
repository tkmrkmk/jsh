package jsh.util.debugging.file;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileIoExample {
    public static void main(final String[] args) {
        final Path path = Path.of(".");
        Files.exists(path);
        System.out.println(path.toAbsolutePath());
    }
}
