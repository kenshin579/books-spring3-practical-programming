package madvirus.spring.chap06.controller;

import org.springframework.web.multipart.MultipartFile;

public class ReportCommand {

    private String studentNumber;
    //단지 커맨드 클래스에 파라미터와 동일한 이름의 MultipartFile 타입 프로퍼티를 추가해주면 된다
    private MultipartFile report;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public MultipartFile getReport() {
        return report;
    }

    public void setReport(MultipartFile report) {
        this.report = report;
    }

}
