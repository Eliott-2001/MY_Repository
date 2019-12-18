package com.alexandre.picturechanger.filters;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class filterBlur {
    public Mat filterBlur(Mat image) {
        int size = 3;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }
}
