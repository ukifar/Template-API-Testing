package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteInvalidUser(id);
    }
}
