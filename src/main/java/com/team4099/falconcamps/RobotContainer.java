package com.team4099.falconcamps;

import com.team4099.falconcamps.commands.ShootCommand;
import com.team4099.falconcamps.subsystems.Drivetrain;
import com.team4099.falconcamps.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
    public Drivetrain drivetrain = new Drivetrain();
    public Shooter shooter = new Shooter();
    public ShootCommand shooterCommand = new ShootCommand(shooter);

    public RobotContainer() {

    }

    public Command getAutonomousCommand() {
        return shooterCommand.withTimeout(5.0);
    }
}
