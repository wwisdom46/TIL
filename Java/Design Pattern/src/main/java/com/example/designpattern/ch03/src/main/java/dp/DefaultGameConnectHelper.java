package dp;

import dp.AbsGameConnectHelper;

public class DefaultGameConnectHelper extends AbsGameConnectHelper {

    @Override
    protected String doSecurity(String string) {
        return string;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디/암호 확인과정");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권한 확인");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println("마지막 접속단계");
        return info;
    }
}
