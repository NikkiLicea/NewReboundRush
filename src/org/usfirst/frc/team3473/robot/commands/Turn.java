package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.Robot;
import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private double angle;
	
    public Turn(double angleToTurn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	angle = angleToTurn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(angle > 0) {
    		Robot.drivetrain.setLeft(0.5);
    		Robot.drivetrain.setRight(-0.5);
    	}
    	else {
    		Robot.drivetrain.setLeft(-0.5);
    		Robot.drivetrain.setRight(0.5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentAngle = RobotMap.gyro.getAngle();
        if(Math.abs(currentAngle) < Math.abs(angle))
        	return false;
        else
        	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
