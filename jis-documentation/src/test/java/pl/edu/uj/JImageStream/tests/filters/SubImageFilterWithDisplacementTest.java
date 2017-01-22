package pl.edu.uj.JImageStream.tests.filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import pl.edu.uj.JImageStream.collectors.BufferedImageCollector;
import pl.edu.uj.JImageStream.filters.arithmetic.SubImageFilter;
import pl.edu.uj.JImageStream.tests.AbstractBaseTest;

public class SubImageFilterWithDisplacementTest extends AbstractBaseTest {
    @Test
    public void subImageFilterWithDisplacementTest() {

        BufferedImage carBufferedImage = streamableImage2.stream().collect(new BufferedImageCollector());

        // tag::SubImageFilterWithDisplacement[]
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new SubImageFilter(carBufferedImage, 200, 200))
                .collect(new BufferedImageCollector());
        // end::SubImageFilterWithDisplacement[]

        try {
            ImageIO.write(bufferedImage, "png", new File("target/docs/images/SubImageFilterWithDisplacement.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
