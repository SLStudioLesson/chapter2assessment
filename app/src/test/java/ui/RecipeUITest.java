package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import data.RecipeFileHandler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeUITest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private RecipeFileHandler fileHandlerMock;
    private RecipeUI recipeUI;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        fileHandlerMock = Mockito.mock(RecipeFileHandler.class);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); // 標準出力を元に戻す
    }

    @Tag("Q1")
    @Test
    void displayMenu_ShouldHandleDisplayRecipes() {
        String input = "1\n4\n"; // 1: Display Recipes, then 4: Exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        recipeUI = new RecipeUI(new BufferedReader(new InputStreamReader(System.in)), fileHandlerMock);

        recipeUI.displayMenu();

        assertThat(outContent.toString()).contains("No recipes available.");
        verify(fileHandlerMock, times(1)).readRecipes();
    }

    @Tag("Q2")
    @Test
    void displayMenu_ShouldHandleAddNewRecipe() {
        String input = "2\nTest Recipe\nTest Ingredients\n4\n"; // 2: Add New Recipe, then 4: Exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        recipeUI = new RecipeUI(new BufferedReader(new InputStreamReader(System.in)), fileHandlerMock);

        recipeUI.displayMenu();

        assertThat(outContent.toString()).contains("Recipe added successfully.");
        verify(fileHandlerMock, times(1)).addRecipe("Test Recipe", "Test Ingredients");
    }

    @Tag("Q3")
    @Test
    void displayMenu_ShouldHandleSearchRecipe() {
        String input = "3\nTest Query\n4\n"; // 3: Search Recipe, then 4: Exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        recipeUI = new RecipeUI(new BufferedReader(new InputStreamReader(System.in)), fileHandlerMock);

        recipeUI.displayMenu();

        assertThat(outContent.toString()).contains("Search Results:");
    }

    @Test
    void displayMenu_ShouldHandleInvalidChoice() {
        String input = "5\n4\n"; // Invalid choice, then 4: Exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        recipeUI = new RecipeUI(new BufferedReader(new InputStreamReader(System.in)), fileHandlerMock);

        recipeUI.displayMenu();

        assertThat(outContent.toString()).contains("Invalid choice. Please select again.");
    }
}

