package pl.edu.uj.JImageStream.filters.arithmetic;

import pl.edu.uj.JImageStream.api.core.Filter;
import pl.edu.uj.JImageStream.model.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class AddImageFilter extends Filter {

    private BufferedImage bufferedImage;
    private int x;
    private int y;

    public AddImageFilter(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.x = 0;
        this.y = 0;
    }

    public AddImageFilter(BufferedImage bufferedImage, int x, int y) {
        this.bufferedImage = bufferedImage;
        this.x = x;
        this.y = y;
    }

    @Override
    public void apply(int x, int y) {
        Pixel pixel = getPixel(x, y);
        try{
            Color bufferedImagePixelColor = new Color(bufferedImage.getRGB(x - this.x, y - this.y));
            pixel.setRed((pixel.getRed() + bufferedImagePixelColor.getRed()) / 2);
            pixel.setGreen((pixel.getGreen() + bufferedImagePixelColor.getGreen()) / 2);
            pixel.setBlue((pixel.getBlue() + bufferedImagePixelColor.getBlue()) / 2);

            setPixel(x, y, pixel);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
    }
}
