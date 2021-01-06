import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1
        Stream.empty().filter(Objects::nonNull).map(item -> {
            String s = item.toString();

            return s.length() + ":" + s;
        }).forEach(System.out::println);

        //2
        Set<Integer> set2 = Arrays.asList(65, 2, 5, 87, 12, 34, 0, -1, 17, 100)
                        .stream()
                        .filter(item -> item > 0)
                        .limit(3)
                        .collect(Collectors.toSet());

        //3
        List<String> list3 = "Lorem ipsum dolor sit amet"
                .chars()
                .distinct()
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList());

        //4
        List<String> src = Arrays.asList("Lorem ipsum dolor sit amet".split(" "));
        Map<Integer, String> map4 = src.stream().collect(Collectors.toMap(s -> src.indexOf(s), s -> s));
        map4.keySet().stream().map(map4::get).peek(System.out::println).collect(Collectors.toList());

        //5
        Set<Integer> set5 = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
                .stream()
                .skip(1)
                .limit(8)
                .map(Integer::valueOf)
                .filter(x -> x%2 == 0)
                .collect(Collectors.toSet());

        //6
        Random random = new Random(System.currentTimeMillis());
        Optional<Integer> optional6 = Stream.iterate(1, x -> random.nextInt(1000))
                .limit(100)
                .parallel()
                .sorted()
                .filter(x -> x%2 != 0 && x > 50)
                .findFirst();

        //7;
        Arrays.stream("Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eligendi delectus libero reprehenderit numquam cupiditate laboriosam commodi tenetur alias non aliquam."
                .split("[., ]"))
                .filter(s -> !s.isEmpty())
                .map(String::length)
                .map(random::nextInt)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(System.out::println);
    }
}
