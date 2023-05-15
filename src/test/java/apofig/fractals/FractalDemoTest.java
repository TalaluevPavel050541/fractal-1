package apofig.fractals;

import io.nayuki.bmpio.BmpImage;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class FractalDemoTest {

    public FractalDemo fractalDemo = new FractalDemo();
    public MandelbrotNew mandelbrotTest = new MandelbrotNew();

    @Test
    public void writeToTest() throws IOException {
        mandelbrotTest.getFunction(-4.5, 2.3, 152);
        BmpImage bmp = new BmpImage();
        Palette palette = new RandomPalette(512);
        Progress image = new Progress(new FractalImage(1920, 1080, mandelbrotTest, palette));
        bmp.image = image;
        fractalDemo.writeTo(bmp,image);
        Assert.assertEquals("MandelbrotNew.bmp", image.getFractalName() + ".bmp");
    }

    @Test
    public void testCreateFile() throws IOException {
        InputStream is = Files.newInputStream(Paths.get("MandelbrotNew.bmp"));
        assertThat(is.read(), notNullValue());
    }
}