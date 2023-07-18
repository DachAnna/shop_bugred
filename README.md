# Автоматизация Rest API интернет магазина shop_bugred


## :point_right: Проект в Allure TestOps с автотестами с результатами их прохождения.
<a target="_blank" href="https://allure.autotests.cloud/project/3510/dashboards">Проект в Allure TestOps</a>

В Allure TestOps хранится информация по всем автотестам проекта, по запускам сборок, а также отчет по пройденным сборкам.
![Отчет Allure](https://github.com/DachAnna/shop_bugred/assets/118796374/c80bbfe0-337f-4f18-ac06-9c3a2cedbfc8)



## :point_right:  Jenkins job c Allure Report с результатами пройденной сборки.
<a target="_blank" href="https://jenkins.autotests.cloud/job/08-sub_ekt-bugredAPI/">Сборка в jenkins</a>
В Jenkins запускается сборка с параметрами:
* Выбор, какие тесты нужно проходить
    * test - выполнение всех тестов
    * item_tests - выполнение тестов для проверки работы с товарами
    * photo_tests - выполнение тестов для проверки работы с фотографиями к товару
* Выбор опции параллельного прохождения тест-кейсов
* Выбор количества тест-кейсов для параллельного запуска

В Allure Report отображается вся информация по пройденной сборке

![Allure Report](https://github.com/DachAnna/shop_bugred/assets/118796374/b336912f-66d0-4c7e-b19b-bd066c00e81e)


## :point_right: Уведомления о прохождении тестов в Телеграмм :v:
Уведомления о прохождении тестов приходит в телеграмм канал.

![Телеграмм](https://github.com/DachAnna/shop_bugred/assets/118796374/01dab82b-5458-4050-9cab-e66ee6a45df5)


## :point_right: Примеры использования

Запуск тестов:
```bash
gradle clean test
```
Запуск определенного теста:
```bash
gradle clean itemTest
gradle clean photoTest
```
Сформировать отчет:
```bash
allure serve build/allure-results
```


## :point_right: Языки и инструменты
<h3 align="left">Языки и инструменты, используемые в данном проекте </h3>

| IntelliJ IDEA | Java | Gradle | Junit5 | REST assured |
|:------:|:----:|:----:|:------:|:------:|
| <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Intelij_IDEA.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Java.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Gradle.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/JUnit5.png" width="40" height="40"> | <img src="https://github.com/murugka31/PetStoreTests/blob/main/images/Rest-assured.png" width="40" height="40"> |

| GitHub | Jenkins | Allure Report | Allure TestOps | Telegram |
|:------:|:----:|:----:|:------:|:------:|
| <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Github.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Jenkins.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Allure_Report.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/AllureTestOps.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Telegram.png" width="40" height="40"> |

:arrow_right: <a target="_blank" href="https://github.com/DachAnna">github.com/DachAnna</a><br/>

