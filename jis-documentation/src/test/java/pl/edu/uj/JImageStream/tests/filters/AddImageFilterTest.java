package pl.edu.uj.JImageStream.tests.filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import pl.edu.uj.JImageStream.collectors.BufferedImageCollector;
import pl.edu.uj.JImageStream.filters.arithmetic.AddImageFilter;
import pl.edu.uj.JImageStream.tests.AbstractBaseTest;

public class AddImageFilterTest extends AbstractBaseTest {
    @Test
    public void addImageFilterTest() {

        BufferedImage addBufferedImage = streamableImage2.stream().collect(new BufferedImageCollector());

        // tag::AddImageFilter[]
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new AddImageFilter(addBufferedImage))
                .collect(new BufferedImageCollector());
        // end::AddImageFilter[]

        try {
            ImageIO.write(bufferedImage, "png", new File("target/docs/images/AddImageFilter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


