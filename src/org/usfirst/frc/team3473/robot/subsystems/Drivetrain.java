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
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

