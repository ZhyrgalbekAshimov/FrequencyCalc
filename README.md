
# frequency-calculator

Frequency Calc API service

Stack
===================  

* Java 17
* Spring (boot, validation)
* Hibernate (Criteria API queries, batch insert/updates)
* Docker
* OpenAPI

Деплой
===================  

1. JAR build: `$ gradle clean build`
2. Container build: `$ sudo docker-compose build`
3. Container start: `$ sudo docker-compose up`

## Особенности

- Расчет частоты символов в списке текстовых входных данных
- RESTful API для легкой интеграции с другими сервисами.

## Описание и инструкция

Сервер по умолчанию запускается на порту `8080`.
У сервиса есть только один эндпойнт, который принимает POST запросы по адресу `/calculate-frequency`.
с JSON-заголовком,  содержащим список *[array]* текстовых входных данных. Сервис ответным JSON'ом вернет частоты символов учитывая порядок текстовых входных данных в исходном списке.

##### Пример запроса:

```
POST /calculate-frequency
Host: your-api-hostname.ru
Content-Type: application/json  
```  

```json  
{  
 "input": [ 
	 "Lorem ipsum dolor sit amet",
	 "Consectetur adipiscing elit",
	 "Etiam ac tortor quis felis convallis congue",
	 "Cras bibendum lacinia velit"
	 ]
 }  
```  

##### Пример ответа:

```JSON  
{
	"output": [
		{
			" ": 4,
			"m": 3,
			"o": 3,
			"e": 2,
			"i": 2,
			"r": 2,
			"s": 2,
			"t": 2,
			"a": 1,
			"d": 1,
			"L": 1,
			"l": 1,
			"p": 1,
			"u": 1
		},
		{
			"i": 4,
			"e": 3,
			"t": 3,
			" ": 2,
			"c": 2,
			"n": 2,
			"s": 2,
			"a": 1,
			"C": 1,
			"d": 1,
			"g": 1,
			"l": 1,
			"o": 1,
			"p": 1,
			"r": 1,
			"u": 1
		},
		{
			" ": 6,
			"i": 4,
			"o": 4,
			"a": 3,
			"c": 3,
			"l": 3,
			"s": 3,
			"t": 3,
			"e": 2,
			"n": 2,
			"r": 2,
			"u": 2,
			"E": 1,
			"f": 1,
			"g": 1,
			"m": 1,
			"q": 1,
			"v": 1
		},
		{
			"i": 4,
			" ": 3,
			"a": 3,
			"b": 2,
			"e": 2,
			"l": 2,
			"n": 2,
			"C": 1,
			"c": 1,
			"d": 1,
			"m": 1,
			"r": 1,
			"s": 1,
			"t": 1,
			"u": 1,
			"v": 1
		}
	]
} 
```  

### Документация по API

API документирован с использованием Swagger UI, доступ к документации можно получить посетив URL при запущенном сервисе:

`/swagger-ui.html`
