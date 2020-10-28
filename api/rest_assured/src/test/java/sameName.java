import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class sameName extends BaseTest{

    private static String RESOURCE = "/v1/examen/sameName";


    @Test
    public void sameName(){
        getRandomName randomName = new getRandomName();
        String jsonBody = "{\n" + "\"name\": \"" + randomName.nameResult + "\" \n}";
        /*System.out.println("BODY ENVIADO==>>" + jsonBody);
        System.out.println("RESULTADO DE RANDOM NAME==>>" + randomName.nameResult);*/

        request
                .body(jsonBody)
                .post(String.format("%s", RESOURCE))
                .then()
                .statusCode(200)
                .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                .body("name", equalTo(randomName.nameResult));
    }

}
