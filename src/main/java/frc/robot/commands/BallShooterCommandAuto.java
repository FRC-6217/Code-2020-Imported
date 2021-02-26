/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballShooter;

public class BallShooterCommandAuto extends CommandBase {
  private boolean ifOn;
  private ballShooter shooter;
  private double rpm;
  /**
   * Creates a new ShooterCommand.
   */
  public BallShooterCommandAuto(ballShooter shooter, boolean ifOn, double rpm) {
    addRequirements(shooter);
    this.shooter = shooter;
    this.ifOn = ifOn;
    this.rpm = rpm;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Top Shoot Set Auto", rpm);
    SmartDashboard.putNumber("Bottom Shoot Set Auto", rpm);
  }

  // Called every time the scheduler runs while the command is scheduled
  @Override
  public void execute() {
    double top = SmartDashboard.getNumber("Top Shoot Set", 0);
    double bottom = SmartDashboard.getNumber("Bottom Shoot Set", 0);
    //TODO make distance based
    if(ifOn){
      shooter.onPID(top, bottom);
      //shooter.on();
    }
    else{
      shooter.off();
    }
    SmartDashboard.putBoolean("On?", ifOn);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
