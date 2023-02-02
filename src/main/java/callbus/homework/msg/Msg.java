package callbus.homework.msg;

import lombok.Getter;

@Getter
public enum Msg {
    UNKNOWN_MEMBER("해당 유저가 존재하지 않습니다."),
    ACCESS_DENIED("작성 권한이 없습니다"),

    WRITE_SUCCESS("작성되었습니다.");
    private final String msg;
    Msg(String msg) {
        this.msg = msg;
    }
}
