package com.alexandre.picturechanger;

        import com.alexandre.picturechanger.filters.FilterBlur;
        import org.bytedeco.opencv.global.opencv_imgcodecs;
        import org.bytedeco.opencv.opencv_core.Mat;

        import java.io.File;
        import java.io.IOException;

public class App {

    public static void main(String[] args) {


        FilterBlur fb = new FilterBlur();

            File inputDir = new File("imgs");
            File[] files = inputDir.listFiles();


            for (File f : files){

                Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

                try{
                    image = fb.filterBlur(image, f.getName());
                }catch (FiltrerExecption | IOException e){
                  System.out.println(e.getMessage());
                }

                File outputDir = new File("output");
                File outputFile = new File(outputDir, f.getName());
                opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
            }

    }

}
