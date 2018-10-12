package monads;

import java.util.stream.Stream;

public class TryStream {
  public static void main(String[] args) {
//    Stream.of("Fred", "Jim", "Sheila")
    Stream.<String>of()
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));

//    String s = null;
//    s.toUpperCase();
  }
}
