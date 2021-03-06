// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.IntakeSub;

public class AutoDriveTwo extends CommandBase {
  DriveTrainSub drivetrain;
  IntakeSub intake;
  Timer timer;
  private boolean finish = false;
  /** Creates a new AutoDriveTwo. */
  public AutoDriveTwo(DriveTrainSub dt, IntakeSub i) {
    drivetrain = dt;
    intake = i;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain, intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.retractIntake();
    timer.reset();
    timer.start();
    /*
    while (timer.get() < 2)
    {
      drivetrain.autoDriveTwo();
    }
    */
    timer.stop();
    finish = true;
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
