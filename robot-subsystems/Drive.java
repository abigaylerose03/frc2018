package org.usfirst.frc.team1378.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		//Timer Initialization
    		timer = new Timer();
    		reading = timer.get();
	}
    }
    /*
     * change all to arcadeDrive() or tankDrive() for Talon Drive 
     * change all driveCartesian() for Mecanum drive 
     */
    @Deprecated
    public void TeleopControl(double LYAxis, double RYAxis)
    {
    	TDrive.setLeftRightMotorOutputs(LYAxis*0.75, RYAxis*0.75); 
    	VDrive.setLeftRightMotorOutputs(LYAxis*0.75, RYAxis*0.75);
    }

    public static void TimeReset()
    {
    	timer.reset();
    	timer.start();
    }
    
    public static void TimeStop()
    {
    	timer.stop();
    }
    
    public static double TimeGet()
    {
    	return timer.get();
    }
   
    @Deprecated
    public static void AutoTimeReverse(double speed)
    {
    		TDrive.setLeftRightMotorOutputs(0.95*speed, speed);
    		VDrive.setLeftRightMotorOutputs(0.95*speed, speed);
    }
    
    @Deprecated
    public static void AutoTimeForward(double speed)
    {
    		TDrive.setLeftRightMotorOutputs(0.95*-speed, -speed);
    		VDrive.setLeftRightMotorOutputs(0.95*-speed, -speed);
    }
    
    @Deprecated
    public static void AutoTimeLeftTurn(double speed)
    {
    		TDrive.setLeftRightMotorOutputs(0.95*-speed, speed);
    		VDrive.setLeftRightMotorOutputs(0.95*-speed, speed);
    }
    
    @Deprecated
    public static void AutoTimeRightTurn(double speed)
    {
    		TDrive.setLeftRightMotorOutputs(0.95*speed, -speed);
			VDrive.setLeftRightMotorOutputs(0.95*speed, -speed);
	}
    
    @Deprecated
    public static void AutoSenseReverse(double speed, double distance, double read)
    {
    	if(read<distance)
    	{
    		TDrive.setLeftRightMotorOutputs(speed, speed);
    		VDrive.setLeftRightMotorOutputs(speed, speed);
    	}
    	else
    	{
    		TDrive.setLeftRightMotorOutputs(0, 0);
    		VDrive.setLeftRightMotorOutputs(0, 0);
    	}
    }
    
    @Deprecated
    public static void AutoSenseForward(double speed, double distance, double read)
    {
    	if(read>distance)
    	{
    		TDrive.setLeftRightMotorOutputs(-speed, -speed);
    		VDrive.setLeftRightMotorOutputs(-speed, -speed);
    	}
    	else
    	{
    		TDrive.setLeftRightMotorOutputs(0, 0);
    		VDrive.setLeftRightMotorOutputs(0, 0);
    	}
    }
    
    @Deprecated
    public static void AutoSenseTurnLeft(double speed, double distance, double read, boolean free)
    {
    	if(free)
    	{
	    	if(read<distance)
	    	{
	    		TDrive.setLeftRightMotorOutputs(-speed, speed);
	    		VDrive.setLeftRightMotorOutputs(-speed, speed);
	    	}
	    	else
	    	{
	    		TDrive.setLeftRightMotorOutputs(0, 0);
	    		VDrive.setLeftRightMotorOutputs(0, 0);
	    	}
    	}
    	else
    	{
    		if(read>distance)
        	{
        		TDrive.setLeftRightMotorOutputs(-speed, speed);
        		VDrive.setLeftRightMotorOutputs(-speed, speed);
        	}
        	else
        	{
        		TDrive.setLeftRightMotorOutputs(0, 0);
        		VDrive.setLeftRightMotorOutputs(0, 0);
        	}
    	}
    }
    
    @Deprecated
    public static void AutoSenseTurnRight(double speed, double distance, double read, boolean free)
    {
    	if(free)
    	{
	    	if(read<distance)
	    	{
	    		TDrive.setLeftRightMotorOutputs(speed, -speed);
	    		VDrive.setLeftRightMotorOutputs(speed, -speed);
	    	}
	    	else
	    	{
	    		TDrive.setLeftRightMotorOutputs(0, 0);
	    		VDrive.setLeftRightMotorOutputs(0, 0);
	    	}
    	}
    	else
    	{
    		if(read>distance)
        	{
        		TDrive.setLeftRightMotorOutputs(speed, -speed);
        		VDrive.setLeftRightMotorOutputs(speed, -speed);
        	}
        	else
        	{
        		TDrive.setLeftRightMotorOutputs(0, 0);
        		VDrive.setLeftRightMotorOutputs(0, 0);
        	}
    	}
    }
    
}
}
