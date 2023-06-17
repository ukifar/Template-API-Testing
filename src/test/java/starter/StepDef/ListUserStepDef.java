package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class ListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list users with page {string}")
    public void getListUsersWithPage(String page) {
        reqresAPI.getListUsersInvalidParamPage(page);
    }
}
