import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

public class JunitTest1 {


    public static final String BASE_URI = "https://reqres.in";

    final Logger LOGGER = LogManager.getLogger(JunitTest1.class.getSimpleName());  //com.org.JunitTest1

    @Before
    public void before(){
        PropertyConfigurator.configure("log4j.properties") ;
        LOGGER.info("setting up base uri to :"+BASE_URI);
        RestAssured.baseURI= BASE_URI;
    }

    @Test
    public void test1(){

        LOGGER.debug("some debug messsge");
        LOGGER.info("this is an info message");
        LOGGER.warn("some warn messsge");
        LOGGER.error("some err messsge");
        LOGGER.fatal("some fatal messsge");
    }

    @Test
    public void getRequest() {
        String API_PATH = "/11api/users";

        // create a request  (blank)
        RequestSpecification request= RestAssured.given();

        LOGGER.info("Sending request to " + API_PATH + "?page=2");

        try {
            //setup and executing request
            Response response = request.get(API_PATH + "?page=2");

            JsonPath jp = response.jsonPath();

            LOGGER.debug("total pages= " + jp.getString("total_pages"));
            LOGGER.debug("total pages= " + jp.getString(""));
            LOGGER.info("request completed successfully");
        }catch(Exception e){
            // e.printStackTrace();
            LOGGER.error("error in executing get request:"+API_PATH+" :: " +e.getMessage());
        }
    }

}
