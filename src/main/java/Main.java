import hw_18.utils.ShufflingUpperStrPipe;
import hw_18.utils.SimpleLowerStrPipe;
import hw_18.utils.helpers.EmailHelper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //4
        String testStr = "Vasya";
        SimpleLowerStrPipe simpleLowerStrPipe = new SimpleLowerStrPipe(testStr);

        System.out.println(simpleLowerStrPipe.getSimpleString());
        System.out.println(simpleLowerStrPipe.getLowerString());
        System.out.println(simpleLowerStrPipe.get("Petya"));
        System.out.println(simpleLowerStrPipe.getSimpleBoolean());
        System.out.println(simpleLowerStrPipe.getLowerBoolean());

        simpleLowerStrPipe.setStr("");
        System.out.println(simpleLowerStrPipe.getSimpleBoolean());
        System.out.println(simpleLowerStrPipe.getLowerBoolean());

        ShufflingUpperStrPipe shufflingUpperStrPipe = new ShufflingUpperStrPipe(testStr);

        System.out.println(shufflingUpperStrPipe.getShuffledString());
        System.out.println(shufflingUpperStrPipe.getUpperString());
        System.out.println(shufflingUpperStrPipe.get("Petya"));
        System.out.println(shufflingUpperStrPipe.getShuffledBoolean());
        System.out.println(shufflingUpperStrPipe.getUpperBoolean());

        shufflingUpperStrPipe.setStr("");
        System.out.println(shufflingUpperStrPipe.getShuffledBoolean());
        System.out.println(shufflingUpperStrPipe.getUpperBoolean());

        shufflingUpperStrPipe.setStr(null);
        System.out.println(shufflingUpperStrPipe.getShuffledString());
        System.out.println(shufflingUpperStrPipe.getUpperString());
        System.out.println(shufflingUpperStrPipe.getShuffledBoolean());
        System.out.println(shufflingUpperStrPipe.getUpperBoolean());

        //5
        Optional<String> emailOptional = EmailHelper.check("vasya@vas.net");

        try {
            //6
            emailOptional.ifPresentOrElse(System.out::println, () -> { throw new NoSuchElementException("No valid email"); });

            emailOptional = EmailHelper.check(null);
            //7
            emailOptional.ifPresentOrElse(System.out::println, () -> { throw new NoSuchElementException("No valid email"); });
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        Main app = new Main();
        //8.1
        System.out.printf("Checking salary of %.2f: %b%n", 2000.d, app.predicateExample(new BigDecimal(2000)));
        System.out.printf("Checking salary of %.2f: %b%n", 1000.d, app.predicateExample(new BigDecimal(1000)));
        //8.2
        app.consumerExample("Hello, Functional Programming!!!");
        //8.3
        System.out.println(app.functionExample(5));
        //8.4
        System.out.println(app.supplierExample());
    }

    //8.1
    public boolean predicateExample(BigDecimal salary) {
        Predicate<BigDecimal> salaryChecker = value -> value.compareTo(new BigDecimal(1500)) > 0;

        return salaryChecker.test(salary);
    }

    //8.2
    public void consumerExample(String input) {
        Consumer<String> consumer = value -> {
            for(char ch: value.toCharArray()) {
                System.out.print(ch);
            }
            System.out.println();
        };

        consumer.accept(input);
    }

    //8.3
    public String functionExample(int number) {
        Function<Integer, String> function = key -> {
            String[] values = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

            return key > 0 && key < 11 ? values[key - 1] : "unknown";
        };

        return function.apply(number);
    }

    //8.4
    public String supplierExample() {
        Supplier<String> supplier = () -> "Today is " + LocalDate.now().toString();

        return supplier.get();
    }
}
