package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option(){

        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOPtion);

    }
    @When("user clicks on Add employee button")
    public void user_clicks_on_Add_employee_button(){
        DashBoardPage dash=new DashBoardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_middlename_lastname(){
        AddEmployeePage add=new AddEmployeePage();
       sendText(add.firstName,"Nelson123");
       sendText(add.middleName,"MS");
       sendText(add.lastName,"MS123");

    }
    @When("user enters firstname {string} middlename {string} and lastname {string}")
    public void user_enters_firstname_middlename_and_lastname(String firstname, String middlename, String lastname) {

        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstname);
        sendText(add.middleName, middlename);
        sendText(add.lastName, lastname);
    }
    @When("user enters firstname {string} and middlename {string} and lastname \"Yulia456")
    public void user_enters_firstname_and_middlename_and_lastname_yulia456(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }@When("user enters\"Test123456\" {string} and {string} in application")
    public void user_enters_test123456_and_in_application(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user enters\"Test1212\" {string} and {string} in application")
    public void user_enters_test1212_and_in_application(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }






    @When("user enters\"Test3232\" {string} and {string} in application")
    public void user_enters_test3232_and_in_application(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);

    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }
        @When("add multiple employees and verify they are added successfully")
        public void add_multiple_employees_and_verify_they_are_added_successfully (DataTable employees) throws InterruptedException {
            List<Map<String, String>> employeenames = employees.asMaps();
            for (Map<String, String> employeename : employeenames) {
                String firstnamevalue=employeename.get("firstname");
                String middlenamevalue=employeename.get("middlename");
                String lastnamevalue=employeename.get("lastname");
                System.out.println(firstnamevalue+" "+middlenamevalue+" "+lastnamevalue);

                AddEmployeePage addEmployeePage=new AddEmployeePage();
                sendText(addEmployeePage.firstName,firstnamevalue);
                sendText(addEmployeePage.middleName,middlenamevalue);
                sendText(addEmployeePage.lastName,lastnamevalue);
                click(addEmployeePage.saveBtn);
                //assertion to be used as homework
                Thread.sleep(4000);
                DashBoardPage dash=new DashBoardPage();
                click(dash.addEmployeeButton);
                Thread.sleep(4000);
            }}

            @When("user adds multiple employees from excel file {string} sheet and verify they are added")
            public void user_adds_multiple_employees_from_excel_file_sheet_and_verify_they_are_added(String sheetname) {
                List<Map<String,String>> newemployees= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetname);
                        DashBoardPage dash=new DashBoardPage();
                AddEmployeePage addEmployeePage=new AddEmployeePage();

                Iterator<Map<String,String>> it=newemployees.iterator();
                while(it.hasNext()){
                    Map<String,String> mapNewEmp=it.next();
                    sendText(addEmployeePage.firstName,mapNewEmp.get("Firstname"));
                    sendText(addEmployeePage.middleName,mapNewEmp.get("MiddleName"));
                    sendText(addEmployeePage.lastName,mapNewEmp.get("LastName"));
                    click(addEmployeePage.saveBtn);


                    //assertion complete in hw.
                }

    }}