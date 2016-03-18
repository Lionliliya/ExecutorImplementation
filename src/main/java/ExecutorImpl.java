import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<Number> implements Executor {

    private List<Task<? extends Number>> validList;
    private List<Task<? extends Number>> invalidList;
    private long executeCounter;
    private boolean executeIsRun;

    public ExecutorImpl() {
        this.validList = new ArrayList<>();
        this.invalidList = new ArrayList<>();
        this.executeCounter = 0;
        this.executeIsRun = false;
    }

    @Override
    public void addTask(Task task) throws Exception {
        if (executeIsRun) {
            throw new Exception("ERROR!!!Executor is run");
        } else {
           NumberValidator numberValidator = new NumberValidator();
           addTask(task, numberValidator);
        }

    }

    @Override
    public void addTask(Task task, Validator validator) throws Exception {
        if (executeIsRun) {
            throw new Exception("ERROR!!!Executor is run");
        } else {
            if (validator.isValid(task)) {
                validList.add(task);
            } else {
                invalidList.add(task);
            }

        }
    }

    @Override
    public void execute() {
        executeIsRun = true;
        executeCounter++;
        for (int i = 0; i < validList.size() ; i++) {
            validList.get(i).execute();
        }
        for (int i = 0; i < invalidList.size() ; i++) {
            invalidList.get(i).execute();
        }
        executeIsRun = false;
    }

    @Override
    public List<? extends Number> getInvalidResults() throws Exception {
        List<? extends Number> list;
        if (executeCounter == 0) {
            throw new Exception("ERROR!!!Execute method was not run!");
        } else {
            list = new ArrayList<>();
            for (int i = 0; i < invalidList.size() ; i++) {
                list.add(invalidList.get(i).getResult());
            }
        }
        return list;
    }

    @Override
    public List<? extends Number> getValidResults() throws Exception {
        List<? extends Number> list;
        if (executeCounter == 0) {
            throw new Exception("ERROR!!!Execute method was not run!");
        } else {
            list = new ArrayList<>();
            for (int i = 0; i < validList.size() ; i++) {
                list.add(validList.get(i).getResult());
            }
        }
        return list;
    }

    public List<Task<? extends Number>> getValidList() {
        return validList;
    }

    public void setValidList(List<Task<? extends Number>> validList) {
        this.validList = validList;
    }

    public List<Task<? extends Number>> getInvalidList() {
        return invalidList;
    }

    public void setInvalidList(List<Task<? extends Number>> invalidList) {
        this.invalidList = invalidList;
    }

    public long getExecuteCounter() {
        return executeCounter;
    }

    public void setExecuteCounter(long executeCounter) {
        this.executeCounter = executeCounter;
    }

    public boolean isExecuteIsRun() {
        return executeIsRun;
    }

    public void setExecuteIsRun(boolean executeIsRun) {
        this.executeIsRun = executeIsRun;
    }
}