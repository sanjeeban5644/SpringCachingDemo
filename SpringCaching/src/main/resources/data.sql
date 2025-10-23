INSERT INTO brs.t_author (author_name) VALUES
('R. K. Narayan'),
('Sarat Chandra Chattopadhyay'),
('J. K. Rowling'),
('Rabindranath Tagore'),
('Satyajit Ray');

INSERT INTO brs.t_genre (genre_name) VALUES
('Fiction'),
('Classics'),
('Adventure'),
('Science Fiction'),
('Detective');

INSERT INTO brs.t_user (user_name, fav_genre) VALUES
('Arjun', 'Adventure'),
('Suman', 'Fiction'),
('Priya', 'Detective'),
('Ritika', 'Classics'),
('Rahul', 'Science Fiction');

INSERT INTO brs.t_book (book_name, author_id_fk, genre_id_fk, avg_rating, total_views) VALUES
('Swami and Friends', 1, 1, 4.5, 150),
('Devdas', 2, 2, 4.8, 200),
('Harry Potter', 3, 1, 4.9, 500),
('Gitanjali', 4, 2, 4.7, 100),
('Feluda Stories', 5, 5, 4.6, 180);
