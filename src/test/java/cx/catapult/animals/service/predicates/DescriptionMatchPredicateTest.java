package cx.catapult.animals.service.predicates;

import cx.catapult.animals.domain.BaseAnimal;
import cx.catapult.animals.domain.Group;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionMatchPredicateTest {
    @Test
    void descriptionTestShouldMatchOnNullValue() {
        DescriptionMatchPredicate descriptionMatchPredicate = new DescriptionMatchPredicate(null);

        BaseAnimal cat = new BaseAnimal("Tom", "Cat", "Grey", "Grey Big", Group.MAMMALS);
        Map.Entry<String, BaseAnimal> animalEntrySet = new AbstractMap.SimpleEntry<>("1", cat);
        assertTrue(descriptionMatchPredicate.test(animalEntrySet));
    }

    @Test
    void descriptionTestShouldMatchOnEmptyValue() {
        DescriptionMatchPredicate descriptionMatchPredicate = new DescriptionMatchPredicate("");

        BaseAnimal cat = new BaseAnimal("Tom", "Cat", "Grey", "Grey Big", Group.MAMMALS);
        Map.Entry<String, BaseAnimal> animalEntrySet = new AbstractMap.SimpleEntry<>("1", cat);
        assertTrue(descriptionMatchPredicate.test(animalEntrySet));
    }

    @Test
    void descriptionTestShouldMatch() {
        DescriptionMatchPredicate descriptionMatchPredicate = new DescriptionMatchPredicate("Grey Big");

        BaseAnimal cat = new BaseAnimal("Tom", "Cat", "Grey", "Grey Big", Group.MAMMALS);
        Map.Entry<String, BaseAnimal> animalEntrySet = new AbstractMap.SimpleEntry<>("1", cat);
        assertTrue(descriptionMatchPredicate.test(animalEntrySet));
    }

    @Test
    void descriptionTestShouldNotMatch() {
        DescriptionMatchPredicate descriptionMatchPredicate = new DescriptionMatchPredicate("Grey Red");

        BaseAnimal cat = new BaseAnimal("Tom", "Cat", "Grey", "Grey Big", Group.MAMMALS);
        Map.Entry<String, BaseAnimal> animalEntrySet = new AbstractMap.SimpleEntry<>("1", cat);
        assertFalse(descriptionMatchPredicate.test(animalEntrySet));
    }
}