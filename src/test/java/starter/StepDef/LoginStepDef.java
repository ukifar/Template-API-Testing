package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("User login with valid email and password")
    public void userLoginWithValidUsernameAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"LoginBody.json");
        reqresAPI.loginUser(json);
    }
    @When("Send request post login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }
    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int responseCode) {
        SerenityRest.then().statusCode(responseCode);
    }
    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Validate json schema success login user")
    public void validateJsonSchemaSuccessLoginUser() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("User login with valid email and blank password")
    public void userLoginWithValidUsernameAndBlankPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"LoginBlankPassword.json");
        reqresAPI.loginUser(json);
    }
    @And("Response error body should be {string}")
    public void responseErrorBodyShouldBe(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(error));
    }
    @And("Validate json schema failed login user with registered email and blank password")
    public void validateJsonSchemaFailedLoginUser() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginFailedJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 2
    @Given("User login with unregistered email and password")
    public void userLoginWithUnregisteredEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"LoginUnregisteredEmail&Password.json");
        reqresAPI.loginUser(json);
    }
    @And("Validate json schema failed login user with unregistered email and password")
    public void validateJsonSchemaFailedLoginUserWithUnregisteredEmailAndPassword() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginFailedJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
