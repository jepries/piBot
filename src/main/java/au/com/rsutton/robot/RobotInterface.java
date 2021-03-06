package au.com.rsutton.robot;

import au.com.rsutton.entryPoint.units.Speed;

public interface RobotInterface
{

	void freeze(boolean b);

	void setSpeed(Speed speed);

	void setHeading(double normalizeHeading);

	void publishUpdate();

	void addMessageListener(RobotListener listener);

}
