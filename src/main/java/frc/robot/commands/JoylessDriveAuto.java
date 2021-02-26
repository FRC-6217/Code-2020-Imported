// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class JoylessDriveAuto extends CommandBase {
  private final driveTrain train;

  private double y;
  private double x;
  private double distance;



  /** Creates a new JoyDriveAuto. */
  public JoylessDriveAuto(driveTrain train, double y, double x, double distance) {
    addRequirements(train);

    this.train = train;

    this.y = y;
    this.x = x;
    this.distance = distance;
    

    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    train.resetDistance();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    train.Drive(-y, x, 0, 0.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    train.Drive(0, 0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(train.getDistance()) >= Math.abs(distance ));
  }
}
