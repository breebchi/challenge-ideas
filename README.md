## How to call the ReST endpoints using CURL (the same for Tasks 2.1 and 2.2)

- find all news article :

```
  curl -X GET "http://localhost:8080/api/news-articles" -H "accept: */*"
```

- create a news article :

```
  curl -X POST "http://localhost:8080/api/news-articles" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dateCreated\": \"2021-03-03\", \"id\": 2, \"text\": \"Test\", \"title\": \"Testsd\"}"
```

- find a news article by id :

```
  curl -X GET "http://localhost:8080/api/news-articles/1" -H "accept: */*"
```

- update a news article's text :

```
  curl -X PUT "http://localhost:8080/api/news-articles/1/text?text=update%20text" -H "accept: */*"
```

- update a new article's title :

```
  curl -X PUT "http://localhost:8080/api/news-articles/1/title?title=update%20title" -H "accept: */*"
```

- find a news article by title :

```
  curl -X GET "http://localhost:8080/api/news-articles/title?title=title" -H "accept: */*"
```
