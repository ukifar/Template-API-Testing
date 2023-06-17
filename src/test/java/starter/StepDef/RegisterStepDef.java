package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("User register with valid email and password")
    public void userRegisterWithValidEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterUserValid.json");
        reqresAPI.registerUser(json);
    }
    @When("Send request post register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
    @And("Response body id should be {int} and token {string}")
    public void responseBodyIdShouldBeAndToken(int id, String token) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id)).body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserValidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("User register with valid email and blank password")
    public void userRegisterWithValidEmailAndBlankPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterUserInvalid.json");
        reqresAPI.registerUser(json);
    }
    @And("Validate json schema failed register user with valid email and blank password")
    public void validateJsonSchemaFailedRegisterUserWithValidEmailAndBlankPassword() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserInvalidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(error));
    }
}
