import com.fasterxml.jackson.core.JsonParser;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class getRandomName extends BaseTest{

    private static String RESOURCE = "/v1/examen/randomName";
    public static String nameResult;

    @Test
    public void getNameNoAuth(){
        request
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(401)
                .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                .body("message", equalTo("Please login first"));
    }

    /*@Test
    public void getName(){
        request
                .auth()
                .preemptive()
                .basic("testuser", "testpass")
                .get(String.format("%s", RESOURCE))
                .then()
                .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                .statusCode(200);
    }*/

    @Test
    public void getName(){
        Response response =
                request
                    .auth()
                    .preemptive()
                    .basic("testuser", "testpass")
                    .get(String.format("%s", RESOURCE))
                    .then()
                    .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                    .statusCode(200)
                    .extract().response();

        Map<String, Object> details = response.as(new TypeRef<Map<String, Object>>() {});
        nameResult = details.get("name").toString();
        //System.out.println("NOMBRE RETORNA ===>" + nameResult);
        assertThat(details.get("name"), Matchers.notNullValue());

    }

}
