import org.junit.jupiter.api.Test;

public class RegexTest {


    @Test
    public void test() {


        String regex = "^[a-zA-Z_]([a-zA-Z_0-9])*$";

        boolean matches = "mysql_asset_factor_database ".matches(regex);
        System.out.println(matches);
    }
}
