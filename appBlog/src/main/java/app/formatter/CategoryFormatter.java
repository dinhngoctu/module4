package app.formatter;

import app.model.Category;
import app.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {

    ICateService cateService;
    @Autowired
    public CategoryFormatter(ICateService cateService) {
        this.cateService = cateService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return cateService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" +object.getName()+"]";
    }
}
