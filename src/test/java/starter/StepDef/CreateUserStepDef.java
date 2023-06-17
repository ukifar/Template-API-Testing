package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Post create user with blank name and blank password json")
    public void postCreateUserWithBlankNameAndBlankPasswordJson() {
        File json = new File(Constants.REQ_BODY_DIR+"CreateUserBlank.json");
        reqresAPI.postCreateUser(json);
    }

    //Negative Case 2
    @Given("Post create user with category name, job, and age")
    public void postCreateUserWithCategoryNameJobAndAge() {
        File json = new File(Constants.REQ_BODY_DIR+"UpdateInvalid.json");
        reqresAPI.postCreateUser(json);
    }
}
