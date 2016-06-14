package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {

    @RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
    public String form() {
        return "report/submissionForm";
    }

    /*
    1.@RequestParam 어노테이션과 MultipartFile 타입의 파라이터를 이용해서 업로드 파일 데이터를 전달 받을 수 있음

     */
    @RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
    public String submitReport1(
            @RequestParam("studentNumber") String studentNumber,
            @RequestParam("report") MultipartFile report) { //MultipartFile이 제공하는 메서드를 이용해서 업로드 데이터 접근
        printInfo(studentNumber, report);
        return "report/submissionComplete";
    }

    private void printInfo(String studentNumber, MultipartFile report) {
        System.out.println("학생번호: " + studentNumber +
                " 파일 이름: " + report.getOriginalFilename());
    }

    /*
    2. MultipartHttpServletRequest를 이용한 업로드 파일 접근
    -
     */
    @RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
    public String submitReport2(MultipartHttpServletRequest request) {
        String studentNumber = request.getParameter("studentNumber");
        MultipartFile report = request.getFile("report");

        printInfo(studentNumber, report);
        return "report/submissionComplete";
    }

    /*
    3. 커맨드 객체를 통한 업로드 파일 접근
     */
    @RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
    public String submitReport3(ReportCommand reportCommand) {
        printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
        return "report/submissionComplete";
    }

}
