package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;

public class Shooter extends SubsystemBase implements Loggable {
    private CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    private final CANPIDController pidController = shooterFollower.getPIDController();

    public Shooter() {
        shooterFollower.follow(shooterLeader, true);
        pidController.setP(1.7 / 300);
        pidController.setI(0);
        pidController.setD(5.4 * 1000);
    }

    public void setSetpoint(double setpoint) {
        pidController.setReference(setpoint, ControlType.kVelocity);
    }
}
