package pointofsale;

public class PoliceException extends Exception {
  public PoliceException() {
  }

  public PoliceException(String message) {
    super(message);
  }

  public PoliceException(String message, Throwable cause) {
    super(message, cause);
  }

  public PoliceException(Throwable cause) {
    super(cause);
  }

  public PoliceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
