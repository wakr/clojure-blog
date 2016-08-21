-- name: blogpost-count
-- Counts the amount of different blogposts
SELECT count(*) AS count
FROM blog_posts

-- name: save-blogpost<!
-- Inserts a new blogpost into database
INSERT INTO blog_posts (title)
VALUES (:title)
