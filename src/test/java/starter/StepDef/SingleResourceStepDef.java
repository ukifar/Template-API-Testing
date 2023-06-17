package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

public class SingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("Get single resource with id {int}")
    public void getSingleResourceWithId(int id) {
        reqresAPI.getSingleResource(id);
    }
    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }
    @And("Validate json scheme single resource with valid parameter id")
    public void validateJsonSchemeSingleResourceWithValidParameterId() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleResourceJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get single resource with exceed id {int}")
    public void getSingleResourceWithExceedId(int id) {
        reqresAPI.getSingleResource(id);
    }
}
