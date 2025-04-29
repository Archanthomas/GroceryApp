package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadUtilities {

	public static void main(String[] args) throws AWTException {

		FileUploadUtilities upload = new FileUploadUtilities();
		// upload.fileUploadUsingsendkeys();
		upload.fileUpload_roboClass(null, null);
	}

	public void fileUploadUsingsendkeys(WebElement element, String filepath) {
		element.sendKeys(filepath);

	}

	public void fileUpload_roboClass(WebElement element, String fileInputPath) throws AWTException {

		element.click();
		StringSelection selection = new StringSelection(fileInputPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);// toolkit is a class to copy the
																						// folder path to clip board.
		Robot robo = new Robot();
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_CONTROL);// press control key.
		robo.keyPress(KeyEvent.VK_V);// for press control v key.
		robo.delay(500);
		robo.keyRelease(KeyEvent.VK_CONTROL);// for release control key.
		robo.keyRelease(KeyEvent.VK_V);// for release control v.
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_ENTER);// for press enter.
		robo.keyRelease(KeyEvent.VK_ENTER);// for release enter.

	}

}
