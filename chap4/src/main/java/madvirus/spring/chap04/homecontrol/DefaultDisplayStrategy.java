package madvirus.spring.chap04.homecontrol;

import org.springframework.stereotype.Component;

@Component("displayStrategy")
public class DefaultDisplayStrategy implements DisplayStrategy {

    @Override
    public DisplayType getDisplayType() {
        return DisplayType.GRID;
    }

}
