package callbus.homework.util;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class MemberTypeCheck {

    private static final String ANONYMOUS = "ANONYMOUS";

    public Long memberIdCheck(String memberInfo) {
        if (memberInfo != null) {
            String memberId = memberInfo.split(" ")[1];
            return Long.valueOf(memberId);
        } else {
            return -1L;
        }
    }

    public String accountTypeCheck(String memberInfo) {
        if (memberInfo != null) {
            return memberInfo.split(" ")[0];
        } else {
            return ANONYMOUS;
        }
    }


}
