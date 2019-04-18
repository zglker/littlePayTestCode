import Model.Client;
import org.junit.Assert;
import org.junit.Test;


public class ClientTest {

    @Test
    public void getPAN() {
        Client client = new Client("5500005555555559");
        Assert.assertEquals("5500005555555559",client.getPAN());
    }
}