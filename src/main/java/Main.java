import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by revo on 4/21/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("/media/revo/revo/nlp/src/main/resources/ff"))) {
            Map<String, Long> collect = lines.map(s -> Arrays.asList(s.split(" "))).flatMap(x -> x.stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            collect.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).forEach(s -> System.out.println(s.getKey() + "                  " + s.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
