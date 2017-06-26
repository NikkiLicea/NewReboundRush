package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.Robot;
import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	
	private long time; // amount of time, in milliseconds
	private long startingTime;
	private boolean leftright;

    public Turn(long timeInMilliseconds, boolean leftORight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = timeInMilliseconds;
    	leftright = leftORight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(leftright){
    		Robot.drivetrain.setLeft(-0.5);
        	Robot.drivetrain.setRight(-0.5);
    	}
    	else{
    		Robot.drivetrain.setLeft(0.5);
    		Robot.drivetrain.setRight(0.5);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	long currentTime = System.currentTimeMillis();
    	long elapsedTime = currentTime - startingTime;
    	if(elapsedTime < time)
    		return false;
    	else
    		return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setLeft(0.0);
    	Robot.drivetrain.setRight(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.setLeft(0.0);
    	Robot.drivetrain.setRight(0.0);
    }
}
