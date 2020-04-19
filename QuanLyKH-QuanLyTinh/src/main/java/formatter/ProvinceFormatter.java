package formatter;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.ProvinceServiceInterface;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    @Autowired
    ProvinceServiceInterface provinceService;

    public ProvinceFormatter() {
    }

    public ProvinceFormatter(ProvinceServiceInterface provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return new Province(text);
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" +object.getName()+"]";
    }
}
