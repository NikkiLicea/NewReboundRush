package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeft(double speed) {
		RobotMap.frontLeft.set(speed);
		RobotMap.midLeft.set(speed);
		RobotMap.backLeft.set(speed);
	}
	
	public void setRight(double speed) {
		RobotMap.frontRight.set(-speed);
		RobotMap.midRight.set(-speed);
		RobotMap.backRight.set(-speed);
	}
	
//public static void Drive(double rightValue, double leftValue){
//		if(rightValue > 0.1 || rightValue < -0.1){
//			RobotMap.frontLeft.set(-rightValue);
//			RobotMap.midLeft.set(-rightValue);
//			RobotMap.backLeft.set(-rightValue);
//
//			RobotMap.frontRight.set(rightValue);
//			RobotMap.midRight.set(rightValue);
//			RobotMap.backRight.set(rightValue);
//		}
//
//		else {
//			RobotMap.frontLeft.set(leftValue);
//			RobotMap.midLeft.set(leftValue);
//			RobotMap.backLeft.set(leftValue);
//
//			RobotMap.frontRight.set(leftValue);
//			RobotMap.midRight.set(leftValue);
//			RobotMap.backRight.set(leftValue);
//		}
//}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

