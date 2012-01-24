package mmotest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ExceptionHandler {

	public static void exchandle(Exception e) {

		final String filepath = "";

		System.out.println(e.toString());
		e.printStackTrace();

		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		// get current date time with Date()
		Date date = new Date();
		Calendar cal = Calendar.getInstance();

		try {
			// Create file
			String filename = dateFormat.format(date);

			FileWriter fstream = new FileWriter(filepath + filename, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.append(dateFormat.format(cal.getTime()) + e.toString() + "\n");
			out.append(dateFormat.format(cal.getTime())
					+ e.getStackTrace()
					+ "\n<-------------------------------NEW ERROR---------------------------->\n");
			// Close the output stream
			out.close();
		} catch (Exception efile) {// Catch exception if any
			System.err.println(cal.getTime() + "Error: " + efile.getMessage());
		}

	}

}
