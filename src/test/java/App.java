import me.znie.windFoal.validate.ValidateEnum;

public class App {
    public static void main(String[] args){
        System.out.println(ValidateEnum.ACCOUNT.validate("6321212222221222"));
        System.out.println(ValidateEnum.CERTNO.validate("162522199011222013"));

    }
}
