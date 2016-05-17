package madvirus.spring.chap05.member.service;

import madvirus.spring.chap05.member.Member;

public class MemberServiceImpl implements MemberService {

    @Override
    public void regist(Member member) {
        System.out.println("MemberServiceImpl.regist() �޼��� ����");
    }

    @Override
    public boolean update(String memberId, UpdateInfo info) {
        System.out.println("MemberServiceImpl.update() �޼��� ����");
        return true;
    }

}
