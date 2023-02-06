import dp.AbsGameConnectHelper;
import dp.DefaultGameConnectHelper;

public class Main {
    public static void main(String[] args) {
        AbsGameConnectHelper helper = new DefaultGameConnectHelper();

        helper.requestConnection("접속 정보");
    }
}
