package com.alexandre.picturechanger;

        import com.alexandre.picturechanger.filters.FilterBlur;

        import com.alexandre.picturechanger.filters.FilterDilate;
        import com.alexandre.picturechanger.filters.FilterGrayscale;
        import org.apache.commons.cli.*;
        import org.bytedeco.opencv.global.opencv_imgcodecs;
        import org.bytedeco.opencv.opencv_core.Mat;

        import java.io.File;
        import java.io.IOException;
        import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        Options options= new Options();
        options.addOption("i","input-dir",true,"Input directory");
        options.addOption("o","output-dir",true,"Output directory");
        options.addOption("f","filter",true,"Name of the filter");
        options.addOption("h","help",false,"This is help");

        String inputDirArg = "imgs";
        String outputDirArg = "output";

        CommandLineParser parser = new DefaultParser();
        try{
            CommandLine cmd = parser.parse(options,args);
            if(cmd.hasOption("i")){
                inputDirArg=cmd.getOptionValue("i");
                System.out.println(inputDirArg);
            }
            if(cmd.hasOption("o")){
                outputDirArg=cmd.getOptionValue("o");
                System.out.println(outputDirArg);
            }
            if(cmd.hasOption("f")){
                String filterArg=cmd.getOptionValue("f");
                if (filterArg.equals("Blur")){
                    FilterBlur fb = new FilterBlur();

                    File inputDir = new File(inputDirArg);
                    File[] files = inputDir.listFiles();


                    for (File f : files){

                        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

                        try{
                            image = fb.filterBlur(image, f.getName());
                        }catch (FiltrerExecption | IOException e){
                            System.out.println(e.getMessage());
                        }

                        File outputDir = new File(outputDirArg);
                        File outputFile = new File(outputDir, f.getName());
                        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
                    }

                }
                if (filterArg.equals("Dilate")){
                    FilterDilate fd = new FilterDilate();

                    File inputDir = new File(inputDirArg);
                    File[] files = inputDir.listFiles();


                    for (File f : files){

                        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

                        try{
                            image = fd.filterDilate(image, f.getName());
                        }catch (FiltrerExecption | IOException e){
                            System.out.println(e.getMessage());
                        }

                        File outputDir = new File(outputDirArg);
                        File outputFile = new File(outputDir, f.getName());
                        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
                    }

                }
                if(filterArg.equals("Grayscale")){
                    FilterGrayscale fg = new FilterGrayscale();

                    File inputDir = new File(inputDirArg);
                    File[] files = inputDir.listFiles();


                    for (File f : files){

                        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

                        try{
                            image = fg.filterGrayscale(image, f.getName());
                        }catch (FiltrerExecption | IOException e){
                            System.out.println(e.getMessage());
                        }

                        File outputDir = new File(outputDirArg);
                        File outputFile = new File(outputDir, f.getName());
                        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
                    }

                }
            }
            if (cmd.hasOption("h")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "ant", options );
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

}
