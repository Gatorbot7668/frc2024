// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax m_motor;

  public IntakeSubsystem() {
    m_motor = new CANSparkMax(Constants.INTAKE_MOTOR_PORT, MotorType.kBrushless);
    m_motor.restoreFactoryDefaults();
  }

  public void in(double speed) {
    m_motor.set(speed);
  }

  public void stop() {
    m_motor.set(0);
  }

  public Command intakeCommand(double speed) {
    return runEnd(() -> { in(speed); },
                  () -> { stop();});
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
