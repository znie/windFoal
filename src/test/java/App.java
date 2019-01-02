import me.znie.windFoal.AppConstants;
import me.znie.windFoal.container.XmlContainer;
import me.znie.windFoal.validate.ValidateEnum;
import me.znie.windFoal.xml.TransXmlparser;
import me.znie.windFoal.xml.XmlParser;

public class App {
    public static void main(String[] args){
//        System.out.println(ValidateEnum.ACCOUNT.validate("6321212222221222"));
//        System.out.println(ValidateEnum.CERTNO.validate("162522199011222013"));

        XmlParser.getXml("C:\\workspace\\me.znie\\windFoal\\src\\main\\resources\\conf\\trans\\trans.xml");
        XmlParser.getXml("C:\\workspace\\me.znie\\windFoal\\src\\main\\resources\\conf\\gw\\gws.xml");
        TransXmlparser.getRequest(XmlContainer.getINSTANCE().getElement(AppConstants.TRANSID+"/fe/login"));
    }
}
