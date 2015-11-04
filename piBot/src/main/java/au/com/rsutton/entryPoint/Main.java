package au.com.rsutton.entryPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import au.com.rsutton.calabrate.CalabrateCompass;
import au.com.rsutton.calabrate.CalabrateLidar;
import au.com.rsutton.calabrate.CalabrateTelemetry;
import au.com.rsutton.i2c.I2cSettings;
import au.com.rsutton.robot.rover.Rover;

import com.pi4j.gpio.extension.adafruit.ADS1115;
import com.pi4j.gpio.extension.adafruit.Adafruit16PwmProvider;

public class Main
{
	boolean distanceOk = true;

	public static void main(String[] args) throws InterruptedException,
			IOException
	{
		// I2CFactory.setFactory(new I2CFactoryProviderBanana());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Press 0 to start the rover\n");
		System.out.println("Press 1 to calabrate compass");
		System.out.println("Press 2 to calabrate lidar");
		System.out.println("Press 3 to calabrate telemetry");

		int ch = br.read();
		if (ch == '0')
		{
			new Rover();
			while (true)
			{
				Thread.sleep(1000);
			}
		} else if (ch == '1')
		{
			new CalabrateCompass();
		} else if (ch == '2')
		{
			new CalabrateLidar();
		} else if (ch == '3')
		{
			new CalabrateTelemetry();
		}

	}

	// private static void sonarFullScanTest() throws IOException,
	// InterruptedException
	// {
	// Adafruit16PwmProvider provider = setupPwm();
	//
	// ADS1115 ads = new ADS1115(1, 0x48);
	//
	// Sonar sonar = new Sonar(0.1, 2880, 0);
	// new FullScan(provider);
	//
	// }

	private static Adafruit16PwmProvider setupPwm() throws IOException,
			InterruptedException
	{
		Adafruit16PwmProvider provider = new Adafruit16PwmProvider(
				I2cSettings.busNumber, 0x40);
		provider.setPWMFreq(30);
		return provider;
	}

	private static void sonarTest() throws IOException, InterruptedException
	{
		ADS1115 ads = new ADS1115(I2cSettings.busNumber, 0x48);

		// Sonar sonar = new Sonar(0.1, 2880, 0);
		// ads.addListener(sonar);
		for (int i = 0; i < 5000; i++)
		{

			// int values = (int) sonar.getCurrentDistance().convert(
			// DistanceUnit.CM);
			// System.out.println("value: " + values);
			Thread.sleep(100);

		}
	}

}
