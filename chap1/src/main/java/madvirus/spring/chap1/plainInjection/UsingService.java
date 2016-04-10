package madvirus.spring.chap1.plainInjection;

/**
 * Created by ykoh on 2016. 3. 28..
 */
public class UsingService {
    public UsingService() {
        Assembler assembler = new Assembler();

        //조립기부터 사용할 객체를 구함
        WriteArticleService service = assembler.getWriteArticleService();
        service.write(new Article());
    }
}
