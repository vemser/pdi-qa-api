package utils;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.Locale;

@Data
public class FakerUtils {
    public Faker faker = new Faker(new Locale("pt-BR"));
}