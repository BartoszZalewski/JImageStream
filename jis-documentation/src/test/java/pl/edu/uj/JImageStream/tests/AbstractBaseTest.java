package pl.edu.uj.JImageStream.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import pl.edu.uj.JImageStream.collectors.FileCollector;
import pl.edu.uj.JImageStream.model.StreamableImage;

public abstract class AbstractBaseTest {

    protected StreamableImage streamableImage;
    protected StreamableImage streamableImage2;

    @Before
    public void setUp() throws IOException {
        if (!Files.exists(Paths.get("target/docs/images"))) {
            Files.createDirectories(Paths.get("target/docs/images"));
        }
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File("");
        File file2 = new File("");
        try {
            file = new File(classLoader.getResource("lena.png").toURI());
            file2 = new File(classLoader.getResource("car.png").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

        streamableImage = new StreamableImage(file);

        streamableImage.stream().collect(new FileCollector("png", "target/docs/images/lena.png"));

        streamableImage2 = new StreamableImage(file2);
        streamableImage2.stream().collect(new FileCollector("png", "target/docs/images/car.png"));
    }

}