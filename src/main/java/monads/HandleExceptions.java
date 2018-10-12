package monads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

interface ExFunction<E,F> {
  F apply(E e) throws Throwable;
}

public class HandleExceptions {
  public static <E, F> Function<E, Optional<F>> wrap(ExFunction<E,F> op) {
    return e -> {
      try {
        return Optional.of(op.apply(e));
      } catch (Throwable t) {
        return Optional.empty();
      }
    };
  }

//  public static Stream<String> open(String fn) {
//    try {
//      return Files.lines(Paths.get(fn));
//    } catch (IOException ioe){
//      return Stream.empty();
//    }
//  }
  public static void main(String[] args) {
    Stream.of("A.txt", "B.txt", "C.txt")
//        .flatMap(fn -> open(fn))
        .map(wrap(fn -> Files.lines(Paths.get(fn))))
        .peek(opt -> {if (!opt.isPresent()) System.out.println("Missing file");})
        .filter(opt -> opt.isPresent())
        .flatMap(opt -> opt.get())
        .forEach(s -> System.out.println(s));
  }
}
