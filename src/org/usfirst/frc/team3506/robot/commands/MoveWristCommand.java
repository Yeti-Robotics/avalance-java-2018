package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWristCommand extends Command {

    public MoveWristCommand() {
    	requires(Robot.wristSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (RobotMap.USE_GAMEPAD) {
            Robot.wristSubsystem.joystickControl(-Robot.oi.getGamepadLeftY());
        } else {
            if (Math.abs(Robot.oi.getSecondaryY()) <= RobotMap.WRIST_STOP_POWER) {
                Robot.wristSubsystem.joystickControl(RobotMap.WRIST_STOP_POWER);
            } else {
                Robot.wristSubsystem.joystickControl(Robot.oi.getSecondaryY());
            }
        }
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
