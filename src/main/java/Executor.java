import java.util.List;


public interface Executor <T> {

    void addTask(Task<? extends T> task) throws Exception;

    void addTask(Task<? extends T> task, Validator<T> validator) throws Exception;

    void execute();

    <T> List<? extends T> getValidResults() throws Exception;

    <T> List<? extends T> getInvalidResults() throws Exception;
}
