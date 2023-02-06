package dp;

public abstract class AbsGameConnectHelper {
    // 외부에서 호출되면 안되지만 하위클래스에서 사용되어야 하므로 protected 로 정의
    protected abstract String doSecurity(String string);
    protected abstract boolean authentication(String id, String password);
    protected abstract int authorization(String userName);
    protected abstract String connection(String info);

    // 템플릿 메소드
    public String requestConnection(String str) {

        // 보안 작업 -> 암호화 된 문자열을 복호화 하는 메소드
        String decodedInfo = doSecurity(str);
        // 반환된 것을 가지고 아이디, 암호를 할당한다.
        String id = "test";
        String password = "password";


        if (!authentication(id, password)) {
            throw new Error("아이디 암호 불일치");
        }
        String userName = "userName";
        int result = authorization(userName);

        switch (result) {
            case 0: // 게임 매니저
                break;
            case 1: // 유료 회원
                break;
            case 2: // 유료 회원
                break;
            case 3: // 권한없음
                break;
            default: // 기타상황
                break;
        }



        return connection(decodedInfo);
    }
}
