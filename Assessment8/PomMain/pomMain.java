package Assessment8;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomUtilities.AddCandidatePage;
import PomUtilities.CandidatesPage;
import PomUtilities.LoginPage;
import PomUtilities.LogoutPage;
import PomUtilities.RecruitmentPage;

public class pomMain {

    public static void main(String[] args) throws IOException, InterruptedException {


        // Read Properties File

        FileInputStream file = new FileInputStream("src/main/resources/Assessment8_Data/common_data.properties");

        Properties p = new Properties();

        p.load(file);


        // Get Data

        String Browser = p.getProperty("Browser");

        String url = p.getProperty("url");

        String username = p.getProperty("username");

        String password = p.getProperty("password");
        
        FileInputStream file1=new FileInputStream("src/main/resources/Assessment8_Data/Testing_Data.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		
		String firstName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String middleName = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String lastName = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String mobile = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String filePath = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		

        
        
        // Browser

        WebDriver driver=null;
        

        if (Browser.equals("chrome")) {

            driver = new ChromeDriver();

        } 


        // Browser Settings

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));


        // Open URL

        driver.get(url);


        // LOGIN PAGE

        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);

        login.enterPassword(password);

        login.clickLogin();


        // RECRUITMENT PAGE

        RecruitmentPage recruitment = new RecruitmentPage(driver);

        recruitment.clickRecruitment();


        // ADD CANDIDATE PAGE

        AddCandidatePage addCandidate = new AddCandidatePage(driver);

        addCandidate.clickAdd();
        Thread.sleep(2000);
        addCandidate.enterFirstName(firstName);
        Thread.sleep(2000);
        addCandidate.enterMiddleName(middleName);
        Thread.sleep(2000);
        addCandidate.enterLastName(lastName);
        Thread.sleep(2000);
        addCandidate.selectVacancy();
        Thread.sleep(2000);
        addCandidate.enterEmail(email);
        Thread.sleep(2000);
        addCandidate.enterMobile(mobile);
        Thread.sleep(2000);
        addCandidate.uploadFile(filePath);
        Thread.sleep(2000);
        addCandidate.clickSave();
        Thread.sleep(2000);

        // CANDIDATES PAGE

        CandidatesPage candidates = new CandidatesPage(driver);

        candidates.clickCandidates();
        Thread.sleep(2000);
        candidates.selectJobTitle();
        Thread.sleep(2000);
        candidates.selectVacancy();
        Thread.sleep(2000);
        candidates.selectHiringManager();
        Thread.sleep(2000);
        candidates.selectStatus();
        Thread.sleep(2000);
        candidates.enterCandidateName(firstName,middleName,lastName);
        Thread.sleep(2000);
        candidates.clickSearch();
        Thread.sleep(2000);

        // VERIFY CANDIDATE

        boolean result = candidates.verifyCandidate(firstName);

        Thread.sleep(2000);
        if (result) {

            System.out.println("Candidate is present in Records Found section");

        } else {

            System.out.println("Candidate is NOT present in Records Found section");
        }


        // LOGOUT

        LogoutPage logout = new LogoutPage(driver);
        Thread.sleep(2000);
        logout.logout();


        System.out.println("Testcase completed");


        // Close Browser

        driver.quit();
    }
}

