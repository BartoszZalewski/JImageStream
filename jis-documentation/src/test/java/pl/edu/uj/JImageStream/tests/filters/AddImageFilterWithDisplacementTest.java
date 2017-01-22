package pl.edu.uj.JImageStream.tests.filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import pl.edu.uj.JImageStream.collectors.BufferedImageCollector;
import pl.edu.uj.JImageStream.filters.arithmetic.AddImageFilter;
import pl.edu.uj.JImageStream.tests.AbstractBaseTest;

public class AddImageFilterWithDisplacementTest extends AbstractBaseTest {
    @Test
    public void addImageFilterWithDisplacement() {

        BufferedImage addBufferedImage = streamableImage2.stream().collect(new BufferedImageCollector());

        // tag::AddImageFilterWithDisplacement[]
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new AddImageFilter(addBufferedImage, 200, 200))
                .collect(new BufferedImageCollector());
        // end::AddImageFilterWithDisplacement[]

        try {
            ImageIO.write(bufferedImage, "png", new File("target/docs/images/AddImageFilterWithDisplacement.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


