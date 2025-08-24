package utils;

import io.restassured.RestAssured;

public class Constants {
    public static final String CONFIG_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public static final String EXCEL_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/testData/Batch19TestData1.xlsx";

    public static final String SCREENSHOTS_PATH=System.getProperty("user.dir")+"/src/screenshots/";

    public static final String DB_URL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
    public static final String USER_NAME="syntax_hrm";
    public static final String USER_PASSWORD="syntaxhrm123";

    public static final String BASEURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_EMPLOYEE_URI = BASEURI +"/createEmployee.php";
    public static final String GENERATE_TOKEN_URI = BASEURI+"/generateToken.php";
    public static final String GET_ONE_EMPLOYEE_URI = BASEURI+"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI = BASEURI+"/updateEmployee.php";


    public static final String HEADER_CONTENT_TYPE_KEY="Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE="application/json";
    public static final String HEADER_AUTHORIZATION_KEY="Authorization";
}

