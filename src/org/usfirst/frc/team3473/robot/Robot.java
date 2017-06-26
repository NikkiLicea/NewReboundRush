
package org.usfirst.frc.team3473.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3473.robot.commands.Drive;
import org.usfirst.frc.team3473.robot.commands.ExampleCommand;
import org.usfirst.frc.team3473.robot.commands.IntakeIn;
import org.usfirst.frc.team3473.robot.commands.IntakeOut;
import org.usfirst.frc.team3473.robot.commands.Launch;
import org.usfirst.frc.team3473.robot.commands.MoveForward;
import org.usfirst.frc.team3473.robot.commands.RevGreen;
import org.usfirst.frc.team3473.robot.commands.ShooterMoveDown;
import org.usfirst.frc.team3473.robot.commands.ShooterMoveUp;
import org.usfirst.frc.team3473.robot.commands.Turn;
import org.usfirst.frc.team3473.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3473.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3473.robot.subsystems.Intake;
import org.usfirst.frc.team3473.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

	public static Drivetrain drivetrain = new Drivetrain();
	public static Drive drive = new Drive();
	public static Shooter shooter = new Shooter();
	public static Intake intake = new Intake();
	public static IntakeIn intakeIn = new IntakeIn();
	public static IntakeOut intakeOut = new IntakeOut();
	public static Launch launch = new Launch();
	public static RevGreen revGreen = new RevGreen();
	public static ShooterMoveDown shooterMoveDown = new ShooterMoveDown();
	public static ShooterMoveUp shooterMoveUp = new ShooterMoveUp();
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		CommandGroup autonCommand = new CommandGroup();
		autonCommand.addSequential(new MoveForward(3000));
//		autonCommand.addSequential(new Turn(300, false));
//		autonCommand.addSequential(new MoveForward(1500));
//		autonCommand.addSequential(new Turn(300, false));
//		autonCommand.addSequential(new MoveForward(1500));
//		autonCommand.addSequential(new Turn(300, true));
//		autonCommand.addSequential(new MoveForward(1500));
//		autonCommand.addSequential(new Turn(300, true));
//		autonCommand.addSequential(new MoveForward(1500));
		autonCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		drive.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		OI.actuatorUp.whileHeld(new ShooterMoveUp());
		OI.actuatorDown.whileHeld(new ShooterMoveDown());
		OI.intakeIn.whileHeld(new IntakeIn());
		OI.intakeOut.whileHeld(new IntakeOut());
		OI.servos.whenPressed(new Launch());
		OI.greenSpinners.whileHeld(new RevGreen());
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
