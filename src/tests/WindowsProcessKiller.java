package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsProcessKiller {

	// command used to get list of running task
	private static final String TASKLIST = "tasklist";
	// command used to kill a task
	private static final String KILL = "taskkill /IM /F ";

	public boolean isProcessRunning(String serviceName) {
		int count=0;
		try {
			Process pro = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (line.startsWith(serviceName)) {
					//System.out.println(line);
					return true;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void killProcess(String serviceName) {

		try {
			Runtime.getRuntime().exec(KILL + serviceName);
			System.out.println(serviceName+" killed successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		WindowsProcessKiller pKiller = new WindowsProcessKiller();

		// To kill a command prompt
		String processName = "geckodriver.exe";

		if(pKiller.isProcessRunning("geckodriver.exe"))
			pKiller.killProcess("geckodriver.exe");
		if(pKiller.isProcessRunning("chromedriver.exe"))
			pKiller.killProcess("chromedriver.exe");
		if(pKiller.isProcessRunning("IEDriverServer.exe"))
			pKiller.killProcess("IEDriverServer.exe");
		

	}
}
