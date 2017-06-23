package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setRevGreen(double revSpeedInMethod){
		RobotMap.greenLeft.set(revSpeedInMethod);
		RobotMap.greenRight.set(-revSpeedInMethod);
	}
	public void setServoPosition(double angleInMethod){
		RobotMap.ballLauncherLeft.setAngle(angleInMethod);
		RobotMap.ballLauncherRight.setAngle(-angleInMethod);
	}
	public void shooterUp(){
		RobotMap.shooterUpDown.set(0.4);
	}
	public void shooterDown(){
		RobotMap.shooterUpDown.set(-0.4);
	}
	public void shooterStop(){
		RobotMap.shooterUpDown.set(0);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

