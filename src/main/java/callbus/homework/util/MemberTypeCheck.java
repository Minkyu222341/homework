package callbus.homework.util;

import org.springframework.stereotype.Component;

@Component
public class MemberTypeCheck {

    public Long memberIdCheck(String userInfo) {
        if (userInfo != null) {
            String memberId = userInfo.split(" ")[1];
            return Long.valueOf(memberId);
        } else {
            return -1L;
        }
    }
}
