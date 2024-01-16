import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamCreationExercise {
    public static void main(String[] args) {

        // 1- in this way we use a collection to create stream.
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().forEach(System.out::println);

        // 2- in this way we use Stream.of for creating a stream of elements of a specific type
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        // 3- Another way of creating Stream type is to use Arrays.stream which creates a stream of the given array
        Arrays.stream(new Integer[]{1, 2, 3, 4, 5}).forEach(System.out::println);

        // 4- This way is used to create empty stream.
        // This is good to use when we don't want to return null from a stream
        Stream.empty().forEach(System.out::println);

        // 5- In this way we use Stream.Builder to create a Stream.
        // first we add elements and we call build method to create a stream.
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1).add(2).add(3).add(4).add(5).build().forEach(System.out::println);

        // 6- Another way of creating stream is to use iterate method which creates infinite stream.
        // In this way we have to define the seed amount which is the amount that the iterator starts with
        // Then we define a method to create the elements of the stream
        // As it continues to generate elements, we should use limit method to limit the number of generated elements
        // for example here my stream elements are integers which starts with 2 and increase by one until it reaches to 11.
        Stream.iterate(2, i -> i + 1).limit(10).forEach(System.out::println);

        // 7- Another way of creating infinite stream is to use generate method
        // we have to define a Supplier and limit it as it generate infinite number of elements
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        // 8- Another way to create stream is to use StreamSupport
        // First we have to create iterator and make a Spliterator from it
        // Then by using spliterator we can create stream using StreamSupport
        Iterator<Integer> integerIterator = Arrays.asList(1,2,3,4,5).iterator();
        Spliterator<Integer> spliterator = Spliterators.spliteratorUnknownSize(integerIterator, Spliterator.NONNULL);
        StreamSupport.stream(spliterator,false).forEach(System.out::println);

        // 9- We can simply use iterable instead of iterator and create spliterator from iterable
        // Then pass it to StreamSupport.stream and create a stream from it
        Iterable<Integer> integerIterable = Arrays.asList(1,2,3,4,5);
        StreamSupport.stream(integerIterable.spliterator(),false).forEach(System.out::println);
    }
}
