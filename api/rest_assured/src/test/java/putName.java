import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class putName extends BaseTest{

    private static String RESOURCE = "v1/examen/updateName";


    @Test
    public void putNameNoBody(){
        request
                .when()
                .put(String.format("%s",RESOURCE))
                .then()
                .statusCode(406)
                .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                .body("message", equalTo("Name was not provided"));
    }


}
