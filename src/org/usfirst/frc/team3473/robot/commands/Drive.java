package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.OI;
import org.usfirst.frc.team3473.robot.Robot;
import org.usfirst.frc.team3473.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double left = -OI.leftJoystick.getY();
    	double right = -OI.rightJoystick.getY();
    	
    	if(Math.abs(left) < 0.1)
    		left = 0;
    	if(Math.abs(right) < 0.1)
    		right = 0;
    	
    	Robot.drivetrain.setLeft(left);
    	Robot.drivetrain.setRight(right);
    	
//    	Drivetrain.Drive(OI.rightJoystick.getY(), OI.leftJoystick.getX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}