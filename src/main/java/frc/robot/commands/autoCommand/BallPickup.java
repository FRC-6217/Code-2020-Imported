// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autoCommand;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Constants.STATE;
import frc.robot.commands.JoylessDriveAuto;
import frc.robot.commands.NotShooterIntakeCommand;
import frc.robot.subsystems.NotShooterIntake;
import frc.robot.subsystems.driveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BallPickup extends ParallelDeadlineGroup {
  /** Creates a new BallPickup. */
  public BallPickup(driveTrain train, NotShooterIntake intake) {
    // Add the deadline command in the super() call. Add other commands using
    // addCommands().
    super(
      new JoylessDriveAuto(train, -1, 0, 90),
      new NotShooterIntakeCommand(intake, STATE.FORWARDS)
    );
    // addCommands(new FooCommand(), new BarCommand());
  }
}
