<h1>Тестовое задание Back-End</h1>

<h3>Запуск программы</h3>

1) Вариант : Для запуска программы необходимо скопировать проект из git репозитория и запустить, используя ide.  <br>

2) Вариант : при наличии docker, необходимо скопировать репозиторий из git, перейти в корень и ввести команды <br>
   
   mvn clean package <br>
   docker build -t shift:0.0.1 . <br>
   docker run -p 8080:8080 shift:0.0.1


<h3>Принцип работы с API</h3>
Для проверки работы API необходима программа postman. <br>

<h4>POST запросы</h4>

Для выполнения запроса по этим API используется json формата: <br>

{ "array" :  [ [1,2], [2,3], [4,6] ] } <br>

По адресу http://localhost:8080/api/v1/intervals/merge?kind=digits <br>

{ "array" :  [ ["a","c"], ["b","d"], ["e","f"] ] } <br>

Для http://localhost:8080/api/v1/intervals/merge?kind=letters соответственно <br>

<h4>GET запросы</h4>

Взяв данные из предыдущего примера: <br>

при использовании api http://localhost:8080/api/v1/intervals/min?kind=digits <br>

Получим вывод : [ 1, 3 ] <br>

При использовании api http://localhost:8080/api/v1/intervals/min?kind=letters <br>

Получим вывод : ["a","d"]