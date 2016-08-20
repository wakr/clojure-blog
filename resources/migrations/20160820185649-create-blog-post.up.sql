ALTER TABLE IF EXISTS blog_posts ADD COLUMN title text,
                                 ADD COLUMN bodytext text,
                                 ADD COLUMN tags text,
                                 ADD COLUMN timestamp timestamptz
