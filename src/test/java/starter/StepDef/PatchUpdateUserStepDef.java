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

public class PatchUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("Patch update user with valid json and id {int}")
    public void patchUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"PatchUpdateUser.json");
        reqresAPI.patchUpdateUser(id,json);
    }
    @When("Send patch update user")
    public void sendPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }
    @And("Validate patch update user JSON Schema")
    public void validatePatchUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Patch update user with empty name and job with id {int}")
    public void patchUpdateUserWithEmptyNameAndJobWithId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"PatchUpdateUserInvalid.json");
        reqresAPI.patchUpdateUser(id,json);
    }
}
