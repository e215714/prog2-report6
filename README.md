# Brainfuckインタプリタ

  prog2-report6で作成した、Javaで実装されたBrainfuckインタプリタ。

### 機能
  - Brainfuckのコードが書かれたファイルから結果を出力する。
  - インタラクティブモードからコードを入力して実行できる。

## build方法(jarファイルの生成)
  ```
  ./gradlew build
  ```
  
  `app/build/libs/BfInterpreter.jar`が生成されます。

## 使い方

### ファイルを読み込んで出力

```
java -jar BfInterpreter.jar [filename]
```

### インタラクティブモードの起動
```
java -jar BfInterpreter.jar
```

## コントリビューター
  - Taiga Ogawa ([@e215714](https://github.com/e215714))
  - Taisei Maetake ([@e215703](https://github.com/e215703))
