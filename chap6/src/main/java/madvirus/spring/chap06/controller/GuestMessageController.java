package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.model.GuestMessage;
import madvirus.spring.chap06.model.GuestMessageList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class GuestMessageController {

    @RequestMapping(value = "/guestmessage/xml.do", method = RequestMethod.GET)
    @ResponseBody
    public GuestMessageList listXml() {
        return getMessageList();
    }

    @RequestMapping(value = "/guestmessage/jsontest.do")
    public String jsonForm() {
        return "guestmessage/jsonform";
    }

    @RequestMapping(value = "/guestmessage/json.do", method = RequestMethod.GET, headers = "accept=application/json")
    @ResponseBody
    public GuestMessageList listJson() {
        return getMessageList();
    }

    private GuestMessageList getMessageList() {
        GuestMessage message1 = new GuestMessage(1, "�޽���", new Date());
        GuestMessage message2 = new GuestMessage(2, "�޽���2", new Date());

        GuestMessageList messageList = new GuestMessageList();
        List<GuestMessage> messages = new ArrayList<GuestMessage>();
        messages.add(message1);
        messages.add(message2);
        messageList.setMessages(messages);

        return messageList;
    }
}
