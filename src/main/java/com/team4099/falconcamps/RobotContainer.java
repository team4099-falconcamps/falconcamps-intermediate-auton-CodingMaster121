package com.team4099.falconcamps;

import com.team4099.falconcamps.commands.DriveDistanceCommand;
import com.team4099.falconcamps.commands.ShootCommand;
import com.team4099.falconcamps.commands.ShooterIdleCommand;
import com.team4099.falconcamps.commands.TurnAngleCommand;
import com.team4099.falconcamps.subsystems.Drivetrain;
import com.team4099.falconcamps.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import io.github.oblarg.oblog.annotations.Log;

public class RobotContainer {
    @Log
    public Drivetrain drivetrain = new Drivetrain();
    @Log public Shooter shooter = new Shooter();
    public ShootCommand shooterCommand = new ShootCommand(shooter);
    public DriveDistanceCommand distanceCommand = new DriveDistanceCommand(3, drivetrain);
    public TurnAngleCommand turnCommand = new TurnAngleCommand(90, drivetrain);

    public RobotContainer() {
        shooter.setDefaultCommand(new ShooterIdleCommand(shooter));
    }

    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(shooterCommand, turnCommand, distanceCommand);
    }
}
