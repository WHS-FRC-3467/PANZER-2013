package org.usfirst.frc0.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc0.OI;
import org.usfirst.frc0.subsystems.ArmRoller;
import org.usfirst.frc0.subsystems.DriveBase;
import org.usfirst.frc0.subsystems.Pneumatics;
import org.usfirst.frc0.subsystems.Shooter;
import org.usfirst.frc0.subsystems.ShooterRoller;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    private static DriveBase driveSubsystem;
    private static Shooter shooterSubsystem;
    private static ArmRoller armRollerSubsystem;
    private static Pneumatics pneumaticsSubsystem;
    private static ShooterRoller shooterRollerSubsystem;

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        //oi = new OI();
    	OI.getInstance();
    	driveSubsystem = DriveBase.getInstance();
    	shooterSubsystem = Shooter.getInstance();
    	armRollerSubsystem = ArmRoller.getInstance();
    	pneumaticsSubsystem = Pneumatics.getInstance();
    	shooterRollerSubsystem = ShooterRoller.getInstance();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveSubsystem);
        SmartDashboard.putData(shooterSubsystem);
        SmartDashboard.putData(armRollerSubsystem);
        SmartDashboard.putData(pneumaticsSubsystem);
        SmartDashboard.putData(shooterRollerSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
