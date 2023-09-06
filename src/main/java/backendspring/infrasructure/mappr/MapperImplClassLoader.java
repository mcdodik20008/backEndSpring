package backendspring.infrasructure.mappr;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class MapperImplClassLoader extends ClassLoader {
    char sep = File.separatorChar;

    @Override
    @SneakyThrows
    protected Class<?> findClass(String className) {
        String fileName = "target" + sep + "generated-sources" + sep + "annotations" + className.replace('.', sep) + "Impl.java";
        byte[] bytecode = Files.newInputStream(Path.of(fileName)).readAllBytes();
        return defineClass(className, bytecode, 0, bytecode.length);
    }
}
