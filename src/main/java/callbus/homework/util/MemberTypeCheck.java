package callbus.homework.util;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class MemberTypeCheck {

    private static final String ANONYMOUS = "ANONYMOUS";

    public Long memberIdCheck(String userInfo) {
        if (userInfo != null) {
            String memberId = userInfo.split(" ")[1];
            return Long.valueOf(memberId);
        } else {
            return -1L;
        }
    }

    public String accountTypeCheck(String userInfo) {
        if (userInfo != null) {
            return userInfo.split(" ")[0];
        } else {
            return ANONYMOUS;
        }
    }
}
