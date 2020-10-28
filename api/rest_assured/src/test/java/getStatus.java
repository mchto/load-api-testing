import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class getStatus extends BaseTest {

    private static String RESOURCE = "/v1/examen/status";

    @Test
    public void getStatusTest(){
        request
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(200)
                .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                .body("status", equalTo("Listos para el examen"));
    }

}
