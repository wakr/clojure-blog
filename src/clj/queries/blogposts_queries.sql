-- name: blogpost-count
-- Counts the amount of different blogposts
SELECT count(*) AS count
FROM blog_posts

-- name: save-blogpost<!
-- Inserts a new blogpost into database
INSERT INTO blog_posts (title, bodytext, tags)
VALUES (:title, :bodytext, :tags)

-- name: get-all-blogposts
-- Fetches all blogposts. Sorted by date.
SELECT * FROM blog_posts ORDER BY created
