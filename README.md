# statistics-collector
Experimenting over Spring Data pagination

App controllers listening at: http://localhost:8080

This app is h2-db driven.



## Basic interactions
1) http://localhost:8080/api/events/add   POST
Provide JSON body as follows
   {
   "classifier": "......",
   "text": "......"
   }

Where classifier stands for event type, text stands for event message.
In case classifier provided is not found in the DB, a new Classifier Entity is saved.

2) http://localhost:8080/api/events/get   GET
Pageable interface implements the following parameters:
   - page=0 by default
   - size=20 by default
   - sort =unsorted by default

Example
http://localhost:8080/api/events/get?page=1&size=10&sort=timestamp,desc 
Returns a page #1, with 10 elements places on it, sorted in descending order by event timestamp


