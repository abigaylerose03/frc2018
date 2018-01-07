import edu.wpi.cscore.UsbCamera;

import org.opencv.core.Rect;
import.org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wbilibj.vision.VisionThread;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Vision extends IterativeRobot {
  
  private static int final IMG_WIDTH = 0;
  private static int final IMG_HEIGHT = 0;
  
  private final Object imgLock = new Object();
  
  
  public void robotInit() {
    
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    
    VisionThread = new VisionThread(camera, new VisionPIpeline(), pipeline -> {
     if(!pipeline.filterContoursOutput().isEmpty()) {
       Rect r = Imgproc.boundedRect(pipeline.filterContourdOutput().get(0));
       synchronized(imgLock) {
         centerX = r.x + (r.width / 2);
       }
     } 
    });
    VisionThread.start();
    
  }
}
