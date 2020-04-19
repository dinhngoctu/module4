package app.repository;

import app.repository.repoInterface.IQuizEntityRepo;

public class QuizEntityRepo implements IQuizEntityRepo {

    @Override
    public void add() {

    }

    @Override
    public Long getMaxId() {
        String sqlQuerry = "select max(id) from QuizEntity;";
        return null;
    }
}
