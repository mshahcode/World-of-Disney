
What is DisneyAPI?  
Dinsye is an easy-to-use project that helps you find your favorite characters and movies effortlessly.  

**Features**  
Character Management: Create, edit, and delete characters with images.  
Genre Managemet : Create, edit and delete genres with images  
Image management : storing images, adding image to character, genre and movie  
Movie management : Create, edit, delete, add movie with new characters as well as images  
Rating management : Rating enum with mappings  

Database Migrations via liqubase  
Entity to DB Table using Jpa and Hibernate  

Relationships:  
Movie and Characters -> Many-to-Many  
Movie and Genres -> Many-to-Many  
Images and Characters -> One-to-One  
Images and Genres -> One-to-One  
Images and Movies -> One-to-One  


todo in future:  
exception handling, character_log, genre_log, movie_log, spock test, RestTemplate, Swagger, JWT Secutiry  
