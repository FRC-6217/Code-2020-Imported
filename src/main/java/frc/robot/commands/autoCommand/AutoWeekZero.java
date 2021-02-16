/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.STATE;
import frc.robot.commands.Align;
import frc.robot.commands.BallShooterCommand;
import frc.robot.commands.BallShooterCommandAuto;
import frc.robot.commands.ShooterIntakeCommand;
import frc.robot.commands.Wait;
import frc.robot.libraries.Angle;
import frc.robot.subsystems.ballShooter;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.ShooterIntake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoWeekZero extends SequentialCommandGroup {
  /**
   * Creates a new AutoWeekZero.
   */
  public AutoWeekZero(ballShooter bs, ShooterIntake si, driveTrain train, Joystick joy, Angle angle) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new Align(train, joy, angle), 
    // new Wait(5),
    new  BallShooterCommandAuto(bs, true), 
    new Wait(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF), 
    new WaitCommand(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF), 
    new WaitCommand(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF),
    new WaitCommand(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF),
    new WaitCommand(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF),
    new WaitCommand(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF),
    new WaitCommand(1),
    new ShooterIntakeCommand(si, STATE.FORWARDS), 
    new WaitCommand(0.15),
    new ShooterIntakeCommand(si, STATE.OFF),
    new BallShooterCommandAuto(bs, false));
  }
}
