package com.alexandre.picturechanger;

        import com.alexandre.picturechanger.filters.filterBlur;
        import com.alexandre.picturechanger.filters.filterDilate;
        import com.alexandre.picturechanger.filters.filterGrayscale;
        import org.bytedeco.opencv.global.opencv_imgcodecs;
        import org.bytedeco.opencv.opencv_core.Mat;

        import java.io.File;

public class App {

    public static void main(String[] args) {
        filterBlur fb = new filterBlur();



        File inputDir = new File("imgs");
        File[] files = inputDir.listFiles();

        for (File f : files){

            Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
            image = fb.filterBlur(image);

            File outputDir = new File("output");
            File outputFile = new File(outputDir, f.getName());
            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

            System.out.println("Les images sont bien modifiées");
        }


    }
}
