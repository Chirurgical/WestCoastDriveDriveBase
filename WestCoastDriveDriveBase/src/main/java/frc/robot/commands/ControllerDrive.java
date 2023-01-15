// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ControllerDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveBase m_driveBase;
  private double forwardAndBackward;
  private double leftAndRight;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

   //Class constructor to declare  
  public ControllerDrive(DriveBase driveBase, double forwardAndBackward, double leftAndRight) {
    m_driveBase = driveBase;
    this.forwardAndBackward = forwardAndBackward;
    this.leftAndRight = leftAndRight;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     //Reset the speed and rotation of drive base when this method is called.
     m_driveBase.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //When this method executes, the m_driveBase object will move in accordance to the arguments of the arcadeDrive method.
    m_driveBase.arcadeDrive(forwardAndBackward, leftAndRight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
