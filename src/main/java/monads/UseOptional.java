package monads;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseOptional {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("Fred", "Jones");

    String lastName = map.get("Fred"); // crashes on next line if not found!
    int charCount = lastName.length();
    System.out.println("Fred's last name has " + charCount + " charaters");

    Optional.of(map)
        .map(m -> m.get("Julie"))
        .map(n -> n.length())
        .ifPresent(i -> System.out.println("The last name has a length of " + i));
  }
}
