package data;

import java.io.IOException;
import java.util.List;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    // 設問1: 一覧表示機能
    public List<String> readRecipes() {
        try {

        } catch (IOException e) {

        }
        return null;
    }

    // 設問2: 新規登録機能
    public void addRecipe(String recipeName, String ingredients) {
        try {

        } catch (IOException e) {

        }
    }
}
