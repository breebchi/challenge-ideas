## Task 1.1

Something that's very dear to a developer's heart is the knowledge that one's work is needed by somebody, and is being used. I am no exception. An example I can site is a project I
worked on for a year starting January 2018. I was working for a consultancy company, and our customer needed someone to recode their very old (70' - 80') modeling and simulation
tool suits. My manager picked me, so unenthusiastically, off I went. The code was in Delphi, I had to brush my not very strong skills in the language. Already scarce resources
there. The code also had no documentation and was very ambiguous (i.e., variable naming typically one or two chars, very long procedures, many global variables). And the person who
had developed it was long gone. So I asked to sit next the people who were using the current tools and were going to be using the new ones I'm writing in Matlab OO. I asked them
for help understanding the functionality of each tool, they knew what it was for but nothing about the code. And I also made sure they liked what I was doing at every step. By the
time I left they were already using my library. So of course I was happy.

## Task 1.2

I've been busy, so I mostly listen to books and podcasts instead of reading. Two stood in my mind, actually, two sections of two books.

- The first section is from "Clean Code" by Robert Martin, about code quality, comments, methods (i.e., arguments, size, calls from different levels of abstraction)
  and other aspects. This one is a good read/listen for every developer, it's either comforting (if you're already doing it) or challenging (if you're not or if you didn't even
  consider ceftain issues)
- The second section is from "The Start-up of you" by Reid Hoffman (the LinkedIn boss), and it underlines the importance of networking in every profession, how not to do it, how to
  best approach it... This one you should read if you want to know some cool/interesting stories about the Paypal mafia, but also because one might be interested in knowing how the
  boss of the biggest professional networking platform sees those matters.

## Task 3 - The Path To Production

- I would first add integration tests using MockMvc for example. 
I would call the endpoints using the get() or post() methods for example, and expect certain results.
- Once my code is done (team has to define what done means though), it has to go into a repository where other team members have access. 
I would create build plans (on Bamboo for example) to ensure that the builds stay green with every change. 
I would also put in place quality gates (Sonar for example):
if the builds are not green or the quality gates are not passed, a pull request, hence a merge, shall not be allowed. I would also make it so that a pull request requires two
people or more for review. The build plans I would put in place would be one for unit tests, and one for integration tests. 
- I would also organise small cyclic meetings were developers from other projects would play with our code, and we do the same with theirs, in an attempt to make it break. Before every release, development branch would be frozen,
and a new release branch would be created.

## How to run :

Have maven installed, get your IDE, mvn clean install, find the ChallengeIdeasApplication class, run the application, and go to the your browser were you can call localhost:8080 to
play with your endpoints using Swagger ui.

## How to call the ReST endpoints using CURL (the same for Tasks 2.1 and 2.2)

- find all news article :

```
  curl -X GET "http://localhost:8080/api/news-articles" -H "accept: */*"
```

- create a news article :

```
  curl -X POST "http://localhost:8080/api/news-articles" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dateCreated\": \"2021-03-03 03:03:03\", \"id\": 0, \"text\": \"Test\", \"title\": \"Testsd\"}"
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
