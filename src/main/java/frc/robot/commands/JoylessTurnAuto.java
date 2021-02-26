// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class JoylessTurnAuto extends CommandBase {
  private final driveTrain train;
  private double angle;
  private int direction = 1;
  


  /** Creates a new JoylessTurnAuto. */
  public JoylessTurnAuto(driveTrain train, double angle) {
    addRequirements(train);
    this.train = train;

    this.angle = angle;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double shortest = Math.abs(train.GetAngle() - angle);
    if(shortest > Math.abs(train.GetAngle() + 360 - angle)){
      shortest = Math.abs(train.GetAngle() + 360 - angle);
      //TODO fix?!
      direction = -1;
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    train.Drive(0, 0, direction, 0.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    train.Drive(0, 0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //TODO does gyro wrap?
    return (Math.abs(train.GetAngle()) > Math.abs(angle));
  }
}
