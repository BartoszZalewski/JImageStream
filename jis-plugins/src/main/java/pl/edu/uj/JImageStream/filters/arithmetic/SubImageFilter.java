package pl.edu.uj.JImageStream.filters.arithmetic;

import pl.edu.uj.JImageStream.api.core.Filter;
import pl.edu.uj.JImageStream.model.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class SubImageFilter extends Filter {

    private BufferedImage bufferedImage;
    private int x;
    private int y;

    public SubImageFilter(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.x = 0;
        this.y = 0;
    }

    public SubImageFilter(BufferedImage bufferedImage, int x, int y) {
        this.bufferedImage = bufferedImage;
        this.x = x;
        this.y = y;
    }

    @Override
    public void apply(int x, int y) {
        Pixel pixel = getPixel(x, y);
        try{
            Color bufferedImagePixelColor = new Color(bufferedImage.getRGB(x - this.x, y - this.y));
            pixel.setRed(abs(pixel.getRed() - bufferedImagePixelColor.getRed()));
            pixel.setGreen(abs(pixel.getGreen() - bufferedImagePixelColor.getGreen()));
            pixel.setBlue(abs(pixel.getBlue() - bufferedImagePixelColor.getBlue()));

            setPixel(x, y, pixel);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
    }
}
