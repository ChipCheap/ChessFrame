package com.chessframe.util;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * The NetworkImage stores an image needed for displaying
 * and information for transmitting the avatar of the network.
 *
 * @link some private methods are from:
 * https://gist.github.com/jamesthompson/3344090#file-javafximageconversion-java-L26
 */
public class NetworkImage {
    private Image image;
    private String base64Pixels;
    private byte[] rawPixels;
    private int width;
    private int height;

    /**
     * Initialize a NetworkImage from a base64 string.
     * The String is converted to the raw byte array, representing the pixels.
     *
     * @param base64Pixels the base64 string.
     * @param width        the width of the image.
     * @param height       the height of the image.
     * @throws Base64DecodingException when there is an issue decoding the base64 string.
     */
    public NetworkImage(String base64Pixels, int width, int height) throws Base64DecodingException {
        this(Base64.decode(base64Pixels), width, height);
        this.base64Pixels = base64Pixels;
    }

    /**
     * Initialize a NetworkImage from raw pixels.
     *
     * @param rawPixels the raw pixels.
     * @param width     the width of the image.
     * @param height    the height of the image.
     */
    public NetworkImage(byte[] rawPixels, int width, int height) {
        this.rawPixels = rawPixels;
        this.width = width;
        this.height = height;
    }

    /**
     * Get the JavaFX image representation of the avatar
     * at the requested size from the image cache.
     *
     * @return the avatar image.
     */
    public Image getImage() throws IOException {
        if (image == null) {
            image = getJavaFXImage(this.rawPixels, width, height);
        }

        return image;
    }

    /**
     * Get a base64 representation of the pixels of the avatar.
     *
     * @return the base64 representation of the pixels.
     */
    public String getAsBase64Pixels() {
        if (this.base64Pixels == null)
            this.base64Pixels = Base64.encode(this.rawPixels);
        return this.base64Pixels;
    }

    private Image getJavaFXImage(byte[] rawPixels, int width, int height) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(createBufferedImage(rawPixels, width, height), "png", out);
        out.flush();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        return new javafx.scene.image.Image(in);
    }

    private BufferedImage createBufferedImage(byte[] pixels, int width, int height) {
        SampleModel sm = getIndexSampleModel(width, height);
        DataBuffer db = new DataBufferByte(pixels, width * height, 0);
        WritableRaster raster = Raster.createWritableRaster(sm, db, null);
        IndexColorModel cm = getDefaultColorModel();
        return new BufferedImage(cm, raster, false, null);
    }

    private SampleModel getIndexSampleModel(int width, int height) {
        IndexColorModel icm = getDefaultColorModel();
        WritableRaster wr = icm.createCompatibleWritableRaster(1, 1);
        SampleModel sampleModel = wr.getSampleModel();
        sampleModel = sampleModel.createCompatibleSampleModel(width, height);
        return sampleModel;
    }

    private IndexColorModel getDefaultColorModel() {
        byte[] r = new byte[256];
        byte[] g = new byte[256];
        byte[] b = new byte[256];
        for (int i = 0; i < 256; i++) {
            r[i] = (byte) i;
            g[i] = (byte) i;
            b[i] = (byte) i;
        }
        return new IndexColorModel(8, 256, r, g, b);
    }
}
