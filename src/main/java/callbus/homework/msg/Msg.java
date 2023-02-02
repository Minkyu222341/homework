package callbus.homework.msg;

import lombok.Getter;

@Getter
public enum Msg {
    ALREADY_HEART("이미 추천한 게시글입니다."),
    HEART_SUCCESS("추천했습니다."),
    UNKNOWN_MEMBER("해당 유저가 존재하지 않습니다."),
    UNKNOWN_ARTICLE("존재하지않는 게시물입니다."),
    ACCESS_DENIED("작성 권한이 없습니다"),
    WRITE_SUCCESS("작성되었습니다.");
    private final String msg;
    Msg(String msg) {
        this.msg = msg;
    }
}
