package pl.edu.uj.JImageStream.tests.filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import pl.edu.uj.JImageStream.collectors.BufferedImageCollector;
import pl.edu.uj.JImageStream.filters.arithmetic.SubImageFilter;
import pl.edu.uj.JImageStream.tests.AbstractBaseTest;

public class SubImageFilterTest extends AbstractBaseTest {
    @Test
    public void subImageFilterTest() {

        BufferedImage carBufferedImage = streamableImage2.stream().collect(new BufferedImageCollector());

        // tag::SubImageFilter[]
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new SubImageFilter(carBufferedImage))
                .collect(new BufferedImageCollector());
        // end::SubImageFilter[]

        try {
            ImageIO.write(bufferedImage, "png", new File("target/docs/images/SubImageFilter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
