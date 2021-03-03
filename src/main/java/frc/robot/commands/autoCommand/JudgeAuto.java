// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autoCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.STATE;
import frc.robot.commands.Align;
import frc.robot.commands.BallShooterCommandAuto;
import frc.robot.commands.JoylessDriveAuto;
import frc.robot.commands.JoylessTurnAuto;
import frc.robot.commands.NotShooterIntakeCommand;
import frc.robot.commands.ShooterIntakeCommand;
import frc.robot.commands.Wait;
import frc.robot.libraries.Angle;
import frc.robot.subsystems.NotShooterIntake;
import frc.robot.subsystems.ShooterIntake;
import frc.robot.subsystems.ballShooter;
import frc.robot.subsystems.driveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class JudgeAuto extends SequentialCommandGroup {
  /** Creates a new JudgeAuto. */
  public JudgeAuto(ballShooter bs, ShooterIntake si, NotShooterIntake nsi, driveTrain train, Joystick joy, Angle angle) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    // addCommands();
    super(
      //Start on right, align and shoot
      new Align(train, joy, angle),
      new BallShooterCommandAuto(bs, true, 2500), 
      new Wait(2),
      new ShooterIntakeCommand(si, STATE.FORWARDS), 
      new WaitCommand(0.15),
      new ShooterIntakeCommand(si, STATE.OFF),
      new BallShooterCommandAuto(bs, false, 2500),

      //Move to next center position
      new JoylessTurnAuto(train, 0),
      new JoylessDriveAuto(train, -1, 0, 60),

      //Align and shoot
      new Align(train, joy, angle),
      new BallShooterCommandAuto(bs, true, 2500), 
      new Wait(2),
      new ShooterIntakeCommand(si, STATE.FORWARDS), 
      new WaitCommand(0.15),
      new ShooterIntakeCommand(si, STATE.OFF),
      new BallShooterCommandAuto(bs, false, 2500),

      //Move to left position
      new JoylessTurnAuto(train, 0),
      new JoylessDriveAuto(train, -1, 0, 60),
      new JoylessTurnAuto(train, -15),

      //Align and shoot
      new Align(train, joy, angle),
      new BallShooterCommandAuto(bs, true, 2500), 
      new Wait(2),
      new ShooterIntakeCommand(si, STATE.FORWARDS), 
      new WaitCommand(0.15),
      new ShooterIntakeCommand(si, STATE.OFF),
      new BallShooterCommandAuto(bs, false, 2500),

      //pick up 2 balls
      new JoylessTurnAuto(train, 0),
      new BallPickup(train, nsi),
      new JoylessDriveAuto(train, 1, 0, 60),
      new JoylessTurnAuto(train, 0),

      //Big shoot
      //new JoylessDriveAuto(train, 1, 0, 0);
      new BallShooterCommandAuto(bs, true, 3500), 
      new Wait(2),
      new ShooterIntakeCommand(si, STATE.FORWARDS), 
      new WaitCommand(0.15),
      new ShooterIntakeCommand(si, STATE.OFF),
      new BallShooterCommandAuto(bs, false, 4500),

      //drive to low goal
      new Align(train, joy, angle),
      new JoylessDriveAuto(train, 0, -1, 120),
      new NotShooterIntakeCommand(nsi, STATE.OFF),

      //shoot low
      new BallShooterCommandAuto(bs, true, 2000), 
      new Wait(2),
      new ShooterIntakeCommand(si, STATE.FORWARDS), 
      new WaitCommand(0.15),
      new ShooterIntakeCommand(si, STATE.OFF),
      new BallShooterCommandAuto(bs, false, 2000),

      //back up
      new JoylessDriveAuto(train, 0, 1, 90),

      //spinnnnn
      new JoylessTurnAuto(train, 900)


    );
  }
}
