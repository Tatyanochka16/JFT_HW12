package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.MovieItem;
import ru.netology.MovieManager;

import static org.mockito.Mockito.*;


public class MovieManagerTest {

    MovieItem item1 = new MovieItem(1, "Бладшот", "боевик", 1);
    MovieItem item2 = new MovieItem(2, "Вперед", "мультфильм", 2);
    MovieItem item3 = new MovieItem(3, "Отель Белград", "комедия", 3);
    MovieItem item4 = new MovieItem(4, "Джентельмены", "боевик", 4);
    MovieItem item5 = new MovieItem(5, "Человек-неведивка", "ужасы", 5);
    MovieItem item6 = new MovieItem(6, "Тролли. Мировой тур", "мультфильм", 6);
    MovieItem item7 = new MovieItem(7, "Номер один", "комедия", 7);

    @Test
    public void testSaveMany() {
        MovieManager repo = new MovieManager();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);


        MovieItem[] expected = {item1, item2, item3, item4, item5, item6, item7};
        MovieItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSaveNothing() {
        MovieManager repo = new MovieManager();
        MovieItem[] expected = {};
        MovieItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    //MovieManager repo = Mockito.mock(MovieManager.class);

    @Test
    public void shouldFindLastFive() {

        MovieManager repo = new MovieManager(5);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        MovieItem[] expected = {item7, item6, item5, item4, item3};
        MovieItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastUnderLimit() {

        MovieManager repo = new MovieManager(5);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        MovieItem[] expected = {item4, item3, item2, item1};
        MovieItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAboveFive() {
        MovieManager repo = new MovieManager(6);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        MovieItem[] expected = {item7, item6, item5, item4, item3, item2};
        MovieItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}

