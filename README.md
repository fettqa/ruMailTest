# ruMailTest
Maven-проект на Java.
Автотест с использованием библиотеки Selenide. Браузер - Chrome.
Тест кейс:
Шаг 1:
Авторизоваться на маил.ру с аккаунта_1.
Проверить авторизацию.
Шаг 2:
Отправить 6 писем на аккаунт_2 с темой письма "Тестовое задание Selenide".
Прикрепить аттач (текстовый документ с текстом "mdm система") с телом письма "Тело письма Selenide".
Проверить успешную отправку 6 писем
Шаг 3:
Авторизовать на маил.ру с аккаунта_2 открыть третье непрочитанное письмо, в котором тело письма содержит Selenide.
Проверить тему письма, тело письма, аттач. 
Шаг 4:
Ответить на данное письмо на аккаунт_1, с телом письма "Выполнено"Авторизовать на маил.ру с акааунта_1.
Открыть 1ое непрочитанное письмо, проверить, что тело письма содержит "Выполнено".
