package com.alexandre.picturechanger.filters;

import com.alexandre.picturechanger.FiltrerExecption;
import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.FileWriter;
import java.io.IOException;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
/**
 Apply black and white on an image (grayscale)
 */
public class FilterGrayscale {
    /**
     * @param image The image which be selected for the grayscale
     * @param name The name of the image
     * @return Return the image with filter
     * @throws FiltrerExecption When the filter can't be applied
     * @throws IOException
     */
    public Mat filterGrayscale(Mat image, String name) throws FiltrerExecption, IOException {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        FileWriter fw = new FileWriter("imagefilter.log", true);
        fw.write("File = " + name + "    Filter = Grayscale\n");
        fw.close();
        return result;
    }

}
