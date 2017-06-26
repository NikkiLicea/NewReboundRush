package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void TreadIn(){
		RobotMap.intakeIn.set(-1);
	}
	
	public void TreadOut(){
		RobotMap.intakeIn.set(1);
	}
	
	public void TreadStop(){
		RobotMap.intakeIn.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

