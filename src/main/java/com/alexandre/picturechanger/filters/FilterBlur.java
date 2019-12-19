package com.alexandre.picturechanger.filters;

import com.alexandre.picturechanger.FiltrerExecption;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.FileWriter;
import java.io.IOException;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class FilterBlur {
    public Mat filterBlur(Mat image, String name) throws FiltrerExecption, IOException {

        int size = 33;
        if(size %2 == 0){
            throw new FiltrerExecption(" ! SIZE MUST BE ODD !");
        }
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        FileWriter fw = new FileWriter("imagefilter.log", true);
        fw.write("File = " + name + "    Filter = Blur \n");
        fw.close();

        return result;
    }
}
