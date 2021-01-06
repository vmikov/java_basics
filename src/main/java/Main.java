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
        Arrays.asList(65, 2, 5, 87, 12, 34, 0, -1, 17, 100)
                        .stream()
                        .filter(item -> item > 0)
                        .limit(3)
                        .collect(Collectors.toSet());

        //3
        "Lorem ipsum dolor sit amet"
                .chars()
                .distinct()
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList());

        //4
        List<String> src = Arrays.asList("Lorem ipsum dolor sit amet".split(" "));
        Map<Integer, String> map4 = src.stream().collect(Collectors.toMap(s -> src.indexOf(s), s -> s));
        Collection<String> values = new ArrayList<>(map4.size());

        map4.keySet().forEach(key -> {
            System.out.println(key);
            values.add(map4.get(key));
        });

        //5
        List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
                .stream()
                .skip(1)
                .limit(8)
                .map(Integer::valueOf)
                .filter(x -> x%2 == 0)
                .collect(Collectors.toSet());

        //6
        Random random = new Random(System.currentTimeMillis());
        Stream.iterate(1, x -> random.nextInt(1000))
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
