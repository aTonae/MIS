package mis.oblabs.com.mis.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ato on 02/04/17.
 */

public class Constants {

    public static List<String> navElement;

    public static void setNavElement(){
        navElement = new ArrayList<>();
        navElement.add("Attendace List");
        navElement.add("Company Master");
        navElement.add("Customer Requirement");
        navElement.add("Daily Activity");
        navElement.add("Daily Receipt");
        navElement.add("Due Emc");
        navElement.add("Holiday List");
        navElement.add("Increment Eligibilty");
        navElement.add("Lead");
        navElement.add("Leave Request");
        navElement.add("Leave Details");
        navElement.add("Miscellaneous List");
        navElement.add("New Customer List");
        navElement.add("Rate Master");
        navElement.add("RFA Appoval");
        navElement.add("RFA Expense");
        navElement.add("Rollout");
        navElement.add("Salary Increment");
        navElement.add("Sale Summary");
    }

    public static List<String> getNavElement() {
        return navElement;
    }
}
