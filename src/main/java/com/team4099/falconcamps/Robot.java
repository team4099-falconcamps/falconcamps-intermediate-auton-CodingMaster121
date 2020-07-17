package com.team4099.falconcamps;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import io.github.oblarg.oblog.Logger;

public class Robot extends TimedRobot {
    private final RobotContainer robotContainer = new RobotContainer();
    private Command autonomousCommand;

    @Override public void robotInit() {
        Logger.configureLoggingAndConfig(robotContainer, false);
    }

    @Override public void autonomousInit() {
        System.out.println("autonInit");
        autonomousCommand = robotContainer.getAutonomousCommand();
        System.out.println(autonomousCommand);
        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override public void teleopInit() {
        System.out.println("teleInit");
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    @Override public void disabledInit() {}

    @Override public void robotPeriodic() {
        Logger.updateEntries();
        CommandScheduler.getInstance().run();
    }

    @Override public void autonomousPeriodic() {}

    @Override public void disabledPeriodic() {}
}
