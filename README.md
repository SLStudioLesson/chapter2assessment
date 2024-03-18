# Chapter2アセスメント

## 試験概要

試験時間：120分

以下の説明を読み、各設問に解答し提出してください。

- 実装前に処理フローをコメントアウトで記述すること
- 実装完了後、自己採点（動作確認）を行うこと
- 自己採点完了後、次の設問に進むこと
- 全てのプログラムが実行可能であること
- コンパイルエラー状態での提出は禁止
- 出力内容やメソッド名が指示通りでない場合は不正解となる

## 設問の前提

各設問の指示に従い以下のクラスを拡張してください。

- `src/main/java/App.java` - 実行用クラス

- `src/main/java/ui/RecipeUI.java` - 表示に関連したクラス

- `src/main/java/data/RecipeFileHandler.java` - データ操作に関連したクラス

- `src/main/resources/recipes.txt` - レシピのデータ

  - ファイルの各行は、単一のレシピを表し、レシピ名と主な材料がカンマ区切りで記載されています。

  - 誤って消してしまったりした場合は以下の内容をコピーしてください。

    ```
    Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock
    Chicken Curry,Chicken, Curry Powder, Onion, Garlic, Ginger
    Beef Stew,Beef, Potatoes, Carrots, Onion, Beef Stock
    Vegetable Stir Fry,Broccoli, Carrot, Bell Peppers, Soy Sauce
    Spaghetti Bolognese,Ground Beef, Tomato Sauce, Onion, Garlic, Spaghetti
    Caesar Salad,Romaine Lettuce, Croutons, Parmesan Cheese, Caesar Dressing
    Grilled Salmon,Salmon, Lemon, Garlic, Olive Oil
    Pancakes,Flour, Milk, Egg, Butter, Maple Syrup
    Chocolate Cake,Flour, Cocoa Powder, Baking Powder, Eggs, Sugar
    Lasagna,Ground Beef, Lasagna Noodles, Ricotta Cheese, Tomato Sauce
    Tacos,Ground Beef, Taco Shells, Lettuce, Tomato, Cheese
    French Toast,Bread, Egg, Milk, Cinnamon, Sugar
    Mushroom Risotto,Arborio Rice, Mushrooms, Onion, Chicken Stock, Parmesan Cheese
    Quiche Lorraine,Eggs, Cream, Bacon, Cheese, Pie Crust
    Ratatouille,Eggplant, Zucchini, Bell Pepper, Tomato, Onion
    Chicken Alfredo,Chicken, Fettuccine, Cream, Parmesan Cheese, Garlic
    BBQ Ribs,Pork Ribs, BBQ Sauce, Garlic, Brown Sugar
    Vegetable Soup,Carrots, Potatoes, Celery, Tomato, Vegetable Stock
    Macaroni and Cheese,Macaroni, Cheddar Cheese, Milk, Butter, Flour
    Banana Bread,Bananas, Flour, Sugar, Baking Soda, Eggs
    ```

- 各設問の実装完了後`src/main/java/ui/RecipeUI.java`のdisplayMenu()メソッドにて実装したメソッドを呼び出してください。

## 設問1: レシピ一覧表示機能

### 目安時間

30分

### 設問

`recipes.txt`ファイルからレシピデータを読み込み、コンソールに一覧表示する機能をステップに従い作成してください。



### ステップ1：プログラムの設計

以下のメソッドを定義し、コメントアウトを使用してプログラムの流れを説明する内容を記述してください。

`src/main/java/data/RecipeFileHandler.java` 

| メソッド名    | 戻り値の型     | 引数 | 説明                                                         |
| ------------- | -------------- | ---- | ------------------------------------------------------------ |
| `readRecipes` | `ArrayList<String>` | なし | `recipes.txt`からレシピデータを読み込み、それをリスト形式で返します。 |

IOExceptionが発生したときは`Error reading file: 例外のメッセージ`と表示すること



`src/main/java/ui/RecipeUI.java` 

| メソッド名       | 戻り値の型 | 引数 | 説明                                                         |
| ---------------- | ---------- | ---- | ------------------------------------------------------------ |
| `displayRecipes` | `void`     | なし | `RecipeFileHandler`から読み込んだレシピデータを整形してコンソールに表示します。 |

