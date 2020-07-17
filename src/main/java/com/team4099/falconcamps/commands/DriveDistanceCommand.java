package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class DriveDistanceCommand extends CommandBase implements Loggable {
    private double distanceMeters;
    private Drivetrain drivetrain;
    @Log private PIDController pidController = new PIDController(0, 0, 0);
    @Log private PIDController pidController1 = new PIDController(0, 0, 0);

    public DriveDistanceCommand(double distanceMeters, Drivetrain drivetrain) {
        this.distanceMeters = distanceMeters;
        this.drivetrain = drivetrain;
        this.addRequirements(drivetrain);
    }

    @Override 
    public void execute(){
        drivetrain.setLRPower(pidController.calculate(drivetrain.getLeftDistance(), distanceMeters), pidController1.calculate(drivetrain.getRightDistance(), distanceMeters));
    }
}
