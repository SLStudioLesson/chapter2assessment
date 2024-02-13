package data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

class RecipeFileHandlerTest {
    private static final String TEST_FILE_PATH = "src/test/resources/test_recipes.txt";
    private RecipeFileHandler fileHandler;

    @BeforeEach
    void setUp() throws Exception {
        fileHandler = new RecipeFileHandler(TEST_FILE_PATH);
        System.out.println("Current directory: " + System.getProperty("user.dir"));

        // テスト用のファイルを準備
        try (PrintWriter out = new PrintWriter(TEST_FILE_PATH)) {
            out.println("Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock");
        }
    }

    @AfterEach
    void tearDown() {
        // テスト用のファイルを削除
        new File(TEST_FILE_PATH).delete();
    }

    @Tag("Q1")
    @Test
    void readRecipes_ShouldReturnListOfRecipes() {
        List<String> recipes = fileHandler.readRecipes();
        Assertions.assertThat(recipes).isNotNull().hasSize(1);
        Assertions.assertThat(recipes.get(0)).contains("Tomato Soup");
    }

    @Tag("Q2")
    @Test
    void addRecipe_ShouldAddRecipeToFile() {
        fileHandler.addRecipe("Pancakes", "Flour, Milk, Egg, Butter, Maple Syrup");
        List<String> recipes = fileHandler.readRecipes();
        Assertions.assertThat(recipes).hasSize(2);
        Assertions.assertThat(recipes.get(1)).contains("Pancakes");
    }
}

