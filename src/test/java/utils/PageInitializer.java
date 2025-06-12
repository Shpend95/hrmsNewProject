package utils;

import pages.*;
import steps.AddEmployeeSteps;

public class PageInitializer {

    public static LoginPage loginPage;
    public static EmployeeSearchPage employeeSearchPage;

    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dashboardPage;
    public static NationalityPage nationalityPage;
    public static AssignPage assignPage;


    public static void initializePageObjects() {
        loginPage = new LoginPage();
        employeeSearchPage = new EmployeeSearchPage();
        addEmployeePage = new AddEmployeePage();
        dashboardPage = new DashboardPage();
        nationalityPage=new NationalityPage();
        assignPage=new AssignPage();


    }
}
