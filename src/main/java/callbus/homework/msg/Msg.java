package callbus.homework.msg;

import lombok.Getter;

@Getter
public enum Msg {
    WITHDRAWAL_MEMBER("탈퇴한 사용자입니다."),
    DELETED_SUCCESS("삭제되었습니다."),
    ANONYMOUS_USER("로그인하지 않은 사용자"),
    UPDATE_SUCCESS("수정되었습니다."),
    ALREADY_HEART("이미 추천한 게시글입니다."),
    HEART_SUCCESS("추천했습니다."),
    UNKNOWN_MEMBER("해당 유저가 존재하지 않습니다."),
    UNKNOWN_ARTICLE("존재하지않는 게시물입니다."),
    ACCESS_DENIED("권한이 없습니다"),
    WRITE_SUCCESS("작성되었습니다.");
    private final String msg;
    Msg(String msg) {
        this.msg = msg;
    }
}
