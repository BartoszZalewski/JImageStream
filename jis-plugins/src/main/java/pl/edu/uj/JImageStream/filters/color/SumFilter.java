package pl.edu.uj.JImageStream.filters.color;

import pl.edu.uj.JImageStream.api.core.Filter;
import pl.edu.uj.JImageStream.model.Pixel;

import java.awt.Color;
import java.awt.image.BufferedImage;


public class SumFilter extends Filter {

    private BufferedImage bufferedImage;

    public SumFilter(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    @Override
    public void apply(int x, int y) {
        Pixel pixel = getPixel(x, y);

        Color bufferedImagePixelColor = new Color(bufferedImage.getRGB(x, y));

        pixel.setRed((pixel.getRed() + bufferedImagePixelColor.getRed()) / 2);
        pixel.setGreen((pixel.getGreen() + bufferedImagePixelColor.getGreen()) / 2);
        pixel.setBlue((pixel.getBlue() + bufferedImagePixelColor.getBlue()) / 2);

        setPixel(x, y, pixel);

        /*Sample usage
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new SumFilter(bufferedImage1))
                .collect(new BufferedImageCollector());*/
    }
}
