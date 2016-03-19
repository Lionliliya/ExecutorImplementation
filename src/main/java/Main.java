import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task<Integer> intTask1 = new IntTask(100);
        Task<Integer> intTask2 = new IntTask(350);

        List<Task<Integer>> intTasks = Arrays.asList(intTask1, intTask2);
        Validator<Number> validator = new NumberValidator();
        try {
            Executor<Number> numberExecutor = new ExecutorImpl<>();
            for (Task<Integer> intTask : intTasks) {
                numberExecutor.addTask(intTask);
            }

            numberExecutor.addTask(new LongTask(10L), validator);
            numberExecutor.execute();

            System.out.println("Valid results:");


            for (Number number : numberExecutor.getValidResults()) {
                System.out.println(number);
            }

            System.out.println("Invalid results:");
            for (Number number : numberExecutor.getInvalidResults()) {
                System.out.println(number);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}

