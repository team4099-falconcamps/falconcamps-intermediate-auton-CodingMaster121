package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {
    private double distanceMeters;
    private Drivetrain drivetrain;
    private PIDController pidController = new PIDController(0, 0, 0);
    private PIDController pidController1 = new PIDController(0, 0, 0);

    public DriveDistanceCommand(double distanceMeters, Drivetrain drivetrain) {
        this.distanceMeters = distanceMeters;
        this.drivetrain = drivetrain;
    }

    @Override 
    public void execute(){
        drivetrain.setLRPower(pidController.calculate(drivetrain.getLeftDistance(), distanceMeters), pidController1.calculate(drivetrain.getRightDistance(), distanceMeters));
    }
}
