package com.alexandre.picturechanger.filters;

import com.alexandre.picturechanger.FiltrerExecption;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;
/**
 Apply dilate on an image
 */
public class FilterDilate {
    /**
     * @param image The image which be selected for the dilate
     * @param name The name of the image
     * @return Return the image with filter
     * @throws FiltrerExecption When the filter can't be applied
     * @throws IOException
     */

    public Mat filterDilate(Mat image, String name) throws FiltrerExecption, IOException {
        int size = 8;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        FileWriter fw = new FileWriter("imagefilter.log", true);
        fw.write("File = " + name + "    Filter = Dilate\n");
        fw.close();
        return result;
    }

}
