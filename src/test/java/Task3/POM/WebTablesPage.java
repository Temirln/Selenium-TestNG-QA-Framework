package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.ButtonElement;
import FRAMEWORK.ELEMENTS.TextFieldElement;
import Task3.MODELS.UserTable;
import FRAMEWORK.UTILS.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WebTablesPage extends BaseForm {
    
    private final By registrationForm = By.xpath("//div[@class='fade modal-backdrop show']");
    
    private final By addNewRecord = By.xpath("//button[@id='addNewRecordButton']");
    private final ButtonElement addNewRecordButton = new ButtonElement(addNewRecord,"Add New Record Button");
    
    
    private final By firstname = By.xpath("//input[@id='firstName']");
    private final TextFieldElement firstNameField = new TextFieldElement(firstname,"First Name Field");
    
    private final By lastname = By.xpath("//input[@id='lastName']");
    private final TextFieldElement lastNameField = new TextFieldElement(lastname,"Last Name Field");
    
    private final By email = By.xpath("//input[@id='userEmail']");
    private final TextFieldElement emailField = new TextFieldElement(email,"Email Field");
    
    private final By age = By.xpath("//input[@id='age']");
    private final TextFieldElement ageField = new TextFieldElement(age,"Age Field");
    
    private final By salary = By.xpath("//input[@id='salary']");
    private final TextFieldElement salaryField = new TextFieldElement(salary,"Salary Field");
    
    private final By department = By.xpath("//input[@id='department']");
    private final TextFieldElement departmentField = new TextFieldElement(department,"Department Field");
    
    private final By sumbit = By.xpath("//button[@id='submit']");
    private final ButtonElement submitButton = new ButtonElement(sumbit,"Submit Button");
    
    private final By userRowOdd = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-tr -odd']");
    private final By userRowEven = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-tr -even']");
    private final By userRowTd = By.xpath(".//div[@class='rt-td']");
    
    private final By delete = By.xpath(".//div[@class='action-buttons']//span[2]");
    
    private final By paginationBottom = By.xpath("//div[@class='pagination-bottom']");
    
    public WebTablesPage() {
        super(By.xpath("//div[@class='web-tables-wrapper']"), "Web Tables Page");
    }
    
    public void clickAddButton(){
        addNewRecordButton.waitClick();
    }
    
    public boolean checkFormAppeared(){
        return DriverUtils.getDriver().findElements(registrationForm).size() > 0;
    }
    
    public void fillRegistrationFormAndSubmit(String name, String lastname,String email,String age,String salary,String department){
        firstNameField.waitSend(name);
        lastNameField.waitSend(lastname);
        emailField.waitSend(email);
        ageField.waitSend(age);
        salaryField.waitSend(salary);
        departmentField.waitSend(department);
        
        submitButton.waitClick();
    }
    
    public List<UserTable> getAllUsers(){
        List<WebElement> usersRowOdd =  DriverUtils.getDriver().findElements(userRowOdd);
        List<WebElement> usersRowEven =  DriverUtils.getDriver().findElements(userRowEven);
        
        List<UserTable> users = new ArrayList<>();
        
        List<WebElement> usersRow = new ArrayList<>();
        usersRow.addAll(usersRowEven);
        usersRow.addAll(usersRowOdd);
        
        for(WebElement user: usersRow){
            users.add(getUser(user));
        }
        
        return users;
    }
    
    public UserTable getUser(WebElement user){
    
        List<WebElement> tds = user.findElements(userRowTd);
        String firstname = tds.get(0).getText().strip();
        String lastname = tds.get(1).getText().strip();
        String age = tds.get(2).getText().strip();
        String email = tds.get(3).getText().strip();
        String salary = tds.get(4).getText().strip();
        String department = tds.get(5).getText().strip();
    
        
        return new UserTable(firstname,lastname,age,email,salary,department);
        
    }
    
    public void deleteUser(UserTable userNo){
        List<WebElement> usersRowOdd =  DriverUtils.getDriver().findElements(userRowOdd);
        List<WebElement> usersRowEven =  DriverUtils.getDriver().findElements(userRowEven);
        
        List<WebElement> usersRow = new ArrayList<>();
        usersRow.addAll(usersRowEven);
        usersRow.addAll(usersRowOdd);
        
        for(WebElement user: usersRow){
            List<WebElement> tds = user.findElements(userRowTd);
            String firstname = tds.get(0).getText().strip();
            String lastname = tds.get(1).getText().strip();
            String age = tds.get(2).getText().strip();
            String email = tds.get(3).getText().strip();
            String salary = tds.get(4).getText().strip();
            String department = tds.get(5).getText().strip();

            if (Objects.equals(userNo, new UserTable(firstname, lastname, age, email, salary, department))){
                ButtonElement pagButton = new ButtonElement(paginationBottom,"Pagination Button");
                pagButton.scrollToTheElement();
                tds.get(6).findElement(delete).click();
                break;
            }
            
        }
 
    }
    
}
