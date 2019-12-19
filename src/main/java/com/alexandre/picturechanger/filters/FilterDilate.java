package com.alexandre.picturechanger.filters;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.FileWriter;
import java.io.IOException;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class FilterDilate {

    public Mat filterDilate(Mat image, String name) throws IOException {
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
