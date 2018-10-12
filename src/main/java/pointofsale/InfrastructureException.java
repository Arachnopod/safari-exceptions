package pointofsale;

public class InfrastructureException extends Exception {
  public InfrastructureException() {
  }

  public InfrastructureException(String message) {
    super(message);
  }

  public InfrastructureException(String message, Throwable cause) {
    super(message, cause);
  }

  public InfrastructureException(Throwable cause) {
    super(cause);
  }

  public InfrastructureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
