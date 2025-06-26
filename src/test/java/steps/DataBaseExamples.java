package steps;

import utils.CommonMethods;
import utils.DataBaseUtils;

import java.util.List;
import java.util.Map;

public class DataBaseExamples extends CommonMethods {



    public static void main(String[] args) {
        //System.out.println(DataBaseUtils.fetch("Select * from person"));
        List<Map<String,String>> allData=DataBaseUtils.fetch("select * from customers;");
        System.out.println(allData.get(2));
        Map<String,String> row=allData.get(2);
        System.out.println(row.get("phone_number"));



    }
}
