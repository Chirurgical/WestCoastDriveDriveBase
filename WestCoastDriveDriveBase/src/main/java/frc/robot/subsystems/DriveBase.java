// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveBase extends SubsystemBase {

  //Instantiating objects for each left motor
  CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax m_midLeft = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax m_rearLeft = new CANSparkMax(3, MotorType.kBrushless);
  //Creating m_left object with all left motor as fields to group them together.
  MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_frontLeft, m_midLeft, m_rearLeft);

  //Instantiating object for each right motor
  CANSparkMax m_frontRight = new CANSparkMax(4, MotorType.kBrushless);
  CANSparkMax m_midRight = new CANSparkMax(5, MotorType.kBrushless);
  CANSparkMax m_rearRight = new CANSparkMax(6, MotorType.kBrushless);

  //Instant m_right object with all right motor as fields to group them together.
  MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_frontRight, m_midRight, m_rearRight);

  /*Instantiating differential drive object using the m_left and m_right objects to control all motors. 
  Enables usage of the DifferentialDrive class methods. */
  DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  //Instantiating gyro object with the appropriate port in the class constructor.
  AHRS m_gyro = new AHRS(Port.kMXP);
  //Instantiating a smart dashboard object so we can use methods from the SmartDashBoard class
  SmartDashBoard m_smartDashBoard = new SmartDashBoard();

  //Inverting the right side motors with the setInverted method so the robot won't spin in circles when we move.
  public DriveBase() {
    m_right.setInverted(true);
    m_left.setInverted(false);
  }
  
  /*Creating method for arcade drive to set speed and rotation of the drive base. Inside the method, I set
  the m_diffDrive class with the dot modifier so we can use the arcadeDrive method with that object.*/
  public void arcadeDrive(double xSpeed, double zRotation){
    m_diffDrive.arcadeDrive(xSpeed, zRotation);
  }

  //This method returns the angle of the gyro.
  public double getAngle(){
    return m_gyro.getAngle();
  }

  @Override
  public void periodic() {
    /*Calling the SmartDashBoard object with putNumber method to display the Z angle on the SmartDashboard. 
     The "Angle" string acts as a label for the getAngle() values we will get on the SmartDashboard. 
     This keeps running forever as the drive base moves.
    */
    m_smartDashBoard.putNumber("Angle", getAngle()); 

    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
