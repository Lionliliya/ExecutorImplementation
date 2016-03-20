#ExecutorImplementation

There are three generics interfaces.

1 Rewrite Task interface so that it was typed by the result (value returned by getResult() method);

2 Rewrite the Validator interface so that it was typed by the accepted value  - method isValid (Object result);

3 Overwrite the Executor interface so that it was typed in accordance with a types of Task and Validator interfaces;

4 Impelements Executor interface

5 Write tests.


public interface Executor<T> {

  /****Add a task for execution. The result of Task will be 
  available via the getValidResults () method. Throws 
  Exeption if execute () method has been called****/
  
  
  void addTask(Task<? extends T> task) throws Exception; 

  /**Add a task for execution, and the validator of result. 
  The result will be stored to ValidResults if validator.isValid 
  returns true for this result**/
  /**The result of Task will be stored to InvalidResults if 
  validator.isValid returns false for this result**/
  /**Throws Exeption if execute () method has been called**/
  
  void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exception;
  
  /**Execute all added Tasks**/
  void execute();
  
  /**Get valid results. Throws Exeption if the execute () 
  method was not called**/
  List<T> getValidResults() throws Exception;

  /**Get invalid results. Throws Exeption if the execute () 
  method was not called**/
  List<T> getInvalidResults() throws Exception;

}

public interface Task<T> {
  
  /**Method launches the Task for execution**/
  void execute();
  
  /**Returns the result of the execution**/
  T getResult();
}

public interface Validator<T> {

  /**Validates the passed value**/
  boolean isValid(T result);
}
