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

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //Positive Case 1
    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id) {
        reqresAPI.getSingleUser(id);
    }
    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID,equalTo(id));
    }
    @And("Validate json scheme single user with valid parameter id")
    public void validateJsonSchemeListUserWithValidParameterId() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get single user with exceed id {}")
    public void getSingleUserWithExceedId(int id) {
        reqresAPI.getSingleUser(id);
    }
    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //Negative Case 2
    @Given("Get single user with first name {string}")
    public void getSingleUserWithFirstNameAndLastName(String firstName) {
        reqresAPI.getInvalidSingleUser(firstName);
    }
    @When("Send requests get single user")
    public void sendRequestsGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_INVALID_SINGLE_USER);
    }
}
