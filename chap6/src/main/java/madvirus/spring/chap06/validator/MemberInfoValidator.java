package madvirus.spring.chap06.validator;

import madvirus.spring.chap06.model.Address;
import madvirus.spring.chap06.model.MemberInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberInfoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberInfo memberInfo = (MemberInfo) target;
        if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
            errors.rejectValue("id", "required"); //rejectValue() 메서드는 실제로 오류 정보를 List<ObjectError>에 담는다
        }
        if (memberInfo.getName() == null
                || memberInfo.getName().trim().isEmpty()) {
            errors.rejectValue("name", "required");
        }
        Address address = memberInfo.getAddress();
        if (address == null) {
            errors.rejectValue("address", "required");
        }
        if (address != null) {
            errors.pushNestedPath("address"); //todo: 알뜻 모를뜻
            try {
                if (address.getZipcode() == null
                        || address.getZipcode().trim().isEmpty()) {
                    errors.rejectValue("zipcode", "required");
                }
                if (address.getAddress1() == null
                        || address.getAddress1().trim().isEmpty()) {
                    errors.rejectValue("address1", "required");
                }
            } finally {
                errors.popNestedPath();
            }
        }
    }

}
