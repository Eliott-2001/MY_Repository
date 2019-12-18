package com.alexandre.picturechanger.filters;

import com.alexandre.picturechanger.FiltrerExecption;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class FilterBlur {
    public Mat filterBlur(Mat image) throws FiltrerExecption {

        int size = 3;
        if(size %2 == 0){
            throw new FiltrerExecption("Size must be odd");
        }
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);

        return result;
    }
}
