INSERT INTO company (id, name) VALUES (1, 'Psyonix');
INSERT INTO company (id, name) VALUES (2, 'Bungie');
INSERT INTO company (id, name) VALUES (3, 'Jagex');
ALTER TABLE COMPANY ALTER COLUMN ID RESTART WITH 4;

--Manual datetime insert. 
INSERT INTO game (id, name, genre, company_id, CREATE_DTM) VALUES (1, 'Rocket League', 'Sport', 1, '2024-10-17 12:29:51.451973');
INSERT INTO game (id, name, genre, company_id, CREATE_DTM) VALUES (2, 'Halo 3', 'Shooter', 2, CURRENT_TIMESTAMP());
INSERT INTO game (id, name, genre, company_id, CREATE_DTM) VALUES (3, 'Runescape', 'MMORPG', 3, CURRENT_TIMESTAMP());
ALTER TABLE GAME ALTER COLUMN ID RESTART WITH 4;


INSERT INTO review (id, game_id, author, body, rating) VALUES (1, 1, 'René Descartes', 'I play, therefore I boost.', 3 );
INSERT INTO review (id, game_id, author, body, rating) VALUES (2, 1, 'Immanuel Kant', 'The categorical imperative demands we play with good sportsmanship, even in Rocket League.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (3, 1, 'Friedrich Nietzsche', 'In Rocket League, one must become the Übercar to truly transcend the field of play.', 5);
INSERT INTO review (id, game_id, author, body, rating) VALUES (4, 1, 'Plato', 'The perfect game of Rocket League exists only in the realm of Forms; we merely chase its shadow.', 3);
INSERT INTO review (id, game_id, author, body, rating) VALUES (5, 1, 'Jean-Paul Sartre', 'Rocket League is the epitome of existential freedom: we are condemned to choose our moves in every moment.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (6, 1, 'Aristotle', 'The virtue of Rocket League lies in the golden mean between aggression and defense.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (7, 1, 'Søren Kierkegaard', 'The leap of faith required to aerial in Rocket League is a sublime expression of human possibility.', 5);
INSERT INTO review (id, game_id, author, body, rating) VALUES (8, 1, 'Confucius', 'The superior player cultivates harmony with teammates; the inferior player blames them for missed shots.', 3);
INSERT INTO review (id, game_id, author, body, rating) VALUES (9, 1, 'John Locke', 'All cars enter the pitch as blank slates, it is experience that shapes their skill.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (10, 1, 'Thomas Hobbes', 'Without rules, Rocket League would be nasty, brutish, and short—much like a bad teammate.', 2);
INSERT INTO review (id, game_id, author, body, rating) VALUES (11, 1, 'Simone de Beauvoir', 'One is not born, but rather becomes, a Rocket League champion.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (12, 1, 'Ludwig Wittgenstein', 'The limits of my boost gauge mean the limits of my world in Rocket League.', 3);
INSERT INTO review (id, game_id, author, body, rating) VALUES (13, 1, 'Karl Marx', 'Rocket League players of the world, unite! You have nothing to lose but your lower ranks!', 2);


INSERT INTO review (id, game_id, author, body, rating) VALUES (14, 2, 'René Descartes', 'I frag, therefore I am.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (15, 2, 'Immanuel Kant', 'The universal maxim of Halo 3: respawn and try again.', 5);
INSERT INTO review (id, game_id, author, body, rating) VALUES (16, 2, 'Friedrich Nietzsche', 'In Halo 3, one must stare into the abyss of defeat to truly appreciate victory.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (17, 2, 'Plato', 'The Spartan armor is but a shadow of the ideal form of protection.', 3);
INSERT INTO review (id, game_id, author, body, rating) VALUES (18, 2, 'Jean-Paul Sartre', 'In the face of alien hordes, we are condemned to be free.', 5);
INSERT INTO review (id, game_id, author, body, rating) VALUES (19, 2, 'Aristotle', 'The excellence of a Spartan lies in the mean between recklessness and cowardice.', 4);

-- Runescape reviews
INSERT INTO review (id, game_id, author, body, rating) VALUES (20, 3, 'Søren Kierkegaard', 'The grind in Runescape is a leap of faith towards self-realization.', 3);
INSERT INTO review (id, game_id, author, body, rating) VALUES (21, 3, 'Confucius', 'The wise player seeks knowledge, the fool seeks only to level up.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (22, 3, 'John Locke', 'Our Runescape characters begin as blank slates, it is our choices that define them.', 5);
INSERT INTO review (id, game_id, author, body, rating) VALUES (23, 3, 'Thomas Hobbes', 'Without the Grand Exchange, trade in Runescape would be solitary, poor, nasty, brutish, and short.', 3);
INSERT INTO review (id, game_id, author, body, rating) VALUES (24, 3, 'Simone de Beauvoir', 'One is not born, but rather becomes, a master of all skills in Runescape.', 4);
INSERT INTO review (id, game_id, author, body, rating) VALUES (25, 3, 'Karl Marx', 'Runescape players of all levels, unite! You have nothing to lose but your bronze armor!', 2);
ALTER TABLE REVIEW ALTER COLUMN ID RESTART WITH 26;
