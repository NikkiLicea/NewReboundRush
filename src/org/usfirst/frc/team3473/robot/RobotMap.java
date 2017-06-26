package org.usfirst.frc.team3473.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Servo;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static CANTalon frontLeft = new CANTalon(5);
	public static CANTalon midLeft = new CANTalon(10);
	public static CANTalon backLeft = new CANTalon(6);
	public static CANTalon frontRight = new CANTalon(1);
	public static CANTalon midRight = new CANTalon(11);
	public static CANTalon backRight = new CANTalon(0);
	public static CANTalon intakeIn = new CANTalon(8);
	public static CANTalon shooterUpDown = new CANTalon(3);
	public static CANTalon greenLeft = new CANTalon(4);
	public static CANTalon greenRight = new CANTalon(2);
	public static Servo ballLauncherLeft = new Servo(0);
	public static Servo ballLauncherRight = new Servo(1);
	public static AnalogGyro gyro = new AnalogGyro(0);
}
