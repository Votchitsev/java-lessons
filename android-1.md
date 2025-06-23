# 📚 Специфика Android: Context, Activity, Intent

## 1. Context — контекст выполнения

### Что такое Context

`Context` — это абстрактный класс, предоставляющий доступ к базовым функциям Android-приложения:

- доступ к ресурсам (`getResources()`)
- запуск новых `Activity` или `Service`
- доступ к системным сервисам (`getSystemService()`)

### Основные виды Context

- `ApplicationContext`  
  — жизненный цикл привязан ко всему приложению.  
  Используется, если требуется контекст, не зависящий от UI (например, в синглтонах, `Room`, `Retrofit` и пр.).

- `Activity`/`Service` context  
  — зависит от жизненного цикла соответствующего компонента. Используется при работе с UI.

> ⚠️ **Важно:** не сохраняй `Activity context` в статических переменных — это может вызвать утечку памяти.

### Примеры использования

```java
// Получение строки из ресурсов
String title = context.getString(R.string.app_name);

// Получение системного сервиса
InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
```

---

## 2. Activity — экран (UI-компонент)

### Что такое Activity

`Activity` — это один экран с пользовательским интерфейсом. Это точка входа, когда пользователь взаимодействует с приложением.

Каждая `Activity`:

- имеет жизненный цикл (onCreate → onStart → onResume → onPause → onStop → onDestroy)
- отображает layout (`setContentView(R.layout.some_layout)`)

### Пример простой Activity

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // вызов родительского метода
        setContentView(R.layout.activity_main); // установка layout'а
    }
}
```

### Жизненный цикл Activity

| Метод         | Что происходит                                    |
|---------------|---------------------------------------------------|
| `onCreate()`  | Инициализация, установка layout'а                |
| `onStart()`   | Activity становится видимой                      |
| `onResume()`  | Пользователь начинает взаимодействие              |
| `onPause()`   | Частично закрыта (например, диалоговое окно)     |
| `onStop()`    | Полностью закрыта (видна другая Activity)        |
| `onDestroy()` | Activity уничтожена                              |

> ⚠️ Важно учитывать жизненный цикл при работе с ресурсами (камера, сеть и т.д.)

---

## 3. Intent — сообщение между компонентами

### Что такое Intent

`Intent` — это объект для взаимодействия между компонентами Android: `Activity`, `Service`, `BroadcastReceiver`.

С помощью `Intent` можно:

- Запустить другую `Activity`
- Отправить данные
- Запустить `Service`
- Послать широковещательное сообщение

### Виды Intent

- **Явный (`Explicit`)** — указываем конкретный компонент (обычно внутри приложения)
- **Неявный (`Implicit`)** — указываем только действие, система выбирает нужный компонент

### Пример запуска новой Activity

```java
Intent intent = new Intent(CurrentActivity.this, SecondActivity.class);
intent.putExtra("username", "ChatGPT");
startActivity(intent);
```

### Получение данных в новой Activity

```java
String username = getIntent().getStringExtra("username");
```

### Пример неявного Intent'а — открыть ссылку в браузере

```java
Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
startActivity(browserIntent);
```

---

# 🛠️ Практические задания

## ✅ Задание 1: Вывод строки из ресурсов

**Цель:** Понять, как использовать `Context` для доступа к ресурсам.

- Создай `Activity`
- Получи строку из `res/values/strings.xml` с помощью `getString(R.string.your_string)`
- Отобрази её в `TextView`

<details>
<summary>Подсказка</summary>

Используй `setContentView()`, найди `TextView` по `id`, установи текст.
</details>

---

## ✅ Задание 2: Переход между экранами

**Цель:** Практика `Intent` и передачи данных между `Activity`.

- Создай две `Activity`
- В первой Activity добавь поле ввода и кнопку
- При нажатии на кнопку — переход ко второй Activity и передача введённого текста
- Во второй Activity отобрази полученное сообщение

<details>
<summary>Подсказка</summary>

`intent.putExtra(...)` и `getIntent().getStringExtra(...)`
</details>

---

## ✅ Задание 3: Неявный Intent

**Цель:** Использовать неявный `Intent` для взаимодействия с другими приложениями.

- Добавь кнопку, которая при нажатии открывает браузер с сайтом `developer.android.com`
- Используй `Intent.ACTION_VIEW` и `Uri.parse(...)`

---

# 📌 Заключение

| Понятие | Назначение |
|--------|------------|
| `Context` | Доступ к системным функциям, ресурсам |
| `Activity` | Отдельный экран, управляющий UI |
| `Intent` | Объект сообщения между компонентами |