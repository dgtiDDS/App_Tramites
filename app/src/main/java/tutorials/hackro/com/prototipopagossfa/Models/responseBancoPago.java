package tutorials.hackro.com.prototipopagossfa.Models;

/**
 * Created by david on 26/07/16.
 */
public class responseBancoPago {

    private String xml;

    public responseBancoPago(String xml) {
        this.xml = xml;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
