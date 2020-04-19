package app.formatter;

import app.model.User;
import app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;


public class UserFormatter implements Formatter<User> {

    IUserService userService;

    @Autowired
    public UserFormatter(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public User parse(String text, Locale locale) throws ParseException {
        return new User(text);
    }

    @Override
    public String print(User user, Locale locale) {
        return "[" +user.getName()+"]";
    }
}
