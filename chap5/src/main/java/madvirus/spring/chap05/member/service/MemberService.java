package madvirus.spring.chap05.member.service;

import madvirus.spring.chap05.member.Member;

public interface MemberService {

    void regist(Member member);

    boolean update(String memberId, UpdateInfo info);

}