- 表示形式は以下の出力例を再現すること

```
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 1

Recipes:
-----------------------------------
Recipe Name: Tomato Soup
Main Ingredients: Tomatoes, Onion, Garlic, Vegetable Stock
-----------------------------------
Recipe Name: Chicken Curry
Main Ingredients: Chicken, Curry Powder, Onion, Garlic, Ginger
-----------------------------------
Recipe Name: Beef Stew
Main Ingredients: Beef, Potatoes, Carrots, Onion, Beef Stock
-----------------------------------

以下省略
```



### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

#### テストケース1

- `recipes.txt`ファイルに複数のレシピが記載されている場合、すべてのレシピが正しく一覧表示されることを確認します。

#### テストケース2

- `recipes.txt`ファイルが空の場合、"No recipes available."というメッセージが表示されることを確認します。



## 設問2: 新規登録機能

### 目安時間

30分

### 設問

ユーザーからレシピ名と主な材料を入力させ、これらの情報を`recipes.txt`ファイルに新しい行として追加する機能をステップに従い作成してください。

### ステップ1：プログラムの設計

以下のメソッドを定義し、コメントアウトを使用してプログラムの流れを説明する内容を記述してください。

`src/main/java/data/RecipeFileHandler.java`

| メソッド名  | 戻り値の型 | 引数                                    | 説明                                                         |
| ----------- | ---------- | --------------------------------------- | ------------------------------------------------------------ |
| `addRecipe` | `void`     | `String recipeName, String ingredients` | 新しいレシピを`recipes.txt`に追加します。レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。 |

`src/main/java/ui/RecipeUI.java` 

| メソッド名     | 戻り値の型 | 引数 | 説明                                                         |
| -------------- | ---------- | ---- | ------------------------------------------------------------ |
| `addNewRecipe` | `void`     | なし | ユーザーからレシピ名と主な材料を入力させ、`RecipeFileHandler`を使用して`recipes.txt`に新しいレシピを追加します。 |

- 表示形式は以下の出力例を再現すること

```
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 2

Enter recipe name: abc
Enter main ingredients (comma separated): a,b,c
Recipe added successfully.
```

### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

#### **テストケース1**

- レシピ名と主な材料を入力し、`"Recipe added successfully."`というメッセージが表示されること
- 登録した内容が`recipes.txt`ファイルに正しく追加されていること



## 設問3: 検索機能

### 目安時間

50分

### 設問

ユーザーが指定した条件（レシピ名や主な材料）に基づいて`recipes.txt`ファイル内のレシピを検索し、一致するものを表示する機能をステップに従い作成してください。

`src/main/java/ui/RecipeUI.java` 

| メソッド名     | 戻り値の型 | 引数 | 説明                                                         |
| -------------- | ---------- | ---- | ------------------------------------------------------------ |
| `searchRecipe` | `void`     | なし | ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。 |

- 検索クエリは`name`と`ingredient`のキーをサポートし、`&`で複数の条件を組み合わせることができる。
  - 例: `name=Soup&ingredient=Tomato`は、名前に"Soup"を含み、材料に"Tomato"を含むレシピを検索する。

- 一致するレシピがある場合は、そのレシピの名前と主な材料を表示する。
- 一致するレシピがない場合は、`No recipes found matching the criteria.`と出力する。
- 表示形式は以下の出力例を再現すること

```
// 一致するレシピがある場合
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 3
Enter search query (e.g., 'name=Tomato&ingredient=Garlic'): name=Soup&ingredient=Tomato

Search Results:
Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock
Vegetable Soup,Carrots, Potatoes, Celery, Tomato, Vegetable Stock
```



```
// 一致するレシピがない場合
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 3
Enter search query (e.g., 'name=Tomato&ingredient=Garlic'): pizza

Search Results:
No recipes found matching the criteria.
```



### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

#### **テストケース1**

- 検索クエリ`name=Soup&ingredient=Tomato`を入力し、条件に一致するレシピが表示されることを確認します。

#### **テストケース2**

- 検索クエリ`name=Pizza`を入力し、`No recipes found matching the criteria.`というメッセージが表示されることを確認します。
